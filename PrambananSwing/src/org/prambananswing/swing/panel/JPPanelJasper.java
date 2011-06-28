/*
 * @author Latief Al Amin
 * Dec 2, 2010
 */

package org.prambananswing.swing.panel;

import java.io.InputStream;
import java.util.Locale;
import java.util.ResourceBundle;
import net.sf.jasperreports.view.JRViewer;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author Latief Al Amin
 */
public class JPPanelJasper extends JRViewer{

    public JPPanelJasper(String fileName, boolean isXML) throws JRException {
        super(fileName, isXML);
    }

    public JPPanelJasper(InputStream is, boolean isXML) throws JRException {
        super(is, isXML);
    }

    public JPPanelJasper(JasperPrint jrPrint) {
        super(jrPrint);
    }

    public JPPanelJasper(String fileName, boolean isXML, Locale locale) throws JRException {
        super(fileName, isXML, locale);
    }

    public JPPanelJasper(InputStream is, boolean isXML, Locale locale) throws JRException {
        super(is, isXML, locale);
    }

    public JPPanelJasper(JasperPrint jrPrint, Locale locale) {
        super(jrPrint, locale);
    }

    public JPPanelJasper(String fileName, boolean isXML, Locale locale, ResourceBundle resBundle) throws JRException {
        super(fileName, isXML, locale, resBundle);
    }

    public JPPanelJasper(InputStream is, boolean isXML, Locale locale, ResourceBundle resBundle) throws JRException {
        super(is, isXML, locale, resBundle);
    }

    public JPPanelJasper(JasperPrint jrPrint, Locale locale, ResourceBundle resBundle) {
        super(jrPrint, locale, resBundle);
    }
}
