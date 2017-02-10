package Instruments;

public class Instruments implements Comparable<Instruments>{
	
	private String name;
	private double price;
	private String type;
	
	public Instruments(String name, double price, String type) {
		// TODO checks for fields; type must be realized using switch and cases!
		this.name = name;
		this.price = price;
		this.type = type;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Instruments other = (Instruments) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Instruments [name=" + name + ", price=" + price + ", type=" + type + "]";
	}



	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}



	@Override
	public int compareTo(Instruments o) {
		
		return this.getName().compareTo(o.getName());
	}
	
	
	

}
