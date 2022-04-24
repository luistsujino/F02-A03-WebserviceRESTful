package br.com.fiap.dao;

import br.com.fiap.entity.Manutencao;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.IdNotFoundException;

public interface ManutencaoDao {
	
	void cadastrar(Manutencao manutencao);
	
	void atualizar(Manutencao manutencao);
	
	Manutencao buscar(Integer codigo) throws IdNotFoundException;
	
	void deletar(Integer codigo) throws IdNotFoundException;
	
	void commit() throws CommitException;

}
