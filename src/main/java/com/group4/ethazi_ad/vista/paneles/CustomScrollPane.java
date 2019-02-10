package com.group4.ethazi_ad.vista.paneles;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

class CustomScrollPane extends JScrollPane
{
    /**
	 * Esta una clase de ScrollPane modificada para la estetica, no aporta funcionalidad
	 */
	private static final long serialVersionUID = 1L;
	public CustomScrollPane () {
        super (VERTICAL_SCROLLBAR_ALWAYS, HORIZONTAL_SCROLLBAR_ALWAYS);
        Image imageThumb = createImage (1, 1, Color.DARK_GRAY);
        Image imageThumbPressed = createImage (5, 5, Color.GRAY);
        Image imageTrack = createImage (5, 5, new Color(35,35,35));
        // Adding some test labels
        JPanel view = new JPanel (new GridLayout (5, 5, 5, 5));
        for (int i = 0; i < 50; i++) view.add (new JLabel ("Test Label " + String.valueOf (i)));
        setViewportView (view);
        setHorizontalScrollBar (new CustomScrollBar (JScrollBar.HORIZONTAL, imageThumb, imageThumbPressed, imageTrack));
        setVerticalScrollBar (new CustomScrollBar (JScrollBar.VERTICAL, imageThumb, imageThumbPressed, imageTrack));
        // Setting preferred size for convenience. Not a good practice !
        setPreferredSize (new Dimension (200, 8));
        getVerticalScrollBar().setPreferredSize(new Dimension(8, 8));
        getVerticalScrollBar().setUnitIncrement(20);
        
       
    }
    private Image createImage (int width, int height, Color color) {
        BufferedImage image = new BufferedImage (width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics g = image.getGraphics ();
        g.setColor (color);
        g.fillRect (0, 0, width, height);
        g.dispose ();
        return image;
    }
}

/**
 *  Esta es una clase Scrollbar modificada para la estetica no aporta funcionalidad
 */
class CustomScrollBar extends JScrollBar
{

	private static final long serialVersionUID = 1L;
	private boolean isThumbPressed;

    public CustomScrollBar (final int orientation, final Image thumb, final Image thumbPressed, final Image track) { 
        super (orientation);

               addMouseListener (new MouseAdapter () {
            public void mousePressed (MouseEvent e) {
                isThumbPressed = true;
            }
            public void mouseReleased (MouseEvent e) {
                isThumbPressed = false;
            }
        });
        setUI (new BasicScrollBarUI () {
            @Override protected void paintThumb (Graphics g, JComponent c, Rectangle r) {
                if (isThumbPressed) g.drawImage (thumbPressed, r.x, r.y, r.width, r.height, null);
                else g.drawImage (thumb, r.x, r.y, r.width, r.height, null);
            }
            @Override protected void paintTrack (Graphics g, JComponent c, Rectangle r) {
                g.drawImage(track, r.x, r.y, r.width, r.height, null);
            }
        });
    }
}