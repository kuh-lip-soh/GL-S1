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

                @Override
		public void actionPerformed(ActionEvent e) {
			
			double firstNumber, secondNumber = 1;
                        String operation;
                        int i=0;
                        boolean b=false;
			
			
			
			try{
			
				firstNumber = theView.getFirstNumber();
				secondNumber = theView.getSecondNumber();
                                operation = theView.getOperation();
                                
                                if(operation.charAt(0)=='/' && secondNumber==0)
                                {
                                    theView.displayErrorMessage("Second number cannot be 0");
                                }
                                
                                if(operation.charAt(0)=='!' && firstNumber<0)
                                {
                                    theView.displayErrorMessage("Number cannot be negative");
                                }
                                
                                if((operation.charAt(0)=='S' || operation.charAt(0)=='C') && (firstNumber>1 || firstNumber<-1))
                                {
                                    theView.displayErrorMessage("Incorrect input");
                                }
                                
                                if(operation.charAt(0)=='T' && (firstNumber<=-1 || firstNumber>=1))
                                {
                                    theView.displayErrorMessage("Incorrect input");
                                }
                                
                                if(operation.charAt(0) =='b')
                                {
                                    b=true;
                                    i=1;
                                    firstNumber=theModel.decimalConvert(firstNumber);
                                    secondNumber=theModel.decimalConvert(secondNumber);
                                }
				
				theModel.calculate(firstNumber, secondNumber, operation.charAt(i));
				if(b){
                                    theModel.binaryConvert();
                                }
				theView.setCalcSolution(theModel.getCalculationValue());
			
			}

			catch(NumberFormatException ex){
				
				System.out.println(ex);
				
				theView.displayErrorMessage("You Need to Enter 2 Integers and a valid operrand");
				
			}
			
		}
		
	}
	
}