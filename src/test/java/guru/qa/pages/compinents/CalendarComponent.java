package guru.qa.pages.compinents;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    public  void setDate(String day, String month, String year) {

        $("#dateOfBirthInput").click();

        $(byClassName("react-datepicker__month-select")).click();
        $(byClassName("react-datepicker__month-select")).$(byText(month)).click(); //  $(byClassName("react-datepicker__month-select")).$(byText("April")).click();
        // либо две строки выше так      $(byClassName("react-datepicker__month-select")).selectOption("April");

        $(byClassName("react-datepicker__year-select")).click();
        $(byClassName("react-datepicker__year-select")).$(byText(year)).click(); // $(byClassName("react-datepicker__year-select")).$(byText("1989")).click();
        // либо две строки выше так      $(byClassName("react-datepicker__year-select")).selectOption("1989"); //         $("div[aria-label='Choose Sunday, April 16th, 1989']").click();

        $("div[aria-label='Choose Sunday, April " +  day + "th, 1989']").click();


        // Варианты         $("div[aria-label='Choose Sunday, April " +  day + "th, 1989']").click();
     /*   // 1
        String selector = "div[aria-label='Choose Sunday, April 16th, 1989']";
        $(selector).click();

        //2
        String selector1 = "div[aria-label='Choose Sunday, April %sth, 1989']";
        String formatSelector = String.format(selector1, day);
        $(formatSelector).click();

        //ПРОСТОЙ ПРИМЕР работы String.format, когда не хотим рвать код на + переменная +, можно заменить на %s и потом задавать по порядк учто туд абудет подставляться

        String bigtext = "я родился %s %s %s";
        String a = "16";
        String b = "Апреля";
        String c = "1989";
        System.out.println(String.format(bigtext,a,b,c));
*/
    }
}
