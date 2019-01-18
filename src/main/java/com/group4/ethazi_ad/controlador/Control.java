package com.group4.ethazi_ad.controlador;

import com.group4.ethazi_ad.controlador.configuracion.SessionManager;
import com.group4.ethazi_ad.modelo.clases.Administrador;
import com.group4.ethazi_ad.modelo.clases.Cliente;
import com.group4.ethazi_ad.modelo.constantes.Literales;
import com.group4.ethazi_ad.vista.ventanas.VentanaAdmin;
import com.group4.ethazi_ad.vista.ventanas.VentanaCliente;
import com.group4.ethazi_ad.vista.ventanas.VentanaPrincipal;

import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Toolkit;
import java.util.ArrayList;

public class Control {

	public static final int UPDATELIST = 1;
	public static final int DELETEUSER = 2;
	public static final int NEWUSERFRAME = 3;
	public static final int EXIT =4;
	public static final int NEWCLIENT = 5;
	public static final int MODCLIENT = 6;
	public static final int NEWADMIN = 7;
	public static final int MODADMIN = 8;
	private static ArrayList<Object> usuarios = new ArrayList<>();

	public static void control(int opcion, Object object) {

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



	private static void modAdmin(Object object) {
		Administrador admin = ((Administrador)object);	
		try {

			admin.cifrar();

			SentenciasHQL.modify_User(admin);
			control(Control.UPDATELIST, null);
			VentanaCliente.getFrame().dispose();
		} catch (Exception e) {
			e.printStackTrace();
			VentanaCliente.getLbl_error().setVisible(true);
			Toolkit.getDefaultToolkit().beep();
		}
	}
	



	private static void newAdmin(Object object) {
		Administrador admin = ((Administrador)object);	
		try {

			admin.cifrar();

			SentenciasHQL.insert_User(admin);
			control(Control.UPDATELIST, null);
			VentanaCliente.getFrame().dispose();
		} catch (Exception e) {
			e.printStackTrace();
			VentanaAdmin.getLbl_error().setVisible(true);
			Toolkit.getDefaultToolkit().beep();
		}
		
	}



	private static void modClient(Object object) {
		Cliente cliente = ((Cliente)object);	
		try {

			cliente.cifrar();

			SentenciasHQL.modify_User(cliente);
			control(Control.UPDATELIST, null);
			VentanaCliente.getFrame().dispose();
		} catch (Exception e) {
			e.printStackTrace();
			VentanaAdmin.getLbl_error().setVisible(true);
			Toolkit.getDefaultToolkit().beep();
		}
	}



	private static void newClient(final Object object) {
	Cliente cliente = ((Cliente)object);	
	try {

		cliente.cifrar();

		SentenciasHQL.insert_User(cliente);
		control(Control.UPDATELIST, null);
		VentanaCliente.getFrame().dispose();
	} catch (Exception e) {
		e.printStackTrace();
		VentanaCliente.getLbl_error().setVisible(true);
		Toolkit.getDefaultToolkit().beep();
	}
	}



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

	public static ArrayList<Object> getUsuarios() {
		return usuarios;
	}

	@SuppressWarnings("unchecked")
	public static void setUsuarios(Object a) {
		Control.usuarios = (ArrayList<Object>) a;
	}

	@SuppressWarnings("unchecked")
	public static void actualizarLista() {

		if (VentanaPrincipal.getRdbtnEditores().isSelected()) {

			VentanaPrincipal.getTxField_buscar().requestFocus();
			ArrayList<Administrador> a = new ArrayList<Administrador>(SentenciasHQL
					.select_Admins_Contain_Nick(VentanaPrincipal.getLastFind(), Literales.AdminsLiterals.EDITOR));
			((ArrayList<Object>) ((ArrayList<?>) usuarios)).clear();
			setUsuarios(((Object) a));
			for (int i = 0; i < a.size(); i++) {
				System.out.println(a.get(i).toString());
			}

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

	public static void deleteUser(Object usuario) {
		VentanaPrincipal.setFocusTxField();
		SentenciasHQL.delele_User(usuario);

	}
}
