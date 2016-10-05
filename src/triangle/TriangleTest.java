package triangle;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TriangleTest {
	private Triangle triangle;
	private static final double DELTA = 1e-15;
	
	@Test
	public void testTriangle() {
		triangle = new Triangle(1, 2, 3);
		assertEquals(1, triangle.getSideA(), DELTA);
		assertEquals(2, triangle.getSideB(), DELTA);
		assertEquals(3, triangle.getSideC(), DELTA);
	}
	
	/**
	 * Eclemma ne peut pas vérifier les "expected"
	 * http://stackoverflow.com/questions/12757559/
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testTriangleAnySideIsNegative1() {
		triangle = new Triangle(0, 1, 2);
		assertEquals(-1, triangle.type());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTriangleAnySideIsNegative2() {
		triangle = new Triangle(0, 0, 2);
		assertEquals(-1, triangle.type());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTriangleAnySideIsNegative3() {
		triangle = new Triangle(0, 0, 0);
		assertEquals(-1, triangle.type());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTriangleAnySideIsNegative4() {
		triangle = new Triangle(0, 1, 0);
		assertEquals(-1, triangle.type());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTriangleAnySideIsNegative5() {
		triangle = new Triangle(1, 0, 0);
		assertEquals(-1, triangle.type());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTriangleAnySideIsNegative6() {
		triangle = new Triangle(1, 1, 0);
		assertEquals(-1, triangle.type());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTriangleSidesViolatesTriangleInequality1() {
		triangle = new Triangle(1, 2, 4);
		assertEquals(-1, triangle.type());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTriangleSidesViolatesTriangleInequality2() {
		triangle = new Triangle(5, 1, 3);
		assertEquals(-1, triangle.type());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTriangleSidesViolatesTriangleInequality3() {
		triangle = new Triangle(1, 6, 2);
		assertEquals(-1, triangle.type());
	}
	
	@Test
	public void testIsEquilateral() {
		triangle = new Triangle(1, 1, 1);
		assertEquals(6, triangle.type());
	}
	
	@Test
	public void testIsScaleneAcutangle() {
		triangle = new Triangle(3, 4, 5);
		assertEquals(0, triangle.type());
	}
	
	@Test
	public void testIsScaleneObtusangle() {
		triangle = new Triangle(12, 13, 14);
		assertEquals(0, triangle.type());
	}
}
