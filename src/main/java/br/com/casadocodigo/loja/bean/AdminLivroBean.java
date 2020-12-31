package br.com.casadocodigo.loja.bean;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.com.casadocodigo.loja.dao.AutorDao;
import br.com.casadocodigo.loja.dao.LivroDao;
import br.com.casadocodigo.loja.model.Autor;
import br.com.casadocodigo.loja.model.Livro;

@Named
@RequestScoped
public class AdminLivroBean {

	private Livro livro = new Livro();

	// Context and Dependency Injection
	@Inject
	private LivroDao livroDao;

	@Inject
	private AutorDao autorDao;

	@Inject
	private FacesContext context;

	public FacesContext getContext() {
		return context;
	}

	public void setContext(FacesContext context) {
		this.context = context;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	@Transactional
	public String salvar() {

		livroDao.salvar(this.livro);

		this.context.getExternalContext().getFlash().setKeepMessages(true);
		this.context.addMessage(null, new FacesMessage("Livro " + this.livro.getTitulo() + " cadastrado com sucesso!"));

		this.livro = new Livro();

		return "/livros/lista?faces-redirect=true";
	}

	public List<Autor> getAutores() {

		return autorDao.listarTodos();

	}
}
