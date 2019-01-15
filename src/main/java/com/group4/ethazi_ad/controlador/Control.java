package com.group4.ethazi_ad.controlador;

import com.group4.ethazi_ad.modelo.clases.Administrador;
import com.group4.ethazi_ad.modelo.clases.Cliente;
import com.group4.ethazi_ad.modelo.constantes.Literales;
import com.group4.ethazi_ad.vista.ventanas.VentanaPrincipal;

import java.util.ArrayList;

public class Control {

	public static final int UPDATELIST = 1;
	public static final int DELETEUSER = 2;

	public static void control(int opcion, Object object) {

		switch (opcion) {
		case 1:
			actualizarLista();
			break;
		case 2:
			deleteUser(object);
			actualizarLista();
			break;
		default:
			break;
		}
	}

	@SuppressWarnings("unchecked")
	public static void actualizarLista() {

		if (VentanaPrincipal.getRdbtnEditores().isSelected()) {

			VentanaPrincipal.getTxField_buscar().requestFocus();
			ArrayList<Administrador> a = new ArrayList<Administrador>(SentenciasHQL
					.select_Admins_Contain_Nick(VentanaPrincipal.getLastFind(), Literales.AdminsLiterals.EDITOR));
			((ArrayList<Administrador>) VentanaPrincipal.getUsuarios()).clear();
			VentanaPrincipal.setUsuarios(((Object) a));
			for (int i = 0; i < a.size(); i++) {
				System.out.println(a.get(i).toString());
			}

			VentanaPrincipal.getPa_buscarUsuarios().actualizar(VentanaPrincipal.getUsuarios());

			VentanaPrincipal.getPa_contenedor().updateUI();
			VentanaPrincipal.getPa_contenedor().repaint();
			VentanaPrincipal.getPa_contenedor().validate();
		} else {
			VentanaPrincipal.getTxField_buscar().requestFocus();
			ArrayList<Cliente> a = new ArrayList<Cliente>(
					SentenciasHQL.select_Clients_Contain_Search(VentanaPrincipal.getLastFind()));
			((ArrayList<Cliente>) VentanaPrincipal.getUsuarios()).clear();
			VentanaPrincipal.setUsuarios(((Object) a));
			for (int i = 0; i < a.size(); i++) {
				System.out.println(a.get(i).toString());
			}

			VentanaPrincipal.getPa_buscarUsuarios().actualizar(VentanaPrincipal.getUsuarios());
			

			VentanaPrincipal.getPa_contenedor().updateUI();
			VentanaPrincipal.getPa_contenedor().repaint();
			VentanaPrincipal.getPa_contenedor().validate();
		}

	}

	public static void deleteUser(Object usuario) {
		VentanaPrincipal.setFocusTxField();
		SentenciasHQL.delele_User((Administrador) usuario);

	}
}
