import java.awt.*;
import javax.swing.*;

public class StartPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	public StartPanel(PrintMe pm) {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		addLabel("PrintMe", 56);
		addLabel("Закажите печать фотографий", 24);
		addLabel("Предоставьте фотографию через:");


		JPanel buttons = new JPanel();

		JButton usb = new JButton("USB накопитель");
		buttons.add(usb);

		for (String t: new String[] {
			"Сканер фотографий",
			"Яндекс.Диск"
		}){ 
			JButton b = new JButton(t);
			b.setEnabled(false);
			buttons.add(b);
		}

		add(buttons);

		usb.addActionListener(e -> pm.usb());
	}

	private void addLabel(String text, int fontsize) {
		JLabel label = new JLabel(text);
		label.setFont(new Font("Arial", Font.PLAIN, fontsize));
		addCenter(label);
	}

	private void addLabel(String text) {
		addCenter(new JLabel(text));
	}

	private void addCenter(JComponent comp) {
		add(Box.createVerticalGlue());

		comp.setAlignmentX(CENTER_ALIGNMENT);
		add(comp);
	}
}
