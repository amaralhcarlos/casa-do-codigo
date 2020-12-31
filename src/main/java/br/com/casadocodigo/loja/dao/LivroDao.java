package br.com.casadocodigo.loja.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.casadocodigo.loja.model.Livro;

public class LivroDao {

	@PersistenceContext
	private EntityManager manager;

	public void salvar(Livro livro) {

		manager.persist(livro);

	}

	public List<Livro> listarTodos() {
		
		String jpql="select distinct(l) from Livro l join fetch l.autores";

		return manager.createQuery(jpql, Livro.class).getResultList();

	}

}
