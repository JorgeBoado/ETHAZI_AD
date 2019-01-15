package com.group4.ethazi_ad.vista.paneles;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Elementos_Listados extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1617775952182198487L;

	public Elementos_Listados(ArrayList<Elemento_A_Listar> arrayElementosListables, int limite) {
		setLayout(null);
		setBorder(null);
		setAlignmentX(0);
		setAlignmentY(0);
		setOpaque(false);
		setPreferredSize(new Dimension(450, arrayElementosListables.size() * 75 ));
		setBackground(new Color (35,35,35));
		setBorder(null);
		
		for (int i = 0, coordenada = 0; i < limite; i++, coordenada += 75) {
			arrayElementosListables.get(i).setBounds(0, coordenada, 475, 75);
			add(arrayElementosListables.get(i));
		}
	}

	public void actualizar(ArrayList<Elemento_A_Listar> arrayElementosListables, int limite) {
		removeAll();
		setPreferredSize(new Dimension(450, arrayElementosListables.size() * 75 ));
		setBackground(new Color (35,35,35));
		setBorder(null);
		for (int i = 0, coordenada = 0; i < limite; i++, coordenada += 75) {

			arrayElementosListables.get(i).setBounds(0, coordenada, 475, 75);

			add(arrayElementosListables.get(i));
		}
	}
}
