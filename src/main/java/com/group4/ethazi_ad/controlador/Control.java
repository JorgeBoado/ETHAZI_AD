package com.group4.ethazi_ad.controlador;

import com.group4.ethazi_ad.controlador.configuracion.SessionManager;
import com.group4.ethazi_ad.modelo.clases.Administrador;
import com.group4.ethazi_ad.modelo.clases.Cliente;
import com.group4.ethazi_ad.modelo.constantes.Literales;
import com.group4.ethazi_ad.vista.ventanas.VentanaAdmin;
import com.group4.ethazi_ad.vista.ventanas.VentanaCliente;
import com.group4.ethazi_ad.vista.ventanas.VentanaPrincipal;

import java.awt.*;
import java.util.ArrayList;

/**
 * Clase control
 * <p>
 * Siempre que tenga que interactuar la vista con el modelo se pasa por esta clase
 * <p>
 * Esta clase se apolla en SentenciasHQL
 */
public class Control {

    /**
     * Constantes que determinan la acion a realizar
     */
    public static final int UPDATELIST = 1;
    public static final int DELETEUSER = 2;
    public static final int NEWUSERFRAME = 3;
    public static final int EXIT = 4;
    public static final int NEWCLIENT = 5;
    public static final int MODCLIENT = 6;
    public static final int NEWADMIN = 7;
    public static final int MODADMIN = 8;
    private static ArrayList<Object> usuarios = new ArrayList<>();

    /**
     * @param opcion  la opcion que tiene que realizar
     * @param object, un objeto auxiliar que puede ser cualquier cosa
     *                (Cuando se creo esta clase se decicio poner este auxiliar porque aun no se sabian
     *                todas las aciones necesarias ni lo que necesitarian, era una forma de prevenir futuros requerimientos
     *                de parametros, ya que el objeto auxiliar puede ser un arraylist de objetos y que cada uno sea un parametro)
     */
    public  synchronized  static void control(int opcion, Object object) {

        switch (opcion) {
            case 1:
                actualizarLista();
                break;
            case 2:
                deleteUser(object);
                actualizarLista();
                break;
            case 3:
                newUserFrame();
                break;
            case 4:
                SessionManager.disconnect();
                VentanaPrincipal.getFrame().dispose();
                break;
            case 5:
                newClient(object);
                break;
            case 6:
                modClient(object);
                break;
            case 7:
                newAdmin(object);
                break;
            case 8:
                modAdmin(object);
                break;
            default:
                break;
        }
    }

    /**
     *
     * @param object objeto administrador a modificar
     *
     *  modifica un usuario
     */
    private static void modAdmin(final Object object) {
        Administrador admin = ((Administrador) object);
        try {
            SentenciasHQL.modify_User(admin);
            control(Control.UPDATELIST, null);
            VentanaAdmin.getFrame().dispose();
        } catch (Exception e) {
            e.printStackTrace();
            VentanaCliente.getLbl_error().setVisible(true);
            Toolkit.getDefaultToolkit().beep();
        }
    }

    /**
     *
     * @param object usuario que crea
     *
     *        crea un usuario
     */
    private static void newAdmin(final Object object) {
        Administrador admin = ((Administrador) object);
        try {
            admin.cifrar();
            SentenciasHQL.insert_User(admin);
            control(Control.UPDATELIST, null);
            VentanaAdmin.getFrame().dispose();
        } catch (Exception e) {
            e.printStackTrace();
            VentanaAdmin.getLbl_error().setVisible(true);
            Toolkit.getDefaultToolkit().beep();
        }

    }

/**
 * @param object usuario que modifica
 *               modifica un usuario
 */
    private static void modClient( final Object object) {
        Cliente cliente = ((Cliente) object);
        try {
            SentenciasHQL.modify_User(cliente);
            control(Control.UPDATELIST, null);
            VentanaCliente.getFrame().dispose();
        } catch (Exception e) {
            e.printStackTrace();
            VentanaAdmin.getLbl_error().setVisible(true);
            Toolkit.getDefaultToolkit().beep();
        }
    }

    /**
     *
     * @param object usuario  que crea
     *
     *               crea un usuario
     */
    private static void newClient(final Object object) {
        Cliente cliente = ((Cliente) object);
        try {
            SentenciasHQL.insert_User(cliente);
            control(Control.UPDATELIST, null);
            VentanaCliente.getFrame().dispose();
        } catch (Exception e) {
            e.printStackTrace();
            VentanaCliente.getLbl_error().setVisible(true);
            Toolkit.getDefaultToolkit().beep();
        }
    }

    /**
     * Crea una ventana de crear usuaario
     */
    private static void newUserFrame() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        PointerInfo a = MouseInfo.getPointerInfo();
        Point b = a.getLocation();
        int x = (int) b.getX();
        int y = (int) b.getY();
        if (x > screenSize.width - 450) {
            x = x - 450;
        }
        if (VentanaPrincipal.getRdbtnEditores().isSelected()) {
            VentanaAdmin.adminFrame(null, VentanaAdmin.NEWUSER, x, y);
        } else {
            VentanaCliente.clientFrame(null, VentanaCliente.NEWUSER, x, y);
        }

    }

    /**
     *
     * @return lista usuarios
     */
    public static ArrayList<Object> getUsuarios() {
        return usuarios;
    }

    /**
     *
     * @param a lista de usuarios
     *          modifica la lista de usuarios
     */
    @SuppressWarnings("unchecked")
    public static void setUsuarios(Object a) {
        Control.usuarios = (ArrayList<Object>) a;
    }

    /**
     * Actualiza la lista de l pantalla
     */
    @SuppressWarnings("unchecked")
    public static void actualizarLista() {

        if (VentanaPrincipal.getRdbtnEditores().isSelected()) {

            VentanaPrincipal.getTxField_buscar().requestFocus();
            ArrayList<Administrador> a = new ArrayList<Administrador>(SentenciasHQL
                    .select_Admins_Contain_Nick(VentanaPrincipal.getLastFind(), Literales.AdminsLiterals.EDITOR));
            ((ArrayList<Object>) ((ArrayList<?>) usuarios)).clear();
            setUsuarios(((Object) a));

            VentanaPrincipal.getPa_buscarUsuarios().actualizar(usuarios);

            VentanaPrincipal.getPa_contenedor().updateUI();
            VentanaPrincipal.getPa_contenedor().repaint();
            VentanaPrincipal.getPa_contenedor().validate();
        } else {
            VentanaPrincipal.getTxField_buscar().requestFocus();
            ArrayList<Cliente> a = new ArrayList<Cliente>(
                    SentenciasHQL.select_Clients_Contain_Search(VentanaPrincipal.getLastFind()));
            ((ArrayList<Object>) ((ArrayList<?>) usuarios)).clear();
            setUsuarios(((Object) a));
            for (int i = 0; i < a.size(); i++) {
                System.out.println(a.get(i).toString());
            }

            VentanaPrincipal.getPa_buscarUsuarios().actualizar(usuarios);

            VentanaPrincipal.getPa_contenedor().updateUI();
            VentanaPrincipal.getPa_contenedor().repaint();
            VentanaPrincipal.getPa_contenedor().validate();
        }

    }

    /**
     *
     * @param usuario usuario al que borrar
     *                borra un usuario
     */
    public static void deleteUser(Object usuario) {
        VentanaPrincipal.setFocusTxField();
        SentenciasHQL.delele_User(usuario);

    }
}
