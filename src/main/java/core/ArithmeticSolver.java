package core;

public class ArithmeticSolver {

	public double add(double num1, double num2) {
		return num1 + num2;
		
	}
	
	public double subtract(double num1, double num2) {
		return num1 - num2;
	}
	
	public double multiply(double num1, double num2) {
		return num1 * num2;
	}
	public double divide(double num1, double num2) {
		return num1/num2;
	}
	public double modulus(double num1, double num2) {
		return num1%num2;
	}

	public double solve(String operator, double leftOperand, double rightOperand) {
		double answer = 0;
		
		switch (operator) {
			case "+":
				answer = add(leftOperand, rightOperand);
				break;
			case "-":
				answer = subtract(leftOperand, rightOperand);
				break;
			case "*":
				answer = multiply(leftOperand, rightOperand);
				break;
			case "/":
				answer = divide(leftOperand, rightOperand);
				break;
			case "%":
				answer = modulus(leftOperand, rightOperand);
				break;
			default:
				break;
		}
		
		return answer;
	}
}

