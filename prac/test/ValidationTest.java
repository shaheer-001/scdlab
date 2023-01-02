/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rajas
 */
public class ValidationTest {
    
    public ValidationTest() {
    }
   
    /**
     * Test of login method, of class Validation.
     */
    @Test
    public void testLogin() {
        System.out.println("Login Test");
        Validation instance = new Validation();
        boolean expResult = true;
        boolean actualResult = instance.login("Ali", "12345");
        assertEquals(expResult, actualResult);

    }

}
