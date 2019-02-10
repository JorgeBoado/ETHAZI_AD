package com.group4.ethazi_ad.vista.ventanas;

import com.group4.ethazi_ad.controlador.Control;
import com.group4.ethazi_ad.modelo.clases.Administrador;
import com.group4.ethazi_ad.modelo.constantes.Literales;
import com.group4.ethazi_ad.vista.paneles.ModernTXField;
import com.group4.ethazi_ad.vista.paneles.PanelDegradado2;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.net.URL;


/**
 *  Ventana para crear o modificar admionistradores
 */
public class VentanaAdmin extends JDialog {

	public static final int NEWUSER = 1;
	public static final int EDITUSER = 2;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public final int CREAR = 1;
	private static JButton btn_anterior;
	static VentanaAdmin frame;
	private static ModernTXField txt_Nick;
	private ModernTXField txtNames;
	private ModernTXField txt_pass;
	private static JLabel lbl_error;
	private String passcigrada = "";
	public static JTextField getTxt_Nick() {
		return txt_Nick;
	}

	public static void setTxt_Nick(ModernTXField txt_Nick) {
		VentanaAdmin.txt_Nick = txt_Nick;
	}

	public static VentanaAdmin getFrame() {
		return frame;
	}


	/**
	 *
	 * @param usuario usuario clickado
	 * @param modo si es edicion o modificaccion
	 * @param x coordenada para abrir
	 * @param y coordenada para abrir
	 */
	public static void adminFrame(final Object usuario, final int modo, final int x, final int y) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new VentanaAdmin(usuario, x, y, modo);
					frame.getContentPane().requestFocusInWindow();
					txt_Nick.requestFocus();
					VentanaAdmin.getTxt_Nick().requestFocus();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 *
	 * @param usuario  clickado
	 * @param x coordenada para abrir la ventana
	 * @param y coordenada para abrir la ventana
	 * @param modo si es creacion o modificacion
	 */
	public VentanaAdmin(final Object usuario, final int x, final int y, final int modo) {
		super(frame, true);
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(x, y, 450, 254);
		contentPane = new PanelDegradado2();
		contentPane.setFocusTraversalPolicyProvider(true);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		if(modo == 2){
			passcigrada = ((Administrador)usuario).getPass();
		}

		JLabel lbl_nick = new JLabel("Nick:");
		lbl_nick.setForeground(Color.LIGHT_GRAY);
		lbl_nick.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_nick.setBounds(25, 81, 46, 14);
		contentPane.add(lbl_nick);

		JLabel lbl_pass = new JLabel("Pass:");
		lbl_pass.setForeground(Color.LIGHT_GRAY);
		lbl_pass.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_pass.setBounds(25, 155, 46, 14);
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

		JLabel lblNombreYApellidos = new JLabel("Nombre y Apellidos:");
		lblNombreYApellidos.setForeground(Color.LIGHT_GRAY);
		lblNombreYApellidos.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNombreYApellidos.setBounds(25, 118, 157, 16);
		contentPane.add(lblNombreYApellidos);
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
		lbl_error.setBounds(41, 212, 233, 14);
		
		lbl_error.setVisible(false);
		contentPane.add(lbl_error);

		txt_pass = new ModernTXField(16);

		if (modo == 2) {
			txt_pass.setText(((Administrador) usuario).getPass());
		}
	
		txt_pass.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_pass.setHorizontalAlignment(SwingConstants.LEFT);
		txt_pass.setColumns(16);
		txt_pass.setBounds(81, 150, 333, 25);
		contentPane.add(txt_pass);

		txt_Nick = new ModernTXField(16);
		if (modo == 2) {
			txt_Nick.setText(((Administrador) usuario).getNick());
		}
		txt_Nick.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_Nick.setHorizontalAlignment(SwingConstants.LEFT);
		txt_Nick.setBounds(227, 76, 187, 25);
		contentPane.add(txt_Nick);
		txt_Nick.setColumns(10);

		txtNames = new ModernTXField(20);
		txtNames.addKeyListener(new KeyAdapter() {

		});
		if (modo == 2) {
			txtNames.setText(((Administrador) usuario).getName());
		}
		txtNames.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNames.setHorizontalAlignment(SwingConstants.LEFT);
		txtNames.setColumns(10);
		txtNames.setBounds(227, 114, 187, 25);
		contentPane.add(txtNames);

		JButton btn_guardar = new JButton();
		btn_guardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (modo == 1) {

					Administrador admin = new Administrador(0, txt_Nick.getText(), txt_pass.getText(),
							Literales.AdminsLiterals.EDITOR, txtNames.getText());
					admin.cifrar();
					Control.control(Control.NEWADMIN, admin);

				} else {

					((Administrador) usuario).setname(txtNames.getText());
					((Administrador) usuario).setNick(txt_Nick.getText());
					((Administrador) usuario).setPass(txt_pass.getText());
					if (!passcigrada.equals(((Administrador) usuario).getPass())) {
						((Administrador) usuario).cifrar();
					}
					Control.control(Control.MODADMIN, usuario);

				}
			}
		});
		btn_guardar.setToolTipText("Guardar cambios");
		btn_guardar.setOpaque(false);
		btn_guardar.setContentAreaFilled(false);
		btn_guardar.setBorder(null);
		btn_guardar.setBackground((Color) null);
		btn_guardar.setBounds(377, 190, 63, 53);
		URL imageURL3 = getClass().getClassLoader().getResource(Literales.Iconos.SAVEICO);
		ImageIcon saveico = new ImageIcon(imageURL3);
		btn_guardar.setIcon(saveico);
		contentPane.add(btn_guardar);

	}

	public static JLabel getLbl_error() {
		return lbl_error;
	}


}
	

