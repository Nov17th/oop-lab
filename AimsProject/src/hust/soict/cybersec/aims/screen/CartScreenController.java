package hust.soict.cybersec.aims.screen;

import hust.soict.cybersec.aims.cart.Cart;
import hust.soict.cybersec.aims.media.Media;
import hust.soict.cybersec.aims.media.Playable;
import hust.soict.cybersec.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController
{
	private Cart cart;
	private Store store;

	@FXML
	private TableView<Media> tblMedia;

	@FXML
	private TableColumn<Media, String> colMediaTitle;

	@FXML
	private TableColumn<Media, String> colMediaCategory;

	@FXML
	private TableColumn<Media, Float> colMediaCost;

	@FXML
	private Button btnPlay;

	@FXML
	private Button btnRemove;

	@FXML
	private RadioButton radioBtnFilterId;

	@FXML
	private RadioButton radioBtnFilterTitle;

	@FXML
	private TextField tfFilter;

	@FXML
	private Label costLabel;

	public CartScreenController(Store store, Cart cart)
	{
		super();
		this.cart = cart;
		this.store = store;
	}

	@FXML
	void btnRemovePressed(ActionEvent event)
	{
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		cart.removeMedia(media);
		costLabel.setText(cart.totalCost() + " $");
	}

	@FXML
	void btnPlayPressed(ActionEvent event)
	{
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		Alert alert = new Alert(Alert.AlertType.NONE, media.playGUI());
		alert.setTitle("Playing");
		alert.setHeaderText(null);
		alert.getDialogPane().getButtonTypes().add(ButtonType.OK);
		alert.showAndWait();
	}

	@FXML
	void btnPlaceOrderPressed(ActionEvent event)
	{
		Alert alert = new Alert(Alert.AlertType.INFORMATION, cart.placeOrder());
		costLabel.setText(cart.totalCost() + " $");
		alert.setTitle("Order created");
		alert.setHeaderText(null);
		alert.showAndWait();
	}

	@FXML
	void btnAddBookPressed(ActionEvent event)
	{
		new AddBookToStoreScreen(store, cart);
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
	private void initialize()
	{
		colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
		colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
		colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
		tblMedia.setItems(this.cart.getItemsOrdered());
		costLabel.setText((cart.totalCost() + " S"));

		btnPlay.setVisible(false);
		btnRemove.setVisible(false);

		tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>()
		{
			@Override
			public void changed(ObservableValue<? extends Media> observableValue, Media oldValue, Media newValue)
			{
				if (newValue != null)
				{
					updateButtonBar(newValue);
				}
			}

			private void updateButtonBar(Media media)
			{
				btnRemove.setVisible(true);
				btnPlay.setVisible(media instanceof Playable);
			}
		});

		tfFilter.textProperty().addListener(new ChangeListener<String>()
		{
			@Override
			public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue)
			{
				showFilteredMedia(newValue);
			}

			private void showFilteredMedia(String keyword)
			{
				FilteredList<Media> filteredList = new FilteredList<>(cart.getItemsOrdered());

				if (!keyword.isEmpty() && radioBtnFilterId.isSelected())
				{
					filteredList.setPredicate(media ->
					{
						String idString = String.valueOf(media.getId());
						return idString.equals(keyword);
					});
				}
				else if (!keyword.isEmpty() && radioBtnFilterTitle.isSelected())
				{
					filteredList.setPredicate(media ->
					{
						String title = media.getTitle().toLowerCase();
						return title.contains(keyword.toLowerCase());
					});
				}
				else
				{
					filteredList.setPredicate(null);
				}
				tblMedia.setItems(filteredList);
			}
		});
	}
}
