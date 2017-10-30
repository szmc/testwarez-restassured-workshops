package healthcheck;

import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;

public class HealthCheck {
	String url = "https://trello.com";

	@Test
	public void heatlhCheckTest() {
		given().baseUri(url).when().get("/").prettyPrint();
	}
}
