package br.com.mdw.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.mdw.model.Noticia;
import br.com.mdw.repository.NoticiaRepository;

@Service
public class NoticiaService {

	@Autowired
	private NoticiaRepository noticaRepository;

	public Noticia atualizar(Long codigo, Noticia noticia) {
		Noticia noticiaSalva = noticaRepository.findOne(codigo);
		if (noticiaSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}

		BeanUtils.copyProperties(noticia, noticiaSalva, "codigo");
		return noticaRepository.save(noticiaSalva);
	}
}
