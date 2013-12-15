package telegram;

import java.util.List;

public interface Telegram {

	List<String> wrap(String text, int maxLength);
	
}
