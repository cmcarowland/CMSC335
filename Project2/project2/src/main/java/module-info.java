/**
 * DATE: April 1, 2025
 * AUTHOR: Raymond Rowland
 * PURPOSE: This file defines the module configuration for the project.
 * FILE: module-info.java
 */

module com.project2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    
    opens com.project2 to javafx.fxml;
    exports com.project2;
    exports com.shapes;
}
