import java.awt.*;
import javax.swing.*;

public class PrintMe extends JFrame {
	private static final long serialVersionUID = 1L;
	Order order = new Order();
	JPanel editorPanel = new EditorPanel(this);

	public PrintMe() {
		setTitle("PrintMe");
		setSize(920, 690); 
		setLayout(new CardLayout());
		add(new StartPanel(this));
		add(editorPanel);
	}

	public void usb() {
		next();
	}

	public void pay() {
		System.out.println(order);
	}

	public void setPhotoSize(int w, int h) {
		order.width = w;
		order.height = h;
	}

	public void setPaperType(PaperType type) {
		order.paperType = type;
	}

	public void setMargins(int selected) {
		order.margins = selected == java.awt.event.ItemEvent.SELECTED;
	}
	
	public void first() { getCardLayout().first(getContentPane()); }
	public void  next() { getCardLayout().next (getContentPane()); }

	private CardLayout getCardLayout() {
		return (CardLayout)getContentPane().getLayout();
	}

	public static void main(String[] args) {
		Font font = new Font("Arial", Font.PLAIN, 18);

		for (String p: new String[]{
			"Button.font",
			"RadioButton.font",
			"CheckBox.font",
			"Label.font"
		}) UIManager.put(p, font);
		
		SwingUtilities.invokeLater(() -> {
			PrintMe pm = new PrintMe(); 

			pm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			pm.setVisible(true); 
		});
	}
}
