package Instruments;

import java.util.Comparator;

public class ComparePrice implements Comparator<Instruments>{

	@Override
	public int compare(Instruments o1, Instruments o2) {
		if (o1.getPrice()-o2.getPrice() > 0) {
			return 1;
		} else {
			if (o1.getPrice()-o2.getPrice() < 0) {
				return -1;
			}
		}
		
		return 0;
	}
	
	

}
