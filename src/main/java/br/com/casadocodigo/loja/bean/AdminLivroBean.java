package br.com.casadocodigo.loja.bean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.casadocodigo.loja.model.Livro;

@Named
@RequestScoped
public class AdminLivroBean {

	private Livro livro = new Livro();

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public void salvar() {
		System.out.println("Livro cadastrado: " + this.livro);
	}
}
