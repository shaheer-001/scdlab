/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rajas
 */
public class userinformationTest {
    
    public userinformationTest() {
    }

    @Test
    public void testFeedback() {
        System.out.println("feedback");
        
        userinformation instance = new userinformation();
        boolean expResult = false;
        boolean actualResult = instance.feedback("Test", "test@email.com", "Hello, just here to test");
        assertEquals(expResult, actualResult);
    }

}
