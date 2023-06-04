// некая сущность, куда забиты статические данные и что мы с этим делаем
package guru.qa.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import guru.qa.pages.compinents.CalendarComponent;
import guru.qa.tests.TestData;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

// статика, локаторы и тд, то с чем мы делаем методы далее
    private SelenideElement formTitle = $(".practice-form-wrapper"),// вынесли, динамический, может менятся
                            firstNameInpute = $("#firstName"),
                            lastNameInpute = $("#lastName");
    public CalendarComponent calendarComponent = new CalendarComponent();

    private final String FORM_TITLE = "Student Registration Form"; // заданим константой тескт который НЕ будет изменятся

// МЕТОДЫ
    public void openPage(){
        open("https://demoqa.com/automation-practice-form");
// проверка что страница открылась
        formTitle.shouldHave(text(FORM_TITLE));
    }

    public RegistrationPage typeFirstName(String value){
        firstNameInpute.setValue(value);
        return this; //вернутся назад и можно опять вызывать методы, см в
    }

    public void typeLastName(String value){
        lastNameInpute.setValue(value);
    }

    public void checkresultValue(String key, String value){
        $x("//td[text()='" + key + "']").parent()
                .shouldHave(text(value));
    }
}
