package com.group4.ethazi_ad.vista.paneles;

import com.group4.ethazi_ad.controlador.Control;
import com.group4.ethazi_ad.modelo.clases.Administrador;
import com.group4.ethazi_ad.modelo.clases.Cliente;
import com.group4.ethazi_ad.modelo.constantes.Literales;
import com.group4.ethazi_ad.vista.ventanas.VentanaAdmin;
import com.group4.ethazi_ad.vista.ventanas.VentanaCliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

/**
 * clase : Elementos_A_Listar
 *
 * ve rsion :
 */

public class Elemento_A_Listar extends JPanel {

	private static final long serialVersionUID = 1L;

	private JButton btn_Eliminar;
	private JLabel lbl_correo;
	private JLabel lbl_dni;
	private JLabel lbl_nombre;
	private JLabel lbl_nick;

	public final static byte VER_EDITORES = 0;
	public final static byte VER_CLIENTES = 1;

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(Color.DARK_GRAY);
		g.drawLine(30, 74, 450, 74);
	}

	public Elemento_A_Listar(final Object usuario, final byte opcion) {
		setBackground(new Color(35, 35, 35));
		// miPaElemento_A_Listar=new JPanel();
		/* miPaElemento_A_Listar. */setBounds(0, 0, 462, 75);
		setLayout(null);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				setBackground((Color.DARK_GRAY));
				btn_Eliminar.setVisible(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				setBackground(new Color(35, 35, 35));
				btn_Eliminar.setVisible(false);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				Toolkit t = Toolkit.getDefaultToolkit();
				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				PointerInfo a = MouseInfo.getPointerInfo();
				Point b = a.getLocation();
				int x = (int) b.getX();
				int y = (int) b.getY();
				if (x > screenSize.width - 450) {
					x = x - 450;
				}
				if (y > screenSize.height - 257) {
					y = y - 257;
				}
				if (opcion == 0) {
					VentanaAdmin.adminFrame(usuario, VentanaAdmin.EDITUSER, x, y);
				} else {
					VentanaCliente.clientFrame(usuario, VentanaAdmin.EDITUSER, x, y);
				}
			}
		});
		btn_Eliminar = new JButton();
		btn_Eliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				setBackground((Color.DARK_GRAY));
				btn_Eliminar.setVisible(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				setBackground(new Color(35, 35, 35));
				btn_Eliminar.setVisible(false);
			}
		});
		btn_Eliminar.setVisible(false);
		btn_Eliminar.setToolTipText(Literales.ToolTips.DELETEUSER);
		btn_Eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_Eliminar.setFocusable(false);
				btn_Eliminar.setFocusable(true);
				Control.control(Control.DELETEUSER, usuario);
			}
		});

		btn_Eliminar.setBackground(null);
		btn_Eliminar.setContentAreaFilled(false);
		btn_Eliminar.setOpaque(false);
		btn_Eliminar.setBorder(null);
		URL imageURL = getClass().getClassLoader().getResource(Literales.Iconos.DELETEICO);
		ImageIcon deleteico = new ImageIcon(imageURL);
		btn_Eliminar.setIcon(deleteico);
		btn_Eliminar.setBounds(387, 11, 63, 53);
		add(btn_Eliminar);

		
		
		
		switch (opcion) {
		case 0: {

			lbl_nick = new JLabel(((Administrador) usuario).getNick());
			lbl_nick.setForeground(Color.LIGHT_GRAY);
			lbl_nick.setFont(new Font("Times New Roman", Font.BOLD, 15));
			lbl_nick.setBounds(27, 35, 189, 27);
			add(lbl_nick);
			lbl_nombre = new JLabel(((Administrador) usuario).getName());
			lbl_nombre.setForeground(Color.LIGHT_GRAY);
			lbl_nombre.setFont(new Font("Times New Roman", Font.BOLD, 16));
			lbl_nombre.setBounds(27, 13, 202, 27);
			add(lbl_nombre);
		}
			break;
		case 1: {
			lbl_nick = new JLabel("");
			lbl_nick = new JLabel(((Cliente) usuario).getNick());
			lbl_nick.setForeground(Color.LIGHT_GRAY);
			lbl_nick.setFont(new Font("Times New Roman", Font.BOLD, 15));
			lbl_nick.setBounds(27, 14, 189, 27);
			add(lbl_nick);
			lbl_dni = new JLabel("");
			lbl_dni = new JLabel(((Cliente) usuario).getDni());
			lbl_dni.setForeground(Color.LIGHT_GRAY);
			lbl_dni.setFont(new Font("Times New Roman", Font.BOLD, 16));
			lbl_dni.setBounds(160, 13, 202, 27);
			add(lbl_dni);
			lbl_correo = new JLabel("");
			lbl_correo = new JLabel(((Cliente) usuario).getEmail());
			lbl_correo.setForeground(Color.LIGHT_GRAY);
			lbl_correo.setFont(new Font("Times New Roman", Font.BOLD, 16));
			lbl_correo.setBounds(27, 37, 317, 27);
			add(lbl_correo);

		}
			break;

		}
	}
}