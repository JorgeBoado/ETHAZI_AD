package com.group4.ethazi_ad.controlador;

import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Elementos_Listados extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1617775952182198487L;


	public Elementos_Listados(ArrayList<Elemento_A_Listar> arrayElementosListables, int limite) {
		setLayout(null);
		setAlignmentX(0);
		setAlignmentY(0);
		setPreferredSize(new Dimension(600,1050));
		for(int i=0, coordenada=0;i< limite;i++,coordenada+=100)
		{
			arrayElementosListables.get(i).setBounds(10,coordenada,500,91);
			add(arrayElementosListables.get(i));
		}	
	}
	
	public void actualizar(ArrayList<Elemento_A_Listar> arrayElementosListables, int limite) {
		removeAll();
		for(int i=0, coordenada=0;i< limite;i++,coordenada+=100)
		{
			
			arrayElementosListables.get(i).setBounds(10,coordenada,500,91);
			
			add(arrayElementosListables.get(i));
		}	
	}
}
