package com.group4.ethazi_ad.vista.ventanas;

import com.group4.ethazi_ad.controlador.Control;
import com.group4.ethazi_ad.modelo.clases.Administrador;
import com.group4.ethazi_ad.modelo.constantes.Literales;
import com.group4.ethazi_ad.vista.paneles.PanelDegradado;
import com.group4.ethazi_ad.vista.paneles.PanelUsuarios;
import com.group4.ethazi_ad.vista.paneles.ShadowPane;
import com.group4.ethazi_ad.vista.paneles.TFbuscar;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;


/**
 * Ventana principal
 */
public class VentanaPrincipal extends JFrame {

	private static JRadioButton rdbtnClientes;
	private static JRadioButton rdbtnEditores;
	private static String lastFind;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static TFbuscar txField_buscar;
	private static JPanel pa_contenedor = new JPanel();
	private static PanelUsuarios pa_buscarUsuarios;
	private static JButton btn_buscar;
	private static VentanaPrincipal frame;
	private static PanelDegradado pa_barraHerramientas;
	private static JButton btn_newUser;
	private static ButtonGroup buttonGroup = new ButtonGroup();
	private static JButton btn_off;

	public static VentanaPrincipal getFrame() {
		return frame;
	}

	private static int rdb = 1;

	public static JRadioButton getRdbtnEditores() {
		return rdbtnEditores;
	}
	public static String getLastFind() {
		return lastFind;
	}
	public static void setLastFind(String lastFind) {
		VentanaPrincipal.lastFind = lastFind;
	}
	public static JButton getBtn_buscar() {
		return btn_buscar;
	}
	public static JTextField getTxField_buscar() {
		return txField_buscar;
	}

	public static JPanel getPa_contenedor() {
		return pa_contenedor;
	}
	public static PanelUsuarios getPa_buscarUsuarios() {
		return pa_buscarUsuarios;
	}

	/**
	 *
	 * @param admin el que inicia la session
	 *              abre una ventana principañ
	 */

	public static void sessionIniciada(final Administrador admin) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new VentanaPrincipal(admin);
					frame.addWindowListener(new WindowAdapter() {
						public void windowOpened(WindowEvent e) {
							txField_buscar.requestFocus();
						}
					});
					frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void setFocusTxField() {
		txField_buscar.requestFocus();
	}

	/**
	 * Create the frame
	 */
	public VentanaPrincipal(final Administrador administrador) {
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 523, 574);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		crearPaneles();

