
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginTests extends  BaseTest{

    public LoginTests() throws IOException {
    }

    @Test
    public void loginWithCorrectData() {
        mainPage.login(propertyHandler.getStringProperty("login"),
                            propertyHandler.getStringProperty("correctPassword"));

        $(By.id("js-profile-switcher")).shouldBe(visible);
        mainPage.logout();
    }

    @Test
    public void loginWithIncorrectData() {
        mainPage.login(propertyHandler.getStringProperty("login"),
                            propertyHandler.getStringProperty("incorrectPassword"));

        $(By.className("js-message-text")).shouldBe(visible);
    }

   @Test
    public void logOut() {
       mainPage.login(propertyHandler.getStringProperty("login"),
                        propertyHandler.getStringProperty("correctPassword"))
                .logout();
       $(By.className("header__btn-auth")).shouldBe(enabled);
    }
}
