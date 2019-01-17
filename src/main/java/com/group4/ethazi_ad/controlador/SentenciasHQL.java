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
import java.util.List;

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
        Session session = SessionManager.getInstance().getFactory().openSession();
        session.save(cliente);  //Inserta los clientes
        session.getTransaction().commit();
        session.close();
    }

    /**
     * TODO
     */
    public static void insert_User(Administrador admin)  {
        Session session = SessionManager.getInstance().getFactory().openSession();
        session.save(admin);  //Inserta los admin
        session.getTransaction().commit();
        session.close();
    }

    /**
     * TODO
     */
    public static void modify_User(final Administrador admin) {
        Session session = SessionManager.getInstance().getFactory().openSession();
        session.update(admin);  //Modifica el admin
        session.getTransaction().commit();
        session.close();
    }

    /**
     * TODO
     */
    public static void modify_User(Cliente cliente) {
        Session session = SessionManager.getInstance().getFactory().openSession();
        session.update(cliente);  //Modifica el cliente
        session.getTransaction().commit();
        session.close();
    
    }

    /**
     * TODO
     */
    public static void delele_User(Administrador admin) {
        Session session = SessionManager.getInstance().getFactory().openSession();
        session.delete(admin);  //borra el admin
        session.getTransaction().commit();
        session.close();
   
    }

    /**
     * TODO
     */
    public static void delete_User(Cliente cliente) {
        Session session = SessionManager.getInstance().getFactory().openSession();
        session.delete(cliente);  //borra el cliente
        session.getTransaction().commit();
        session.close();
    }

    /**
     * TODO
     */
    public static Administrador select_User(Administrador admin) {
        Session session = SessionManager.getInstance().getFactory().openSession();
        int id = admin.getId();
        admin = session.get(Administrador.class, id);
        session.close();
        return admin;
    }

    /**
     * TODO
     */
    public static Cliente select_User(Cliente cliente) {
        Session session = SessionManager.getInstance().getFactory().openSession();
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
        Session session = SessionManager.getInstance().getFactory().openSession();
		Query<Cliente> query = session.createQuery("from Cliente where nick like :nick or email like :email or dni like :dni");
        query.setParameter(Tablas.Clientes.NICK, "%" + busqueda + "%");
        query.setParameter(Tablas.Clientes.EMAIL, "%" + busqueda + "%");
        query.setParameter(Tablas.Clientes.DNI, "%" + busqueda + "%");
        ArrayList<Cliente> c = getClientes(query.list());
        session.close();
        return c;
    }

    private static ArrayList<Cliente> getClientes(List lista) {
        ArrayList<Cliente> clientes = new ArrayList<>();
        try{
            for (int i = 0; i <lista.size(); i++) {
                clientes.add((Cliente) lista.get(i));
            }
        }
        catch (PersistenceException e){
            System.out.println(Literales.Mensajes.NORESULTS);
        }
        return clientes;
    }

    public static ArrayList<Cliente> select_Clients_Contain_Client(Cliente client) {
        Session session = SessionManager.getSession();

        Query<Cliente> query = session.createQuery("from Cliente where nick like :nick or email like :email and id = :id");
        query.setParameter(Tablas.Clientes.NICK, "%" + client.getNick() + "%");
        query.setParameter(Tablas.Clientes.EMAIL, "%" + client.getEmail() + "%");
        query.setParameter(Tablas.Clientes.ID, client.getId());
        ArrayList<Cliente> c = getClientes(query.list());
        return c;
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
        Session session = SessionManager.getInstance().getFactory().openSession();
        Query<Cliente> query = session.createQuery("from Administrador where nick like :nick or name like :name and role = :role");
        query.setParameter(Tablas.Administradores.NICK, "%" + busqueda + "%");
        query.setParameter(Tablas.Administradores.NAME, "%" + busqueda + "%");
        query.setParameter(Tablas.Administradores.ROLE, tipo);
        ArrayList<Administrador> a = getAdministradors(query.list());
        System.out.println("Se han encontrado " + a.size() + " usuarios");
        session.close();
        return a;
    }

    private static ArrayList<Administrador> getAdministradors(List lista) {
        ArrayList<Administrador> admins = new ArrayList<>();
        try{
            for (int i = 0; i <lista.size(); i++) {
                admins.add((Administrador) lista.get(i));
            }
        }
        catch (PersistenceException e){
            System.out.println(Literales.Mensajes.NORESULTS);
        }
           
        return admins;
    }

    /**
     * TODO
     * @param admin :
     * @return lista de administradores
     */
    public static ArrayList<Administrador> select_Admins_Contain_Admin(Administrador admin) {
        Session session = SessionManager.getInstance().getFactory().openSession();
        @SuppressWarnings("unchecked")
		Query<Administrador> query = session.createQuery("from Administrador where nick like :nick and  role like :role and pass like :pass");//
        //query.setString("id", "%"+admin.getId()+"%");
        query.setParameter("nick", admin.getNick() );
        query.setParameter("role", "%" + admin.getRole() + "%");
        query.setParameter("pass", "%" + admin.getPass() + "%");
        ArrayList<Administrador> a = getAdministradors(query.list());
        session.close();
        return a;
    }
;

}
