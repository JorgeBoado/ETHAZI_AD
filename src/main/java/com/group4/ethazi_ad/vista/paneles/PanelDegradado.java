package com.group4.ethazi_ad.vista.paneles;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JPanel;

public class PanelDegradado extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Color color1 = new Color(145, 145, 145);
	private Color color2 = new Color(50,50,50);


	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g.create();
		Rectangle clip = g2.getClipBounds();

		g2.setPaint(new GradientPaint(500, 0, color1.darker(), 500, getHeight(), color2.darker()));
		g2.fillRect(clip.x, clip.y, clip.width, clip.height);

	}

	public Color getColor1() {
		return color1;
	}

	public void setColor1(Color color1) {
		this.color1 = color1;
	}

	public Color getColor2() {
		return color2;
	}

	public void setColor2(Color color2) {
		this.color2 = color2;
	}
	/*
	 * public static void main(String[] args){ JFrame ventana = new JFrame();
	 * PanelDegradado panel = new PanelDegradado(); panel.setVisible(true);
	 * ventana.add(panel); ventana.setVisible(true);
	 * 
	 * }
	 */
}