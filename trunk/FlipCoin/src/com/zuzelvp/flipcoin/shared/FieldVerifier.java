package com.zuzelvp.flipcoin.shared;

/**
 * <p>
 * FieldVerifier validates the data entered by the user.
 * </p>
 * <p>
 * This class is in the <code>shared</code> package because we use it in both
 * the client code and on the server. On the client, we verify that the data is
 * valid before sending an RPC request so the user doesn't have to wait for a
 * network round trip to get feedback. On the server, we verify that the data is
 * correct to ensure that the input is correct regardless of where the RPC
 * originates.
 * </p>
 * <p>
 * When creating a class that is used on both the client and the server, be sure
 * that all code is translatable and does not use native JavaScript. Code that
 * is note translatable (such as code that interacts with a database or the file
 * system) cannot be compiled into client side JavaScript. Code that uses native
 * JavaScript (such as Widgets) cannot be run on the server.
 * </p>
 */
public class FieldVerifier {

	/**
	 * Verifies that the specified name is valid.
	 * 
	 * @param text the name to validate
	 * @return true if name is not valid, false otherwise
	 */
	public static boolean validName(String name) {
		// A name is valid if it is not empty
        return !(name == "");
	}
	
	/**
	 * Verifies that the specified email is valid.
	 * 
	 * @param text the email to validate
	 * @return true if email is not valid, false otherwise
	 */
	public static boolean validEmail(String email) {
		
        return EmailAddress.isValidTex(email);
	}
}
