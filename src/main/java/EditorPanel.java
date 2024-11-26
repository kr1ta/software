import java.awt.*;
import javax.swing.*;

public class EditorPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private int border = 10;
	PrintMe pm;
	JPanel previewPanel = new JPanel();

	JButton pay = new JButton("К оплате");
	JButton exit = new JButton("Выход");
	JCheckBox margins = new JCheckBox("Включить поля");
	JRadioButton paperTypes[];
	JRadioButton sizes[];

	public EditorPanel(PrintMe pm) {
		this.pm = pm;

		pay.addActionListener(e -> pm.pay());
		exit.addActionListener(e -> pm.first());
		margins.addItemListener(e -> pm.setMargins(e.getStateChange()));

		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		previewPanel.setBackground(Color.WHITE);
		previewPanel.setBorder(new javax.swing.border.LineBorder(Color.BLACK));

		c.gridwidth = GridBagConstraints.RELATIVE;
		c.gridheight = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		add(previewPanel, c);
		c.gridheight = 1;
		c.weightx = 0;


		c.gridwidth = GridBagConstraints.REMAINDER;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		c.insets = new Insets(border, border, 0, border);
		add(new JLabel("Размер бумаги, мм"), c);
		c.insets.top = 0;

		addSizeButtons(new Dimension[] {
			new Dimension(75, 100),
			new Dimension(100, 150),
			new Dimension(150, 210),
			new Dimension(210, 300),
		}, c);

		c.insets.top = border;
		add(new JLabel("Тип бумаги"), c);
		c.insets.top = 0;

		addPaperButtons(c);

		c.insets.top = border;
		c.weighty = 1;
		add(margins, c);
		c.weighty = c.insets.top = 0;

		c.insets.bottom = border;

		add(pay, c);
		add(exit, c);
	}

	private void setPhotoSize(int w, int h) {
		pm.setPhotoSize(w, h);

		previewPanel.setPreferredSize(new Dimension(w*2, h*2));
		previewPanel.setMinimumSize(new Dimension(w*2, h*2));
		previewPanel.revalidate();
	}

	private void addPaperButtons(Object constraints) {
		ButtonGroup group = new ButtonGroup();

		int i = 0;
		paperTypes = new JRadioButton[PaperType.values().length];
		for (PaperType v: PaperType.values()) {
			JRadioButton b = new JRadioButton(v.toString());
			group.add(b);
			b.addActionListener(e -> pm.setPaperType(v));
			if (v.ordinal() == 0) b.doClick();
			add(b, constraints);

			paperTypes[i++] = b;
		}
	}

	private void addSizeButtons(Dimension[] values, Object constraints) {
		ButtonGroup group = new ButtonGroup();

		int i = 0;
		sizes = new JRadioButton[values.length];
		for (Dimension v: values) {
			JRadioButton b = new JRadioButton(v.width + " \u00d7 " + v.height);
			group.add(b);
			b.addActionListener(e -> setPhotoSize(v.width, v.height));
			if (values[0] == v) b.doClick();
			add(b, constraints);

			sizes[i++] = b;
		}
	}
}