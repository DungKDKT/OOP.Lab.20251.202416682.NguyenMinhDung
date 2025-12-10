package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.cart.Cart.Cart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MediaStore extends JPanel {
	private Media media;
	private Cart cart;
	
	public MediaStore(Media media, Cart cart) {
        this.media = media;
        this.cart = cart;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton addToCartBtn = new JButton("Add to cart");
        addToCartBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cart.addMedia(media);
                JOptionPane.showMessageDialog(null, 
                        media.getTitle() + " has been added to the cart.");
            }
        });
        container.add(addToCartBtn);

        if (media instanceof Playable) {
            JButton playBtn = new JButton("Play");
            playBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JDialog dialog = new JDialog();
                    dialog.setTitle("Playing Media");
                    dialog.setSize(400, 300);
                    dialog.setLocationRelativeTo(null);
                    dialog.setLayout(new BorderLayout());
                    String message = "<html><center>Playing: " + media.getTitle() + "<br>Length: " + ((Disc)media).getLength() + " mins</center></html>";
                    JLabel label = new JLabel(message);
                    label.setHorizontalAlignment(SwingConstants.CENTER);
                    label.setFont(new Font(label.getFont().getName(), Font.PLAIN, 20));
                    dialog.add(label, BorderLayout.CENTER);
                    dialog.setVisible(true);
                }
            });
            container.add(playBtn);
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}
