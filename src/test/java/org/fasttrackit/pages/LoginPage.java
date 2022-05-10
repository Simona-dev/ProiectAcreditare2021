package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://qa5.fasttrackit.org:8008/?page_id=7")
public class LoginPage extends PageObject {

    @FindBy(id="user_login")
    private WebElementFacade userNameField;

    @FindBy(id="user_pass")
    private WebElementFacade userPasswordField;

    @FindBy(id="rememberme")
    private WebElementFacade rememberMeBox;

    @FindBy(id="wp-submit")
    private WebElementFacade loginButton;

    @FindBy(css = "li strong")
    private WebElementFacade errorMessage;

    public void setUserNameField(String name){
        typeInto(userNameField,name);
    }
    public void setUserPasswordField(String password){
        typeInto(userPasswordField, password);
    }
    public void clickRememberMeBox(){
        clickOn(rememberMeBox);
    }
    public void clickLoginButtonMeta(){
        clickOn(loginButton);
    }
    public void verifyErrorMessage(String error) {
        waitFor(errorMessage);
        errorMessage.containsText(error);
    }

}

