package tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

public class SearchJUnitTestsAndroid extends TestBase {

    @BeforeAll
    static void setup() {
        if (System.getProperty("platform") == null) {
            System.setProperty("platform", "android");
        }
    }
    @Test
    void successfulSearchTestJUnit() {
        step("Вводим слово JUnit5 для поиска в вики", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("JUnit5");
        });

        step("Проверяем, что результат больше чем 0", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));

    }
}

