package br.com.mdw.repository.filter;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class NoticiaFilter {

	private String titulo;

	private String conteudo;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataNoticia;

	private String font;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public LocalDate getDataNoticia() {
		return dataNoticia;
	}

	public void setDataNoticia(LocalDate dataNoticia) {
		this.dataNoticia = dataNoticia;
	}

	public String getFont() {
		return font;
	}

	public void setFont(String font) {
		this.font = font;
	}

}
