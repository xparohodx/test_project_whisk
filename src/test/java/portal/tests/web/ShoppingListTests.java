package portal.tests.web;

import org.testng.annotations.Test;
import portal.utils.suppliers.PageObjectSupplier;
import portal.utils.User;

import java.time.LocalTime;

public class ShoppingListTests extends BaseTest implements PageObjectSupplier {
    @Test(description = "Create shopping list and add  items")
    public void testCreateShoppingList() {
        User testUser = new User();
        String testListName = LocalTime.now().toString();
        String product1 = "apple";
        String product2 = "banana";
        String product3 = "milk";
        String product4 = "garlic";
        String product5 = "cheese";

        //step 1 - go to main page
        mainPage()
                .openPage()
                .clickButtonSignup();

        //step 2 - sign in
        authorizationDialog()
                .isVisible()
                .fillInputUsername(testUser.getEmail())
                .clickButtonContinue();
        authorizationDialog()
                .fillInputPassword(testUser.getPassword())
                .clickButtonLogin();

        //step 3 - go to Shopping list
        mainPage().waitPageForLoad();
        successfulLoginAlert()
                .isVisible()
                .clickOnSuccessfulLoginAlert();
        headerSection()
                .clickLinkShopping();

        //step 4 - create new Shopping list
        shoppingListPage().waitPageForLoad();
        shoppingListPage()
                .clickButtonCreateNewList();
        createListDialog()
                .isVisible()
                .fillInputListName(" " + testListName)
                .clickButtonCreate();
        shoppingListPage()
                .selectCreatedList(testListName)

                //step 5 - add items to the list
                .findAndAddItem(product1)
                .findAndAddItem(product2)
                .findAndAddItem(product3)
                .findAndAddItem(product4)
                .findAndAddItem(product5)

                //step 6 - check items in shopping list
                .assertItemInList(product1)
                .assertItemInList(product2)
                .assertItemInList(product3)
                .assertItemInList(product4)
                .assertItemInList(product5);
    }

    @Test(description = "Create shopping list and delete it")
    public void testCreateAndDeleteShoppingList() {
        String testListName = LocalTime.now().toString();
        User testUser = new User();

        //step 1 - go to main page
        mainPage()
                .openPage()
                .clickButtonSignup();

        //step 2 - sign in
        authorizationDialog()
                .isVisible()
                .fillInputUsername(testUser.getEmail())
                .clickButtonContinue();
        authorizationDialog()
                .fillInputPassword(testUser.getPassword())
                .clickButtonLogin();

        //step 3 - go to Shopping list
        mainPage().waitPageForLoad();
        successfulLoginAlert()
                .isVisible()
                .clickOnSuccessfulLoginAlert();
        headerSection()
                .clickLinkShopping();

        //step 4 - create new Shopping list
        shoppingListPage().waitPageForLoad();
        shoppingListPage()
                .clickButtonCreateNewList();
        createListDialog()
                .isVisible()
                .fillInputListName(" " + testListName)
                .clickButtonCreate();
        shoppingListPage()
                .selectCreatedList(testListName)

                //step 5 - delete created list
                .clickActionsButtonForList(testListName)
                .clickButtonDeleteList();
        deleteListDialog()
                .isVisible()
                .clickButtonConfirmDeleteList();

        //step 6 - check that shopping list was deleted
        shoppingListPage()
                .clickAlertListDeleted()
                .assertThatListWasDeleted(testListName);
    }
}
