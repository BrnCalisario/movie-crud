package br.edu.up;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.edu.up.model.Filme;

public class MovieStorage {

	static EntityManagerFactory emf;
	static EntityManager em;

	public static void initialize() {
		emf = Persistence.createEntityManagerFactory("prj-jpa-sqlite");
		em = emf.createEntityManager();
	}

	public static void insertMovie(Filme filme) {
		em.getTransaction().begin();
		em.persist(filme);
		em.getTransaction().commit();
	}

	public static List<Filme> listMovies() {

		return em.createQuery("from Filme", Filme.class).getResultList();
	}

	public static void removeMovie(Filme filme){
		em.getTransaction().begin();
		em.remove(filme);
		em.getTransaction().commit();
	}


}