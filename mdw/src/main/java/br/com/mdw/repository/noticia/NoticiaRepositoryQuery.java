package br.com.mdw.repository.noticia;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.mdw.model.Noticia;
import br.com.mdw.repository.filter.NoticiaFilter;

public interface NoticiaRepositoryQuery {
	
	public Page<Noticia> filtrar(NoticiaFilter noticiaFilter, Pageable pageable);

}
