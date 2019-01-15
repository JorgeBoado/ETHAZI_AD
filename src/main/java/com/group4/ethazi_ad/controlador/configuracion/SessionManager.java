package com.group4.ethazi_ad.controlador.configuracion;

import com.group4.ethazi_ad.modelo.constantes.Literales;
import org.hibernate.HibernateException;
import org.hibernate.Session;
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

	/**
	 * createSession :
	 * 
	 *  Crea una conexion con la bbdd cargando las propiedades y los mapeos
	 *  de la Literales
	 */
	public static void createSession() throws HibernateException {
		Configuration config = new Configuration(); // Instancia un objeto del tipo Configuration
		for (String s : Literales.SessionLiterals.MAPPERS) config.addResource(s);// Carga los mapeos xml
		for (String[] s : Literales.SessionLiterals.PROPERTYS) config.setProperty(s[0], s[1]);// Carga las propiedades
		session = config.buildSessionFactory().openSession(); // Retorna una sesion de trabajo
		System.out.println("Sesion creada con exito");
	}

	/*
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

	/*
	 *  disconnect :
	 *  
	 *  Cierra la conexion cuando la aplicaccion va ha finalizar
	 * */
	public static void disconnect() {
		session.close();
		System.out.println("Desconectado con exito");
	}
}
