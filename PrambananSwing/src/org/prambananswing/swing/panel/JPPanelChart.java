/*
 * creator : Latief Al Amin
 * e-mail  : al _amin_o4_032@yahoo.co.id
 * create  : Oct 2, 2010
 */

package org.prambananswing.swing.panel;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.JPanel;
import org.jfree.chart.JFreeChart;

/**
 *
 * @author Latief Al Amin
 */
public class JPPanelChart extends JPanel{

    private JFreeChart chart;
    private float alphaTransparency = 0.5f;

    public JPPanelChart() {
        super();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g.create();
        
        if(chart != null){
            g2d.setComposite(AlphaComposite.SrcOver.derive(alphaTransparency));
            g2d.drawImage(createChart(), 0, 0, getWidth(), getHeight(), null);
        }
        g2d.dispose();
    }

    public JFreeChart getChart() {
        return chart;
    }

    public void setChart(JFreeChart chart) {
        this.chart = chart;
        repaint();
    }

    public float getAlphaTransparency() {
        return alphaTransparency;
    }

    public void setAlphaTransparency(float alphaTransparency) {
        this.alphaTransparency = alphaTransparency;
        repaint();
    }

    protected Image createChart(){
        return chart.createBufferedImage(getWidth(), getHeight());
    }

}
