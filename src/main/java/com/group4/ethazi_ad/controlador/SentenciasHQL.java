package com.group4.ethazi_ad.controlador;

import com.group4.ethazi_ad.configuracion.SessionManager;
import com.group4.ethazi_ad.modelo.clases.Administrador;
import com.group4.ethazi_ad.modelo.clases.Cliente;
import org.hibernate.Session;

/**
 * Clase SentenciasHQL
 *
 * @author : JON
 * @version : 19/12/2018
 *
 * Siempre que se necesite crear, modificar, recuperar o borrar registros
 * mediante ORM se hara mediante los metodos de esta clase.
 *
 * Los metodos de esta clase son sobrecargados.
 */
public class SentenciasHQL {

    //__________PARECE SER QUE TIENE UN AUTOCOMMIT
    //Transaction tx = session.beginTransaction();
    //tx.commit();

    /**
     * TODO
     */
    public static void insert_User(Cliente cliente) {
        Session session = SessionManager.getSession();
        session.beginTransaction();//genera una transaccion
        session.save(cliente);  //Inserta los clientes
        session.getTransaction().commit();
        session.close();
    }
    /**
     * TODO
     */
    public static void insert_User(Administrador admin) {
        Session session = SessionManager.getSession();
        session.beginTransaction();
        session.save(admin);  //Inserta los admin
        session.getTransaction().commit();
        session.close();
    }
    /**
     * TODO
     */
    public static void modify_User(Administrador admin) {
        Session session = SessionManager.getSession();
        session.beginTransaction();
        session.update(admin);  //Modifica el admin
        session.getTransaction().commit();
        session.close();
    }
    /**
     * TODO
     */
    public static void modify_User(Cliente cliente) {
        Session session = SessionManager.getSession();
        session.beginTransaction();
        session.update(cliente);  //Modifica el cliente
        session.getTransaction().commit();
        session.close();
    }
    /**
     * TODO
     */
    public static void delele_User(Administrador admin) {
        Session session = SessionManager.getSession();
        session.beginTransaction();
        session.delete(admin);  //borra el admin
        session.getTransaction().commit();
        session.close();
    }
    /**
     * TODO
     */
    public static void delete_User(Cliente cliente) {
        Session session = SessionManager.getSession();
        session.beginTransaction();
        session.delete(cliente);  //borra el cliente
        session.getTransaction().commit();
        session.close();
    }
}
