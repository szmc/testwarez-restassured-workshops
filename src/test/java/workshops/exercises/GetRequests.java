package workshops.exercises;

import com.jayway.restassured.response.Response;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

public class GetRequests {
	Authentication authentication = new Authentication();

	/** Exercise 1 Boards
	 * 1) Create get request for /members/me/boards endpoint
	 * 2) Create method that will return id of chosen board taking board name as a parameter
	 */


	public void displayBoards() {
		 		 given()
						.when()
						.get("");

	}

	@Test
	public void displayBoardDetailsTest() {
		//ToDo: call displayBoards with prettyPrint() method here
		displayBoards();
	}


	public String getBoardId(String boardName) {
		Response respone = null;
		return getItemIdByName(respone, boardName);
	}

	@Test
	public void displayBoardIdTest() {
		System.out.println(getBoardId("nameOfYourBoard"));
	}


	/**
	 * Exercise 4 Cards
	 * 1) Display Card
	 * 2) Display id of Card using card name
	 */

	public Response getCards(String boardName) {
		//ToDo: add endpoint /boards/{$boardId}/cards. Hint: boardId can be taken from getBoardId method.
		return given()
				.spec(authentication.requestSpecification())
				.when().get("");
	}

	public String getCardId(String cardName, String boardName) {
		//ToDo:  Use proper method to initiate response variable. Replace variable1 and variable2 with proper node names.
		return "";
	}

	@Test
	public void displayCards() {
		//ToDo: test getCards and getCardId methods
	}

	/**Exercise 5 Lists
	 * Display list
	 * Display list id by list name
	 */

	//ToDo: Create getList(), getListId() methods with proper parameters. Use endpoint: "/boards/"+getBoardId(boardName)+"/lists"
	//Hint: You might need 2 parameters in getListId method


	public static String getItemIdByName(Response response, String itemName) {
		int i = 0;
		while (!response.jsonPath().getString("name[" + String.valueOf(i) + "]").equals(itemName)) {
			i++;
		}
		return response.jsonPath().getString("id[" + String.valueOf(i) + "]");
	}
}