		lastFind = "";
		Control.control(Control.UPDATELIST, null);
		setContentPane(contentPane);
	}

	public void crearPaneles() {
		pa_buscarUsuarios = new PanelUsuarios(Control.getUsuarios());
		pa_buscarUsuarios.setBounds(0, 0, 522, 500);
		pa_buscarUsuarios.setBackground(new Color(35, 35, 35));
		pa_contenedor.setBackground(new Color(35, 35, 35));
		pa_contenedor.setBounds(0, 80, 762, 506);
		pa_contenedor.setLayout(null);
		pa_contenedor.add(pa_buscarUsuarios);

		contentPane = new ShadowPane();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.add(pa_contenedor);
		lanzarBarraHerramientas();
		contentPane.add(pa_barraHerramientas);
	}

	public void lanzarBarraHerramientas() {

		pa_barraHerramientas = new PanelDegradado();
		pa_barraHerramientas.setOpaque(false);
		pa_barraHerramientas.setLayout(null);
		pa_barraHerramientas.setBounds(0, 0, 523, 81);

		txField_buscar = new TFbuscar(50);
		txField_buscar.setAlignmentY(Component.TOP_ALIGNMENT);
		txField_buscar.setAlignmentX(Component.LEFT_ALIGNMENT);
		txField_buscar.setToolTipText(Literales.ToolTips.SEARCH);
		txField_buscar.setText("");
		txField_buscar.setHorizontalAlignment(SwingConstants.LEFT);
		txField_buscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txField_buscar.setColumns(10);
		txField_buscar.setBounds(67, 13, 195, 33);
		pa_barraHerramientas.add(txField_buscar);

		btn_buscar = new JButton();
		btn_buscar.setFocusPainted(false);
		btn_buscar.setBorder(null);
		btn_buscar.setContentAreaFilled(false);
		btn_buscar.setOpaque(false);
		btn_buscar.setBackground(null);
		try {
			Image img = ImageIO.read(getClass().getResource(Literales.Iconos.FINDICO));
			btn_buscar.setIcon(new ImageIcon(img));
		} catch (Exception ex) {
			System.out.println(ex);
		}

		btn_buscar.setBounds(12, 5, 50, 50);
		btn_buscar.setToolTipText(Literales.ToolTips.FIND);
		btn_buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_buscar.setFocusable(false);
				VentanaPrincipal.getBtn_buscar().setFocusable(true);
				setLastFind(getTxField_buscar().getText());
				Control.control(Control.UPDATELIST, null);
			}
		});
		btn_buscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btn_buscar.setFocusPainted(true);
			}

		});

		pa_barraHerramientas.add(btn_buscar);
		btn_newUser = new JButton();
		btn_newUser.setBorder(null);
		btn_newUser.setBackground(null);
		btn_newUser.setOpaque(false);
		btn_newUser.setContentAreaFilled(false);
		btn_newUser.setToolTipText(Literales.ToolTips.NEWUSER);
		try {
			Image img = ImageIO.read(getClass().getResource(Literales.Iconos.NEWUSERICO));
			btn_newUser.setIcon(new ImageIcon(img));
		} catch (Exception ex) {
			System.out.println(ex);
		}

		btn_newUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_newUser.setFocusable(false);
				btn_newUser.setFocusable(true);
				Control.control(Control.NEWUSERFRAME, null);
				txField_buscar.requestFocus();
			}
		});
		btn_newUser.setBounds(269, 5, 66, 50);
		pa_barraHerramientas.add(btn_newUser);

		btn_off = new JButton();
		btn_off.setBorder(null);
		btn_off.setBackground(null);
		btn_off.setOpaque(false);
		btn_off.setContentAreaFilled(false);
		try {
			Image img = ImageIO.read(getClass().getResource(Literales.Iconos.OFFICO));
			btn_off.setIcon(new ImageIcon(img));
		} catch (Exception ex) {
			System.out.println(ex);
		}
		btn_off.setToolTipText(Literales.ToolTips.OFF);

		btn_off.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_off.setFocusable(false);
				btn_off.setFocusable(true);
				Control.control(Control.EXIT, null);
				txField_buscar.requestFocus();
			}
		});
		btn_off.setBounds(445, 5, 66, 50);
		pa_barraHerramientas.add(btn_off);

		rdbtnEditores = new JRadioButton("Editores");
		rdbtnEditores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				txField_buscar.requestFocus();
				if (rdb != 1) {
					Control.control(Control.UPDATELIST, 1);
				}
				rdb = 1;
			}
		});
		rdbtnEditores.setForeground(Color.WHITE);
		rdbtnEditores.setSelected(true);
		rdbtnEditores.setOpaque(false);
		rdbtnEditores.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnEditores.setBounds(343, 8, 93, 23);
		pa_barraHerramientas.add(rdbtnEditores);

		rdbtnClientes = new JRadioButton("Clientes");
		rdbtnClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				txField_buscar.requestFocus();
				if (rdb != 2) {
					Control.control(Control.UPDATELIST, 1);
				}
				rdb = 2;
			}
		});
		rdbtnClientes.setForeground(Color.WHITE);
		rdbtnClientes.setOpaque(false);
		rdbtnClientes.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnClientes.setBounds(344, 28, 93, 23);
		pa_barraHerramientas.add(rdbtnClientes);

		buttonGroup.add(rdbtnClientes);
		buttonGroup.add(rdbtnEditores);

		txField_buscar.requestFocus();
	}

}