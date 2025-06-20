package tests.iosBrowserStack;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.qameta.allure.Allure.step;

@Tag("ios_browserstack")
public class SearchJUnitTestsIOS extends TestBase {

    @BeforeAll
    static void setup() {
        System.setProperty("platform", "ios");
        System.setProperty("app", "bs://sample.app");
    }

    @Test
    void successfulSearchTestJUnit() {
        step("Вводим слово JUnit5 для поиска", () -> {
            $(accessibilityId("Text Button")).click();
            $(accessibilityId("Text Input")).sendKeys("JUnit5" + "\n");
        });

        step("Проверяем найденный результат, что он больше чем 0", () ->
                $$(accessibilityId("Text Output"))
                        .shouldHave(sizeGreaterThan(0)));

    }
}

