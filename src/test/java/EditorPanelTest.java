import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.*;

class EditorPanelTest {
	EditorPanel ep;
	PrintMe pm;
	
	@BeforeEach
	void setup() {
		pm = mock(PrintMe.class);
		ep = new EditorPanel(pm);
		verify(pm).setPhotoSize(75, 100);
		verify(pm).setPaperType(PaperType.MATTE);
	}
	
	@Test
	void small1() {
		ep.sizes[1].doClick();
		
		verify(pm).setPhotoSize(100, 150);
	}

	@Test
	void largest() {
		ep.sizes[3].doClick();
		
		verify(pm).setPhotoSize(210, 300);
	}
	
	@Test
	void glossy() {
		ep.paperTypes[1].doClick();
		
		verify(pm).setPaperType(PaperType.GLOSSY);
	}
	
	@Test
	void exit() {
		ep.exit.doClick();
		
		verify(pm).first();
	}
	
	@Test
	void pay() {
		ep.pay.doClick();
		
		verify(pm).pay();
	}
	
	@Test
	void margins() {
		ep.margins.doClick();
		
		verify(pm).setMargins(java.awt.event.ItemEvent.SELECTED);
	}
}
