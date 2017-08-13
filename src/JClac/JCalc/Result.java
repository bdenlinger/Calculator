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

import java.math.BigDecimal;

public class Result {
	private BigDecimal numericAnswer;
	private String stringAnswer;
	private boolean errorState;
	
	public Result() {
		numericAnswer = new BigDecimal(0);
		stringAnswer = "";
		errorState = false;
	}
	
	public BigDecimal getNumericAnswer() {
		return numericAnswer;
	}
	public void setNumericAnswer(BigDecimal numericAnswer) {
		this.numericAnswer = numericAnswer;
	}
	public String getStringAnswer() {
		return stringAnswer;
	}
	public void setStringAnswer(String answer) {
		this.stringAnswer = answer;
	}
	public boolean isErrorState() {
		return errorState;
	}
	public void setErrorState(boolean errorState) {
		this.errorState = errorState;
	}		
}
