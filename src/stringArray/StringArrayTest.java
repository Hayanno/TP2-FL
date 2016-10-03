package stringArray;

/*
 * @author PR
 * @version 1
 * Unit tests for the StringArray class (First set)
 */

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import stringArray.StringArray;


public class StringArrayTest {
	private static String[] slist1={
		"a","b","ccc","ccd","d","e","f","g"
	};
	private static String[] slist2={
		"ab","ccd","ccc","g","f","e","d"
	};
	private static String[] slistdupl1 ={
			"ab", "ab"
	};
	private static String[] slistdupl2 ={
			"ab", "a", "b", "ab"
	};

	private StringArray array1;
	private StringArray array2;

	@Before
	public void setUp() throws Exception {		
        //nothing to do for this first set
	}
	
	@Test
	public void testStringArray() {
		array1=new StringArray(slist1);
		array2=new StringArray(slist2);	
		assertEquals(8,array1.size());		
		assertEquals(7,array2.size());	
	}

	@Test
	public void test1IndexOf() {
		array2=new StringArray(slist2);
		assertEquals(-1,array2.IndexOf("ee"));
	}
	
	@Test
	public void test2IndexOf() {
		array2=new StringArray(slist2);
		assertEquals(3,array2.IndexOf("d"));
	}
	
	@Test
	public void testGetString() {
		array1 = new StringArray(slist1);
		assertEquals("a", array1.getString(0));
	}
	
	@Test
	public void test1Dupl() {		
		array1 = new StringArray(slistdupl1);
		assertEquals(1, array1.size());
		assertEquals("ab", array1.getString(0));
	}
	
	@Test
	public void testSort() {
		int i = 0;
		array1 = new StringArray(slist1);
		
		while(i < slist1.length) {
			assertEquals(slist1[0], array1.getString(0));
			i++;
		}
	}
	
	@Test
	public void test2Dupl() {
		array1 = new StringArray(slistdupl2);
		assertEquals(3, array1.size());
	}
}
