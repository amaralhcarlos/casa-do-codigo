package br.com.casadocodigo.loja.bean;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.casadocodigo.loja.dao.LivroDao;
import br.com.casadocodigo.loja.model.Livro;

@Model
public class AdminListaLivroBean {

	@Inject
	private LivroDao livroDao;

	private List<Livro> livros = new ArrayList<>();

	public List<Livro> getLivros() {

		this.livros = livroDao.listarTodos();
		return livros;

	}

}
