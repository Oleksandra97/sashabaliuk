import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.MenuItemRequest;

import java.io.IOException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchTests extends BaseTest{

    public SearchTests() throws IOException {
    }

    @Test
    public void searchWithCorrectData() {
        String expectedRequest = "Товары по запросу «dress»";

        mainPage.search(propertyHandler.getStringProperty("correctSearchText"));

        $(By.xpath("//div[@class='title']/h1")).shouldHave(text(expectedRequest));
    }

   @Test
    public void searchWithIncorrectData() {
        mainPage.search(propertyHandler.getStringProperty("incorrectSearchText"));

       $(By.xpath("//div[@class='inner']/div[@class='info']")).shouldBe(exist);
    }

    @Test
    public void searchByProductCategory() {
        String expectedRequest ="Платья";

        mainPage.selectCategory(5);

        $$(By.className("//li[@class='item']")).get(2).shouldHave(text(expectedRequest));
    }

    @Test
    public void searchByProductCategoryWithAdditionalParameters() {
        String expectedRequest = "до 1500 грн";
        mainPage.selectCategory(5)
                .addSearchParameter(propertyHandler.getStringProperty("additionalParameterText"));

        $$(By.className("//li[@class='item']")).get(0).shouldHave(text(expectedRequest));
    }

    @Test
    public void searchWomenProducts() {
        String expectedRequest = "Женское";
        MenuItemRequest menuItemRequest = mainPage.openWomenMenuItem();

        $$(By.className("breadcrumb__title")).get(1).shouldHave(text(expectedRequest));

        menuItemRequest.productListIsNotEmpty();
    }
}
