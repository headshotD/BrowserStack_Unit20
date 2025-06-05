package tests.emulationAndroid;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

public class WikiTest extends TestBase {
    @BeforeAll
    static void setup() {
        System.setProperty("platform", "emulation");
    }
    @Test
    void successfulOpenExploreScreenTest() {
        step("Кликаем на иконку Explore", () -> {
            $(id("org.wikipedia.alpha:id/navigation_bar_item_icon_view")).click();
        });

        step("Проверяем, что открылась Explore и содержит поисковую строку", () ->
                $(id("org.wikipedia.alpha:id/search_container"))
                        .shouldHave(text("Search Wikipedia")));

    }
    @Test
    void successfulOpenSavedScreenTest() {
        step("Кликаем на иконку Saved", () -> {
            $(id("org.wikipedia.alpha:id/navigation_bar_item_icon_view")).click();
        });

        step("Проверяем, что открылась Explore", () ->
                $(id("org.wikipedia.alpha:id/main_toolbar"))
                        .shouldHave(text("Saved")));

    }
    @Test
    void successfulOpenSearchScreenTest() {
        step("Кликаем на иконку Search", () -> {
            $(id("org.wikipedia.alpha:id/navigation_bar_item_active_indicator_view")).click();
        });

        step("Проверяем, что открылась Search", () ->
                $(id("org.wikipedia.alpha:id/history_title"))
                        .shouldHave(text("History")));

    }
    @Test
    void successfulOpenEditsScreenTest() {
        step("Кликаем на иконку Edits", () -> {
            $(id("org.wikipedia.alpha:id/navigation_bar_item_icon_view")).click();
        });

        step("Проверяем, что открылась Edits", () ->
                $(id("org.wikipedia.alpha:id/main_toolbar"))
                        .shouldHave(text("Edits")));

    }

}
