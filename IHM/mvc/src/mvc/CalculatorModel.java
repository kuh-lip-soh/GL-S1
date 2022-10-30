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

    private int calculationValue;

    public void calculate(int firstNumber, int secondNumber, char operation) {
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
        }
    }

    public int getCalculationValue() {
        return calculationValue;

    }

}
