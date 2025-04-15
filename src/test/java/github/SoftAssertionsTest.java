package github;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SoftAssertionsTest {

    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        //Configuration.baseUrl = "https://github.com/";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void successfulSoftAssertionsTest(){

        open("selenide/selenide");
        $(".UnderlineNav-body").$(byText("Wiki")).click();

        $$("a.internal.present").findBy(text("Soft assertions"))
                .shouldBe(visible).click();

        $$(".highlight.highlight-source-java").findBy(text("@ExtendWith({SoftAssertsExtension.class})"))
                .shouldBe(visible);

    }
}
