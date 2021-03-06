/* 
 * This file is part of JCalc
 * Brian Denlinger
 * brian.denlinger1@gmail.com
 * 
 * JCalc is free software: you can redistribute it and/or modify  
 * it under the terms of the GNU Lesser General Public License as   
 * published by the Free Software Foundation, version 2.1.
 *
 * JCalc is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
*/

package userInterface;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import JCalc.Calculator;
import JCalc.Result;

public class BasicMode {
	private Container pane = new Container();
    private JButton button;
    private final Calculator calc;
    private final JTextArea input = new JTextArea(0, 15);
    private final JTextArea output = new JTextArea(0, 15);
    private final Font inputFont = new Font("Monospaced", Font.PLAIN, 22);
    private final Font outputFont = new Font("Monospaced", Font.BOLD, 22);
    private final Font buttonFont = new Font("Monospaced", Font.PLAIN, 14);
    private final Dimension preferredSize = new Dimension(50,40);
    private final int padx = 10;
    private final int pady = 10;
    private boolean errorState = false;
    
    public BasicMode(JFrame frame) {
    	frame.setContentPane(pane);
    	init();
    	calc = new Calculator();
    }
    
    /**
     * 
     * @param pane
     */
	private void init() {		
        pane.setLayout(new GridBagLayout());
        
        makeButton("0","0",0,5);
        makeButton("1","1",0,4);
        makeButton("2","2",1,4);
        makeButton("3","3",2,4);
        makeButton("4","4",0,3);
        makeButton("5","5",1,3);
        makeButton("6","6",2,3);
    	makeButton("7","7",0,2);
    	makeButton("8","8",1,2);
    	makeButton("9","9",2,2);
    	makeButton("+","+",3,5);
    	makeButton("-","-",3,4);
    	makeButton("÷","/",3,2);
    	makeButton("×","*",3,3);
    	makeButton("(","(",4,3);
    	makeButton(")",")",5,3);
    	makeButton(".",".",1,5);
    	makeButton("^","^",4,4);
    	 	
    	//Special case buttons
    	GridBagConstraints c = new GridBagConstraints();
    	    	    	   	
    	button = new JButton("⌫");
        button.setFont(buttonFont);
        button.setPreferredSize(preferredSize);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = padx;
        c.ipady = pady;
    	c.gridx = 4;
    	c.gridy = 2;
    	button.addActionListener(new ActionListener() { 
    		public void actionPerformed(ActionEvent e) { 
    			if(!errorState) {butDelPress(1);}
    		}
    	});
    	pane.add(button, c);
    	
    	button = new JButton("C");
        button.setFont(buttonFont);
        button.setPreferredSize(preferredSize);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = padx;
        c.ipady = pady;
    	c.gridx = 5;
    	c.gridy = 2;
    	button.addActionListener(new ActionListener() { 
    		public void actionPerformed(ActionEvent e) { 
    			butDelPress(0);
    		}
    	});
    	pane.add(button, c);
    	   	    	    	
    	button = new JButton("√");
        button.setFont(buttonFont);
        button.setPreferredSize(preferredSize);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = padx;
        c.ipady = pady;
    	c.gridx = 5;
    	c.gridy = 4;
    	button.addActionListener(new ActionListener() { 
    		public void actionPerformed(ActionEvent e) { 
    			if(!errorState) {butSquareRoot();}
    		}
    	});
    	pane.add(button, c);
    	    	
    	button = new JButton("x⁻¹");
        button.setFont(buttonFont);
        button.setPreferredSize(preferredSize);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = padx;
        c.ipady = pady;
    	c.gridx = 2;
    	c.gridy = 5;
    	button.addActionListener(new ActionListener() { 
    		public void actionPerformed(ActionEvent e) { 
    			if(!errorState) {butInverse();}
    		}
    	});
    	pane.add(button, c);
    	
    	button = new JButton("=");
        button.setFont(buttonFont);
        button.setPreferredSize(preferredSize);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = padx;
        c.ipady = pady;
    	c.gridx = 4;
    	c.gridy = 5;
    	c.gridwidth = 2;
    	button.addActionListener(new ActionListener() { 
    		public void actionPerformed(ActionEvent e) { 
    			if(!errorState) {butEqual();}
    		}
    	});
    	pane.add(button, c);
    	
        c.ipadx = 0;
        c.ipady = 0;
    	
    	input.setFont(inputFont);
        c.gridwidth = 6;
        c.gridx = 0;
        c.gridy = 0;
        pane.add(input, c);
        
        output.setFont(outputFont);
        c.gridwidth = 6;
        c.gridx = 0;
        c.gridy = 1;
        pane.add(output, c);        
    }
	
	/**
	 * 
	 * @param s
	 * @return
	 */
	private Boolean isOp(String s) {
		if(s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/")||s.equals("^")) {
			return true;
		} else return false;
	}
	
	private Boolean isParen(String s) {
		if(s.equals("(") || s.equals(")")) {
			return true;
		} else return false;
	}
	
	/**
	 * Making buttons is hard. Save lines of code to repeat the same actions
	 * @param s string label and value to insert into input string
	 * @param x Row to insert button into
	 * @param y	Column to insert button into 
	 */
	private void makeButton(final String label, final String input, int x, int y) {
    	button = new JButton(label);
        button.setFont(buttonFont);
		GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = padx;
        c.ipady = pady;
    	c.gridx = x;
    	c.gridy = y;
    	button.setPreferredSize(preferredSize);
    	button.addActionListener(new ActionListener() { 
    		public void actionPerformed(ActionEvent e) { 
    			if(!errorState) {butAddPress(input);}
    		}
    	});   	
    	pane.add(button, c);
	}
    
	/**
	 * 
	 */
	protected void butEqual() {
		Result result = calc.reckon(input.getText());
		errorState = result.isErrorState();
		input.setText("");
		output.setText(String.format("%20s",result.getStringAnswer()));
	}

	protected void butInverse() {
		if(input.getText().isEmpty() && !output.getText().isEmpty()) {
			input.setText(output.getText());
			input.setText("1/(" + input.getText() + ")");
			butEqual();
		} else if(!input.getText().isEmpty()){
			input.setText("1/(" + input.getText() + ")");
			butEqual();
		}
	}
	
	/**
	 * 
	 */
	protected void butSquareRoot() {
		int index = input.getText().length();
		if(!isOp(input.getText().substring(index-1, index))) {
			input.append("*");
		}
		input.setText(input.getText().concat("SQRT("));	
	}

	/**
	 * Deletes the specificed number of characters off the end of the input string.
	 * If 0, clears input and output.
	 * @param numCharDelete number of characters to delete
	 */
	protected void butDelPress(int numCharDelete) {
		if(numCharDelete == 0) {
			if(!input.getText().isEmpty()) {input.setText("");}
			if(!output.getText().isEmpty()) {output.setText("");}
			errorState = false;
		} else if (!input.getText().isEmpty()){
			input.setText(input.getText().substring(0, input.getText().length()-numCharDelete));
		}
	}

	/**
	 * 
	 * @param string
	 */
	protected void butAddPress(String string) {
		//Press = than a symbol (+-*/) set input to output
		if(!output.getText().isEmpty() && input.getText().isEmpty() && (isOp(string) || isParen(string))) {
			input.setText(output.getText().trim());
		}
		//Press ( with no symbol before it append *
		if (string.equals("(") && !input.getText().isEmpty()) {
			int index = input.getText().length();
			String prevChar = input.getText().substring(index-1, index);
			if(!isOp(prevChar) && !isParen(prevChar)) {
				input.append("*");
			}			
		}
		input.append(string);
	}
}
