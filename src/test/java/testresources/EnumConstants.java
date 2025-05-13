package testresources;

public enum EnumConstants {
	
	AddPlaceAPI("/maps/api/place/add/json"),
	GetPlaceAPI("/maps/api/place/get/json"),
	deletePlaceAPI("/maps/api/place/delete/json"),
	UpdatePlaceAPI("/maps/api/place/update/json");
	private String resources;
	
	EnumConstants(String resources) {
		this.resources=resources;
	}
	
	
	public String getresources() {
		return resources;
	}
	
	

}
