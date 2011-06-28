/*
 * creator : Latief Al Amin
 * e-mail  : al _amin_o4_032@yahoo.co.id
 * create  : Oct 2, 2010
 */

package org.prambananswing.swing.scrollpane;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;

/**
 *
 * @author Latief Al Amin
 */
public class JPScrollPane extends JScrollPane{

    private Icon icon;
    private Color colorTransparency;
    private float alphaTransparency = 0f;
    private boolean noBackground = false;

    public final static int ICON_NORMAL = 0;
    public final static int ICON_CENTER = 1;
    public final static int ICON_STRETCH = 2;
    private int iconPosition = 0;
    public JPScrollPane() {
        super();
        getViewport().setOpaque(false);
        setOpaque(false);
        initColorTransparency();
//        initIcon();
        setBorder(null);
    }

    private void initIcon(){
        iconPosition = ICON_STRETCH;
        icon = new javax.swing.ImageIcon(getClass().getResource("/org/prambananswing/image/backgroundpanel.jpg"));
    }

    protected final void initColorTransparency(){
        colorTransparency = new Color(getBackground().getRed(), getBackground().getGreen()
                , getBackground().getBlue(), (int) (255 * alphaTransparency));
    }

    protected Rectangle generateIconBounds(){
        if(icon == null)
            return null;

        Point p = new Point();
        Dimension d = new Dimension();

        if(iconPosition == ICON_CENTER){
            p.x = (getWidth() - icon.getIconWidth())/2;
            p.y = (getHeight() - icon.getIconHeight())/2;
            d.setSize(icon.getIconWidth(), icon.getIconHeight());
        }else if (iconPosition == ICON_STRETCH){
            p.setLocation(0, 0);
            d.setSize(getWidth(), getHeight());
        }else{
            p.setLocation(0, 0);
            d.setSize(icon.getIconWidth(), icon.getIconHeight());
        }


        return new Rectangle(p, d);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g.create();

        if(!noBackground){
            g2d.setColor(colorTransparency);
            g2d.fillRect(0, 0, getWidth(), getHeight());
        }

        if(icon != null){
            Rectangle bounds = generateIconBounds();

            g2d.setComposite(AlphaComposite.SrcOver.derive(alphaTransparency));
            g2d.drawImage(((ImageIcon) icon).getImage(), bounds.x, bounds.y, bounds.width, bounds.height, null);
        }
        g2d.dispose();
    }

    @Override
    public void setBackground(Color bg) {
        super.setBackground(bg);
        initColorTransparency();
        repaint();
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
        initColorTransparency();
        repaint();
    }

    public boolean isNoBackground() {
        return noBackground;
    }

    public void setNoBackground(boolean noBackground) {
        this.noBackground = noBackground;
        initColorTransparency();
        repaint();
    }

    public float getAlphaTransparency() {
        return alphaTransparency;
    }

    public void setAlphaTransparency(float alphaTransparency) {
        this.alphaTransparency = alphaTransparency;
        initColorTransparency();
        repaint();
    }

    public int getIconPosition() {
        return iconPosition;
    }

    public void setIconPosition(int iconPosition) {
        this.iconPosition = iconPosition;
    }
}
