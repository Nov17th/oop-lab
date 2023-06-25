package hust.soict.cybersec.aims.screen;

import java.awt.*;
import java.awt.event.*;

import javax.naming.LimitExceededException;
import javax.swing.*;

import hust.soict.cybersec.aims.exception.PlayerException;
import hust.soict.cybersec.aims.media.*;
import hust.soict.cybersec.aims.cart.*;

public class MediaStore extends JPanel
{
	private Media media;

	public MediaStore(Media media, Cart cart)
	{
		this.media = media;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JLabel title = new JLabel(media.getTitle());
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
		title.setAlignmentX(CENTER_ALIGNMENT);

		JLabel cost = new JLabel( media.getCost() + " S");
		cost.setAlignmentX(CENTER_ALIGNMENT);

		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));

		JButton addToCartButton = new JButton("Add to cart");
		addToCartButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					JOptionPane.showMessageDialog(null, cart.addMedia(media));
				}
				catch (LimitExceededException ex)
				{
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		container.add(addToCartButton);

		if (media instanceof Playable)
		{
			JButton playButton = new JButton("Play");
			playButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					JDialog dialog = new JDialog();
					dialog.setTitle(media.getTitle());
					dialog.setSize(200, 100);

					String mediaInfo = null;
					try
					{
						mediaInfo = "<html>" + media.playGUI().replace("\n", "<br/>") + "</html>";
					}
					catch (PlayerException ex)
					{
						JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
					JLabel mediaLabel = new JLabel(mediaInfo);
					mediaLabel.setVerticalAlignment(JLabel.CENTER);
					mediaLabel.setHorizontalAlignment(JLabel.CENTER);
					JScrollPane scrollPane = new JScrollPane(mediaLabel);
					scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
					
					dialog.add(scrollPane);
					dialog.setVisible(true);
				}
			});
			container.add(playButton);
		}

		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);

		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}

}
