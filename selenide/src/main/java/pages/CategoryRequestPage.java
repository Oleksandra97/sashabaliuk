package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CategoryRequestPage extends BasePage {
    public CategoryRequestPage addToCart(int index) {
        $$(By.className("prod__btn-buy")).get(index).click();
        return this;
    }

    public CategoryRequestPage openCart() {
        $(By.xpath("//span[@class='cart__i a__i']")).click();
        return this;
    }

    public CategoryRequestPage addSearchParameter(String searchText) {
        $(By.id("js-filter-price-to")).val(searchText);
        $(By.xpath("//div[@class='btns']/a")).click();
        return new CategoryRequestPage();
    }
}
