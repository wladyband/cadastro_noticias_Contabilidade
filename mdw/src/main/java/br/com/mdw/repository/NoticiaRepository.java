package br.com.mdw.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mdw.model.Noticia;
import br.com.mdw.repository.noticia.NoticiaRepositoryQuery;

public interface NoticiaRepository extends JpaRepository<Noticia, Long>, NoticiaRepositoryQuery {

}