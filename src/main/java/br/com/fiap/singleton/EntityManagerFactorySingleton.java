package br.com.fiap.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {
	
		//Atributo estático que armazena a única instância
		private static EntityManagerFactory fabrica;
		
		//Construtor privado
		private EntityManagerFactorySingleton() {}
		
		//Método estático que cria e retorna a única instância
		public static EntityManagerFactory getInstance() {
			if (fabrica == null) {
				fabrica = Persistence.createEntityManagerFactory("oracle");
			}
			return fabrica;
		}

}
