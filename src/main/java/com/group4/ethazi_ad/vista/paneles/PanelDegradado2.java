package com.group4.ethazi_ad.vista.paneles;

import javax.swing.*;
import java.awt.*;

public class PanelDegradado2 extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Color color1 = new Color(125, 125, 125);
	private Color color2 = new Color(48, 48, 48);

	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g.create();
		Rectangle clip = g2.getClipBounds();

		g2.setPaint(new GradientPaint(500, 0, color1.darker(), 500, getHeight(), color2.darker()));
		g2.fillRect(clip.x, clip.y, clip.width, clip.height);

		g.setColor(Color.GRAY);
		g.drawLine(26, 60, 415, 60);
		g.setColor(new Color (100,100,100));
		g.drawLine(26, 190, 415, 190);

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
}
