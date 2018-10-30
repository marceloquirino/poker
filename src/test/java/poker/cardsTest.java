package poker;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertEquals;
import org.javatuples.Pair;
import org.junit.Test;


public class cardsTest {
	@Test
	public void testFlushAndRoyalFlush(){
		List<Pair<String, String>> first = new ArrayList<Pair<String, String>>();
		List<Pair<String, String>> second = new ArrayList<Pair<String, String>>();
		first.add(new Pair("3","D"));
		first.add(new Pair("6","D"));
		first.add(new Pair("7","D"));
		first.add(new Pair("T","D"));
		first.add(new Pair("Q","D"));
		second.add(new Pair("J","D"));
		second.add(new Pair("Q","D"));
		second.add(new Pair("K","D"));
		second.add(new Pair("A","D"));
		second.add(new Pair("10","D"));
		assertEquals(cards.verify(first, second), 2);
	}
	
	@Test
	public void testFlushAndStraightFlush(){
		List<Pair<String, String>> first = new ArrayList<Pair<String, String>>();
		List<Pair<String, String>> second = new ArrayList<Pair<String, String>>();
		first.add(new Pair("3","D"));
		first.add(new Pair("2","D"));
		first.add(new Pair("3","D"));
		first.add(new Pair("1","D"));
		first.add(new Pair("2","D"));
		second.add(new Pair("J","D"));
		second.add(new Pair("Q","D"));
		second.add(new Pair("K","D"));
		second.add(new Pair("A","D"));
		second.add(new Pair("10","D"));
		assertEquals(cards.verify(first, second), 2);
	}
}
