
public class Provinces {
	private int prov_id;
	private String city;
	private String district;
	
	public Provinces(String city, String district){ //create
		
		this.city = city;
		this.district = district;
 		
	}
	
	
	public Provinces(int prov_id, String city, String district){ //insert
		this.prov_id = prov_id;
		this.city = city;
		this.district = district;
 		
	}


	public int getprov_id() {
		return prov_id;
	}


	public void setprov_id(int prov_id) {
		this.prov_id = prov_id;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getDistrict() {
		return district;
	}


	public void setDistrict(String district) {
		this.district = district;
	}
}
