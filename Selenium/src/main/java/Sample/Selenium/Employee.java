package Sample.Selenium;

	import static org.testng.Assert.assertEquals;
	import org.testng.annotations.Test;
	import io.restassured.RestAssured;
	import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
	 
	public class Employee {
//		Response response = null;

@Test
public void createEmployee() {
	 		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
	 
			String requestBody = "{\n" +
			"  \"name\": \"tammys\",\n" +
			"  \"salary\": \"5001\",\n" +
			"  \"age\": \"200\"\n" +
			"}";
			
			
			Response response = null;
	 
			try {
			response = RestAssured.given()
			.contentType(ContentType.JSON)
			.body(requestBody)
			.post("/create");
			} catch (Exception e) {
			e.printStackTrace();
			}
	 
			System.out.println("Response :" + response.asString());
			System.out.println("Status Code :" + response.getStatusCode());
			System.out.println("Does Reponse contains 'tammy'? :" + response.asString().contains("tammy"));
			assertEquals(200, response.getStatusCode());
	
			JsonPath jsonPathEvaluator =response.jsonPath();
			String EmpID=jsonPathEvaluator.get("id");
			System.out.println(EmpID);
	
			String Emp=jsonPathEvaluator.get("id");
			System.out.println(EmpID);
	
	
}
	}
		 


