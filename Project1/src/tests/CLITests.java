package tests;

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
    public void mainItem0() {
        setupSystemIn("0\n");
        MainMenu mainMenu = new MainMenu();
        Menu menu = mainMenu.run();        

        assertEquals(menu, null);
    }
}