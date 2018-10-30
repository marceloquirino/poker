package poker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.javatuples.Pair;

public class cards {

	public static int verify(List<Pair<String, String>> first, List<Pair<String, String>> second){
		int firstCards = 0, secondCards = 0;

		if(isFlush(first)){
			if(isRoyal(first)) firstCards += 100000000;
			else firstCards += 10000;
		}
		if(isFlush(second)){
			if(isRoyal(second)) secondCards += 100000000;
			else secondCards += 10000;
		}
		firstCards += getScoreFromRecurrency(first);
		secondCards += getScoreFromRecurrency(second);
		
		return firstCards>secondCards ? 1 : 2;
	}
	
	private static boolean isFlush(List<Pair<String, String>> cards){
		String nipe = null;
		for (Pair<String, String> pair : cards) {
			if(nipe == null){
				nipe = pair.getValue1();
			}else{
				if(!nipe.equals(pair.getValue1())){
					return false;
				}
			}
		}
		return true;
	}
	
	private static boolean isRoyal(List<Pair<String, String>> cards){
		List<String> royalCards = new ArrayList<String>();
		royalCards.add("10");
		royalCards.add("J");
		royalCards.add("Q");
		royalCards.add("K");
		royalCards.add("A");
		for (String royalCard : royalCards) {
			boolean foundRoyalCard = false;
			for (Pair<String, String> pair : cards) {
				if(pair.getValue0().equals(royalCard)){
					foundRoyalCard = true;
				}
			}
			if(!foundRoyalCard){
				return false;
			}
		}
		return true;
	}
	
	private static int getScoreFromRecurrency(List<Pair<String, String>> cards){
		
		int score;
	
	Map<String,Integer> map = new HashMap<String,Integer>();
	
		for (Pair<String, String> pair : cards) {
			
			if (!map.isEmpty() && map.get(pair.getValue0())!=null){
				map.put(pair.getValue0(),map.get(pair.getValue0())+1);
			}else
				map.put(pair.getValue0(), 1);
			
		}
		
		boolean hasOneDuple = false;
		boolean hasTwoDuple = false;
		boolean hasTriple = false;
		
		for (Entry<String, Integer> entry : map.entrySet()) {

			if (entry.getValue()==2){
				if (!hasOneDuple)
					hasOneDuple = true;
				else hasTwoDuple = true;
			}
			if (entry.getValue()==3){
				hasTriple = true;
			}
			
		}
		
		if (hasTriple){
			if (hasOneDuple)
				return 100000;
			return 100;			
		}
		
		if (hasTwoDuple) return 20;
		if (hasOneDuple) return 10;
		return 0;
		
		
	}
	
	
}
