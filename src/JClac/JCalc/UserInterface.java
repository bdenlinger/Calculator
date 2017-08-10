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

package JCalc;

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

public class UserInterface {
    private final JFrame frame;
    private final Calculator calc;
    private final JTextArea input = new JTextArea(0, 15);
    private final JTextArea output = new JTextArea(0, 15);
    private final Font inputFont = new Font("Monospaced", Font.PLAIN, 22);
    private final Font outputFont = new Font("Monospaced", Font.BOLD, 22);
    private final Font buttonFont = new Font("Monospaced", Font.PLAIN, 14);
	
    public UserInterface() {
    	calc = new Calculator();
    	
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        
        init(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
        
    }
    
    private void init(Container pane) {
        JButton button;
        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        //c.weightx = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = 30;
        c.ipady = 30;
 
    	button = new JButton("7");
        button.setFont(buttonFont);
    	c.gridx = 0;
    	c.gridy = 2;
    	button.addActionListener(new ActionListener() { 
    		public void actionPerformed(ActionEvent e) { 
    			butAddPress("7");
    		}
    	});
    	pane.add(button, c);
    	
    	button = new JButton("8");
        button.setFont(buttonFont);
    	c.gridx = 1;
    	c.gridy = 2;
    	button.addActionListener(new ActionListener() { 
    		public void actionPerformed(ActionEvent e) { 
    			butAddPress("8");
    		}
    	});
    	pane.add(button, c);
    	
    	button = new JButton("9");
        button.setFont(buttonFont);
    	c.gridx = 2;
    	c.gridy = 2;
    	button.addActionListener(new ActionListener() { 
    		public void actionPerformed(ActionEvent e) { 
    			butAddPress("9");
    		}
    	});
    	pane.add(button, c);
    	
    	button = new JButton("÷");
        button.setFont(buttonFont);
    	c.gridx = 3;
    	c.gridy = 2;
    	button.addActionListener(new ActionListener() { 
    		public void actionPerformed(ActionEvent e) { 
    			butAddPress("/");
    		}
    	});
    	pane.add(button, c);
    	   	
    	button = new JButton("⌫");
        button.setFont(buttonFont);
    	c.gridx = 4;
    	c.gridy = 2;
    	button.addActionListener(new ActionListener() { 
    		public void actionPerformed(ActionEvent e) { 
    			butDelPress();
    		}
    	});
    	pane.add(button, c);
    	
    	button = new JButton("C");
        button.setFont(buttonFont);
    	c.gridx = 5;
    	c.gridy = 2;
    	button.addActionListener(new ActionListener() { 
    		public void actionPerformed(ActionEvent e) { 
    			butDelAllPress();
    		}
    	});
    	pane.add(button, c);
        
    	button = new JButton("4");
        button.setFont(buttonFont);
    	c.gridx = 0;
    	c.gridy = 3;
    	button.addActionListener(new ActionListener() { 
    		public void actionPerformed(ActionEvent e) { 
    			butAddPress("4");
    		}
    	});
    	pane.add(button, c);
    	
    	button = new JButton("5");
        button.setFont(buttonFont);
    	c.gridx = 1;
    	c.gridy = 3;
    	button.addActionListener(new ActionListener() { 
    		public void actionPerformed(ActionEvent e) { 
    			butAddPress("5");
    		}
    	});
    	pane.add(button, c);
    	
    	button = new JButton("6");
        button.setFont(buttonFont);
    	c.gridx = 2;
    	c.gridy = 3;
    	button.addActionListener(new ActionListener() { 
    		public void actionPerformed(ActionEvent e) { 
    			butAddPress("6");
    		}
    	});
    	pane.add(button, c);
    	
    	button = new JButton("×");
        button.setFont(buttonFont);
    	c.gridx = 3;
    	c.gridy = 3;
    	button.addActionListener(new ActionListener() { 
    		public void actionPerformed(ActionEvent e) { 
    			butAddPress("*");
    		}
    	});
    	pane.add(button, c);
    	
    	button = new JButton("(");
        button.setFont(buttonFont);
    	c.gridx = 4;
    	c.gridy = 3;
    	button.addActionListener(new ActionListener() { 
    		public void actionPerformed(ActionEvent e) { 
    			butAddPress("(");
    		}
    	});
    	pane.add(button, c);
    	
    	button = new JButton(")");
        button.setFont(buttonFont);
    	c.gridx = 5;
    	c.gridy = 3;
    	button.addActionListener(new ActionListener() { 
    		public void actionPerformed(ActionEvent e) { 
    			butAddPress(")");
    		}
    	});
    	pane.add(button, c);
    	
    	button = new JButton("1");
        button.setFont(buttonFont);
    	c.gridx = 0;
    	c.gridy = 4;
    	button.addActionListener(new ActionListener() { 
    		public void actionPerformed(ActionEvent e) { 
    			butAddPress("1");
    		}
    	});
    	pane.add(button, c);
    	
    	button = new JButton("2");
        button.setFont(buttonFont);
    	c.gridx = 1;
    	c.gridy = 4;
    	button.addActionListener(new ActionListener() { 
    		public void actionPerformed(ActionEvent e) { 
    			butAddPress("2");
    		}
    	});
    	pane.add(button, c);
    	
    	button = new JButton("3");
        button.setFont(buttonFont);
    	c.gridx = 2;
    	c.gridy = 4;
    	button.addActionListener(new ActionListener() { 
    		public void actionPerformed(ActionEvent e) { 
    			butAddPress("3");
    		}
    	});
    	pane.add(button, c);
    	
    	button = new JButton("-");
        button.setFont(buttonFont);
    	c.gridx = 3;
    	c.gridy = 4;
    	button.addActionListener(new ActionListener() { 
    		public void actionPerformed(ActionEvent e) { 
    			butAddPress("-");
    		}
    	});
    	pane.add(button, c);
    	
    	button = new JButton("^");
        button.setFont(buttonFont);
    	c.gridx = 4;
    	c.gridy = 4;
    	button.addActionListener(new ActionListener() { 
    		public void actionPerformed(ActionEvent e) { 
    			butAddPress("^");
    		}
    	});
    	pane.add(button, c);
    	
    	button = new JButton("√");
        button.setFont(buttonFont);
    	c.gridx = 5;
    	c.gridy = 4;
    	button.addActionListener(new ActionListener() { 
    		public void actionPerformed(ActionEvent e) { 
    			butSquareRoot();
    		}
    	});
    	pane.add(button, c);
    	
    	button = new JButton("0");
        button.setFont(buttonFont);
    	c.gridx = 0;
    	c.gridy = 5;
    	button.addActionListener(new ActionListener() { 
    		public void actionPerformed(ActionEvent e) { 
    			butAddPress("0");
    		}
    	});
    	pane.add(button, c);
    	
    	button = new JButton(".");
        button.setFont(buttonFont);
    	c.gridx = 1;
    	c.gridy = 5;
    	button.addActionListener(new ActionListener() { 
    		public void actionPerformed(ActionEvent e) { 
    			butAddPress(".");
    		}
    	});
    	pane.add(button, c);
    	
    	button = new JButton("x⁻ⁱ");
        button.setFont(buttonFont);
    	c.gridx = 2;
    	c.gridy = 5;
    	button.addActionListener(new ActionListener() { 
    		public void actionPerformed(ActionEvent e) { 
    			butInverse();
    		}
    	});
    	pane.add(button, c);
    	
    	button = new JButton("+");
        button.setFont(buttonFont);
    	c.gridx = 3;
    	c.gridy = 5;
    	button.addActionListener(new ActionListener() { 
    		public void actionPerformed(ActionEvent e) { 
    			butAddPress("+");
    		}
    	});
    	pane.add(button, c);
    	
    	button = new JButton("=");

        button.setFont(buttonFont);
    	c.gridx = 4;
    	c.gridy = 5;
    	c.gridwidth = 2;
    	button.addActionListener(new ActionListener() { 
    		public void actionPerformed(ActionEvent e) { 
    			butEqual();
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
    
	protected void butEqual() {
		String result = calc.reckon(input.getText());
		output.setText(String.format("%20s",result));
	}

	protected void butInverse() {
		input.setText("1/(" + input.getText() + ")");
		butEqual();		
	}
	
	protected void butSquareRoot() {
		int index = input.getText().length();
		if(!isSymbol(input.getText().substring(index-1, index))) {
			input.setText(input.getText() + "*");
		}
		input.setText(input.getText().concat("SQRT("));
		
	}

	protected void butDelAllPress() {
		input.setText("");
		output.setText("");
	}

	protected void butDelPress() {
		input.setText(input.getText().substring(0, input.getText().length()-1));
		
	}

	protected void butAddPress(String string) {
		if(!output.getText().isEmpty() && isSymbol(string)) {
			input.setText(output.getText().trim() + string);
		} else {
		input.append(string);	
		}
	}
	
	private Boolean isSymbol(String s) {
		if(s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/")) {
			return true;
		} else return false;
	}
}
