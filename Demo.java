package Instruments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Demo {
	
	public static void main(String[] args) {
		
		MusicStore naTymno = new MusicStore("Na Tymno", 8000.0);
		Instruments guitar = new Instruments("Guitar", 168, "Strings");
		Instruments piano = new Instruments("Piano", 1500.5, "Keyboards");
		Instruments flute = new Instruments("FLute", 100, "Brass");
		Instruments okolele = new Instruments("Okolele", 150, "Strings");
		
		naTymno.getInstrumets(guitar, 10);
		naTymno.getInstrumets(piano, 3);
		naTymno.getInstrumets(flute, 10);
		naTymno.getInstrumets(guitar, 2);
		naTymno.getInstrumets(okolele, 3);
		
		naTymno.sellInstruments(guitar, 4);
		naTymno.sellInstruments(guitar, 1);
		naTymno.sellInstruments(piano, 1);
		naTymno.sellInstruments(flute, 10);
		naTymno.sellInstruments(piano, 2);
		naTymno.sellInstruments(okolele, 1);
		naTymno.sellInstruments(okolele, 2);
		LinkedHashMap<String, Integer> op = new LinkedHashMap<>();
		op.put("Az", 12);
		op.put("Toi", 22);
		op.put("Tq", 32);
		
		
		
		//naTymno.catalogByType();
		//naTymno.catalogueByName();
		//naTymno.storageByPrice();
		//naTymno.storageList();
		
		naTymno.report();
	
		
		
	}

}
