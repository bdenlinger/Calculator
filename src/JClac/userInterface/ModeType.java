package userInterface;

public enum ModeType {
	BASIC("Basic"),
	SCIENTIFIC("Scientific"),
	FINANCIAL("Financial");
	
    private String mode;
    
    ModeType(String s) {
    	this.mode = s;
    }
    
    public String getMode() {
    	return this.mode;
    }
}
