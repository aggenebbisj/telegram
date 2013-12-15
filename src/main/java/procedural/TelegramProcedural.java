package procedural;

import java.util.ArrayList;
import java.util.List;

import telegram.Telegram;

public class TelegramProcedural implements Telegram {

	public List<String> wrap(String text, int maxLength) {
		List<String> result = new ArrayList<>();
		String buffer = "";		
		int charsWritten = 0;		
		for (char c : text.toCharArray()) {
			if (buffer.length() == maxLength) {				
				if (c == ' ') {
					result.add(buffer);
					buffer = "";
				} else {
					result.add(buffer.substring(0, buffer.length() - charsWritten));
					buffer = buffer.substring(buffer.length() - charsWritten);
				}
			}
			charsWritten = c == ' ' ? 0 : ++charsWritten; 
			buffer += c;
		}
		if (buffer.length() > 0) {
			result.add(buffer);
			buffer = "";
		}
		return result;
	}
	
}
