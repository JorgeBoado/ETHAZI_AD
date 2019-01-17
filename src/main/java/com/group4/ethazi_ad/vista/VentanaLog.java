package com.group4.ethazi_ad.vista;

import com.group4.ethazi_ad.controlador.SentenciasHQL;
import com.group4.ethazi_ad.controlador.configuracion.SessionManager;
import com.group4.ethazi_ad.modelo.clases.Administrador;
import com.group4.ethazi_ad.modelo.constantes.Literales;
import com.group4.ethazi_ad.vista.paneles.ModernTXField;
import com.group4.ethazi_ad.vista.paneles.PanelDegradado2;
import com.group4.ethazi_ad.vista.paneles.PassField;
import com.group4.ethazi_ad.vista.ventanas.VentanaPrincipal;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class VentanaLog extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static 	JLabel lblNick;
	private static JFrame frame;
	private static PanelDegradado2 contentPane;
	private static JTextField tf_nick;
	private static JTextField tf_pass;
	private JButton btn_iniciar;
	private static int x;
	private static int y;
	static boolean threadEND = false;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Thread thread = new Thread(){
							public void run(){
								SessionManager.getInstance();
								threadEND = true;
						}
					};
					thread.start();
					frame = new VentanaLog();

					frame.addWindowListener(new WindowAdapter() {
						public void windowOpened(WindowEvent e) {
							tf_nick.requestFocus();
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

	public VentanaLog() {
		setUndecorated(true);
		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 454, 259);
		contentPane = new PanelDegradado2();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		getContentPane().setLayout(null);

		final JLabel lbl_error = new JLabel("ERROR");
		lbl_error.setVisible(false);
		lbl_error.setForeground(Color.RED);
		lbl_error.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_error.setBounds(10, 234, 46, 14);
		contentPane.add(lbl_error);
		btn_iniciar = new JButton("");
		btn_iniciar = new JButton();
		btn_iniciar.setForeground(Color.LIGHT_GRAY);
		btn_iniciar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_iniciar.setText("Conectar");
		btn_iniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btn_iniciar.setFocusable(false);
				btn_iniciar.setFocusable(true);
				tf_nick.requestFocus();
				if (threadEND){
					try {
						Administrador admin = new Administrador(0, tf_nick.getText(), tf_pass.getText(),
								Literales.AdminsLiterals.ADMINISTRADOR, "");
						admin.cifrar();
						// TODO verificar
						if (SentenciasHQL.select_Admins_Contain_Admin(admin).size() == 1) {
							setVisible(false);
							VentanaPrincipal.sessionIniciada(admin);
							dispose();
						}
						else {
							lbl_error.setVisible(true);
						}
					} catch (Exception e) {
						lbl_error.setVisible(true);
						e.printStackTrace();
					}

				}

			}
		});
		btn_iniciar.setBorder(null);
		btn_iniciar.setBackground(null);
		btn_iniciar.setOpaque(false);
		btn_iniciar.setContentAreaFilled(false);
		try {
			Image img = ImageIO.read(getClass().getResource(Literales.Iconos.LOGICO));
			btn_iniciar.setIcon(new ImageIcon(img));
		} catch (Exception ex) {
			System.out.println(ex);
		}
		btn_iniciar.setToolTipText(Literales.ToolTips.OFF);
		btn_iniciar.setBounds(169, 204, 104, 33);
		
		contentPane.add(btn_iniciar);
		
	
		setLocationRelativeTo(null);
		final JButton btn_off = new JButton();
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
				if (threadEND){
					btn_off.setFocusable(false);
					btn_off.setFocusable(true);
					SessionManager.disconnect();
					dispose();
				}

			}
		});
		btn_off.setBounds(388, 0, 66, 50);
		contentPane.add(btn_off);

		lblNick = new JLabel("Nick:");
		lblNick.setForeground(Color.LIGHT_GRAY);
		lblNick.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNick.setBounds(102, 99, 46, 14);
		contentPane.add(lblNick);
		
		JLabel lblPass = new JLabel("Pass:");
		lblPass.setForeground(Color.LIGHT_GRAY);
		lblPass.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPass.setBounds(102, 140, 46, 14);
		contentPane.add(lblPass);

		JLabel lblTitulo = new JLabel("Iniciar Sesion");
		lblTitulo.setForeground(Color.LIGHT_GRAY);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitulo.setBounds(169, 24, 133, 26);
		contentPane.add(lblTitulo);

		tf_nick = new ModernTXField();
		tf_nick.setBounds(191, 98, 133, 20);
		contentPane.add(tf_nick);
		tf_nick.setColumns(10);

		tf_pass = new PassField(16);
		tf_pass.setBounds(191, 139, 133, 20);
		contentPane.add(tf_pass);
		tf_pass.setColumns(10);
		
		tf_pass.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				
					try {
						Administrador admin = new Administrador(0, tf_nick.getText(), tf_pass.getText(),
								Literales.AdminsLiterals.ADMINISTRADOR, "");
						admin.cifrar();
						// TODO verificar
						if (SentenciasHQL.select_Admins_Contain_Admin(admin).size() == 1) {
							setVisible(false);
							VentanaPrincipal.sessionIniciada(admin);
							dispose();
						}
						else {
							lbl_error.setVisible(true);
						}
					} catch (Exception e3) {
						lbl_error.setVisible(true);
						e3.printStackTrace();
					}
	
				}
			}
		});


		JLabel lbl_ico = new JLabel("");
		lbl_ico.setBounds(10, 0, 126, 60);
		try {
			Image img = ImageIO.read(getClass().getResource(Literales.Iconos.BUSINESSICO));
			lbl_ico.setIcon(new ImageIcon(img.getScaledInstance(126, 60, Image.SCALE_SMOOTH)));
		} catch (Exception ex) {
			System.out.println(ex);
		}
		tf_nick.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				
					try {
						Administrador admin = new Administrador(0, tf_nick.getText(), tf_pass.getText(),
								Literales.AdminsLiterals.ADMINISTRADOR, "");
						admin.cifrar();
						// TODO verificar
						if (SentenciasHQL.select_Admins_Contain_Admin(admin).size() == 1) {
							setVisible(false);
							VentanaPrincipal.sessionIniciada(admin);
							dispose();
						}
						else {
							lbl_error.setVisible(true);
						}
					} catch (Exception e2) {
						lbl_error.setVisible(true);
						e2.printStackTrace();
					}
	
				}
			}
		});


		contentPane.add(lbl_ico);
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				Point point = MouseInfo.getPointerInfo().getLocation();
				setLocation(point.x - x, point.y - y);
			}
		});
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				x = e.getX();
				y = e.getY();
			}
		});
	}
}
