package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Condition.enabled;

public class MainPage extends BasePage {
    public MenuItemRequest openWomenMenuItem() {
        $(By.xpath("//a[@class='links__a a js-menu-deal-type-women']")).click();
        return new MenuItemRequest();
    }

    public MainPage login(String login, String password) {
        $(By.className("header__btn-auth")).click();
        $(By.name("USER_LOGIN")).val(login);
        $(By.name("U_PASS")).val(password);
        $(By.xpath("//div[@class='control']/a")).shouldBe(enabled).click();
        return new MainPage();
    }

    public MainPage logout() {
        $(By.id("js-profile-switcher")).click();
        $(By.xpath("//a[@id='logout-link']/span[@class='a__p']")).click();
        return new MainPage();
    }

    public MainPage openCart() {
        $(By.xpath("//span[@class='cart__i a__i']")).click();
        return this;
    }

    public CategoryRequestPage selectCategory(int index) {
        $$(By.className("pr__a")).get(index).click();
        return  new CategoryRequestPage();
    }

    public SearchRequestPage search(String searchText) {
        $(By.name("search_input")).val(searchText);
        $(By.name("search_input")).pressEnter();
        return new SearchRequestPage();
    }

}
