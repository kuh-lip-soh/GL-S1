/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc;

/**
 *
 * @author AsmaPC
 */
// Le modèle effectue toutes les opérations nécessaires.
//Le modèle ne sait pas que la vue existe
public class CalculatorModel {

    private double calculationValue=1;

    public void calculate(double firstNumber, double secondNumber, char operation) {
        int i;
        switch (operation) {
            case '+':
                calculationValue = firstNumber + secondNumber;
                break;
            case '-':
                calculationValue = firstNumber - secondNumber;
                break;
            case '*':
                calculationValue = firstNumber * secondNumber;
                break;
            case '/':
                calculationValue = firstNumber / secondNumber;
                break;
            case 'm':
                calculationValue = firstNumber - (firstNumber/secondNumber)*secondNumber;
                break;
            case 'p':
                calculationValue = Math.pow(firstNumber, secondNumber);
                break;
            case 'e':
                calculationValue = Math.exp(firstNumber);
                break;
            case 's':
                calculationValue = Math.sin(Math.toRadians(firstNumber));
                break;
            case 'c':
                calculationValue = Math.cos(Math.toRadians(firstNumber));
                break;
            case 't':
                calculationValue = Math.tan(Math.toRadians(firstNumber));
                break;
            case 'S':
                calculationValue = Math.toDegrees(Math.asin(firstNumber));
                break;
            case 'C':
                calculationValue = Math.toDegrees(Math.acos(firstNumber));
                break;
            case 'T':
                calculationValue = Math.toDegrees(Math.atan(firstNumber));
                break;            
            case '!':
                if(firstNumber==0)
                {
                    calculationValue = 1;
                    break;
                }
                for(i=1; i<=firstNumber; i++)
                {
                    calculationValue *= i;
                }               
                break;            
            case 'l':
                calculationValue = Math.log(firstNumber);
                break;
            
        }
    }
    
    public int decimalConvert(double n) {
        return Integer.parseInt(Integer.toString((int)n));
    }
    
    public void binaryConvert() {
        String b;
        int i;
        b=Double.toString(calculationValue);
        i=Integer.parseInt(b);
        b=Integer.toBinaryString(i);
        calculationValue=Integer.parseInt(b);

    }

    public String getCalculationValue() {
        return Double.toString(calculationValue);
        
    }

}
