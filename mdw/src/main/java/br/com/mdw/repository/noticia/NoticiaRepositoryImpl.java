package br.com.mdw.repository.noticia;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import br.com.mdw.model.Noticia;
import br.com.mdw.model.Noticia_;
import br.com.mdw.repository.filter.NoticiaFilter;

public class NoticiaRepositoryImpl implements NoticiaRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Page<Noticia> filtrar(NoticiaFilter noticiaFilter, Pageable pageable) {

		CriteriaBuilder builder = manager.getCriteriaBuilder();

		CriteriaQuery<Noticia> criteria = builder.createQuery(Noticia.class);

		Root<Noticia> root = criteria.from(Noticia.class);
		
		  criteria.select(root);
		  criteria.orderBy(builder.desc(root.get("dataNoticia")));
		

		Predicate[] predicates = criarRestricoes(noticiaFilter, builder, root);

		criteria.where(predicates);

		/*Esse é o trecho do código responsável em realizar a consulta simples */
		
	
		TypedQuery<Noticia> query = manager.createQuery(criteria);
		
		adicionarRestricoesDePaginacao(query, pageable);

		return new PageImpl<>(query.getResultList(), pageable, total(noticiaFilter));
	}

	private Predicate[] criarRestricoes(NoticiaFilter noticiaFilter, CriteriaBuilder builder, Root<Noticia> root) {
		List<Predicate> predicates = new ArrayList<>();

		if (!StringUtils.isEmpty(noticiaFilter.getTitulo())) {
			predicates.add(builder.like(builder.lower(root.get(Noticia_.titulo)),
					"%" + noticiaFilter.getTitulo().toLowerCase() + "%"));
		}

		if (!StringUtils.isEmpty(noticiaFilter.getConteudo())) {
			predicates.add(builder.like(builder.lower(root.get(Noticia_.conteudo)),
					"%" + noticiaFilter.getConteudo().toLowerCase() + "%"));
		}

		if (noticiaFilter.getDataNoticia() != null) {
			predicates
					.add(builder.greaterThanOrEqualTo(root.get(Noticia_.dataNoticia), noticiaFilter.getDataNoticia()));
		}

		if (!StringUtils.isEmpty(noticiaFilter.getFont())) {
			predicates.add(builder.like(builder.lower(root.get(Noticia_.font)),
					"%" + noticiaFilter.getFont().toLowerCase() + "%"));
		}

		return predicates.toArray(new Predicate[predicates.size()]);
	}

	private void adicionarRestricoesDePaginacao(TypedQuery<Noticia> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalRegistrosPorPagina;

		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalRegistrosPorPagina);
	}

	private Long total(NoticiaFilter noticiaFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Noticia> root = criteria.from(Noticia.class);

		Predicate[] predicates = criarRestricoes(noticiaFilter, builder, root);
		criteria.where(predicates);

		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}

}
