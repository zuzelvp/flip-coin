package com.zuzelvp.flipcoin.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("flip")
public interface FlipCoinService extends RemoteService {
	String flipCoinServer(String name1, String name2, String email1, String email2, Boolean heads1) throws IllegalArgumentException;
}
