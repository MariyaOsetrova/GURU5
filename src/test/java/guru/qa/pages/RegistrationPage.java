package guru.qa.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import guru.qa.tests.TestData;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    // метод открытия формы

    private SelenideElement formTitle = $(".practice-form-wrapper"),// вынесли, динамический, может менятся
                            firstNameInpute = $("#firstName"),
                            lastNameInpute = $("#lastName");

    private final String FORM_TITLE = "Student Registration Form"; // заданим константой тескт который НЕ будет изменятся


    public void openPage(){
        open("https://demoqa.com/automation-practice-form");
// проверка что страница открылась
        formTitle.shouldHave(text(FORM_TITLE));
    }

    public void typeFirstName(String value){
        firstNameInpute.setValue(value);
    }

    public void typeLastName(String value){
        lastNameInpute.setValue(value);
    }
}
