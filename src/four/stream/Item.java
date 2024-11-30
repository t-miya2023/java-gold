package four.stream;

public class Item {
	private String name;
	private Integer id;
	private String productionArea;
	
	public Item(Integer id, String name, String area) {
		this.id = id;
		this.name = name;
		productionArea = area;
	}
	
	public String getName() {
		return name;
	}
	
	public String getArea() {
		return productionArea;
	}
	
	public int getId() {
		return id;
	}
	
	//system.out.printで呼び出されるもの
	@Override
	public String toString() {
		return this.name;
	}
}
