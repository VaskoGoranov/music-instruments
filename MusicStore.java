package Instruments;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;

public class MusicStore {
	
	private String name;
	private HashMap<String, ArrayList<String>> catalog; 
	private HashMap<Instruments, Integer> storage; 
	private double money;
	private TreeSet<Instruments> price; 
	private double profit;
	private TreeMap<Instruments, Integer> sold;
	
	public MusicStore(String name, double money) {
		//TODO checks for name and money
		this.name = name;
		this.money = money;
		catalog = new HashMap<>();
		storage = new HashMap<>();
		price = new TreeSet<>(new ComparePrice());
		sold = new TreeMap<>();
		createCatalog();
		profit = 0;
	}
	
	private void createCatalog () {
		
		ArrayList<String> strings = new ArrayList<>( Arrays.asList("Violin", "Viola", "Contrabass", "Harp", "Guitar", "Okolele"));
		ArrayList<String> percussion = new ArrayList<>( Arrays.asList("Drums", "Tambourine", "Drum", "Xylophone"));
		ArrayList<String> brass = new ArrayList<>( Arrays.asList("Flute", "Trompet", "Tuba", "Trombone"));
		ArrayList<String> keyboards = new ArrayList<>( Arrays.asList("Piano", "Pipe Organ", "Accordion"));
		ArrayList<String> electric = new ArrayList<>( Arrays.asList("Keyboard", "Bass-Guitar", "Hawaiian Guitar"));
		
		this.catalog.put("Strings", strings);
		this.catalog.put("Percussion", percussion);
		this.catalog.put("Brass", brass); 
		this.catalog.put("Keyboards", keyboards);
		this.catalog.put("Electric", electric);
	}
	
	public void getInstrumets (Instruments instr, Integer qnt) {
		//TODO the check contains in the arraylist
		if (qnt > 0 && catalog.containsKey(instr.getType()) ) {
			if (qnt*instr.getPrice() < this.money ){
				price.add(instr);
				if (storage.containsKey(instr)) {
					Integer temp = storage.get(instr) + qnt;
					storage.put(instr, temp); 
				} else {
					storage.put(instr, qnt);
				}
				this.money -= qnt*instr.getPrice();
			} else {
				System.out.println("Insufficient funds!");
			}
		} else {
			System.out.println("No such product is offered in the store!");
		}
		
	}
	
	public void sellInstruments (Instruments instr, Integer qnt) {
		//TODO try using only name
		if (storage.containsKey(instr)){
			if (qnt>0 && qnt<=storage.get(instr)) {
				storage.put(instr, storage.get(instr)-qnt);
				this.money += qnt*instr.getPrice()*1.3;
				this.profit += qnt*instr.getPrice()*1.3;
				if (sold.containsKey(instr)) {
					Integer temp = sold.get(instr) + qnt;
					sold.put(instr, temp);
				} else {
					sold.put(instr, qnt);
				}
				
			} else {
				System.out.println("Not enough stock in storage!");
			}
		} else {
			System.out.println("No such type of stock!");
		}
	}
	
	

	public void catalogByType () {
		
		 for (Entry<String, ArrayList<String>> e : catalog.entrySet()) {
			System.out.println("============" + e.getKey() + "=============");
			for (String str : e.getValue()) {
				System.out.println(str);
			} 
		}
	}
	
	public void catalogueByName () {
		ArrayList<String> cat = new ArrayList<>(); 
		for(Entry<String, ArrayList<String>> e : catalog.entrySet()) {
			for (String str : e.getValue()) {
				cat.add(str);
			}
		}
		Collections.sort(cat);
		System.out.println(cat);
		
	}
	
	public void storageByPrice () {
		System.out.println(price);
	}
	
	public void storageList () {
		System.out.println(storage);
	}
	
	public void report () {
		System.out.println("==================== R E P O R T ====================");
		System.out.println("Overall profit: " + profit);
		System.out.println("========================================");
		System.out.println("Sold items: " + sold);
		System.out.println("========================================");
		TreeMap<Integer, Instruments> sorted = new TreeMap<>(new CompInteg());
		for (Entry<Instruments,Integer> e : sold.entrySet()) {
			sorted.put(e.getValue(), e.getKey());
		}
		System.out.println("Sorted by number of sales : " + sorted);
		System.out.println("========================================");
		System.out.println("Most sold instrument is: " + sorted.lastEntry());
		System.out.println("========================================");
		System.out.println("Most unwanted instrument is: " + sorted.firstEntry());
		System.out.println("========================================");
		System.out.println("Most sold type is : " + mostSoldType());
		System.out.println("========================================");
				
	}
	private Entry mostSoldType() {
		TreeMap<String, Integer> sortedSoldType = new TreeMap<>();
		for(Entry<Instruments, Integer> e : sold.entrySet()) {
			if (!sortedSoldType.containsKey(e.getKey().getType())) {
				sortedSoldType.put(e.getKey().getType(), e.getValue());
			} else {
				Integer t = sortedSoldType.get(e.getKey().getType()) + e.getValue();
				sortedSoldType.put(e.getKey().getType(), t);
			}
		}	
		TreeMap<Integer, String> sor = new TreeMap<>();
		for(Entry<String, Integer> e : sortedSoldType.entrySet()) {
			sor.put(e.getValue(), e.getKey());
		}
		sortedSoldType.clear();
		for(Entry<Integer, String> e : sor.entrySet()) {
			sortedSoldType.put(e.getValue(), e.getKey());
		}
		
		ArrayList<Entry> opit = new ArrayList<>(sor.entrySet());
				
		return opit.get(opit.size()-1);
	}

	@Override
	public String toString() {
		return "MusicStore [name=" + name + " , storage=" + storage + ", money=" + money + "]";
	}

	public String getName() {
		return name;
	}

	public double getProfit() {
		return profit;
	}

}
