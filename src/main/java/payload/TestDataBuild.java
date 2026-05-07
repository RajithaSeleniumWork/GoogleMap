package payload;

import java.util.HashMap;
import java.util.Map;

public class TestDataBuild {
	
	 public static Map<String, Object> addPlacePayload() {

	        Map<String, Object> location = new HashMap<>();
	        location.put("lat", -38.383494);
	        location.put("lng", 33.427362);

	        Map<String, Object> payload = new HashMap<>();
	        payload.put("location", location);
	        payload.put("accuracy", 50);
	        payload.put("name", "Frontline house");
	        payload.put("phone_number", "1234567890");
	        payload.put("address", "India");
	        payload.put("types", new String[]{"shoe park", "shop"});
	        payload.put("website", "http://google.com");
	        payload.put("language", "English");

	        return payload;
	    }

	    public static Map<String, Object> updatePlacePayload(String placeId) {

	        Map<String, Object> payload = new HashMap<>();
	        payload.put("place_id", placeId);
	        payload.put("address", "Bangalore");

	        return payload;
	    }
	    
	    public static Map<String, Object> deletePlacePayload(String placeId) {

	        Map<String, Object> data = new HashMap<>();
	        data.put("place_id", placeId);

	        return data;
	    }

}
