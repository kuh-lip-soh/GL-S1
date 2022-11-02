/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc;

/**
 *
 * @author AsmaPC
 */


// Le seul travail de la vue est d'afficher ce que l'utilisateur voit
// La vue n'effectue pas d'opérations 

import java.awt.event.ActionListener;

import javax.swing.*;

public class CalculatorView extends JFrame{

	private JTextField firstNumber  = new JTextField(10);
	private JTextField operation = new JTextField(2);
	private JTextField secondNumber = new JTextField(10);
	private JButton calculateButton = new JButton("Calculate");
	private JTextField calcSolution = new JTextField(20);
	
	CalculatorView(){
		
		
		JPanel calcPanel = new JPanel();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(700, 80);
		
		calcPanel.add(firstNumber);
		calcPanel.add(operation);
		calcPanel.add(secondNumber);
		calcPanel.add(calculateButton);
		calcPanel.add(calcSolution);
		
		this.add(calcPanel);
		
			
	}
	
	public double getFirstNumber(){
		
		return Double.parseDouble(firstNumber.getText());
		
	}
	
	public double getSecondNumber(){
		
		return Double.parseDouble(secondNumber.getText());
		
	}
        
        public String getOperation(){
		
		return (operation.getText());
		
	}
	
	public int getCalcSolution(){
		
		return Integer.parseInt(calcSolution.getText());
		
	}
	
	public void setCalcSolution(String solution){
		
		calcSolution.setText(solution);
		
	}
	
	// Si on clique sur le bouton, on execute une méthode dans le controlleur
	
            void addCalculateListener(ActionListener listenForCalcButton){
		
		calculateButton.addActionListener(listenForCalcButton);
		
	}
	
	
	
	void displayErrorMessage(String errorMessage){
		
		JOptionPane.showMessageDialog(this, errorMessage);
		
	}

 
	
}