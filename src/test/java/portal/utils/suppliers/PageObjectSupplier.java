package portal.utils.suppliers;

import portal.pages.*;
import portal.pages.elements.alerts.SuccessfulLoginAlert;
import portal.pages.elements.dialogs.AuthorizationDialog;
import portal.pages.elements.dialogs.CreateListDialog;
import portal.pages.elements.dialogs.DeleteListDialog;
import portal.pages.elements.sections.HeaderSection;

public interface PageObjectSupplier {

    default MainPage mainPage() {
        return new MainPage();
    }

    default ShoppingListPage shoppingListPage() {
        return new ShoppingListPage();
    }

    default AuthorizationDialog authorizationDialog() {
        return new AuthorizationDialog();
    }

    default CreateListDialog createListDialog() {
        return new CreateListDialog();
    }

    default DeleteListDialog deleteListDialog() {
        return new DeleteListDialog();
    }

    default HeaderSection headerSection() {
        return new HeaderSection();
    }

    default SuccessfulLoginAlert successfulLoginAlert() {
        return new SuccessfulLoginAlert();
    }

}
