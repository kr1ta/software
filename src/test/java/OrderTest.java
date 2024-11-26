import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class OrderTest {
	Order order;
	
	@BeforeEach
	void setup() {
		order = new Order();
	}
	
	@Test
	void test() {
		order.width = 451;
		order.height = 333;
		
		order.paperType = PaperType.GLOSSY;
		
		order.margins = true;
		
		assert order.toString().equals(
			"Ширина: 451\n" +
			"Длина: 333\n" +
			"Тип бумаги: Глянцевая\n" +
			"Поля: Да"
		);
	}

}
