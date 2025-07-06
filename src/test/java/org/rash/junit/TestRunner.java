/**
 *
 */
package org.rash.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
//    JunitMine.class,   
//    AppTest.class
        MockitTest.class
})
public class TestRunner {


    /**
     * @param args
     */
	/*public static void main(String[] args) {
		Result result = JUnitCore.runClasses(JunitMine.class);

		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}

		System.out.println(result.wasSuccessful());
	}*/

}
