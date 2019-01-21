package com.group4.ethazi_ad.vista.paneles;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ModerPassField extends PassField{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ModerPassField(int i, final int limite) {
		super(i);
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			
				limitar(limite, e);
			}

			@Override
			public void keyReleased(KeyEvent e) {
			limitar(16, e);
			}
		});
		// TODO Auto-generated constructor stub
	}
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
	

	@Override
	public void updateUI() {
		super.updateUI();
		setOpaque(false);
		setBorder(new RoundedCornerBorder());
	}

	public void limitar(int limite, KeyEvent e) {
		System.out.println(e.getKeyCode());
		String passmala = String.valueOf(getPassword());
		String pass = "";
		if (e.getKeyCode() == 8) {
			setText("");
		} else {
			if (String.valueOf(getPassword()).length() >= limite) {
				for (int i = 0; i < limite; i++) {
					pass = pass + passmala.charAt(i);

				}
				setText(pass);

			}

		}
	}

}
