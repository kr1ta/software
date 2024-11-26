public enum PaperType {
	MATTE,
	GLOSSY;

	public String toString() {
		switch (this) {
		case GLOSSY:
			return "Глянцевая";
		case MATTE:
			return "Матовая";
		default:
			return "Неизвестная ("+this.ordinal()+")";
		}
	}
}