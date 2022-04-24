package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ManutencaoDao;
import br.com.fiap.entity.Manutencao;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.IdNotFoundException;

public class ManutencaoDaoImpl implements ManutencaoDao{
	
	private EntityManager em;
	
	public ManutencaoDaoImpl(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Manutencao manutencao) {
		em.persist(manutencao);
	}

	public void atualizar(Manutencao manutencao) {
		em.merge(manutencao);
	}

	public Manutencao buscar(Integer codigo) throws IdNotFoundException {
		Manutencao manutencao = em.find(Manutencao.class, codigo); 
		//Validar se o cliente existe, se não existir lançar exception
		if (manutencao == null)
			throw new IdNotFoundException();
		return manutencao; 
	}

	public void deletar(Integer codigo) throws IdNotFoundException {
		Manutencao manutencao = buscar(codigo);
		em.remove(manutencao);
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
