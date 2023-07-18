// ПАТЕРН!!!!!! к RegistrationFormTestsWithPageObject
// некая сущность, куда забиты статические данные и что мы с этим делаем
// описываем страницу как объект
//PageObject
/*PageObject— один из самых популярных паттернов проектирования кодовых баз веб-UI.
        Часто этот паттерн называют Page Object Model (POM).
        Такая модель проектирования подразумевает за собой объединение
        элементов страницы в свойства класса, а способы взаимодействия с этими
        элементами в методы.*/

package guru.qa.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import guru.qa.pages.compinents.CalendarComponent;
import guru.qa.tests.TestData;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static guru.qa.tests.TestData.firstName;
import static guru.qa.tests.TestData.lastName;

public class RegistrationPage {

// статика, локаторы и тд, то с чем мы делаем методы далее
    private SelenideElement formTitle = $(".practice-form-wrapper"),// вынесли, динамический, может менятся
                            firstNameInpute = $("#firstName"),
                            lastNameInpute = $("#lastName");
    public CalendarComponent calendarComponent = new CalendarComponent();

    private final String FORM_TITLE = "Student Registration Form"; // заданим константой тескт который !!!!!!НЕ будет изменятся

// МЕТОДЫ, вынесеные в отдельный pages и использовате в тесте данный метод , см строку 26 в RegistrationFormWithRandomUtilsTests
    public void openPage(){
        open("https://demoqa.com/automation-practice-form");
// проверка что страница открылась
        formTitle.shouldHave(text(FORM_TITLE)); // объявили переменные выше в стр 18, 23
    }
// метод для FirstName // объявили переменные выше в стр 19
    public RegistrationPage typeFirstName(String value){ // сделали цепочку public RegistrationPage вместо public void , что бы писатт в тест екод так:
      /*  registrationPage.typeFirstName(firstName)       // $("#firstName").setValue(firstName);
                .typeLastName(lastName);//
                вместо
          registrationPage.typeFirstName(firstName)
          registrationPage.typeLastName(lastName);//
                */
        firstNameInpute.setValue(value);
        return this; //вернутся назад и можно опять вызывать методы
    }
//// объявили переменные выше в стр 20
    public void typeLastName(String value){
        lastNameInpute.setValue(value);
    }

    public void checkresultValue(String key, String value){
        $x("//td[text()='" + key + "']").parent()
                .shouldHave(text(value));
    }
}
