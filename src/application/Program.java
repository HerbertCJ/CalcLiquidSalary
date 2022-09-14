package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter your gross salary: ");
		Double salary = sc.nextDouble();
		while (salary < 0) {
			System.out.print("Enter a salary more than 0\n>> ");
			salary = sc.nextDouble();
		}

		Double liquidSalary = calcLiquidSalary(salary);

		System.out.printf("Liquid Salary: %.2f", liquidSalary);
		
		sc.close();

	}

	private static double calcLiquidSalary(Double salary) {
		double inss;

		if (salary <= 1212.00) {
			return salary * 0.075;
		}
		else if (salary <= 2427.35) {
			inss = (salary - 1212.01) * 0.09 + 90.90;
		} 
		else if (salary <= 3641.03) {
			inss = (salary - 2427.36) * 0.12 + 200.28;
		} 
		else if (salary <= 7087.22) {
			inss = (salary - 3641.04) * 0.14 + 345.92;
		} 
		else {
			inss = (salary - 7087.22) * 0.14 + 828.39;
		}

		salary -= inss;

		Double irff = calcIrff(salary);

		return salary -= irff;

	}

	private static Double calcIrff(Double salary) {
		double irff = 0.0;

		if (salary <= 1903.98) {
			return irff;
		} 
		else if (salary <= 2826.65) {
			irff = (salary * 0.075) - 142.80;
		} 
		else if (salary <= 3751.05) {
			irff = (salary * 0.15) - 354.80;
		} 
		else if (salary <= 4664.68) {
			irff = (salary * 0.225) - 636.13;
		} 
		else {
			irff = (salary * 0.275) - 869.36;
		}
		return irff;
	}

}
