
public class Calculator {
	public String operation;
	public double num1;
	public double num2;
	public double result;
	public Calculator() {
			
		}
	public void setNum1(double num1) {
		this.num1 = num1;
	}
	public void setNum2(double num2) {
		this.num2 = num2;
	}
	public void setOperator(String operation) {
		this.operation = operation;
	}
	public void performOperation() {
		if( this.operation == "sum") {
			result = (num1) + (num2);
		}
		if( this.operation == "subtract") {
			result = (num1) - (num2);
		}
	}
	public void getResults() {
		System.out.println(result);
	}
	

}
