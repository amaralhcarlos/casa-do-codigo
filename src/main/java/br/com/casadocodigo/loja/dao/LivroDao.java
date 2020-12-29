package br.com.casadocodigo.loja.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.casadocodigo.loja.model.Livro;

public class LivroDao {

	@PersistenceContext
	private EntityManager manager;

	public void salvar(Livro livro) {

		manager.persist(livro);

	}

}
