package houseProject;

import org.json.simple.JSONObject;


public class ListHouse implements Listable {

private JSONObject houseDetails;

	
	
	public ListHouse(JSONObject house){
		this.houseDetails = house;
	}

	
	@Override
	public int compareTo(Listable compareHouse) {
		// TODO Auto-generated method stub
		ListHouse other = (ListHouse) compareHouse;
		
		Integer thisInt = Integer.parseInt(this.houseDetails.get("lotNumber").toString());
		Integer thatInt = Integer.parseInt(other.houseDetails.get("lotNumber").toString());
		
		return (thisInt - thatInt);
		
	}

	@Override
	public Listable copy() {
		// TODO Auto-generated method stub
		ListHouse result = new ListHouse(houseDetails);
		return result;
	}
	
	public JSONObject getHouse(){
		return houseDetails;
	}

}
