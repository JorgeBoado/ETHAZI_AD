package com.group4.ethazi_ad.vista.paneles;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.group4.ethazi_ad.controlador.Control;
import com.group4.ethazi_ad.vista.ventanas.VentanaPrincipal;

public class TFbuscar extends ModernTXField{
	
	private static boolean activo = false;
	public TFbuscar(int limite) {
		super(limite);
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					VentanaPrincipal.setLastFind(getText());
					Control.control(Control.UPDATELIST, null);
					setText("");
				} else if (e.getKeyCode() == KeyEvent.VK_ESCAPE || e.getKeyCode() == 8) {
					setText("");
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					PanelAtrasAlante.leftPress();
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					PanelAtrasAlante.rightPress();
				} else {
                    Thread thread = new Thread() {
                        public void run() {

                            VentanaPrincipal.setLastFind(getText());
                            Control.control(Control.UPDATELIST, null);

                        }
                    };
				    thread.start();

				}

			}
		});
	}

}
