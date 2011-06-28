/*
 * creator : Latief Al Amin
 * e-mail  : al _amin_o4_032@yahoo.co.id
 * create  : Oct 2, 2010
 */

package org.prambananswing.viewport;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JViewport;

/**
 *
 * @author Latief Al Amin
 */
public class JPViewPort extends JViewport{

    public JPViewPort() {
        setOpaque(false);
    }

    @Override
    protected void paintChildren(Graphics g) {
        Graphics2D gd = (Graphics2D) g.create();
        gd.setPaint(Color.BLUE);
        gd.drawRect(10, 10, 200, 200);

        gd.dispose();


        super.paintChildren(g);
    }
}
