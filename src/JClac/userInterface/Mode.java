package userInterface;

import javax.swing.JFrame;

public class Mode {
	
	private ModeType mt;
	
	@SuppressWarnings("unused")
	public void setMode(ModeType m, JFrame f) {
    	switch(m) {
    	case BASIC:
    		BasicMode bm = new BasicMode(f);
    		mt = ModeType.BASIC;
    		break;
    	case SCIENTIFIC:
    		ScientificMode sm = new ScientificMode();
    		mt = ModeType.SCIENTIFIC;
    		break;
    	case FINANCIAL:
    		FinancialMode fm = new FinancialMode();
    		mt = ModeType.FINANCIAL;
    		break;   		
    	}	
	}
	
	public ModeType getModeType() {
		return mt;
	}
}
