package seven.compare;

import java.util.Comparator;

public class ItemName implements Comparator<Item>{
	@Override
	public int compare(Item a, Item b) {
		return a.getName().compareTo(b.getName());
	}
}
