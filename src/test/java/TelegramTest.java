import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import procedural.Telegram;


public class TelegramTest {

	@Test public void 
	should_wrap_string_with_maximum_characters() {
		final String text = "The quick brown fox jumped over the lazy dog.";
		
		Telegram sut = new Telegram();
		List<String> result = sut.wrap(text, 20);
		
		List<String> expected = new ArrayList<>();
		expected.add("The quick brown fox ");
		expected.add("jumped over the lazy");
		expected.add(" dog.");
				
		assertThat(result, is(expected));
	}

	@Test public void 
	should_wrap_string_with_multiple_spaces() {
		final String text = "The quick    brown fox   jumped over           the lazy dog.";
		Telegram sut = new Telegram();
		List<String> result = sut.wrap(text, 20);
		
		List<String> expected = new ArrayList<>();
		expected.add("The quick    brown ");
		expected.add("fox   jumped over   ");
		expected.add("        the lazy ");
		expected.add("dog.");
		
		assertThat(result, is(expected));
	}
	
}
