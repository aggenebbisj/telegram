package oo;

import java.util.List;

import telegram.Telegram;

public class TelegramOO implements Telegram {
	
	@Override
	public List<String> wrap(String text, int maxLength) {
		Decomposer decomposer = new Decomposer(text);
		Recomposer recomposer = new Recomposer(maxLength);
		for (String fragment : decomposer.decompose()) {
			recomposer.add(fragment);
		}
		return recomposer.flush();
	}
	
}
