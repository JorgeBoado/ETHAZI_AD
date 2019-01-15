package com.group4.ethazi_ad.vista.ventanas;

import com.group4.ethazi_ad.controlador.Control;
import com.group4.ethazi_ad.controlador.SentenciasHQL;
import com.group4.ethazi_ad.controlador.configuracion.SessionManager;
import com.group4.ethazi_ad.modelo.constantes.Literales;
import com.group4.ethazi_ad.vista.paneles.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class VentanaPrincipal extends JFrame {

	private static JRadioButton rdbtnClientes;
	private static JRadioButton rdbtnEditores;
	private static String lastFind;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField txField_buscar;
	private static JPanel pa_contenedor = new JPanel();
	private static PanelUsuarios pa_buscarUsuarios;
	private static JButton btn_buscar;
	private static VentanaPrincipal frame;
	private static JButton btn_newUser;
	private static ButtonGroup buttonGroup = new ButtonGroup();
	private static int x;
	private static int y;

	public static JRadioButton getRdbtnClientes() {
		return rdbtnClientes;
	}

	public static void setRdbtnClientes(JRadioButton rdbtnClientes) {
		VentanaPrincipal.rdbtnClientes = rdbtnClientes;
	}

	public static JRadioButton getRdbtnEditores() {
		return rdbtnEditores;
	}

	public static void setRdbtnEditores(JRadioButton rdbtnEditores) {
		VentanaPrincipal.rdbtnEditores = rdbtnEditores;
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

	public static void setBtn_buscar(JButton btn_buscar) {
		VentanaPrincipal.btn_buscar = btn_buscar;
	}

	public static JButton getBtn_newUser() {
		return btn_newUser;
	}

	public static void setBtn_newUser(JButton btn_newUser) {
		VentanaPrincipal.btn_newUser = btn_newUser;
	}

	public static JButton getBtn_off() {
		return btn_off;
	}

	public static void setBtn_off(JButton btn_off) {
		VentanaPrincipal.btn_off = btn_off;
	}

	public static Object getUsuarios() {
		return usuarios;
	}

	@SuppressWarnings("unchecked")
	public static void setUsuarios(Object a) {
		VentanaPrincipal.usuarios = (ArrayList<Object>) a;
	}

	public static JTextField getTxField_buscar() {
		return txField_buscar;
	}

	public static void setTxField_buscar(JTextField txField_buscar) {
		VentanaPrincipal.txField_buscar = txField_buscar;
	}

	public static JPanel getPa_contenedor() {
		return pa_contenedor;
	}

	public static void setPa_contenedor(JPanel pa_contenedor) {
		VentanaPrincipal.pa_contenedor = pa_contenedor;
	}

	public static PanelUsuarios getPa_buscarUsuarios() {
		return pa_buscarUsuarios;
	}

	public static void setPa_buscarUsuarios(PanelUsuarios pa_buscarUsuarios) {
		VentanaPrincipal.pa_buscarUsuarios = pa_buscarUsuarios;
	}

	private static JButton btn_off;
	private static ArrayList<Object> usuarios = new ArrayList<Object>();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// LookAndFeel();
					SessionManager.createSession();
					frame = new VentanaPrincipal();
					// Esto va al logger TODO
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

	public static void LookAndFeel() {
		try {
			// Set System L&F
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException
				| IllegalAccessException e) {
			// handle exception
		}
	}

	/**
	 * Create the frame
	 */
	@SuppressWarnings("unchecked")
	public VentanaPrincipal() {
		setUndecorated(true);
		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 523, 574);
		contentPane = new ShadowPane();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		lanzarBarraHerramientas();
		pa_contenedor.setBackground(new Color(35, 35, 35));
		pa_contenedor.setBounds(0, 80, 762, 506);
		contentPane.add(pa_contenedor);
		pa_contenedor.setLayout(new CardLayout(0, 0));

		usuarios = (ArrayList<Object>) ((ArrayList<?>) SentenciasHQL.select_Admins_Contain_Nick("la", "editor"));

		crearPaneles();

	}

	public void crearPaneles() {

		pa_buscarUsuarios = new PanelUsuarios(usuarios);
		pa_buscarUsuarios.setBackground(new Color(35, 35, 35));
		pa_contenedor.add(pa_buscarUsuarios);

	}

	public void lanzarBarraHerramientas() {

		JPanel pa_barraHerramientas = new PanelDegradado();
		pa_barraHerramientas.setOpaque(false);
		pa_barraHerramientas.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				Point point = MouseInfo.getPointerInfo().getLocation();
				setLocation(point.x - x, point.y - y);
			}
		});
		pa_barraHerramientas.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				x = e.getX();
				y = e.getY();
			}
		});

		pa_barraHerramientas.setLayout(null);

		pa_barraHerramientas.setBounds(0, 0, 523, 81);
		contentPane.add(pa_barraHerramientas);

		txField_buscar = new ModernTXField();
		txField_buscar.setAlignmentY(Component.TOP_ALIGNMENT);
		txField_buscar.setAlignmentX(Component.LEFT_ALIGNMENT);

		txField_buscar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					setLastFind(getTxField_buscar().getText());
					Control.control(Control.UPDATELIST, null);
					txField_buscar.setText("");
				}
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					txField_buscar.setText("");
				}
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					PanelAtrasAlante.leftPress();
				}
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					PanelAtrasAlante.rightPress();
				}
			}
		});
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
		;

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
				Toolkit t = Toolkit.getDefaultToolkit();
				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				PointerInfo a = MouseInfo.getPointerInfo();
				Point b = a.getLocation();
				int x = (int) b.getX();
				int y = (int) b.getY();
				if (x > screenSize.width - 450) {
					x = x - 450;
				}
				if (rdbtnEditores.isSelected()) {
					VentanaAdmin.adminFrame(null, VentanaAdmin.NEWUSER, x, y);
				} else {
					VentanaCliente.clientFrame(null, VentanaCliente.NEWUSER, x, y);
				}

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
				txField_buscar.requestFocus();
				SessionManager.disconnect();
				dispose();
			}
		});
		btn_off.setBounds(445, 5, 66, 50);
		pa_barraHerramientas.add(btn_off);

		rdbtnEditores = new JRadioButton("Editores");
		rdbtnEditores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				Control.control(Control.UPDATELIST, null);
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
				Control.control(Control.UPDATELIST, null);
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

	public static void remcont() {
		pa_contenedor.remove(pa_buscarUsuarios);
	}

}
