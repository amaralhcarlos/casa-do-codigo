package br.com.casadocodigo.loja.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.casadocodigo.loja.model.Autor;

public class AutorDao {

	@PersistenceContext
	private EntityManager manager;

	public void salvar(Autor autor) {

		manager.persist(autor);

	}

	public List<Autor> listarTodos() {

		String jpql = "select a from Autor a";
		
		return manager.createQuery(jpql, Autor.class).getResultList();

	}
}
