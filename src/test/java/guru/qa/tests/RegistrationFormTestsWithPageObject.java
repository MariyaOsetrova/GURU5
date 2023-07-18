//PageObject
/*PageObject— один из самых популярных паттернов проектирования кодовых баз веб-UI.
        Часто этот паттерн называют Page Object Model (POM).
        Такая модель проектирования подразумевает за собой объединение
        элементов страницы в свойства класса, а способы взаимодействия с этими
        элементами в методы.*/
package guru.qa.tests;

import guru.qa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static guru.qa.tests.TestData.firstName;
import static guru.qa.tests.TestData.lastName;

//import static guru.qa.tests.TestData;

public class RegistrationFormTestsWithPageObject extends TestBase{
    // PageObject ОПИСЫВАЕМ СТРАНИЦУ КАК ОБЪЕКТ

    /*
    убрали в TestBase, и наследуем из него
    @BeforeAll
    static void beforAll(){
        Configuration.startMaximized = true; // запуск теста в развернутом окне
        Configuration.pageLoadStrategy = ("none");
    }
    */

RegistrationPage registrationPage = new RegistrationPage();

    @Test

    public void practiceForm(){
        /* Убрали в отдельный класс guru.qa.pages.RegistrationPage
        open("https://demoqa.com/automation-practice-form");
// проверка что страница открылась
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        */
        // использование патерна из registrationPage
        registrationPage.openPage(); // dspdfkb nj nxj e,hfkb
// использование патерна из registrationPage
        registrationPage.typeFirstName(firstName)       // $("#firstName").setValue(firstName);
                        .typeLastName(lastName);//    $("#lastName").setValue(TestData.lastName); + в pages добавиди return this; //вернутся назад и можно опять вызывать методы

        $("#userEmail").setValue("male@mail.ru");
        //  $(byText("Привет"));
        $("#genterWrapper").$(byText("Male")).click(); // добавили клнкретики
        //или так
        //$("#gender-radio-1").parent().click();
        $("#userNumber").setValue("9159852374");


        registrationPage.calendarComponent.setDate("16", "April", "1989" );
        // работа с календарем, убрали в отдельный метод - компонент
        /*
        $("#dateOfBirthInput").click();
        $(byClassName("react-datepicker__month-select")).click();
        $(byClassName("react-datepicker__month-select")).$(byText("April")).click();
        // либо две строки выше так      $(byClassName("react-datepicker__month-select")).selectOption("April");
        $(byClassName("react-datepicker__year-select")).click();
        $(byClassName("react-datepicker__year-select")).$(byText("1989")).click();
        // либо две строки выше так      $(byClassName("react-datepicker__year-select")).selectOption("1989");
        $("div[aria-label='Choose Sunday, April 16th, 1989']").click();
        // еще способы, если например в месеце раскрытом, есть 2 одинаковые даты, например 28 при выборе апрель 1989
//class="react-datepicker__day react-datepicker__day--028 react-datepicker__day--outside-month"
//class="react-datepicker__day react-datepicker__day--028"
        // способ 1, исключение с not
//        $(".react-datepicker__day--028:not(.react-datepicker__day--outside-month)").click();
        // способ 2, исключение с not
//        $$(".react-datepicker__day--028").filter(not(cssClass("react-datepicker__day--outside-month"))).first().click();
*/

        // выбор из выпадающего списка
        $("#subjectsInput").setValue("English");
        $(byClassName("subjects-auto-complete__menu")).click();
        // еще способ
//        $("#subjectsInput").setValue("English").pressEnter();



        $("#hobbiesWrapper").$(byText("Sports")).click();

        // загрузка файла по кнопке
        $("#uploadPicture").uploadFile(new File("src/test/data/Снимок.JPG"));
        // еще способ
        //  $("#uploadPicture").uploadFromClasspath("src/test/data/Снимок.JPG");

        $("#currentAddress").setValue("Адрес1");

        // выбор из раскрывающегося выпадающего списка
        $("#state").click();
        // СКРОЛ!!!! . ЕСЛИ НЕ СКРОЛИТ!!!!       $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText("NCR")).click();

        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        // проверка, убрали в паттерн  registrationPage в метод checkresultValue
        registrationPage.checkresultValue("Student Name", firstName + " " + lastName);


    }
}
