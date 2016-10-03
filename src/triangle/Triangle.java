package triangle;

public class Triangle {
	enum TriangleType {
		SCALENE_ACUTANGLE,
	    SCALENE_OBTUSANGLE,
	    SCALENE_RECTANGLE,
	    ISOCELE_ACUTANGLE,
	    ISOCELE_OBTUSANGLE,
	    ISOCELE_RECTANGLE,
	    EQUILATERAL
	}
	private double sideA, sideB, sideC;

	public double getSideA() {
		return sideA;
	}

	public double getSideB() {
		return sideB;
	}

	public double getSideC() {
		return sideC;
	}
	
	private double getAngleAB() {
		return Math.acos((Math.pow(sideA, 2) + Math.pow(sideC, 2) - Math.pow(sideB, 2)) / 2 * sideA * sideC);
	}
	
	private double getAngleBC() {
		return Math.acos((Math.pow(sideB, 2) + Math.pow(sideC, 2) - Math.pow(sideA, 2)) / 2 * sideA * sideB);
	}
	
	private double getAngleAC() {
		return Math.acos((Math.pow(sideA, 2) + Math.pow(sideB, 2) - Math.pow(sideC, 2)) / 2 * sideA * sideB);
	}
	
	private double sumAllAngle() {
		return getAngleAB() + getAngleBC() + getAngleAC();
	}

	public void setSideA(double sideA) {
		this.sideA = sideA;
	}

	public void setSideB(double sideB) {
		this.sideB = sideB;
	}

	public void setSideC(double sideC) {
		this.sideC = sideC;
	}

	Triangle(double sideA, double sideB, double sideC) {
		setSideA(sideA);
		setSideB(sideB);
		setSideC(sideC);
		
		if(anySidesIsNotPositive())
			throw new IllegalArgumentException("Sides are not all positives");
		
		if(sidesViolatesTriangleInequality())
			throw new IllegalArgumentException("Sides violates triangle Inequality");
	}
	
	public int type() {
		if()
	}
	
	private boolean anySidesIsNotPositive() {
		return sideA <= 0 || sideB <= 0 || sideC <= 0;
	}
	
	private boolean sidesViolatesTriangleInequality() {
        return sideA > sideB + sideC
        		|| sideB > sideA + sideC
        		|| sideC > sideA + sideB;
    }
	
	
}
