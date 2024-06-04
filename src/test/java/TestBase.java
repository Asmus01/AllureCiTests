import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;

public class TestBase {
    @BeforeAll
    static void setUp() {

//        Configuration.browser = "firefox";
//        "http://127.0.0.1:4444/wd/hub"  // локальный Selenoid
        Configuration.browserSize = "1100x1080";
        Configuration.remote = "http://127.0.0.1:4444/wd/hub";
        Configuration.browser = "firefox";
        Configuration.browserVersion = "124.0";

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("selenoid:options", new HashMap<String, Object>() {{

            put("enableVNC", true);
            put("enableVideo", true);
        }});
        Configuration.browserCapabilities = capabilities;

    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }


}
