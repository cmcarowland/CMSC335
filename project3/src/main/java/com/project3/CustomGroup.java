/**
 * CMSC 335
 * CustomGroup.java
 * DATE: 22 APR 25
 * AUTHOR: Raymond Rowland
 * 
 * It is designed to represent a custom group allowing for a new property
 * that accepts a string value representing the lights ID.
 * This class extends the JavaFX Group class and adds a StringProperty
 */
package com.project3;

import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.Group;

public class CustomGroup extends Group {
    private final StringProperty customText = new SimpleStringProperty();

    public String getCustomText() {
        return customText.get();
    }

    public void setCustomText(String value) {
        this.customText.set(value);
    }

    public StringProperty customTextProperty() {
        return customText;
    }
}

