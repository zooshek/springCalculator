package pl.baranska.springcalculator;

public class CalculatorMain {
    public static void main(String[] args) {
        CalculatorService calculatorService = new CalculatorService();
        System.out.println(calculatorService.calculate("62 + 8"));
    }
}
