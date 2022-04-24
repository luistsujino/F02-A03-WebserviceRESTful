package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ResponsavelDao;
import br.com.fiap.entity.Responsavel;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.IdNotFoundException;

public class ResponsavelDaoImpl implements ResponsavelDao{
	
	private EntityManager em;
	
	public ResponsavelDaoImpl(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Responsavel responsavel) {
		em.persist(responsavel);
	}

	public void atualizar(Responsavel responsavel) {
		em.merge(responsavel);
	}

	public Responsavel buscar(Integer codigo) throws IdNotFoundException {
		Responsavel responsavel = em.find(Responsavel.class, codigo); 
		//Validar se o cliente existe, se não existir lançar exception
		if (responsavel == null)
			throw new IdNotFoundException();
		return responsavel; 
	}

	public void deletar(Integer codigo) throws IdNotFoundException {
		Responsavel responsavel = buscar(codigo);
		em.remove(responsavel);
	}

	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			throw new CommitException(); 
		}
	}

}
