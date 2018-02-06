package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Condition.empty;

public class MenuItemRequest extends BasePage {
    public String getRequestTitle(int index) {
        String requestTitleText = $$(By.className("breadcrumb__title")).get(index).getText();
        return requestTitleText;
    }

    public MenuItemRequest productListIsNotEmpty () {
        int size = $$(By.className("dl dl-m")).size();
        for(int i = 0; i< size; i++) {
            $$(By.className("dl dl-m")).get(i).shouldNotBe(empty);
        }
        return this;
    }

}
