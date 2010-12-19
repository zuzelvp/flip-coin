package com.zuzelvp.flipcoin.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimpleRadioButton;
import com.google.gwt.user.client.ui.TextBox;
import com.zuzelvp.flipcoin.shared.FieldVerifier;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class FlipCoin implements EntryPoint {
	private TextBox tbName1;
	private TextBox tbEmail1;
	private TextBox tbName2;
	private TextBox tbEmail2;
	private SimpleRadioButton srbHeads1;
	private SimpleRadioButton srbHeads2;

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final FlipCoinServiceAsync flipCoinService = GWT
			.create(FlipCoinService.class);
	private Button bFlip;
	private Label lblName1Error;
	private Label lblEmail1Error;
	private Label lblHeads1Error;
	private Label lblName2Error;
	private Label lblEmail2Error;
	private Label lblHeads2Error;
	private HTML htmlflipACoin;
	private Label lblGeneralError;
	private Label lblResult;
	private Label label;

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
        RootPanel rootPanel = RootPanel.get();
		
		Grid grid = new Grid(10, 3);
		grid.setStyleName((String) null);
		rootPanel.add(grid, 0, 0);
		
		htmlflipACoin = new HTML("<h1>Flip a Coin</h1>", true);
		htmlflipACoin.setStyleName("gwt-Label");
		grid.setWidget(0, 0, htmlflipACoin);
		
		lblResult = new Label("");
		lblResult.setStyleName("gwt-ResultLabel");
		grid.setWidget(1, 0, lblResult);
		
		label = new Label("");
		grid.setWidget(2, 0, label);
		
		Label lblName = new Label("Name");
		grid.setWidget(3, 0, lblName);
		
		Label lblEmail = new Label("Email");
		grid.setWidget(3, 1, lblEmail);
		
		Label lblChoice = new Label("Heads");
		lblChoice.setWordWrap(false);
		grid.setWidget(3, 2, lblChoice);
		
		lblName1Error = new Label("");
		lblName1Error.setStyleName("gwt-ErrorLabel");
		grid.setWidget(4, 0, lblName1Error);
		
		lblEmail1Error = new Label("");
		lblEmail1Error.setStyleName("gwt-ErrorLabel");
		grid.setWidget(4, 1, lblEmail1Error);
		
		lblHeads1Error = new Label("");
		lblHeads1Error.setStyleName("gwt-ErrorLabel");
		grid.setWidget(4, 2, lblHeads1Error);
		
		tbName1 = new TextBox();
		tbName1.setName("name1");
		grid.setWidget(5, 0, tbName1);
		
		tbEmail1 = new TextBox();
		tbEmail1.setName("email1");
		grid.setWidget(5, 1, tbEmail1);
		
		srbHeads1 = new SimpleRadioButton("heads1");
		// Uncheck the other radio button
		srbHeads1.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				srbHeads2.setValue(false);
			}
		});
		grid.setWidget(5, 2, srbHeads1);
		
		lblName2Error = new Label("");
		lblName2Error.setStyleName("gwt-ErrorLabel");
		grid.setWidget(6, 0, lblName2Error);
		
		lblEmail2Error = new Label("");
		lblEmail2Error.setStyleName("gwt-ErrorLabel");
		grid.setWidget(6, 1, lblEmail2Error);
		
		lblHeads2Error = new Label("");
		lblHeads2Error.setStyleName("gwt-ErrorLabel");
		grid.setWidget(6, 2, lblHeads2Error);
		
		tbName2 = new TextBox();
		tbName2.setName("name2");
		grid.setWidget(7, 0, tbName2);
		
		tbEmail2 = new TextBox();
		tbEmail2.setName("email2");
		grid.setWidget(7, 1, tbEmail2);
		
		srbHeads2 = new SimpleRadioButton("heads2");
		// Uncheck the other radio button
		srbHeads2.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				srbHeads1.setValue(false);
			}
		});
		grid.setWidget(7, 2, srbHeads2);
		
		lblGeneralError = new Label("");
		lblGeneralError.setStyleName("gwt-ErrorLabel");
		grid.setWidget(8, 0, lblGeneralError);
		
		bFlip = new Button("Flip");
		bFlip.setText("Flip!");
		grid.setWidget(9, 0, bFlip);
		grid.getCellFormatter().setVerticalAlignment(5, 1, HasVerticalAlignment.ALIGN_MIDDLE);
		grid.getCellFormatter().setVerticalAlignment(5, 2, HasVerticalAlignment.ALIGN_MIDDLE);
		grid.getCellFormatter().setVerticalAlignment(5, 0, HasVerticalAlignment.ALIGN_MIDDLE);
		grid.getCellFormatter().setVerticalAlignment(3, 0, HasVerticalAlignment.ALIGN_MIDDLE);
		grid.getCellFormatter().setVerticalAlignment(3, 1, HasVerticalAlignment.ALIGN_MIDDLE);
		grid.getCellFormatter().setVerticalAlignment(7, 0, HasVerticalAlignment.ALIGN_MIDDLE);
		grid.getCellFormatter().setVerticalAlignment(7, 1, HasVerticalAlignment.ALIGN_MIDDLE);
		grid.getCellFormatter().setVerticalAlignment(9, 0, HasVerticalAlignment.ALIGN_MIDDLE);
		grid.getCellFormatter().setVerticalAlignment(7, 2, HasVerticalAlignment.ALIGN_MIDDLE);
		grid.getCellFormatter().setVerticalAlignment(3, 2, HasVerticalAlignment.ALIGN_MIDDLE);
		grid.getCellFormatter().setHorizontalAlignment(5, 2, HasHorizontalAlignment.ALIGN_CENTER);
		grid.getCellFormatter().setHorizontalAlignment(7, 2, HasHorizontalAlignment.ALIGN_CENTER);
		grid.getCellFormatter().setHorizontalAlignment(9, 0, HasHorizontalAlignment.ALIGN_CENTER);
		grid.getCellFormatter().setHorizontalAlignment(3, 0, HasHorizontalAlignment.ALIGN_LEFT);
		grid.getCellFormatter().setHorizontalAlignment(3, 1, HasHorizontalAlignment.ALIGN_LEFT);
		grid.getCellFormatter().setHorizontalAlignment(3, 2, HasHorizontalAlignment.ALIGN_LEFT);
		grid.getCellFormatter().setHorizontalAlignment(5, 0, HasHorizontalAlignment.ALIGN_LEFT);
		grid.getCellFormatter().setHorizontalAlignment(7, 0, HasHorizontalAlignment.ALIGN_LEFT);
		grid.getCellFormatter().setHorizontalAlignment(5, 1, HasHorizontalAlignment.ALIGN_LEFT);
		grid.getCellFormatter().setHorizontalAlignment(7, 1, HasHorizontalAlignment.ALIGN_LEFT);
		grid.getCellFormatter().setVerticalAlignment(1, 0, HasVerticalAlignment.ALIGN_TOP);

		// Create a handler for the Flip button
		class MyHandler implements ClickHandler {
			/**
			 * Fired when the user clicks on the sendButton.
			 */
			public void onClick(ClickEvent event) {
				sendDataToServer();
			}

			/**
			 * Send the name from the nameField to the server and wait for a response.
			 */
			private void sendDataToServer() {
				// First, we validate the input.
				Boolean validData = true;
				final String name1 = tbName1.getText().trim();
				tbName1.setFocus(true);
				if (!FieldVerifier.validName(name1)) {
					lblName1Error.setText("This field is required.");
					validData = false;
				} else {
					lblName1Error.setText("");
				}
				final String email1 = tbEmail1.getText().trim();
				tbEmail1.setFocus(true);
				if (!FieldVerifier.validEmail(email1)) {
					lblEmail1Error.setText("Enter a valid e-mail address.");
					validData = false;
				} else {
					lblEmail1Error.setText("");
				}
				final String name2 = tbName2.getText().trim();
				tbName2.setFocus(true);
				if (!FieldVerifier.validName(name2)) {
					lblName2Error.setText("This field is required.");
					validData = false;
				} else {
					lblName2Error.setText("");
				}
				final String email2 = tbEmail2.getText().trim();
				tbEmail2.setFocus(true);
				if (!FieldVerifier.validEmail(email2)) {
					lblEmail2Error.setText("Enter a valid e-mail address.");
					validData = false;
				} else {
					lblEmail2Error.setText("");
				}
				final Boolean heads1 = srbHeads1.getValue();
				srbHeads1.setFocus(true);
				if (!heads1 && !srbHeads2.getValue()) {
					lblGeneralError.setText("Select who wins if the coin comes up heads.");
					validData = false;
				} else {
					lblGeneralError.setText("");
				}
				
				if (!validData) {
					return;
				}

				// Then, we send the input to the server.
				bFlip.setEnabled(false);
				flipCoinService.flipCoinServer(name1, name2, email1, email2, heads1,
						new AsyncCallback<String>() {
							public void onFailure(Throwable caught) {
								// Show the RPC error message to the user
								lblGeneralError.setText(caught.toString());
								lblResult.setText("");
								bFlip.setEnabled(true);
							}

							public void onSuccess(String result) {
								lblGeneralError.setText("");
								lblResult.setText(result);
								bFlip.setEnabled(true);
							}
						});
			}
		}

		// Add a handler to send the name to the server
		MyHandler handler = new MyHandler();
		bFlip.addClickHandler(handler);
	}
}
