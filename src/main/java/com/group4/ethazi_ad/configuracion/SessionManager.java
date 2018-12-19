package com.group4.ethazi_ad.configuracion;

import java.util.Properties;


import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class SessionManager {
	public static Session getSession() throws HibernateException{
        // Instancia un objeto del tipo Configuration
        Configuration config = new Configuration();
        
        // Registra las clases a mapear en la configuracion
        registerMappers(config);
        
        // Establece las propiedades de configuracion
        config.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        config.setProperty("hibernate.connection.url", "jdbc:mysql://kasserver.synology.me:3307/reto_gp4");
        config.setProperty("hibernate.connection.username", "gp4");
        config.setProperty("hibernate.connection.password", "MmlYOc8DvJXQns7D");
        config.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        config.setProperty("hibernate.show_sql", "false");
            config.setProperty("hibernate.hbm2ddl.auto", "update");
        config.setProperty("hibernate.current_session_context_class", "thread");
       // config.setProperties(getHibernateProperties() );

        // Retorna una sesion de trabajo
        return config.buildSessionFactory().openSession();
    }
    
    private static Properties getHibernateProperties(){


/**
 *
 */
        // Instancia un objeto del tipo Properties.
        Properties props = new Properties();
        //TODO
        // Establece el driver de conexion dependiente del RDBMS.
        //para MySQL seria:  props.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        props.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        
        // Establece la url de conexion, donde al final va el nombre de la BD
        //para MySQL  props.put("hibernate.connection.url", "jdbc:mysql://localhost/testHibernate");
        //TODO
        props.put("hibernate.connection.url", "jdbc:mysql://kasserver.synology.me:3307/reto_gp4");
                

        props.put("hibernate.connection.username", "gp4");


        // Establece la clave.
        props.put("hibernate.connection.password", "MmlYOc8DvJXQns7D");
        
        // Establece el dialecto a utilizar. Es necesario determinarlo ya que la implementacion
        // de SQL puede variar con cada motor de base de datos.
        // Para MySQL sera: props.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        props.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
          
        // Retorna las propiedades
        return props;
      
    }
    
    // Cada clase mapeada debera aparecer aca.
    private static void registerMappers(Configuration config) throws MappingException
    {
       // config.addResource("../../main/resources/Cliente.xml");


        config.addResource("Cliente.hbm.xml");//.buildSessionFactory();
        config.addResource("Administrador.hbm.xml");
    }
}
