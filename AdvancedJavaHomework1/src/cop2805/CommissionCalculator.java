package cop2805;

public class CommissionCalculator {

	public static void main(String[] args) {
		double totalIncome;
		
		//table header
		System.out.println("Sales				Income");
		
		//loop to output income amounts based on sales ranging from $1000 to $20000 in $1000 increments
		for (int x = 1000; x <= 20000; x += 1000) {
			totalIncome = computeIncome(x);
			System.out.println("$" + x + "				$" + totalIncome);
		}
	}
	
	public static double computeIncome(double salesAmount) {
		double commission;
		int salary = 5000;
		
		//if else statements to determine commission tier and return total + base salary
		if (salesAmount <= 5000) {
			commission = salesAmount * .08;
			return commission + salary;
		}
		else if (salesAmount <= 10000) {
			commission = (salesAmount - 5000) * .1 + (5000 * .08);
			return commission + salary;
		}
		else {
			commission = (salesAmount - 10000) * .12 + (5000 * .1) + (5000 * .08);
			return commission + salary;
		}
	}
}
