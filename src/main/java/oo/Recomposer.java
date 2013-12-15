package oo;

import java.util.ArrayList;
import java.util.List;

public class Recomposer {

	private final int maxLength;
	private List<String> lines = new ArrayList<>();
	private StringBuilder buffer = new StringBuilder();
	
	public Recomposer(int maxLength) {
		this.maxLength = maxLength;		
	}

	public void add(String fragment) {
		if (isTooBig(fragment)) {
			lines.add(buffer.toString());
			buffer = new StringBuilder();
		}
		buffer.append(fragment);
	}

	private boolean isTooBig(String fragment) {
		return buffer.length() + fragment.length() > maxLength;
	}

	public List<String> flush() {
		if (buffer.length() > 0) {
			lines.add(buffer.toString());
		}
		return lines;
	}
	
}
