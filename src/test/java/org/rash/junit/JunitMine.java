/**
 *
 */
package org.rash.junit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runners.MethodSorters;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;

/**
 * @author Admin
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JunitMine {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before Class");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("After Class");
    }

    @Before
    public void before() {
        System.out.println("I will executes before every Test Case");
    }

    @Test
    public void stringTest() {
        String str = "Rasool is a bad boy";
        assertEquals("Rasool is a bad boy", str);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivisionWithException() {
        int i = 1 / 0;
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testEmptyArray() {
        int[] a = {};
        int t = a[5];
    }

    @Test(timeout = 5000)
    public void testInfinity() {
        while (true)
            ;
    }

    @Test(timeout = 5000)
    public void testSlowMethod() throws InterruptedException {
        Thread.sleep(6000);
    }

    @Test
    public void testDivisionFailWithException() {
        thrown.expect(ArithmeticException.class);
        // expectMessage method is expects Matchers
        //hasProperty("errCode") to check particular property or datamember in a class
        //hasProperty("errCode", is(400) with property having with message
        thrown.expectMessage(containsString("/ by zero"));
        int i = 10 / 0;
    }

    @After
    public void after() {
        System.out.println("I will executes after every Test Case");
    }

}
