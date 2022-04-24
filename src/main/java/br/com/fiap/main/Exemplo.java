package br.com.fiap.main;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Exemplo {
	
	public static void main(String[] args) {
		
		//Fabrica de Gerenciador de entidades
									//name da Persistence unit no persistance.xml
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		
		//Fechar o recurso
		fabrica.close();
		
	}

}
