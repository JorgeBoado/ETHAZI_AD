package com.group4.ethazi_ad.controlador;

import com.group4.ethazi_ad.controlador.configuracion.SessionManager;
import com.group4.ethazi_ad.modelo.clases.Administrador;
import com.group4.ethazi_ad.modelo.clases.Cliente;
import com.group4.ethazi_ad.modelo.constantes.Literales;
import com.group4.ethazi_ad.modelo.constantes.Tablas;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.PersistenceException;
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
        int id = admin.getId();
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
     * El metodo select_Users_Contain_Search seleciona los
     * clientes cuyo nick o email contiene la busqueda
     * <p>
     * pensado para cuando el usuario de la aplicacion
     * esta escribiendo o pulsa intro al terminar
     * </p>
     * @param busqueda: La busqueda de un nombre o correo en un textbox
     * @return :Una lista de clientes
     */
    public static ArrayList<Cliente> select_Clients_Contain_Search(String busqueda) {
        Session session = SessionManager.getSession();
        session.beginTransaction();
        Query query = session.createQuery("from Cliente where nick like :nick or email like :email");
        query.setParameter(Tablas.Clientes.NICK, "%" + busqueda + "%");
        query.setParameter(Tablas.Clientes.EMAIL, "%" + busqueda + "%");
        return getClientes(session, query);
    }

    private static ArrayList<Cliente> getClientes(Session session, Query query) {
        ArrayList<Cliente> clientes = new ArrayList<>();
        try{

            for (int i = 0; i < query.list().size(); i++) {
                clientes.add((Cliente) query.list().get(i));
            }
        }
        catch (PersistenceException e){
            System.out.println("No se encontraron clientes");
        }

        session.close();
        return clientes;
    }

    public static ArrayList<Cliente> select_Clients_Contain_Client(Cliente client) {
        Session session = SessionManager.getSession();
        session.beginTransaction();
        Query query = session.createQuery("from Cliente where nick like :nick or email like :email and id = :id");
        query.setParameter(Tablas.Clientes.NICK, "%" + client.getNick() + "%");
        query.setParameter(Tablas.Clientes.EMAIL, "%" + client.getEmail() + "%");
        query.setParameter(Tablas.Clientes.ID, client.getId());
        return getClientes(session, query);
    }

    /**
     * El metodo select_Users_Contain_Search seleciona los
     * administradores cuyo nick contiene la busqueda
     * <p>
     * pensado para cuando el usuario de la aplicacion
     * esta escribiendo o pulsa intro al terminar
     * </p>
     * @param busqueda : La busqueda de un nombre en un textbox
     * @param busqueda : La tipo de usuario
     * @return :Una lista de administradores
     */
    public static ArrayList<Administrador> select_Admins_Contain_Nick(String busqueda, String tipo) {
        Session session = SessionManager.getSession();
        session.beginTransaction();
        Query query = session.createQuery("from Administrador where nick like :nick and role = :role");
        query.setParameter(Tablas.Administradores.NICK, "%" + busqueda + "%");
        query.setParameter(Tablas.Administradores.ROLE, tipo);
        return getAdministradors(session, query);
    }

    private static ArrayList<Administrador> getAdministradors(Session session, Query query) {
        ArrayList<Administrador> admins = new ArrayList<>();
        try{
            for (int i = 0; i < query.list().size(); i++) {
                admins.add((Administrador) query.list().get(i));
            }
        }
        catch (PersistenceException e){
            System.out.println("sin resultados");
        }
        session.close();
        return admins;
    }

    /**
     * TODO
     * @param admin :
     * @return lista de administradores
     */
    public static ArrayList<Administrador> select_Admins_Contain_Admin(Administrador admin) {
        Session session = SessionManager.getSession();
        session.beginTransaction();
        Query query = session.createQuery("from Administrador where nick like :nick and id like :id and role = :role");
        query.setString("id", "%"+admin.getId()+"%");
        query.setParameter("nick", "%" + admin.getNick() + "%");
        query.setParameter("role", admin.getRole());
        return getAdministradors(session, query);
    }
}
