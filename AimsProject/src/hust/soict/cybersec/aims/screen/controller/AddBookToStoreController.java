package hust.soict.cybersec.aims.screen.controller;

import hust.soict.cybersec.aims.cart.Cart;
import hust.soict.cybersec.aims.media.Book;
import hust.soict.cybersec.aims.screen.AddCompactDiscToStoreScreen;
import hust.soict.cybersec.aims.screen.AddDigitalVideoDiscToStoreScreen;
import hust.soict.cybersec.aims.screen.CartScreen;
import hust.soict.cybersec.aims.screen.StoreScreen;
import hust.soict.cybersec.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javax.swing.*;

public class AddBookToStoreController
{
	private Store store;
	private Cart cart;

	private boolean allFieldsFilled = false;

	@FXML
	private Button btnSave;

	@FXML
	private TextField tfCategory;

	@FXML
	private TextField tfCost;

	@FXML
	private TextField tfTitle;

	@FXML
	void btnSavePressed(ActionEvent event)
	{
		String title = tfTitle.getText();
		String category = tfCategory.getText();
		float cost = 0.0f;
		try
		{
			cost = Float.parseFloat(tfCost.getText());
		}
		catch (NumberFormatException e)
		{
			Alert alert = new Alert(Alert.AlertType.ERROR, "Failed to set cost!");
			alert.setTitle("Wrong type");
			alert.setHeaderText(null);
			alert.showAndWait();
			return;
		} Book book = new Book(title, category, cost);
		store.addMedia(book);
		tfTitle.clear();
		tfCategory.clear();
		tfCost.clear();
		Alert alert = new Alert(Alert.AlertType.INFORMATION, "Book has been added to store!");
		alert.setTitle("Success");
		alert.setHeaderText(null);
		alert.showAndWait();
	}

	@FXML
	void btnAddCDPressed(ActionEvent event)
	{
		new AddCompactDiscToStoreScreen(store, cart);
	}

	@FXML
	void btnAddDVDPressed(ActionEvent event)
	{
		new AddDigitalVideoDiscToStoreScreen(store, cart);
	}

	@FXML
	void btnViewStorePressed(ActionEvent event)
	{
		new StoreScreen(store);
	}

	@FXML
	void btnViewCartPressed(ActionEvent event)
	{
		new CartScreen(store, cart);
	}

	public AddBookToStoreController(Store store, Cart cart)
	{
		super();
		this.store = store;
		this.cart = cart;
	}

	@FXML
	void initialize()
	{
		btnSave.setDisable(true);

		tfTitle.textProperty().addListener((observable, oldValue, newValue) -> checkFieldsFilled());
		tfCategory.textProperty().addListener((observable, oldValue, newValue) -> checkFieldsFilled());
		tfCost.textProperty().addListener((observable, oldValue, newValue) -> checkFieldsFilled());
	}

	private void checkFieldsFilled()
	{
		allFieldsFilled =
				!tfTitle.getText().isEmpty() && !tfCategory.getText().isEmpty() && !tfCost.getText().isEmpty();
		btnSave.setDisable(!allFieldsFilled);
	}
}
