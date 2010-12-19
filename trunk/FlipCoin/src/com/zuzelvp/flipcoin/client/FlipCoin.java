package com.zuzelvp.flipcoin.client;

import java.util.Random;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimpleRadioButton;
import com.google.gwt.user.client.ui.TextBox;

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
	private Random generator;
	public void onModuleLoad() {
		RootPanel rootPanel = RootPanel.get();
		
		Grid grid = new Grid(5, 3);
		rootPanel.add(grid, 0, 0);
		grid.setSize("450px", "300px");
		
		Label lblFlipACoin = new Label("Flip a Coin");
		grid.setWidget(0, 0, lblFlipACoin);
		
		Label lblName = new Label("Name");
		grid.setWidget(1, 0, lblName);
		
		Label lblEmail = new Label("Email");
		grid.setWidget(1, 1, lblEmail);
		
		Label lblChoice = new Label("Heads");
		grid.setWidget(1, 2, lblChoice);
		
		tbName1 = new TextBox();
		tbName1.setName("name1");
		grid.setWidget(2, 0, tbName1);
		
		tbEmail1 = new TextBox();
		tbEmail1.setName("email1");
		grid.setWidget(2, 1, tbEmail1);
		
		srbHeads1 = new SimpleRadioButton("heads1");
		// Uncheck the other radio button
		srbHeads1.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				srbHeads2.setValue(false);
			}
		});
		grid.setWidget(2, 2, srbHeads1);
		
		tbName2 = new TextBox();
		tbName2.setName("name2");
		grid.setWidget(3, 0, tbName2);
		
		tbEmail2 = new TextBox();
		tbEmail2.setName("email2");
		grid.setWidget(3, 1, tbEmail2);
		
		srbHeads2 = new SimpleRadioButton("heads2");
		// Uncheck the other radio button
		srbHeads2.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				srbHeads1.setValue(false);
			}
		});
		grid.setWidget(3, 2, srbHeads2);
		
		Button bFlip = new Button("Flip");
		bFlip.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				Flip();
			}
		});
		bFlip.setText("Flip!");
		grid.setWidget(4, 0, bFlip);
		grid.getCellFormatter().setVerticalAlignment(3, 0, HasVerticalAlignment.ALIGN_TOP);
		grid.getCellFormatter().setVerticalAlignment(3, 1, HasVerticalAlignment.ALIGN_TOP);
		grid.getCellFormatter().setVerticalAlignment(4, 0, HasVerticalAlignment.ALIGN_TOP);
		grid.getCellFormatter().setVerticalAlignment(3, 2, HasVerticalAlignment.ALIGN_TOP);
		grid.getCellFormatter().setVerticalAlignment(2, 1, HasVerticalAlignment.ALIGN_MIDDLE);
		grid.getCellFormatter().setVerticalAlignment(2, 2, HasVerticalAlignment.ALIGN_MIDDLE);
		grid.getCellFormatter().setVerticalAlignment(2, 0, HasVerticalAlignment.ALIGN_MIDDLE);
		grid.getCellFormatter().setVerticalAlignment(1, 0, HasVerticalAlignment.ALIGN_BOTTOM);
		grid.getCellFormatter().setVerticalAlignment(1, 1, HasVerticalAlignment.ALIGN_BOTTOM);
		grid.getCellFormatter().setVerticalAlignment(1, 2, HasVerticalAlignment.ALIGN_BOTTOM);
		generator = new Random();
	}


	protected void Flip() { 
		// Validate user input 
		final String name1 = tbName1.getText().trim();
		if (isEmpty(name1, tbName1)) {
			return;
		}
		final String email1 = tbEmail1.getText().trim();
		if (isEmpty(email1, tbEmail1)) {
			return;
		}
		final String name2 = tbName2.getText().trim();
		if (isEmpty(name2, tbName2)) {
			return;
		}
		final String email2 = tbEmail2.getText().trim();
		if (isEmpty(email2, tbEmail2)) {
			return;
		}
		final Boolean heads1 = srbHeads1.getValue();
		srbHeads1.setFocus(true);
		if (!heads1 && !srbHeads2.getValue()) {
		    Window.alert("Please select who wins if the coin comes up heads.");
			return;
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
		if (choice == 0) {
			Window.alert("The coin came up heads, so the winer is " + nameHeads + ".");
		} else {
			Window.alert("The coin came up tails, so the winer is " + nameTails + ".");
		}
	}
	
	
	private boolean isEmpty(String text, TextBox textBox) {
		// If the textbox was empty the focus will be on it after the user
		// closes the alert window.
		textBox.setFocus(true);

	    if (text == "") {
	      Window.alert("Please fill out the two names and the two email addresses.");
	      return true;
	    }
		return false;
	}

}
