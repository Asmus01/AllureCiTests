import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static io.qameta.allure.Allure.attachment;
import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.CRITICAL;
import static javax.swing.UIManager.put;


class BestContributorToSelenide extends TestBase {



    @Description("Test of GitHub page")
    @Severity(CRITICAL)
    @Owner("Aslan")
    @Link(name = "GitHub", url = "https://github.com/selenide/selenide")
    @DisplayName("Проверка pop-up сообщения ")
    @Story("Проверка")


    @Test
    @Tag("remote")
     void solntsevShouldBeTheTopContributor() {

        open("https://github.com/selenide/selenide");
        $(".BorderGrid").$(byText("Contributors")).ancestor(".BorderGrid-row")
                .$$("ul li").first().hover();

        $$(".Popover .Popover-message").findBy(visible).shouldHave(text("Andrei Solntsev"));
        $x("//div").shouldBe(visible);
    }

    @Test
    @Tag("remote")
    public void openGitHubSite() {

        step("Открываем страницу Github", () -> {
            open("https://github.com/selenide/selenide");
        });

        step("Выбираем ховер", () -> {
            $(".BorderGrid").$(byText("Contributors")).ancestor(".BorderGrid-row")
                    .$$("ul li").first().hover();
        });

        step("Проверяем содержимое  pop-up элемента", () -> {
            $$(".Popover .Popover-message").findBy(visible).shouldHave(text("Andrei Solntsev"));
            $x("//div").shouldBe(visible);
        });

        step("Проверяем содержимое  pop-up элемента", () -> {
            $$(".Popover .Popover-message").findBy(visible).shouldHave(text("Andrei Solntsev"));
            $x("//div").shouldBe(visible);
            attachment("Source", webdriver().driver().source());
            Allure.addAttachment("Screenshot", "image/png", "png");
            sleep(5000);

        });
    }

    @Test
    @Tag("remote")
    public void testGitHubPopUp() {

        StepsOfGitHub steps = new StepsOfGitHub();

        steps.openSiteGitHub();
        steps.selectHover();
        steps.inspectPopUpElement();
        steps.takeScreenShot();
    }


}