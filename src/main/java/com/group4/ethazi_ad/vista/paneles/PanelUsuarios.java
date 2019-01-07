package com.group4.ethazi_ad.vista.paneles;

import com.group4.ethazi_ad.controlador.Elemento_A_Listar;
import com.group4.ethazi_ad.controlador.Elementos_Listados;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;




public class PanelUsuarios extends JPanel {

	/**
	 * Create the panel.
	 */
	static ArrayList<Elemento_A_Listar> pUsuarios = new ArrayList();
	static Elementos_Listados panel_QueTieneLaLista;
	public PanelUsuarios(ArrayList<Object> usuarios) {
		setPreferredSize(new Dimension(762,488));
		setLayout(null);
		int cont = 0;
		int elemento = (1 * 10) - 10;
		int maxPags =  ((usuarios.size()/10) + (int)Math.pow(usuarios.size()%10, 0));
		int sobra = usuarios.size()%10;
		int aMostrar = 10;
	
		if (sobra!=0 && maxPags == 1) {
			aMostrar = sobra;
		}
		
		Elemento_A_Listar aux;
		while (cont < aMostrar) {
			aux = new Elemento_A_Listar(usuarios.get(elemento + cont), (byte) 0);
			pUsuarios.add(aux);
			cont++;
		}
		panel_QueTieneLaLista = new Elementos_Listados(pUsuarios, aMostrar);
		JScrollPane pa_listado = new JScrollPane();
		//Elementos_Listados panel_QueTieneLaLista = new Elementos_Listados(pOfertas);

		pa_listado.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		pa_listado.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pa_listado.setBounds(10, 0, 500, 443);
		pa_listado.getVerticalScrollBar().setUnitIncrement(16);
		pa_listado.setViewportView(panel_QueTieneLaLista);
		// getContentPane().add(scroll);
		add(pa_listado);
		
		/* Lanzar panel de filtros */
		JScrollPane pa_filtros = new JScrollPane();
		pa_filtros.setBounds(512, 0, 247, 482);
		add(pa_filtros);
		
		/* Lanzar panel de atras y alante */
		JPanel _panelBotonAtrasYAlante = new PanelAtrasAlante(usuarios, maxPags);
		_panelBotonAtrasYAlante.setBounds(10, 445, 500, 37);
			add(_panelBotonAtrasYAlante);
	}
	public static void mostrar10(ArrayList<Object> ofertas, int nPagina) {
		int cont = 0;
		pUsuarios.clear();
		pUsuarios = new ArrayList();
		int elemento = (nPagina * 10) - 10;
		int maxPags =  ((ofertas.size()/10) + (int)Math.pow(ofertas.size()%10, 0));
		int sobra = ofertas.size()%10;
		int aMostrar = 10;
	
		if (sobra!=0 && maxPags == nPagina) {
			aMostrar = sobra;
		}
		Elemento_A_Listar aux;
		while (cont < aMostrar) {
			aux = new Elemento_A_Listar(ofertas.get(elemento + cont), (byte) 0);
			pUsuarios.add(aux);
			cont++;
		}
		panel_QueTieneLaLista.actualizar(pUsuarios, aMostrar);;
		panel_QueTieneLaLista.updateUI();
	}

}
