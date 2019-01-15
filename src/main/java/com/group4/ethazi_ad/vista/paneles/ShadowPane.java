package com.group4.ethazi_ad.vista.paneles;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ShadowPane extends JPanel {

	private static final long serialVersionUID = 1L;

	public ShadowPane() {
	    setLayout(new BorderLayout());
	    setOpaque(false);
	    setBackground(Color.BLACK);
	    setBorder(new EmptyBorder(0, 0, 10, 10));
	  }

	  @Override
	  public Dimension getPreferredSize() {
	    return new Dimension(1000, 200);
	  }

	  @Override
	  protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    Graphics2D g2d = (Graphics2D) g.create();
	    g2d.setComposite(AlphaComposite.SrcOver.derive(0.9f));
	    g2d.fillRect(10, 10, getWidth(), getHeight());
	    g2d.dispose();
	  }
	}