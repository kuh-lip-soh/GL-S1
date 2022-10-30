/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc;

/**
 *
 * @author AsmaPC
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Le Controlleur fait la coordination des interactions entre la vue et le modèle

public class CalculatorController {
	
	private CalculatorView theView;
	private CalculatorModel theModel;
	
	public CalculatorController(CalculatorView theView, CalculatorModel theModel) {
		this.theView = theView;
		this.theModel = theModel;
		
		
		
		this.theView.addCalculateListener(new CalculateListener());
	}
	
	class CalculateListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			int firstNumber, secondNumber = 0;
                        char operation;
			
			
			
			try{
			
				firstNumber = theView.getFirstNumber();
				secondNumber = theView.getSecondNumber();
                                operation = theView.getOperation().charAt(0);
                                
				
				theModel.calculate(firstNumber, secondNumber, operation);
				
				theView.setCalcSolution(theModel.getCalculationValue());
			
			}

			catch(NumberFormatException ex){
				
				System.out.println(ex);
				
				theView.displayErrorMessage("You Need to Enter 2 Integers and a valid operrand");
				
			}
			
		}
		
	}
	
}