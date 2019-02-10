package com.group4.ethazi_ad.controlador.configuracion;

import com.group4.ethazi_ad.modelo.constantes.Literales;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Clase De Conexion con la BD mediante ORM
 * 
 * Las propiedades y mapeos se encuentran definidas en la Clase Literales
 *
 * @author : Jon
 * @version : 21 /12/2018
 */
public class SessionManager {
	
	
	private static Session session;
	private static SessionFactory factory = null;
	private static SessionManager manager = null;

	private SessionManager() {
		Configuration config = new Configuration(); // Instancia un objeto del tipo Configuration
		for (String s : Literales.SessionLiterals.MAPPERS) config.addResource(s);// Carga los mapeos xml
		String[][] lista =Literales.SessionLiterals.PROPERTYS;
		for (String[] s : Literales.SessionLiterals.PROPERTYS) config.setProperty(s[0], s[1]);// Carga las propiedades
		int longitud = lista.length;
		for (int i = 0; i < lista.length; i++){
			config.setProperty(lista[i][0], lista[i][1]);
		}
		factory = config.buildSessionFactory(); // Retorna una sesion de trabajo
	}

	/**
	 *
	 * @return la instancia de SessionManager
	 */
	public static SessionManager getInstance(){

		if(manager==null){
			manager = new SessionManager();
		}

		return manager;
	}

	public SessionFactory getFactory(){
		return factory;
	}

	/**
	 *  getSession :
	 *  
	 *   @return : la sesion de hibernate 
	 * */
	public static Session getSession() {
		if (!session.isJoinedToTransaction()) {
		       session.beginTransaction();
		}

		return session;
	}

	/**
	 *  disconnect :
	 *
	 *  Cierra la conexion cuando la aplicaccion va ha finalizar
	 * */
	public static void disconnect() {
		factory.close();
		System.out.println("Desconectado con exito");
	}
}
