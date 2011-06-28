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

import java.util.EventObject;

/**
 * Event Object untuk ValidatorListener
 * @author echo
 */
public class ValidatorEvent extends EventObject {

    private static final long serialVersionUID = 1L;
    private String text;

    public String getText() {
        return text;
    }

    public ValidatorEvent(String text, DocumentValidator validator) {
        super(validator);
        this.text = text;
    }
}
