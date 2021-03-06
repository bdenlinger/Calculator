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
import java.math.RoundingMode;

import com.udojava.evalex.Expression;

public class Calculator {

	public Result reckon(String input) {
		Result result = new Result();
		Expression expression = new Expression(input);
		expression.setRoundingMode(RoundingMode.HALF_UP);
		try {
			result.setNumericAnswer(expression.eval());
			result.setStringAnswer(result.getNumericAnswer().toString());
			result.setErrorState(false);
		} 
		catch(ArithmeticException e) {
			System.err.println("Divide by zero is undefined.");
			result.setErrorState(true);
			result.setNumericAnswer(new BigDecimal(0));
			result.setStringAnswer("undef");
		}
		return result;
	}
}