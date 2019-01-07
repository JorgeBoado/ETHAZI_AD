package com.group4.ethazi_ad.vista.paneles;

import com.group4.ethazi_ad.vista.ventanas.VentanaPrincipal;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;



public class PanelAtrasAlante extends JPanel {

	private int pagina = 1;

	public PanelAtrasAlante(final ArrayList<Object> usuarios, final int maxPags ) {
		setLayout(null);
		final JButton btn_siguiente = new JButton("Siguiente");
		final JButton btn_anterior = new JButton("Anterior");
		setPreferredSize(new Dimension(500, 37));
		btn_siguiente.setBounds(295, 0, 105, 34);
		add(btn_siguiente);
		btn_anterior.setBounds(110, 0, 105, 34);
		add(btn_anterior);
		btn_anterior.setVisible(false);
		if (pagina == maxPags) {
			btn_siguiente.setVisible(false);
		}

		btn_siguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// VentanaPrincipal.remcont();
				if (pagina == 1) {
					btn_anterior.setVisible(true);
				}
				if (pagina == maxPags - 1) {
					btn_siguiente.setVisible(false);
				}
				pagina++;
				PanelUsuarios.mostrar10(usuarios, pagina);
				 VentanaPrincipal.addcont();
			}
		});

		btn_anterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// VentanaPrincipal.remcont();
				if (pagina == maxPags) {
					btn_siguiente.setVisible(true);
				}
				if (pagina == 2) {
					btn_anterior.setVisible(false);
				}

				pagina--;
				PanelUsuarios.mostrar10(usuarios, pagina);
	
				// VentanaPrincipal.addcont();
			}
		});

	}

}
