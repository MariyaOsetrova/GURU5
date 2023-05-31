package guru.qa.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    // метод открытия формы
    public void OpenPage(){
        open("https://demoqa.com/automation-practice-form");
// проверка что страница открылась
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
    }
}
