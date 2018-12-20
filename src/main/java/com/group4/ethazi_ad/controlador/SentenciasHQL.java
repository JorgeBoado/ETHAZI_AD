package com.group4.ethazi_ad.controlador;

import com.group4.ethazi_ad.controlador.configuracion.SessionManager;
import com.group4.ethazi_ad.modelo.clases.Administrador;
import com.group4.ethazi_ad.modelo.clases.Cliente;
import org.hibernate.Session;

import java.util.List;

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
public class SentenciasHQL<pass> {

    //No es necesario guardar en una variable la transaccion
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
    /**
     * TODO
     */
    public static Administrador select_User(Administrador admin){
        Session session = SessionManager.getSession();
        session.beginTransaction();
        int id = admin.getid();
        admin = session.get(Administrador.class, id);
        session.close();
        return admin;
    }
    /**
     * TODO
     */
    public static Cliente select_User(Cliente cliente){
        Session session = SessionManager.getSession();
        session.beginTransaction();
        int id = cliente.getId();
        cliente = session.get(Cliente.class, id);
        session.close();
        return cliente;
    }


}
