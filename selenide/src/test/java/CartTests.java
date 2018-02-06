
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CartTests extends BaseTest {

    public CartTests() throws IOException {
    }

    @Test
    public void checkThatCartIsEmpty() {
        mainPage.openCart();

        $(By.className("cart-empty")).shouldBe(visible);
    }

   @Test
    public void AddProductToCart() {
        mainPage.selectCategory(5)
                .addToCart(0)
                .openCart();

       $(By.className("brand")).shouldBe(visible);
    }
}
