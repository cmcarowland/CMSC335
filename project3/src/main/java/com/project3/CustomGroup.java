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

