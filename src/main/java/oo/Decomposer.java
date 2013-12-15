package oo;

public class Decomposer {

	private final String text;
	
	public Decomposer(String text) {
		this.text = text;
	}
	
	public String[] decompose() {
		return text.split("((?<=\\s+)|(?=\\s+))");
	}

}
