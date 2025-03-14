package tests;

/**
 * DATE: March 14, 2025
 * AUTHOR: Raymond Rowland
 * PURPOSE: This class contains unit tests for the Java OO Shape Tool application.
 *          It includes methods to test the main menu and shape construction menus.
 * FILE: CLITests.java
 */

import main.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import org.junit.After;

public class CLITests {

    private final InputStream originalIn = System.in;

    public void setupSystemIn(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }
    
    @After
    public void restoreStreams() {
        System.setIn(originalIn);
    }
    
    @Test
    public void mainItem0() {
        setupSystemIn("0\n");
        MainMenu mainMenu = new MainMenu();
        Menu menu = mainMenu.run();        

        assertEquals(menu, null);
    }

    @Test
    public void mainItem1() {
        setupSystemIn("1\n");
        MainMenu mainMenu = new MainMenu();
        Menu menu = mainMenu.run();        

        assertTrue(menu instanceof TwoDShapeMenu);
    }
    
    @Test
    public void mainItem2() {
        setupSystemIn("2\n");
        MainMenu mainMenu = new MainMenu();
        Menu menu = mainMenu.run();        

        assertTrue(menu instanceof ThreeDShapeMenu);        
    }

    @Test
    public void twoDMenuItem1() {
        setupSystemIn("1\n");
        TwoDShapeMenu twoDMenu = new TwoDShapeMenu(new MainMenu());
        Menu menu = twoDMenu.run();        

        assertTrue(menu instanceof ShapeDataMenu);  
        assertEquals(Questions.Radius.getStatusFlagValue(), ((ShapeDataMenu)menu).getQuestions());      
    }
    
    @Test
    public void twoDMenuItem2() {
        setupSystemIn("2\n");
        TwoDShapeMenu twoDMenu = new TwoDShapeMenu(new MainMenu());
        Menu menu = twoDMenu.run();        

        assertTrue(menu instanceof ShapeDataMenu);  
        assertEquals(Questions.Height.getStatusFlagValue() | Questions.Width.getStatusFlagValue(), ((ShapeDataMenu)menu).getQuestions());      
    }

    @Test
    public void twoDMenuItem3() {
        setupSystemIn("3\n");
        TwoDShapeMenu twoDMenu = new TwoDShapeMenu(new MainMenu());
        Menu menu = twoDMenu.run();        

        assertTrue(menu instanceof ShapeDataMenu);  
        assertEquals(Questions.Height.getStatusFlagValue(), ((ShapeDataMenu)menu).getQuestions());      
    }

    @Test
    public void twoDMenuItem4() {
        setupSystemIn("4\n");
        TwoDShapeMenu twoDMenu = new TwoDShapeMenu(new MainMenu());
        Menu menu = twoDMenu.run();        

        assertTrue(menu instanceof ShapeDataMenu);  
        assertEquals(Questions.Base.getStatusFlagValue() | Questions.Height.getStatusFlagValue(), ((ShapeDataMenu)menu).getQuestions());      
    }
    
    @Test
    public void twoDMenuItem0() {
        setupSystemIn("0\n");
        TwoDShapeMenu twoDMenu = new TwoDShapeMenu(new MainMenu());
        Menu menu = twoDMenu.run();        

        assertTrue(menu instanceof MainMenu);  
    }
    
    @Test
    public void threeDMenuItem1() {
        setupSystemIn("1\n");
        ThreeDShapeMenu threeDMenu = new ThreeDShapeMenu(new MainMenu());
        Menu menu = threeDMenu.run();        

        assertTrue(menu instanceof ShapeDataMenu);  
        assertEquals(Questions.Radius.getStatusFlagValue(), ((ShapeDataMenu)menu).getQuestions());      
    }
    
    @Test
    public void threeDMenuItem2() {
        setupSystemIn("2\n");
        ThreeDShapeMenu threeDMenu = new ThreeDShapeMenu(new MainMenu());
        Menu menu = threeDMenu.run();        

        assertTrue(menu instanceof ShapeDataMenu);  
        assertEquals(Questions.Height.getStatusFlagValue(), ((ShapeDataMenu)menu).getQuestions());    
    }
    
    @Test
    public void threeDMenuItem3() {
        setupSystemIn("3\n");
        ThreeDShapeMenu threeDMenu = new ThreeDShapeMenu(new MainMenu());
        Menu menu = threeDMenu.run();        

        assertTrue(menu instanceof ShapeDataMenu);  
        assertEquals(Questions.Height.getStatusFlagValue() | Questions.Radius.getStatusFlagValue(), ((ShapeDataMenu)menu).getQuestions());    
    }

    @Test
    public void threeDMenuItem4() {
        setupSystemIn("4\n");
        ThreeDShapeMenu threeDMenu = new ThreeDShapeMenu(new MainMenu());
        Menu menu = threeDMenu.run();        

        assertTrue(menu instanceof ShapeDataMenu);  
        assertEquals(Questions.Height.getStatusFlagValue() | Questions.Radius.getStatusFlagValue(), ((ShapeDataMenu)menu).getQuestions());    
    }

    @Test
    public void threeDMenuItem5() {
        setupSystemIn("5\n");
        ThreeDShapeMenu threeDMenu = new ThreeDShapeMenu(new MainMenu());
        Menu menu = threeDMenu.run();        

        assertTrue(menu instanceof ShapeDataMenu);  
        assertEquals(Questions.MajorMinorRadius.getStatusFlagValue(), ((ShapeDataMenu)menu).getQuestions());    
    }

}