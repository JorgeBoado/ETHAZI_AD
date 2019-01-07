package com.group4.ethazi_ad.controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.group4.ethazi_ad.modelo.clases.Administrador;
import com.group4.ethazi_ad.modelo.clases.Cliente;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * clase : Elementos_A_Listar
 *
 * ve	rsion :
 */

public class Elemento_A_Listar extends JPanel {

	private static final long serialVersionUID = 1L;

	private JButton btn_Eliminar;
	private JButton btn_Editar;
	private JLabel lbl_Abrir;

	public final static byte VER_EDITORES = 0;
	public final static byte VER_CLIENTES = 1;


	public Elemento_A_Listar(Object usuario, byte opcion) {
		//miPaElemento_A_Listar=new JPanel();
		/*miPaElemento_A_Listar.*/setBounds(0, 0, 450, 50);
		setLayout(null);

		switch (opcion) {
		case 0: {
			btn_Eliminar = new JButton("Borrar usuario");
			btn_Eliminar.setBounds(364, 44, 107, 30);
			add(btn_Eliminar);
			btn_Editar = new JButton("Editar usuario");
			btn_Editar.setBounds(364, 80, 107, 30);
			add(btn_Editar);
			lbl_Abrir = new JLabel(((Administrador)usuario).getNick());
			lbl_Abrir.setBounds(364, 1, 107, 40);
			add(lbl_Abrir);

			//Codificar
			btn_Eliminar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					super.mouseClicked(e);
				}
			});
			//Codificar
			btn_Editar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					super.mouseClicked(e);
				}
			});
			//Codificar
			lbl_Abrir.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					super.mouseClicked(e);
				}
			});
		}
			break;
		case 1: {
			btn_Eliminar = new JButton("Borrar usuario");
			btn_Eliminar.setBounds(364, 44, 107, 30);
			add(btn_Eliminar);
			lbl_Abrir = new JLabel(((Cliente)usuario).getNick());
			lbl_Abrir.setBounds(364, 1, 107, 40);
			add(lbl_Abrir);

			//Codificar
			btn_Eliminar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					super.mouseClicked(e);
				}
			});
			//Codificar
			btn_Eliminar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					super.mouseClicked(e);
				}
			});
			//Codificar
			lbl_Abrir.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					super.mouseClicked(e);
				}
			});
		}
			break;

		}
	}
}