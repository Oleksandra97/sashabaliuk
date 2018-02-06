import core.PropertyHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    PropertyHandler propertyHandler = new PropertyHandler();
    MainPage mainPage = new MainPage();

    @BeforeClass
    public void init(){
        mainPage = open("https://leboutique.com/", MainPage.class);
    }

    @AfterMethod
    public void afterMethod() {
        mainPage = open("https://leboutique.com/", MainPage.class);
    }
}
