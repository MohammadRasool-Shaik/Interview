/**
 * 
 */
package org.rash.junit;

import static org.rash.interview.Societe.check;
import static org.rash.interview.Societe.closetToZero;
import static org.rash.interview.Societe.concat;
import static org.rash.interview.Societe.sum;
import static org.rash.interview.Societe.sumRange;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Admin
 */
public class SocieteTest {

	@Test
	public void testStrings() {
		String[] str = { "f", "o", "o", "bar" };
		Assert.assertEquals("foobar", concat(str));
	}

	@Test
	public void testEmpty() {
		String[] str = {};
		Assert.assertEquals("", concat(str));
	}

	@Test
	public void testSingleString() {
		String[] str = { "f" };
		Assert.assertEquals("f", concat(str));
	}

	@Test
	public void testSum() {
		Assert.assertTrue(sum(1, 5));
		Assert.assertFalse(sum(2, 3));
		Assert.assertTrue(sum(-3, 4));
		Assert.assertFalse(sum(0, 0));
		Assert.assertTrue(sum(1, 0));
	}

	@Test
	public void testRangeSum() {
		int[] ints = { 1, 20, 3, 10, -2, 100 };
		Assert.assertEquals(130, sumRange(ints));
	}

	@Test
	public void testCheck() {
		Assert.assertTrue(check("[]()"));
		Assert.assertTrue(check("([])"));
		Assert.assertTrue(check("[(AA)]"));
		Assert.assertFalse(check("[(])"));
		Assert.assertFalse(check(null));
		Assert.assertFalse(check(""));

	}

	@Test
	public void testClosetToZero() {
		Assert.assertEquals(2, closetToZero(new int[] { -9, 8, 2, -5, 7 }));
		Assert.assertEquals(5, closetToZero(new int[] { -9, 5, 6, -5, 7 }));
		Assert.assertEquals(-1, closetToZero(new int[] { -9, 8, 2, -1, 7 }));
		Assert.assertEquals(0, closetToZero(new int[] { -9, 8, 0, -1, 7 }));
		Assert.assertEquals(1, closetToZero(new int[] { -9, 8, 1, -1, 7 }));

	}

}
