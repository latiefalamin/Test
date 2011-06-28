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

import java.util.EventListener;

/**
 * Kelas ValidatorListener merupakan kelas yang digunakan untuk mendengarkan proses
 * validasi dari kelas Validator.
 * 
 * @author Eko Kurniawan Khannedy
 */
public interface ValidatorListener extends EventListener {

    /**
     * Metode ini dipanggil saat data yang dimasukkan ke JTextField tidak valid
     * @param event event validator
     */
    void onInvalid(ValidatorEvent event);

    /**
     * Metode ini dipanggil saat data yang dimasukkan ke JTextFiel valid
     * @param event event validator
     */
    void onValid(ValidatorEvent event);
}
