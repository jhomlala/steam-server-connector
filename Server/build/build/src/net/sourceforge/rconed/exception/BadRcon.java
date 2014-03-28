package net.sourceforge.rconed.exception;

/**
 * This exception will be thrown whenever the rcon_password used is incorrect
 */
public class BadRcon extends Exception {

	private static final long serialVersionUID = 9168848946609846093L;
	public BadRcon()
	{
	System.out.println("BAD RCON");
	}
}
