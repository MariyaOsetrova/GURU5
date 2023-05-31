package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    @BeforeAll
    static void beforAll(){
        Configuration.startMaximized = true; // запуск теста в развернутом окне
        Configuration.pageLoadStrategy = ("none");
    }
}
