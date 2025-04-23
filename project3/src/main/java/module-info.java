/**
 * CMSC 335
 * module-info.java
 * DATE: 22 APR 25
 * AUTHOR: Raymond Rowland
 * 
 * This module descriptor defines the dependencies and exports for the 
 * JavaFX-based application. It specifies required modules and opens 
 * the package for reflection by the JavaFX framework.
 */
module com.project3 {
    requires transitive javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    opens com.project3 to javafx.fxml;
    exports com.project3;
}
