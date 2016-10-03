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
	
}
