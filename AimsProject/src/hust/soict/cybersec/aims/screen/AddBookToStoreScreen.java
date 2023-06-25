package hust.soict.cybersec.aims.screen;

import hust.soict.cybersec.aims.cart.Cart;
import hust.soict.cybersec.aims.screen.controller.AddBookToStoreController;
import hust.soict.cybersec.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javax.swing.*;

public class AddBookToStoreScreen extends JFrame
{
	private static Store store;
	private static Cart cart;

	public AddBookToStoreScreen(Store store, Cart cart)
	{
		super();
		AddBookToStoreScreen.store = store;
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);

		this.setTitle("Add Book");
		this.setSize(1024, 768);
		this.setVisible(true);
		Platform.runLater(new Runnable()
		{
			@Override
			public void run()
			{
				try
				{
					FXMLLoader loader = new FXMLLoader(getClass().getResource(
							"/hust/soict/cybersec/aims/screen/fxml/addBook.fxml"));

					AddBookToStoreController controller = new AddBookToStoreController(store, cart);
					loader.setController(controller);
					Parent root = loader.load();
					fxPanel.setScene(new Scene(root));
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}
}