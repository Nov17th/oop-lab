package hust.soict.cybersec.aims.screen;

import hust.soict.cybersec.aims.cart.Cart;
import hust.soict.cybersec.aims.screen.controller.CartScreenController;
import hust.soict.cybersec.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javax.swing.*;
import java.io.IOException;

public class CartScreen extends JFrame
{
	private static Cart cart;
	private static Store store;

	public static void main(String[] args)
	{
		new CartScreen(store, cart);
	}

	public CartScreen(Store store, Cart cart)
	{
		super();
		CartScreen.store = store;
		CartScreen.cart = cart;

		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);

		this.setTitle("Cart");
		this.setSize(1024, 768);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Platform.runLater(new Runnable()
		{
			@Override
			public void run()
			{
				try
				{
					FXMLLoader loader = new FXMLLoader(
							getClass().getResource("/hust/soict/cybersec/aims/screen/fxml/cart.fxml"));
					CartScreenController controller = new CartScreenController(store, cart);
					loader.setController(controller);
					Parent root = loader.load();
					fxPanel.setScene(new Scene(root));
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		});
	}
}
