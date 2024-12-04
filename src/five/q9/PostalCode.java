package five.q9;

public class PostalCode {
	private String code;
	private String prefecture;
	private String district;
	private String town;
	
	public PostalCode(String code, String prefecture, String district, String town) {
		this.code = code;
		this.prefecture = prefecture;
		this.district = district;
		this.town = town;
	}
	
	@Override
	public String toString() {
		return code + " " + prefecture + district + town;
	}
}
