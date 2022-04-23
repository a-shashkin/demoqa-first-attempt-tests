package com.simbirsoft.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    void fillFormTest() {
        String permanentAddress = "10 Anonymous St., Anon City, Anon Country";

        open("https://demoqa.com/text-box");
        $("#userName").setValue("Anonymous User");
        $("#userEmail").setValue("anonymous@gmail.com");
        $("input#currentAddress").setValue("5 Anonymous St., Anon City, Anon Country");
        $("#permanentAddress").setValue(permanentAddress);
        $("#submit").click();
        $("#submit").click();

        $("#output #name").shouldHave(text("Anonymous User"));
        $("#output #email").shouldHave(text("anonymous@gmail.com"));
        $("#output p#currentAddress").shouldHave(text("5 Anonymous St., Anon City, Anon Country"));
        $("#output #permanentAddress").shouldHave(text(permanentAddress ));
    }
}
