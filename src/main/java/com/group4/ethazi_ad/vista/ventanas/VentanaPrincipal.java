package com.group4.ethazi_ad.vista.ventanas;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.group4.ethazi_ad.modelo.clases.Administrador;
import com.group4.ethazi_ad.vista.paneles.PanelUsuarios;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Dimension;
import java.awt.CardLayout;

public class VentanaPrincipal extends JFrame {
    private JPanel contentPane;
    private JTextField txField_buscar;
    private static JPanel pa_contenedor = new JPanel();
    static JPanel pa_buscarUsuarios;
    // variable de prueba
    ArrayList<Object> usuarios = new ArrayList();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    //LookAndFeel();
                    VentanaPrincipal frame = new VentanaPrincipal();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void LookAndFeel() {
        try {
        // Set System L&F
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            // handle exception
        }
    }

    /**
     * Create the frame
     */
    public VentanaPrincipal() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 768, 566);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        getContentPane().setLayout(null);
        setLocationRelativeTo(null);
        lanzarBarraHerramientas();

        // Crear contenedor
        pa_contenedor.setBounds(0, 55, 762, 488);
        contentPane.add(pa_contenedor);
        pa_contenedor.setLayout(new CardLayout(0, 0));
        /* Prueba jonor */
        int cont = 0;
        ArrayList<Administrador> admins = new ArrayList<Administrador>();
        Administrador admin;

        while (cont < 27) {
            admin = new Administrador(1 + cont, "nombre" + cont, null, null);
            usuarios.add(admin);
            cont++;
        }
        /* Prueba jonor */
        crearPaneles();

    }

    public void crearPaneles() {
        // Crear consultar ofertas

        pa_buscarUsuarios = new PanelUsuarios(usuarios);
        pa_contenedor.add(pa_buscarUsuarios);
/*
			JPanel pa_publicarOferta = new PanelPublicarOferta();
			pa_contenedor.add(pa_publicarOferta);
			// Crear editar oferta
			JPanel pa_editarOferta = new PanelEditarOferta();
			pa_contenedor.add(pa_editarOferta);

			JPanel pa_abrirOferta;
			pa_abrirOferta = new PanelAbrirOfertaEmpresa();
			pa_contenedor.add(pa_abrirOferta);*/


    }

    public void lanzarBarraHerramientas() {
        JPanel pa_barraHerramientas = new JPanel();
        pa_barraHerramientas.setLayout(null);
        JButton btn_buscar = new JButton("");
        btn_buscar.setBounds(0, 0, 50, 50);
        pa_barraHerramientas.add(btn_buscar);
        pa_barraHerramientas.setBounds(0, 0, 762, 50);
        contentPane.add(pa_barraHerramientas);

        JButton btn_perfil = new JButton("");
        btn_perfil.setToolTipText("Ver Perfil");
        btn_perfil.setPreferredSize(new Dimension(33, 9));
        btn_perfil.setMinimumSize(new Dimension(33, 9));
        btn_perfil.setMaximumSize(new Dimension(33, 9));
        btn_perfil.setBounds(642, 0, 50, 50);
        pa_barraHerramientas.add(btn_perfil);

        JButton btn_apagar = new JButton("");
        btn_apagar.setToolTipText("Cerrar Sesi\u00F3n");
        btn_apagar.setAlignmentY(0.0f);
        btn_apagar.setAlignmentX(1.0f);
        btn_apagar.setBounds(702, 0, 50, 50);
        pa_barraHerramientas.add(btn_apagar);

        txField_buscar = new JTextField();
        txField_buscar.setToolTipText("");
        txField_buscar.setText("Introduzca el nombre de la Oferta....\r\n");
        txField_buscar.setHorizontalAlignment(SwingConstants.CENTER);
        txField_buscar.setFont(new Font("Tahoma", Font.PLAIN, 11));
        txField_buscar.setColumns(10);
        txField_buscar.setBounds(51, 0, 195, 50);
        pa_barraHerramientas.add(txField_buscar);

        JComboBox combo_menu = new JComboBox();
        combo_menu.setToolTipText("Men\u00FA");
        combo_menu.setName("");
        combo_menu.setBounds(252, 0, 380, 50);
        pa_barraHerramientas.add(combo_menu);
    }

    public static void addcont() {

    }


    public static void remcont() {
        pa_contenedor.remove(pa_buscarUsuarios);
    }

}
