package ru.zavrichko.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class RegistrationTest extends TestBase {
    @Owner("azavrichko")
    @Feature("Registration")
    @Story("Регистрация")
    @DisplayName("Регистрация")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    void RegistrationTest()  {
        // Open website

        step("Открываем страницу", () -> {
            open("/automation-practice-form");
        });

        step("Заполняем имя", () -> {
            $("#firstName").setValue("Alex");
        });

        step("Заполняем фамилию", () -> {
            $("#lastName").setValue("Smirnov");
        });

        step("Заполняем email", () -> {
            $("#userEmail").setValue("alex.smirnov@gmail.com");
        });

        step("Заполняем номер телефона", () -> {
            $(".custom-control-label").click();
            $("#userNumber").setValue("5648798798");
        });

        step("Заполняем дату", () -> {
            $("#dateOfBirthInput").click();
            $(".react-datepicker__month-select").click();
            $(".react-datepicker__month-select").selectOption("May");
            $(".react-datepicker__year-select").selectOption("2014");
            $x("//div[contains(text(),'15')]").click();
        });

        step("Заполняем хобби", () -> {
            $("#subjectsInput").setValue("Eng").pressEnter();
            $x("//label[contains(text(),'Sports')]").click();
            $x("//label[contains(text(),'Reading')]").click();
            $x("//label[contains(text(),'Music')]").click();
        });

        step("Заполняем адрес", () -> {
            $("#currentAddress").setValue("Moscow, Manoilov Street, 64");
        });

        step("Заполняем штат", () -> {
            $("#react-select-3-input").setValue("NCR").pressEnter();
        });

        step("Заполняем город", () -> {
            $("#react-select-4-input").setValue("Gurgaon").pressEnter();
        });

        step("Отправляем форму", () -> {
            $("#submit").click();
        });

        // Assertion

        step("Проверяем отображения модальной формы", () -> {
            $("#example-modal-sizes-title-lg").shouldBe(visible);
        });

        step("Проверяем правильность заполнения формы", () -> {
            $(".table-responsive").shouldHave(text("Alex"));
            $(".table-responsive").shouldHave(text("Smirnov"));
            $(".table-responsive").shouldHave(text("alex.smirnov@gmail.com"));
            $(".table-responsive").shouldHave(text("Male"));
            $(".table-responsive").shouldHave(text("5648798798"));
            $(".table-responsive").shouldHave(text("15 May,2014"));
            $(".table-responsive").shouldHave(text("English"));
            $(".table-responsive").shouldHave(text("Sports, Reading, Music"));
            $(".table-responsive").shouldHave(text("NCR Gurgaon"));
        });

    }

}