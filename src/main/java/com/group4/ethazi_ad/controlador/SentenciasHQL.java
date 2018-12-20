package com.group4.ethazi_ad.controlador;

import com.group4.ethazi_ad.controlador.configuracion.SessionManager;
import com.group4.ethazi_ad.modelo.clases.Administrador;
import com.group4.ethazi_ad.modelo.clases.Cliente;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;

/**
 * Clase SentenciasHQL
 *
 * @author : JON
 * @version : 19/12/2018
 * <p>
 * Siempre que se necesite crear, modificar, recuperar o borrar registros
 * mediante ORM se hara mediante los metodos de esta clase.
 * </p>
 * Los metodos de esta clase son sobrecargados.
 */
public class SentenciasHQL<pass> {

    //TODO
    //si sobra tiempo habria que dinamizar la clase en lugar de sobrecargarla
    // ya que muchas sentencias re repiten

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
    public static Administrador select_User(Administrador admin) {
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
    public static Cliente select_User(Cliente cliente) {
        Session session = SessionManager.getSession();
        session.beginTransaction();
        int id = cliente.getId();
        cliente = session.get(Cliente.class, id);
        session.close();
        return cliente;
    }

    /**
     * El metodo select_Users_Contain_Nick seleciona los
     * clientes cuyo nick o email contiene la busqueda
     * <p>
     * pensado para cuando el usuario de la aplicacion
     * esta escribiendo o pulsa intro al terminar
     * <p>
     * TODO
     */
    public static ArrayList<Cliente> select_Users_Contain_Nick(String busqueda) {
        Session session = SessionManager.getSession();
        session.beginTransaction();
        Query query = session.createQuery("from Cliente where nick like :nick or email like :email");
        query.setParameter("nick", "%" + busqueda + "%");
        query.setParameter("email", "%" + busqueda + "%");

        ArrayList<Cliente> clientes = new ArrayList<>();
        for (int i = 0; i < query.list().size(); i++) {
            clientes.add((Cliente) query.list().get(i));
        }
        return clientes;
    }

    /**
     * El metodo select_Users_Contain_Nick seleciona los
     * administradores cuyo nick contiene la busqueda
     * pensado para cuando el usuario de la aplicacion
     * esta escribiendo o pulsa intro al terminar
     * <p>
     * TODO
     */
    public static ArrayList<Administrador> select_Users_Contain_Nick(Administrador admin) {
        Session session = SessionManager.getSession();
        session.beginTransaction();
        Query query = session.createQuery("from Administrador where nick like :nick");
        query.setParameter("nick", "%" + admin.getNick() + "%");
        ArrayList<Administrador> admins = new ArrayList<>();
        for (int i = 0; i < query.list().size(); i++) {
            admins.add((Administrador) query.list().get(i));
        }

        return admins;
    }


}
