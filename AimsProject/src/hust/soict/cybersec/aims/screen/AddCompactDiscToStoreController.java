package hust.soict.cybersec.aims.screen;

import hust.soict.cybersec.aims.cart.Cart;
import hust.soict.cybersec.aims.media.CompactDisc;
import hust.soict.cybersec.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddCompactDiscToStoreController
{
	private Store store;
	private Cart cart;

	private CompactDisc CD;

	private boolean allFieldsFilled = false;

	@FXML
	private Button btnAddCD;

	@FXML
	private Button btnAddTrack;

	@FXML
	private Button btnSave;

	@FXML
	private TextField tfArtist;

	@FXML
	private TextField tfCategory;

	@FXML
	private TextField tfCost;

	@FXML
	private TextField tfTitle;

	@FXML
	void btnAddCDPressed(ActionEvent event)
	{
		store.addMedia(CD);
		tfTitle.clear();
		tfCategory.clear();
		tfArtist.clear();
		tfCost.clear();
		btnSave.setDisable(true);
		btnAddCD.setDisable(true);
		btnAddTrack.setDisable(true);

		Alert alert = new Alert(Alert.AlertType.INFORMATION, "CD has been added to store!");
		alert.setTitle("Success");
		alert.setHeaderText(null);
		alert.showAndWait();
	}

	@FXML
	void btnAddTrackPressed(ActionEvent event)
	{
		new AddTrack(CD);
	}

	@FXML
	void btnSavePressed(ActionEvent event)
	{
		String titile = tfTitle.getText();
		String category = tfCategory.getText();
		String artist = tfArtist.getText();
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
		}
		CD = new CompactDisc(titile, category, artist, cost);
		btnAddCD.setDisable(false);
		btnAddTrack.setDisable(false);
		btnSave.setDisable(true);
	}

	@FXML
	void initialize()
	{
		btnSave.setDisable(true);
		btnAddCD.setDisable(true);
		btnAddTrack.setDisable(true);

		tfTitle.textProperty().addListener((observable, oldValue, newValue) -> checkFieldsFilled());
		tfCategory.textProperty().addListener((observable, oldValue, newValue) -> checkFieldsFilled());
		tfArtist.textProperty().addListener((observable, oldValue, newValue) -> checkFieldsFilled());
		tfCost.textProperty().addListener((observable, oldValue, newValue) -> checkFieldsFilled());
	}

	@FXML
	void btnAddBookPressed(ActionEvent event)
	{
		new AddBookToStoreScreen(store, cart);
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


	private void checkFieldsFilled()
	{
		allFieldsFilled =
				!tfTitle.getText().isEmpty() && !tfCategory.getText().isEmpty() && !tfArtist.getText().isEmpty()
						&& !tfCost.getText().isEmpty();
		btnSave.setDisable(!allFieldsFilled);
	}

	public AddCompactDiscToStoreController(Store store, Cart cart)
	{
		super();
		this.store = store;
		this.cart = cart;
	}
}
