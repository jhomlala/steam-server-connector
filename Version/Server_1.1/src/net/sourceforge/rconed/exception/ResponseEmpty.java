package net.sourceforge.rconed.exception;

/**
 * This exception will be thrown whenever the server don't send a response to our command
 */
public class ResponseEmpty extends Exception {

	public ResponseEmpty()
	{
	System.out.println("RESPONSE EMPTY");
	}

}
