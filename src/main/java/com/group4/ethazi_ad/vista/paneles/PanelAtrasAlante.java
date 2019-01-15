package com.group4.ethazi_ad.vista.paneles;

import com.group4.ethazi_ad.modelo.constantes.Literales;
import com.group4.ethazi_ad.vista.ventanas.VentanaPrincipal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;

public class PanelAtrasAlante extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3155874535095371982L;
	private static int pagina = 1;

	public static ArrayList<Object> usuarios;

	private static JButton btn_siguiente;
	private static JButton btn_anterior;
	private static int maxPags;

	public PanelAtrasAlante(final ArrayList<Object> usuarios, final int maxPags) {
		this.usuarios = usuarios;
		this.maxPags = maxPags;
		setOpaque(false);
		setLayout(null);
		setBackground(new Color(55, 55, 55));
		btn_siguiente = new JButton();
		btn_siguiente.setBorder(null);
		btn_siguiente.setContentAreaFilled(false);
		btn_siguiente.setOpaque(false);
		btn_siguiente.setBackground(null);
		URL imageURL = getClass().getClassLoader().getResource(Literales.Iconos.FDERECHAICO);
		ImageIcon fderecha = new ImageIcon(imageURL);
		btn_siguiente.setIcon(fderecha);
		btn_anterior = new JButton();
		btn_anterior.setBorder(null);
		btn_anterior.setContentAreaFilled(false);
		btn_anterior.setOpaque(false);
		btn_anterior.setBackground(null);
		btn_anterior.setToolTipText(Literales.ToolTips.LASTPAGE);
		URL imageURL2 = getClass().getClassLoader().getResource(Literales.Iconos.FIZQUIERDAICO);
		ImageIcon fizquierda = new ImageIcon(imageURL2);
		btn_anterior.setIcon(fizquierda);
		setPreferredSize(new Dimension(500, 37));
		btn_siguiente.setBounds(295, 0, 105, 34);
		btn_siguiente.setToolTipText(Literales.ToolTips.NEXTPAGE);
		add(btn_siguiente);
		btn_anterior.setBounds(110, 0, 105, 34);
		add(btn_anterior);
		btn_anterior.setVisible(false);
		if (pagina == maxPags) {
			btn_siguiente.setVisible(false);
		}

		btn_siguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btn_siguiente.setFocusable(false);
				btn_siguiente.setFocusable(true);
				rightPress();
			}

		});

		btn_anterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btn_anterior.setFocusable(false);
				btn_anterior.setFocusable(true);
				leftPress();
				// VentanaPrincipal.addcont();
			}
		});

	}

	public static void leftPress() {
		
		if (pagina > 1){
			PanelUsuarios.up();
			if (pagina == maxPags) {
				btn_siguiente.setVisible(true);
			}
			if (pagina == 2) {
				btn_anterior.setVisible(false);
			}

			pagina--;
			PanelUsuarios.mostrar10(usuarios, pagina);
			VentanaPrincipal.setFocusTxField();
		}
		
	}
	public static void rightPress() {
		if (pagina < maxPags) {
			PanelUsuarios.up();
			if (pagina == 1) {
				btn_anterior.setVisible(true);
			}
			if (pagina == maxPags - 1) {
				btn_siguiente.setVisible(false);
			}
			pagina++;
			PanelUsuarios.mostrar10(usuarios, pagina);
			VentanaPrincipal.setFocusTxField();
		}

	}

}
