package com.zuzelvp.flipcoin.server;

import java.util.Random;

import com.zuzelvp.flipcoin.client.FlipCoinService;
import com.zuzelvp.flipcoin.shared.FieldVerifier;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;


/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class FlipCoinServiceImpl extends RemoteServiceServlet implements
		FlipCoinService {
	
	private static Random generator = new Random();
	
	public String flipCoinServer(String name1, String name2, String email1, String email2, Boolean heads1) throws IllegalArgumentException {
		// Verify that the input is valid. 
		// If the input is not valid, throw an IllegalArgumentException back to
		// the client.
		if (!FieldVerifier.validName(name1)) {
			throw new IllegalArgumentException("The first name was invalid");
		}
		if (!FieldVerifier.validEmail(email1)) {
			throw new IllegalArgumentException("The first email was invalid");
		}
		if (!FieldVerifier.validName(name2)) {
			throw new IllegalArgumentException("The second name was invalid");
		}
	    if (!FieldVerifier.validEmail(email1)) {
	    	throw new IllegalArgumentException("The second email was invalid");
		}

		// Assign the names according to who picked heads		
	    String nameHeads = name1;
	    String nameTails = name2;
	    if (!heads1) {
	    	nameHeads = name2;
	    	nameTails = name1;
	    }
	    // Flip a coin
		final int choice = generator.nextInt(2);
		String result = "The coin came up ";
		if (choice == 0) {
			result += "heads. " + nameHeads;
		} else {
			result += "tails. " + nameTails;
		}
		return result + " wins!";
	}
}
