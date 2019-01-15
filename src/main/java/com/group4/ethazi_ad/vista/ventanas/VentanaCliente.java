package com.group4.ethazi_ad.vista.ventanas;

import com.group4.ethazi_ad.controlador.Control;
import com.group4.ethazi_ad.controlador.SentenciasHQL;
import com.group4.ethazi_ad.modelo.clases.Administrador;
import com.group4.ethazi_ad.modelo.clases.Cliente;
import com.group4.ethazi_ad.modelo.constantes.Literales;
import com.group4.ethazi_ad.vista.paneles.ModernTXField;
import com.group4.ethazi_ad.vista.paneles.PanelDegradado3;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class VentanaCliente extends JDialog {

	/**
	 * 
	 */

	public static final int NEWUSER = 1;
	public static final int EDITUSER = 2;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public final int CREAR = 1;
	private static JButton btn_anterior;
	private static VentanaCliente frame;
	private static JTextField txt_Nick;
	private JTextField txt_correo;
	private JTextField txt_pass;
	private static JLabel lbl_error;
	private JTextField txt_Dni;
	private  String  passcigrada;

	public static JTextField getTxt_Nick() {
		return txt_Nick;
	}

	public static void setTxt_Nick(JTextField txt_Nick) {
		VentanaCliente.txt_Nick = txt_Nick;
	}

	public static void clientFrame(final Object usuario, final int modo, final int x, final int y) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new VentanaCliente(usuario, x, y, modo);
					frame.getContentPane().requestFocusInWindow();
					txt_Nick.requestFocus();
					VentanaCliente.getTxt_Nick().requestFocus();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaCliente(final Object usuario, final int x, final int y, final int modo) {
		super(frame, true);

passcigrada = new String ("");

		if (modo == VentanaCliente.EDITUSER) {
			passcigrada= ((Cliente) usuario).getPass();
		}

		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(x, y, 450, 298);
		contentPane = new PanelDegradado3();
		contentPane.setFocusTraversalPolicyProvider(true);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbl_nick = new JLabel("Nick:");
		lbl_nick.setForeground(Color.LIGHT_GRAY);
		lbl_nick.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_nick.setBounds(25, 81, 46, 14);
		contentPane.add(lbl_nick);

		JLabel lbl_pass = new JLabel("Pass:");
		lbl_pass.setForeground(Color.LIGHT_GRAY);
		lbl_pass.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_pass.setBounds(25, 195, 46, 14);
		contentPane.add(lbl_pass);

		JLabel lbl_titulo = new JLabel("");
		lbl_titulo.setFocusable(false);
		lbl_titulo.setHorizontalAlignment(SwingConstants.CENTER);
		if (modo == 1) {
			lbl_titulo.setText(Literales.ToolTips.NEWUSER);
		} else {
			lbl_titulo.setText(Literales.ToolTips.EDITUSER);
		}
		lbl_titulo.setForeground(Color.LIGHT_GRAY);
		lbl_titulo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lbl_titulo.setBounds(153, 16, 165, 29);
		contentPane.add(lbl_titulo);

		JLabel lbl_correo = new JLabel("Correo:");
		lbl_correo.setForeground(Color.LIGHT_GRAY);
		lbl_correo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_correo.setBounds(25, 118, 157, 16);
		contentPane.add(lbl_correo);
		btn_anterior = new JButton();
		btn_anterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_anterior.setFocusable(false);
				btn_anterior.setFocusable(true);
				dispose();
			}
		});

		btn_anterior.setBorder(null);
		btn_anterior.setContentAreaFilled(false);
		btn_anterior.setOpaque(false);
		btn_anterior.setBackground(null);
		btn_anterior.setToolTipText("Volber");
		URL imageURL2 = getClass().getClassLoader().getResource(Literales.Iconos.FIZQUIERDAICO);
		ImageIcon fizquierda = new ImageIcon(imageURL2);
		btn_anterior.setIcon(fizquierda);
		btn_anterior.setBounds(10, 11, 63, 34);
		btn_anterior.setFocusPainted(false);
		btn_anterior.setBorder(null);
		btn_anterior.setContentAreaFilled(false);
		;
		getContentPane().add(btn_anterior);

		lbl_error = new JLabel("ERROR");
		lbl_error.setForeground(new Color(255, 0, 0));
		lbl_error.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_error.setBounds(25, 254, 233, 14);
		lbl_error.setVisible(false);
		contentPane.add(lbl_error);

		txt_pass = new ModernTXField();
		if (modo == 2) {
			txt_pass.setText(((Cliente) usuario).getPass());
		}
		txt_pass.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_pass.setHorizontalAlignment(SwingConstants.LEFT);
		txt_pass.setColumns(10);
		txt_pass.setBounds(81, 191, 333, 23);
		contentPane.add(txt_pass);

		txt_Nick = new ModernTXField();
		if (modo == 2) {
		txt_Nick.setText(((Cliente) usuario).getNick());
		}
		txt_Nick.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_Nick.setHorizontalAlignment(SwingConstants.LEFT);
		txt_Nick.setBounds(227, 77, 187, 23);
		contentPane.add(txt_Nick);
		txt_Nick.setColumns(10);

		txt_correo = new ModernTXField();
		if (modo == 2) {
		txt_correo.setText(((Cliente) usuario).getEmail());
		}
		txt_correo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_correo.setHorizontalAlignment(SwingConstants.LEFT);
		txt_correo.setColumns(10);
		txt_correo.setBounds(153, 115, 261, 23);
		contentPane.add(txt_correo);

		txt_Dni = new ModernTXField();
		if (modo == 2) {
		txt_Dni.setText(((Cliente) usuario).getDni());
		}
		txt_Dni.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_Dni.setBounds(310, 154, 101, 23);
		txt_Dni.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(txt_Dni);
		txt_Dni.setColumns(10);

		JButton btn_guardar = new JButton();

		btn_guardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (modo == NEWUSER) {

					Cliente cliente = new Cliente(0, txt_Nick.getText(), txt_Dni.getText(), txt_pass.getText(),
							txt_correo.getText());
					try {

							((Administrador) usuario).cifrar();

						SentenciasHQL.insert_User(cliente);
						Control.control(Control.UPDATELIST, null);
						dispose();
					} catch (Exception e) {
						e.printStackTrace();
						lbl_error.setVisible(true);
						Toolkit.getDefaultToolkit().beep();
					}

				} else {

					((Cliente) usuario).setNick(txt_Nick.getText());
					((Cliente) usuario).setEmail(txt_correo.getText());
					((Cliente) usuario).setPass(txt_Dni.getText());
					((Cliente) usuario).setPass(txt_pass.getText());
					if (!passcigrada.equals(((Cliente) usuario).getPass())){
						((Cliente) usuario).cifrar();
					}
					try {
						SentenciasHQL.modify_User(((Cliente) usuario));
						Control.control(Control.UPDATELIST, null);
						dispose();
					} catch (Exception e) {
						e.printStackTrace();
						lbl_error.setVisible(true);
						Toolkit.getDefaultToolkit().beep();
					}

				}
			}
		});
		btn_guardar.setToolTipText("Guardar cambios");
		btn_guardar.setOpaque(false);
		btn_guardar.setContentAreaFilled(false);
		btn_guardar.setBorder(null);
		btn_guardar.setBackground((Color) null);
		btn_guardar.setBounds(377, 234, 63, 53);
		URL imageURL3 = getClass().getClassLoader().getResource(Literales.Iconos.SAVEICO);
		ImageIcon saveico = new ImageIcon(imageURL3);
		btn_guardar.setIcon(saveico);
		contentPane.add(btn_guardar);

		JLabel lblDni = new JLabel("DNI:");
		lblDni.setForeground(Color.LIGHT_GRAY);
		lblDni.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDni.setBounds(25, 156, 46, 14);
		contentPane.add(lblDni);

	}
}