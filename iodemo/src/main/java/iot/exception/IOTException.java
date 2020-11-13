package iot.exception;

/**
 * 魔点异常
 */
public class IOTException extends Exception {
	
	private static final long serialVersionUID = 4359180081622082792L;
	private Exception e;

	public IOTException(String msg) {
		this.e = new Exception(msg);
	}
	
	public IOTException(String msg, Throwable cause) {
		this.e = new Exception(msg,cause);
	}
	
	public IOTException(){
		
	}

	public Exception getE() {
		return e;
	}

	public void setE(Exception e) {
		this.e = e;
	}
	
	
	
	
}
