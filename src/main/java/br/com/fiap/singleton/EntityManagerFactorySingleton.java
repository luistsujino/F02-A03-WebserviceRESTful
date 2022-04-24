package br.com.fiap.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {
	
		//Atributo est�tico que armazena a �nica inst�ncia
		private static EntityManagerFactory fabrica;
		
		//Construtor privado
		private EntityManagerFactorySingleton() {}
		
		//M�todo est�tico que cria e retorna a �nica inst�ncia
		public static EntityManagerFactory getInstance() {
			if (fabrica == null) {
				fabrica = Persistence.createEntityManagerFactory("oracle");
			}
			return fabrica;
		}

}
