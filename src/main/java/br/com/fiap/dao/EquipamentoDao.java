package br.com.fiap.dao;

import br.com.fiap.entity.Equipamento;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.IdNotFoundException;

public interface EquipamentoDao {
	
	void cadastrar(Equipamento equipamento);
	
	void atualizar(Equipamento equipamento);
	
	Equipamento buscar(Integer codigo) throws IdNotFoundException;
	
	void deletar(Integer codigo) throws IdNotFoundException;
	
	void commit() throws CommitException;

}
