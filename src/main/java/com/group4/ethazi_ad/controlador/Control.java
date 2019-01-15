package com.group4.ethazi_ad.controlador;

import java.util.ArrayList;

import com.group4.ethazi_ad.modelo.clases.Administrador;
import com.group4.ethazi_ad.modelo.constantes.Literales;
import com.group4.ethazi_ad.vista.ventanas.VentanaPrincipal;

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

	public static void actualizarLista() {

		if (VentanaPrincipal.getRdbtnEditores().isSelected()) {

			VentanaPrincipal.getTxField_buscar().requestFocus();
			VentanaPrincipal.getUsuarios().clear();
			ArrayList<Administrador> a = new ArrayList<Administrador>(
					SentenciasHQL.select_Admins_Contain_Nick(VentanaPrincipal.getLastFind(), Literales.AdminsLiterals.EDITOR));
			VentanaPrincipal.setUsuarios(a);
			for (int i = 0; i < VentanaPrincipal.getUsuarios().size(); i++) {
				System.out.println(VentanaPrincipal.getUsuarios().get(i).toString());
			}

			VentanaPrincipal.getPa_buscarUsuarios().actualizar(VentanaPrincipal.getUsuarios());
			VentanaPrincipal.getPa_buscarUsuarios().actualizar(VentanaPrincipal.getUsuarios());

			VentanaPrincipal.getPa_contenedor().updateUI();
			VentanaPrincipal.getPa_contenedor().repaint();
			VentanaPrincipal.getPa_contenedor().validate();
		}
		else {
			
		}
		
	}
	
	public static void deleteUser(Object usuario) {
		VentanaPrincipal.setFocusTxField();
		SentenciasHQL.delele_User((Administrador)usuario);
		

	}
}
