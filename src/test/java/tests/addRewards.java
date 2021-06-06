package tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.internal.support.FileReader;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pages.ApiPage;
import utils.AutomationUtils;

public class addRewards  {
	
	
	static Response response;
	static RequestSpecification requestSpec;
	private static String authorisation;
	private static String azureApiUrl;
	private static String pbadminApiUrl;
	public String rewardLink;
	
	Properties props;
	
	public static String getPbadminApiUrl() {
		return pbadminApiUrl;
	}

	public static void setPbadminApiUrl(String pbadminApiUrl) {
		addRewards.pbadminApiUrl = pbadminApiUrl;
	}
    
	
    
	public addRewards() throws IOException {
		props = AutomationUtils.setEnvProperties();
        this.azureApiUrl=props.getProperty("azureApiUrl");
		this.setPbadminApiUrl(props.getProperty("pbadminApiUrl"));
		this.rewardLink=props.getProperty("rewardLink");
	}	
	
	@Test
	public void validateAddRewards() throws IOException {
//		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/auuat.properties");
//        Properties props = new Properties();
//        props.load(file);
		 response = RestAssured.given()
	                .contentType(ContentType.JSON)
	                .header("x-ms-client-principal-name", "lucky")
	                .body("{\"points\":\"1000\",\"description\":\"test\"}")
	                .log().all()
	                .post(props.getProperty("rewardLink") + "/api/pbadmin/" + "385970" + "/rewards" + props.getProperty("rewardCode"));
	        response.then().log().all();
		
	}

	
	
//	@Test
//	public static void getPersonalDetails() {
//         response = RestAssured.given()
//                .spec(requestSpec)
//                .header("Authorization", authorisation)
//                .get(azureApiUrl + pbadminApiUrl);
//        response.then().log().all();
//        response.then().statusCode(200);
//        System.out.println("response status code is:"+response.getStatusCode());
//		System.out.println("response status code is:"+response.getBody().toString());
//    }
	
	
	
//	@Test
//	public static void getData() {
//		Response response = RestAssured.get("https://gmail.com");
//		System.out.println("response status code is:"+response.getStatusCode());
//		System.out.println("response status code is:"+response.getBody().toString());		
//	}

}
