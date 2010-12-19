package com.zuzelvp.flipcoin.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>FlipCoinService</code>.
 */
public interface FlipCoinServiceAsync {

	void flipCoinServer(String name1, String name2, String email1,
			String email2, Boolean heads1, AsyncCallback<String> callback)
	    throws IllegalArgumentException;
}
