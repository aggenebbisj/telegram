import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import oo.TelegramOO;

import org.junit.Test;

import procedural.TelegramProcedural;
import telegram.Telegram;


public class TelegramTest {

	private Telegram sut;

	@Test public void 
	should_wrap_string_with_maximum_characters_procedural() {
		sut = new TelegramProcedural();
		should_wrap_string_with_maximum_characters();
	}

	@Test public void 
	should_wrap_string_with_multiple_spaces_procedural() {
		sut = new TelegramProcedural();
		should_wrap_string_with_multiple_spaces();
	}
	
	@Test public void 
	should_wrap_string_with_maximum_characters_oo() {
		sut = new TelegramOO();
		should_wrap_string_with_maximum_characters();
	}
	
	@Test public void 
	should_wrap_string_with_multiple_spaces_oo() {
		sut = new TelegramOO();
		should_wrap_string_with_multiple_spaces();
	}
	
	private void 
	should_wrap_string_with_maximum_characters() {
		final String text = "The quick brown fox jumped over the lazy dog.";
		
		List<String> result = sut.wrap(text, 20);
		
		List<String> expected = new ArrayList<>();
		expected.add("The quick brown fox ");
		expected.add("jumped over the lazy");
		expected.add(" dog.");
				
		assertThat(result, is(expected));
	}

	private void 
	should_wrap_string_with_multiple_spaces() {
		final String text = "The quick    brown fox   jumped over           the lazy dog.";
		sut = new TelegramProcedural();
		List<String> result = sut.wrap(text, 20);
		
		List<String> expected = new ArrayList<>();
		expected.add("The quick    brown ");
		expected.add("fox   jumped over   ");
		expected.add("        the lazy ");
		expected.add("dog.");
		
		assertThat(result, is(expected));
	}
	
}
