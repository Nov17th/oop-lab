package hust.soict.cybersec.aims.screen;

import hust.soict.cybersec.aims.media.CompactDisc;
import hust.soict.cybersec.aims.screen.controller.AddTrackController;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javax.swing.*;

public class AddTrack extends JFrame
{
	private static CompactDisc CD;
	public AddTrack(CompactDisc CD)
	{
		super();
		AddTrack.CD = CD;

		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);

		this.setTitle("Add Tracks");
		this.setSize(638, 300);
		this.setVisible(true);
		Platform.runLater(new Runnable()
		{
			@Override
			public void run()
			{
				try
				{
					FXMLLoader loader = new FXMLLoader(getClass().getResource(
							"/hust/soict/cybersec/aims/screen/fxml/addTrack.fxml"));

					AddTrackController controller = new AddTrackController(CD);
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
