package userInterface;

import javax.swing.JFrame;

/**
 * Sits inside a frame is holds buttons to interact with
 * @author brian
 *
 */
public class Mode {
	
	private ModeType mt;
	
	/**
	 * Basic constructor to make a mode pane.
	 * @param m modetype to create
	 * @param f frame to insert pane into
	 */
	public Mode(ModeType m, JFrame f) {
		setMode(m,f);
	}

	/**
	 * Creates or changes the mode of a frame
	 * @param m modetype to change to
	 * @param f frame to insert pane into
	 */
	@SuppressWarnings("unused")
	public void setMode(ModeType m, JFrame f) {
		//Remove all components before switching modes
		f.getContentPane().removeAll();
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
