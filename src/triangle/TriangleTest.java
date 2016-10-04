package triangle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class TriangleTest {
	private Triangle triangle;
	
	@Test
	public void testTriangle() {
		triangle = new Triangle(1, 1, 1);
		assertNotNull(triangle);
	}
	
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
}
