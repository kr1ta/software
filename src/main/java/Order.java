public class Order {
	public int width, height;
	public PaperType paperType;
	public boolean margins;

	public String toString() {
		return "Ширина: " + width +
			 "\nДлина: " + height +
			 "\nТип бумаги: " + paperType +
			 "\nПоля: " + (margins? "Да" : "Нет");
	}
}