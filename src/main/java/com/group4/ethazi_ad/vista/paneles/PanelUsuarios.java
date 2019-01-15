package com.group4.ethazi_ad.vista.paneles;

import com.group4.ethazi_ad.modelo.constantes.Literales;
import com.group4.ethazi_ad.vista.ventanas.VentanaPrincipal;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelUsuarios extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */
	private static ArrayList<Elemento_A_Listar> pUsuarios = new ArrayList<Elemento_A_Listar>();
	// private static Elementos_Listados panel_QueTieneLaLista;
	private static Elementos_Listados panel_QueTieneLaLista_1;
	private static JScrollPane pa_listado;
	private static JLabel lbl_SinResultados;
	private JButton btnNewButton;

	public static void up() {
		pa_listado.getVerticalScrollBar().setValue(0);
	}

	public PanelUsuarios(Object arrayusers) {
		@SuppressWarnings("unchecked")
		ArrayList<Object> usuarios = (ArrayList<Object>) arrayusers;
		setBackground(new Color(35, 35, 35));
		setPreferredSize(new Dimension(500, 500));
		setBorder(null);
		int cont = 0;
		int elemento = (1 * 10) - 10;
		int maxPags = ((usuarios.size() / 10) + (int) Math.pow(usuarios.size() % 10, 0));
		int sobra = usuarios.size() % 10;
		int aMostrar = 10;
		setLayout(null);

		lbl_SinResultados = new JLabel(Literales.Mensajes.NORESULTS);
		lbl_SinResultados.setForeground(Color.GRAY);
		if (((ArrayList<?>) arrayusers).size() < 1) {
			lbl_SinResultados.setVisible(true);
		} else {
			lbl_SinResultados.setVisible(false);
		}

		lbl_SinResultados.setBounds(210, 21, 139, 14);
		lbl_SinResultados.setFont(new Font("Tahoma", Font.PLAIN, 16));
		this.add(lbl_SinResultados);
		if (sobra != 0 && maxPags == 1) {
			aMostrar = sobra;
		}

		Elemento_A_Listar aux;
		try {
			while (cont < aMostrar) {
				byte modo;
				if (VentanaPrincipal.getRdbtnEditores().isSelected()) {
					modo = Elemento_A_Listar.VER_EDITORES;
				} else {
					modo = Elemento_A_Listar.VER_CLIENTES;
				}
				aux = new Elemento_A_Listar(usuarios.get(elemento + cont), modo);
				pUsuarios.add(aux);
				cont++;
			}

			cargarConfListado(aMostrar);
			{
				btnNewButton = new JButton("");
				btnNewButton.setBackground(new Color(35, 35, 35));
				btnNewButton.setFocusable(false);
				btnNewButton.setBorder(null);
				btnNewButton.setBounds(485, 0, 50, 16);
				add(btnNewButton);
				btnNewButton = new JButton("");
				btnNewButton.setBackground(new Color(35, 35, 35));
				btnNewButton.setFocusable(false);
				btnNewButton.setBorder(null);
				btnNewButton.setBounds(485, 432, 50, 16);
				add(btnNewButton);
			}

			// pa_listado.getVerticalScrollBar().setUI(new BasicScrollBarUI());
			add(pa_listado);

			/* Lanzar panel de atras y alante */

			JPanel _panelBotonAtrasYAlante = new PanelAtrasAlante(usuarios, maxPags);
			_panelBotonAtrasYAlante.setBounds(0, 453, 500, 37);
			add(_panelBotonAtrasYAlante);
		} catch (Exception e) {
			// e.printStackTrace();
		}

	}

	public static void mostrar10(ArrayList<Object> usuarios, int nPagina) {
		int cont = 0;
		pUsuarios.clear();
		pUsuarios = new ArrayList<Elemento_A_Listar>();
		int elemento = (nPagina * 10) - 10;
		int maxPags = ((usuarios.size() / 10) + (int) Math.pow(usuarios.size() % 10, 0));
		int sobra = usuarios.size() % 10;
		int aMostrar = 10;

		if (sobra != 0 && maxPags == nPagina) {
			aMostrar = sobra;
		}
		Elemento_A_Listar aux;
		while (cont < aMostrar) {
			byte modo;
			if (VentanaPrincipal.getRdbtnEditores().isSelected()) {
				modo = Elemento_A_Listar.VER_EDITORES;
			} else {
				modo = Elemento_A_Listar.VER_CLIENTES;
			}
			aux = new Elemento_A_Listar(usuarios.get(elemento + cont), modo);
			pUsuarios.add(aux);

			cont++;
		}

		panel_QueTieneLaLista_1.actualizar(pUsuarios, aMostrar);

		panel_QueTieneLaLista_1.updateUI();
	}

	public void actualizar(Object arrayusers) {

		removeAll();
		setBorder(null);
		setBackground(new Color(35, 35, 35));
		btnNewButton = new JButton("");
		btnNewButton.setBackground(new Color(35, 35, 35));
		btnNewButton.setFocusable(false);
		btnNewButton.setBorder(null);
		btnNewButton.setBounds(485, 0, 50, 16);
		add(btnNewButton);
		btnNewButton = new JButton("");
		btnNewButton.setBackground(new Color(35, 35, 35));
		btnNewButton.setFocusable(false);
		btnNewButton.setBorder(null);
		btnNewButton.setBounds(485, 432, 50, 16);
		add(btnNewButton);
		@SuppressWarnings("unchecked")
		ArrayList<Object> usuarios = (ArrayList<Object>) arrayusers;
		if (((ArrayList<?>) arrayusers).size() < 1) {
			lbl_SinResultados.setVisible(true);
		} else {
			lbl_SinResultados.setVisible(false);
		}
	
		if (((ArrayList<?>) arrayusers).size() > 0) {
			PanelUsuarios.pUsuarios.clear();
	
			setPreferredSize(new Dimension(500, 450));
			setLayout(null);
			int cont = 0;
			int elemento = (1 * 10) - 10;
			int maxPags;
			if (usuarios.size() % 10 == 0) {
				maxPags = ((usuarios.size() / 10));
			} else {
				maxPags = ((usuarios.size() / 10) + (int) Math.pow(usuarios.size() % 10, 0));
			}

			int sobra = usuarios.size() % 10;
			int aMostrar = 10;

			if (sobra != 0 && maxPags == 1) {
				aMostrar = sobra;
			}

			Elemento_A_Listar aux;
			if (usuarios.size() > 0) {
				while (cont < aMostrar) {
					byte modo;
					if (VentanaPrincipal.getRdbtnEditores().isSelected()) {
						modo = Elemento_A_Listar.VER_EDITORES;
					} else {
						modo = Elemento_A_Listar.VER_CLIENTES;

					}
					aux = new Elemento_A_Listar(usuarios.get(elemento + cont), modo);
					pUsuarios.add(aux);
					cont++;
				}
			}

			cargarConfListado(aMostrar);

			// pa_listado.getVerticalScrollBar().setUI(new BasicScrollBarUI());

			add(pa_listado);
			/* Lanzar panel de atras y alante */
			JPanel _panelBotonAtrasYAlante = new PanelAtrasAlante(usuarios, maxPags);
			_panelBotonAtrasYAlante.setBounds(10, 453, 500, 37);
			add(_panelBotonAtrasYAlante);
		} else {
			this.add(lbl_SinResultados);
		}
		btnNewButton = new JButton("");
		btnNewButton.setBackground(new Color(35, 35, 35));
		btnNewButton.setFocusable(false);
		btnNewButton.setBorder(null);
		btnNewButton.setBounds(485, 0, 50, 16);
		add(btnNewButton);

	}

	public static void cargarConfListado(int aMostrar) {
		panel_QueTieneLaLista_1 = new Elementos_Listados(pUsuarios, aMostrar);
		panel_QueTieneLaLista_1.setOpaque(true);
		panel_QueTieneLaLista_1.setBackground(new Color(35, 35, 35));
		pa_listado = new CustomScrollPane();
		pa_listado.setOpaque(false);
		pa_listado.getViewport().setOpaque(false);
		pa_listado.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

		pa_listado.setBounds(10, 0, 500, 448);
		pa_listado.getVerticalScrollBar().setUnitIncrement(19);
		pa_listado.setViewportView(panel_QueTieneLaLista_1);

		// UIManager.put("ScrollBar.thumb", new ColorUIResource(Color.LIGHT_GRAY));

		pa_listado.getVerticalScrollBar().validate();
		pa_listado.validate();
		System.out.println(pa_listado.getVerticalScrollBar().getBackground());

		pa_listado.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		pa_listado.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

	}
}
