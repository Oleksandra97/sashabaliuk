package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SearchRequestPage extends BasePage {
    public String getSearchTitle() {
       String searchTitle = $(By.xpath("//div[@class='title']/h1")).getText();
        return searchTitle;
    }
}
