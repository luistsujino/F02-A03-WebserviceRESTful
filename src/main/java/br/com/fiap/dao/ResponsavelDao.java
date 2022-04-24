package br.com.fiap.dao;

import br.com.fiap.entity.Responsavel;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.IdNotFoundException;

public interface ResponsavelDao {
	
	void cadastrar(Responsavel responsavel);
	
	void atualizar(Responsavel responsavel);
	
	Responsavel buscar(Integer codigo) throws IdNotFoundException;
	
	void deletar(Integer codigo) throws IdNotFoundException;
	
	void commit() throws CommitException;

}
