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

public class UserInterface {      
    private final JFrame frame;
    private Mode mode = new Mode();
	
    /**
     * 
     */
    public UserInterface() {    	
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mode.setMode(ModeType.BASIC, frame);
        frame.pack();
        
        Dimension minsz = frame.getSize();
        minsz.height = minsz.height+2;
        minsz.width = minsz.width+2;
        
        frame.setMinimumSize(minsz);
        frame.setVisible(true);      
    }
}
