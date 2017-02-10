package Instruments;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class CompByNumber implements Comparator<Entry <String, Integer>> {

	@Override
	public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
		
		return o1.getValue()-o2.getValue();
	}

	

	

}
