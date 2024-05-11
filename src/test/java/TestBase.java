import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
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

        Configuration.browser = "firefox";
        Configuration.browserSize = "1100x1080";
//        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
//        Configuration.browser = "chrome";
//        Configuration.browserVersion = "100.0";

//        DesiredCapabilities capabilities = new DesiredCapabilities();
//
//        capabilities.setCapability("selenoid:options", new HashMap<String, Object>() {{
//
//            put("enableVNC", true);
//            put("enableVideo", true);
//        }});
//        Configuration.browserCapabilities = capabilities;

    }
    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }


}
