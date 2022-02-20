package ru.zavrichko.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.zavrichko.config.Credentials;
import ru.zavrichko.helpers.Attach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static java.lang.String.format;

public class TestBase {
    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";

        String user = Credentials.config.user();
        String password = Credentials.config.password();
        String url = System.getProperty("url");
        String remoteUrl = format("https://%s:%s@%s", user, password, url);

        Configuration.remote = remoteUrl;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }
}