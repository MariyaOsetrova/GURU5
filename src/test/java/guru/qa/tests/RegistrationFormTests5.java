package guru.qa.tests;

        import com.codeborne.selenide.Configuration;
        import org.junit.jupiter.api.BeforeAll;
        import org.junit.jupiter.api.Test;

        import java.io.File;

        import static com.codeborne.selenide.Condition.text;
        import static com.codeborne.selenide.Selectors.byClassName;
        import static com.codeborne.selenide.Selectors.byText;
        import static com.codeborne.selenide.Selenide.$;
        import static com.codeborne.selenide.Selenide.open;

        public class RegistrationFormTests5 {
        @BeforeAll
        static void beforAll(){
        Configuration.startMaximized = true; // запуск теста в развернутом окне
        Configuration.pageLoadStrategy = ("none");
        }
        @Test

        public void practiceForm(){
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Имя");
        $("#lastName").setValue("Фамилия");
        $("#userEmail").setValue("male@mail.ru");
        //  $(byText("Привет"));
        $("#genterWrapper").$(byText("Male")).click(); // добавили клнкретики
        //или так
        //$("#gender-radio-1").parent().click();
        $("#userNumber").setValue("123456789");
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
        $("#stateCity-wrapper").$(byText("NCR")).click();

        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Имя Фамилия"),
        text("male@mail.ru"), text("16 April,1989"));

        }
        }
