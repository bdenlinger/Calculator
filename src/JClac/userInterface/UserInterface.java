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

import java.awt.Dimension;

import javax.swing.JFrame;

/**
 * Class creates the frame holding the mode and menus to facilitate changing modes
 * @author brian
 *
 */
public class UserInterface {      
    private final JFrame frame;
    private Mode mode;
	
    /**
     * Basic Constructor
     */
    public UserInterface() {
        frame = new JFrame("Calculator");
    	new Mode(ModeType.BASIC,frame);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        
        Dimension minsz = frame.getSize();
        minsz.height = minsz.height+2;
        minsz.width = minsz.width+2;
        
        frame.setMinimumSize(minsz);
        frame.setVisible(true);      
    }
    
    /**
     * Method to clear the pane and set a new mode
     * @param m
     */
    private void switchMode(ModeType m) {
    	mode.setMode(m, frame);
    }
}
