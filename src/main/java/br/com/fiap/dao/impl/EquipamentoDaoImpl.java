package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.EquipamentoDao;
import br.com.fiap.entity.Equipamento;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.IdNotFoundException;

public class EquipamentoDaoImpl implements EquipamentoDao{
	
	private EntityManager em;
	
	public EquipamentoDaoImpl(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Equipamento equipamento) {
		em.persist(equipamento);
	}

	public void atualizar(Equipamento equipamento) {
		em.merge(equipamento);
	}

	public Equipamento buscar(Integer codigo) throws IdNotFoundException {
		Equipamento equipamento = em.find(Equipamento.class, codigo); 
		//Validar se o cliente existe, se não existir lançar exception
		if (equipamento == null)
			throw new IdNotFoundException();
		return equipamento; 
	}

	public void deletar(Integer codigo) throws IdNotFoundException {
		Equipamento equipamento = buscar(codigo);
		em.remove(equipamento);
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
