package br.com.mdw.resource;



import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.mdw.api.hander.RecursoCriadoEvent;
import br.com.mdw.model.Noticia;
import br.com.mdw.repository.NoticiaRepository;
import br.com.mdw.repository.filter.NoticiaFilter;
import br.com.mdw.service.NoticiaService;

@CrossOrigin(origins = "https://mdw-arm-wladimir-ui.herokuapp.com", maxAge = 3600)
@RestController
@RequestMapping("/noticias")
public class NoticiaResource {

	@Autowired
	private NoticiaRepository noticiaRepository;

	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private NoticiaService noticiaService;
	
	
	
	@GetMapping
	public Page<Noticia> pesquisar(NoticiaFilter noticiaFilter, Pageable pageable) {
		
		return noticiaRepository.filtrar(noticiaFilter, pageable);
	}

	@PostMapping
	public ResponseEntity<Noticia> criar(@Valid @RequestBody Noticia noticia, HttpServletResponse response) {
		Noticia noticiaSalva = noticiaRepository.save(noticia);

		publisher.publishEvent(new RecursoCriadoEvent(this, response, noticiaSalva.getCodigo()));

		return ResponseEntity.status(HttpStatus.CREATED).body(noticiaSalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Noticia> buscarPeloCodigo(@PathVariable Long codigo) {
		Noticia noticia = noticiaRepository.findOne(codigo);
		return noticia != null ? ResponseEntity.ok(noticia) : ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		noticiaRepository.delete(codigo);
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<Noticia> atualizar(@PathVariable Long codigo, @Valid @RequestBody Noticia noticia) {
		Noticia noticiaSalva = noticiaService.atualizar(codigo, noticia);
		return ResponseEntity.ok(noticiaSalva);
}

}
