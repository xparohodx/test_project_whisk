package portal.tests.api;

import io.restassured.http.ContentType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import portal.utils.suppliers.ApiRequestsSupplier;

public class ShoppingListApiTests implements ApiRequestsSupplier {

    String list_id;

    @BeforeMethod(alwaysRun = true)
    public void preconditionSteps() {
        //step 1 - create shopping list by POST method
        list_id = listApi()
                .post("test name", false)
                .checkStatusCode(200)
                .checkContentType(ContentType.JSON)
                .getParameterFromRequestBody("list.id");
    }

    @Test(description = "Create new Shopping list and get it")
    public void testCreateAndGetList() {

        //step 2 - get shopping list by ID and verify the response
        listApi().get(list_id)
                .checkStatusCode(200)
                .checkContentType(ContentType.JSON)

                //step 3 - verify that response contains correct ID
                .checkValueInResponseBody("list.id", list_id)

                //step 4 - verify that Shopping list is empty
                .checkEmptyValueInResponseBody("content");
    }

    @Test(description = "Create new Shopping list and delete it")
    public void testCreateAndDeleteList() {

        //step 2 - delete shopping list by ID
        listApi()
                .delete(list_id)
                .checkStatusCode(200)
                .checkContentType(ContentType.JSON);

        //steps 3-4 - get deleted list and verify the response
        listApi()
                .get(list_id)
                .checkStatusCode(400)
                .checkContentType(ContentType.JSON)

                //step 5 - verify the message in response body
                .checkValueInResponseBody("code", "shoppingList.notFound");
    }
}
