package com.group4.ethazi_ad.controlador.configuracion;

import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class SessionManager {
	public static Session getSession() throws HibernateException{

        Configuration config = new Configuration(); // Instancia un objeto del tipo Configuration
        registerMappers(config); // Registra las clases a mapear en la configuracion
        
        // Establece las propiedades de configuracion
        config.setProperty("hibernate.connection.driver_class", "org.mariadb.jdbc.Driver");
        config.setProperty("hibernate.connection.url", "jdbc:mariadb://kasserver.synology.me:3307/reto_gp4");
        config.setProperty("hibernate.connection.username", "gp4");
        config.setProperty("hibernate.connection.password", "MmlYOc8DvJXQns7D");
        config.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        config.setProperty("hibernate.show_sql", "false");
        config.setProperty("hibernate.hbm2ddl.auto", "update");
        config.setProperty("hibernate.current_session_context_class", "thread");

        return config.buildSessionFactory().openSession(); // Retorna una sesion de trabajo
    }

    // Cada clase mapeada debera aparecer aca.
    private static void registerMappers(Configuration config) throws MappingException{
        config.addResource("Cliente.hbm.xml");
        config.addResource("Administrador.hbm.xml");
    }
}
