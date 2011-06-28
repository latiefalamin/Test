/*
 * creator : Latief Al Amin
 * e-mail  : al _amin_o4_032@yahoo.co.id
 * create  : Oct 2, 2010
 */

package org.prambananswing.swing.text;

import javax.swing.JTextField;

/**
 *
 * @author Latief Al Amin
 */
public class JpTextField extends JTextField{
    private DocumentValidator documentValidator;

    public JpTextField() {
        this.documentValidator = new DocumentValidator();
    }

    public DocumentValidator getDocumentValidator() {
        return documentValidator;
    }

    public void setDocumentValidator(DocumentValidator documentValidator) {
        this.documentValidator = documentValidator;
        setDocument(documentValidator);
    }

    /**
     * Metode ini digunakan untuk mengubah Validator
     * @param validator Validator baru
     */
    public void setValidator(Validator validator) {
        getDocumentValidator().setValidator(validator);
    }

    /**
     * Metode ini digunakan untuk mendapatkan Validator
     * @return Validator yang digunakan
     */
    public Validator getValidator() {
        return getDocumentValidator().getValidator();
    }

    /**
     * Metode ini digunakan untuk menambahkan Listener untuk proses Validasi
     * @param listener Listener yang akan ditambahkan
     */
    public void removeValidatorListener(ValidatorListener listener) {
        getDocumentValidator().removeValidatorListener(listener);
    }

    /**
     * Metode ini digunakan untuk menghapus Listener yang telah ditambahkan
     * @param listener Listener yang akan dihapus
     */
    public void addValidatorListener(ValidatorListener listener) {
        getDocumentValidator().addValidatorListener(listener);
    }
}
