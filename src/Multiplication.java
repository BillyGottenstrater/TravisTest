
public class Multiplication implements Calculation {
	
	private double a;
	private double b;
	
	public Multiplication(double a, double b) {
		this.a = a;
		this.b = b;
	}
	
	@Override
	public double calculate() {
		return a * b;
	}

}
