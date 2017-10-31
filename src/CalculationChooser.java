
public class CalculationChooser {
	public static Calculation choose(char sign, double a, double b) {
		switch(sign) {
			case '+':
				return new Addition(a,b);
			case '-':
				return new Subtraction(a,b);
			case '*':
				return new Multiplication(a,b);
			case '/':
				return new Division(a,b);
		}
		return null;
	}
}
