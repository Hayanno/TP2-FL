package triangle;

public class Triangle {
	private enum TriangleType {
	    INVALID(-1),
		SCALENE_ACUTANGLE(0),
	    SCALENE_OBTUSANGLE(1),
	    SCALENE_RECTANGLE(2),
	    ISOSCELES_ACUTANGLE(3),
	    ISOSCELES_OBTUSANGLE(4),
	    ISOSCELES_RECTANGLE(5),
	    EQUILATERAL(6);
		
		private final int value;
		
	    private TriangleType(int value) {
	        this.value = value;
	    }

	    public int getValue() {
	        return value;
	    }
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
	
	private double angleAB() {
		return Math.acos((sideA * sideA + sideC * sideC - sideB * sideB) / 2 * sideA * sideC);
	}
	
	private double angleBC() {
		return Math.acos((sideB * sideB + sideC * sideC - sideA * sideA) / 2 * sideA * sideB);
	}
	
	private double angleAC() {
		return Math.acos((sideA * sideA + sideB * sideB - sideC * sideC) / 2 * sideA * sideB);
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
			throw new IllegalArgumentException("Sides are not all positives.");
		
		if(sidesViolatesTriangleInequality())
			throw new IllegalArgumentException("Sides violates triangle inequality.");
	}
	
	public int type() {
		TriangleType type;
		
		if(isEquilateral())
			type = TriangleType.EQUILATERAL;
		else if(isScalene()) {
			if(isObtusangle())
				type = TriangleType.SCALENE_OBTUSANGLE;
			else if(isAcutangle())
				type = TriangleType.SCALENE_ACUTANGLE;
			else if(isRightAngled())
				type = TriangleType.SCALENE_RECTANGLE;
			else
				type = TriangleType.INVALID;
		}
		else if(isIsosceles()) {
			if(isObtusangle())
				type = TriangleType.ISOSCELES_OBTUSANGLE;
			else if(isAcutangle())
				type = TriangleType.ISOSCELES_ACUTANGLE;
			else if(isRightAngled())
				type = TriangleType.ISOSCELES_RECTANGLE;
			else
				type = TriangleType.INVALID;
		}
		else
			type = TriangleType.INVALID;
		
		return type.getValue();
	}
	
	private boolean isObtusangle() {
		return angleAB() > 90 || angleAC() > 90 || angleBC() > 90;
	}
	
	private boolean isAcutangle() {
		return angleAB() < 90 && angleAC() < 90 && angleBC() < 90;
	}
	
	private boolean isScalene() {
		return sideA != sideB && sideA != sideC && sideB != sideC;
	}
	
	private boolean isIsosceles() {
		return	sideA == sideB && sideA != sideC ||
				sideA == sideC && sideA != sideB ||
				sideB == sideC && sideB != sideA;
	}
	
	private boolean isEquilateral() {
		return sideA == sideB && sideB == sideC;
	}
	
	private boolean isRightAngled() {
		return 	sideA * sideA == sideB * sideB + sideC * sideC ||
				sideB * sideB == sideA * sideA + sideC * sideC ||
				sideC * sideC == sideA * sideA + sideB * sideB;
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
