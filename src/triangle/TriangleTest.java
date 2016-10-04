package triangle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
	public void testTriangleAnySideIsNotPositive() {
		triangle = new Triangle(0, 1, 2);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTriangleSidesViolatesTriangleInequality() {
		triangle = new Triangle(1, 2, 4);
	}
}
