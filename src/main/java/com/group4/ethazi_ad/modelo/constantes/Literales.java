package com.group4.ethazi_ad.modelo.constantes;

/**
 * Clase de constantes que contienen todos los textos que no son
 * ni enumeraciones ni tablas.
 *
 * @Author: Jon
 * @Version: 19 /12/2018
 */
public abstract class Literales {

    public static class AdminsLiterals {
        public static final String T_ADMIN = "Tipo de administrador: ";
        public static final String ADMINISTRADOR = "root";
        public static final String EDITOR = "editor";
        public static final String ID = "Número de identificación: ";
        public static final String NICK = "Nick: ";
        public static final String NAME = "Nombre y apellidos: ";
    }

    public static class ClientsLiterals {
        public static final String DNI = "DNI: ";
        public static final String EMAIL = "Correo electrónico: ";
        public static final String ID = "Número de identificación: ";
        public static final String NICK = "Nick: ";
    }

    public static class SessionLiterals{
        public static final String[][] PROPERTYS = {
                {"hibernate.connection.driver_class","org.mariadb.jdbc.Driver"},
                {"hibernate.connection.url","jdbc:mariadb://kasserver.synology.me:3307/reto_gp4"},
                {"hibernate.connection.username", "gp4"},
                {"hibernate.connection.password", "MmlYOc8DvJXQns7D"},
                {"hibernate.dialect", "org.hibernate.dialect.MySQLDialect"},
                {"hibernate.show_sql", "false"},
                {"hibernate.hbm2ddl.auto", "update"},
                {"hibernate.current_session_context_class", "thread"}
        };
        public static final String[] MAPPERS = {
                "Cliente.hbm.xml",
                "Administrador.hbm.xml"
        };
    }

    public static class Mensajes {
        public static final String NORESULTS = "Sin resultados";
        public static final String 	LOAD = "Cargando";
    }

    public static class Botones {
    	   public static final String RDBTN_EDITORES= "Editores";
    	   public static final String RDBTN_CLIENTES = "Clientes";

    }
    
    public static class Iconos{
    	public static final String FINDICO = "/findico.png";
    	public static final String EDITICO = "editico.png";
    	public static final String DELETEICO = "deleteico.png";
    	public static final String NEWUSERICO = "/newuserico.png";
    	public static final String OFFICO = "/offico.png";
    	public static final String FDERECHAICO = "fderecha.png";
    	public static final String FIZQUIERDAICO = "fizquierda.png";
		public static final String SAVEICO = "saveico.png";
    }
    
    public static class ToolTips{
       	public static final String EDITUSER = "Editar usuario ";
    	public static final String DELETEUSER = "Borrar usuario ";
    	public static final String SEARCH = "Introduce nombre o nick";
    	public static final String FIND = "Buscar";
    	public static final String NEWUSER = "Nuevo usuario";
    	public static final String OFF = "Cerrar sesión"; 
    	public static final String NEXTPAGE = "Página siguiente"; 
    	public static final String LASTPAGE = "Página anterior"; 
    }
}
