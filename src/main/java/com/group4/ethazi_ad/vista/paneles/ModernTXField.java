package com.group4.ethazi_ad.vista.paneles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ModernTXField extends JTextField {

	/**
	 *  clase para textfield moderno sin funcionalidad
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void paintComponent(Graphics g) {
		if (!isOpaque() && getBorder() instanceof RoundedCornerBorder) {
			Graphics2D g2 = (Graphics2D) g.create();
			g2.setPaint(getBackground());
			g2.fill(((RoundedCornerBorder) getBorder()).getBorderShape(0, 0, getWidth() - 1, getHeight() - 1));
			g2.dispose();
		}
		super.paintComponent(g);
	}

	public ModernTXField(int limite) {
		super();
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				limitar(30, e);
			}

			@Override
			public void keyReleased(KeyEvent e) {
				limitar(30, e);
			}
		});
	}

	@Override
	public void updateUI() {
		super.updateUI();
		setOpaque(false);
		setBorder(new RoundedCornerBorder());
	}

	public void limitar(int limite, KeyEvent e) {
		System.out.println(e.getKeyCode());
		String passmala = getText();
		String pass = "";
		if (e.getKeyCode() == 8) {
			setText("");
		} else {
			if (getText().length() >= limite) {
				for (int i = 0; i < limite; i++) {
					pass = pass + passmala.charAt(i);

				}
				setText(pass);

			}

		}
	}

}