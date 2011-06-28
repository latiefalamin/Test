/*
 * Copyright 2010 Eko Kurniawan Khannedy
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.prambananswing.swing.text;

import javax.swing.event.EventListenerList;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 * DocumentListener merupakan Document yand digunakan oleh komponen JTextValidator
 * 
 * @author Eko Kurniawan Khannedy
 */
public class DocumentValidator extends PlainDocument {

    private static final long serialVersionUID = 1L;
    private EventListenerList list = new EventListenerList();
    private Validator validator;

    /**
     * Metode ini digunakan untuk mendapatkan Validator
     * @return Validator yang digunakan
     */
    public Validator getValidator() {
        return validator;
    }

    /**
     * Metode ini digunakan untuk mengubah Validator
     * @param validator Validator yang baru
     */
    public void setValidator(Validator validator) {
        this.validator = validator;
    }

    /**
     * Metode ini digunakan untuk menambahkan Listener untuk proses validasi
     * @param listener Listener yang akan ditambahkan
     */
    public void addValidatorListener(ValidatorListener listener) {
        list.<ValidatorListener>add(ValidatorListener.class, listener);
    }

    /**
     * Metode ini digunakan untuk menghapus Listener yang telah ada
     * @param listener Listener yang akan dihapus
     */
    public void removeValidatorListener(ValidatorListener listener) {
        list.<ValidatorListener>remove(ValidatorListener.class, listener);
    }

    /**
     * Metode ini digunakan untuk memberi peringatan ke Listener bahwa
     * data yang dimasukkan tidak valid
     * @param event event validator
     */
    protected void fireOnInvalid(ValidatorEvent event) {
        for (ValidatorListener listener : list.<ValidatorListener>getListeners(ValidatorListener.class)) {
            listener.onInvalid(event);
        }
    }

    /**
     * Metode ini digunakan untuk memberi peringatan ke Listener bahwa
     * data yang dimasukkan valid
     * @param event event validator
     */
    protected void fireOnValid(ValidatorEvent event) {
        for (ValidatorListener listener : list.<ValidatorListener>getListeners(ValidatorListener.class)) {
            listener.onValid(event);
        }
    }

    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        // cek apakah validator null
        if (validator == null) {
            // jika null maka tidak ada proses validasi
            super.insertString(offs, str, a);
        } else {
            // jika tidak null maka lakukan proses validasi
            if (validator.validate(str)) {
                // jika valid
                super.insertString(offs, str, a);
                // beritahu listener bahwa data valid
                fireOnValid(new ValidatorEvent(str, this));
            } else {
                // jika tidak valid, beri tahu listener bahwa data tidak valid
                fireOnInvalid(new ValidatorEvent(str, this));
            }
        }
    }
}
