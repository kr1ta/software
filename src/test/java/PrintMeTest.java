import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PrintMeTest {
	EditorPanel ep;
	PrintMe pm;
	Order order;
	
	@BeforeEach
	void setup() {
		ep = mock(EditorPanel.class);
		pm = new PrintMe();
		pm.editorPanel = ep;
		order = pm.order;
	}
	
	@Test
	void setPhotoSize() {
		int a = 123, b = 456;
		pm.setPhotoSize(a, b);

		assert order.width == a;
		assert order.height == b;
	}
	
	@Test
	void setPaperType() {
		pm.setPaperType(PaperType.GLOSSY);
		
		assert order.paperType == PaperType.GLOSSY;
	}
	
	@Test
	void setMargins() {
		pm.setMargins(java.awt.event.ItemEvent.SELECTED);
		
		assert order.margins;
	}

}
