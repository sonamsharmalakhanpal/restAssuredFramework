package pages;


import java.util.Properties;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class ApiPage {
	
	public static Properties props= null;
	static String externalId;
	
    
	
	
	public static void addRewards(String points) {
		Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("x-ms-client-principal-name", "lucky")
                .body("{\"points\":\"1000\",\"description\":\"test\"}")
                .log().all()
                .post(props.getProperty("rewardLink") + "/api/pbadmin/" + externalId + "/rewards" + props.getProperty("rewardCode"));
        response.then().log().all();
    }
	

}
