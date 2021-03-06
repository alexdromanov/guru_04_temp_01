package tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static utils.RandomUtils.getRandomString;

public class StudentRegistrationFormWithFakerTests {

    Faker faker = new Faker();


    @Test
    void selenideSearchTest() {
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String gender = "Male";
        String email = faker.internet().emailAddress();
        String phone = faker.phoneNumber().cellPhone();
        String birthDay = "17";
        String birthMonth = "August";
        String birthYear = "1982";
        String birthСheck ="17 August,1982";
        String subjects = "English";
        String hobby = "Sports";
        String photoName = "11.jpg";
        String address = "Russia" + "Moscow" + "Ostankino";
        String state = "Haryana";
        String city = "Karnal";

        open("https://demoqa.com/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#gender-radio-1").doubleClick();
        $("#userNumber").setValue(phone);

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(birthMonth);
        $(".react-datepicker__year-select").selectOption(birthYear);
        $(String.format("[aria-label='Choose Tuesday, %s %sth, %s']", birthMonth, birthDay, birthYear)).click();

        $("#subjectsInput").setValue(subjects);
        $("#subjectsInput").pressEnter();


        $("[for='hobbies-checkbox-1']").click();


        $("#uploadPicture").uploadFromClasspath("11.jpg");
        $("#currentAddress").setValue(address);

        $("#react-select-3-input").setValue(state).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();

        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text(firstName), text(lastName));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text(email));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text(gender));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text(phone));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text(birthСheck));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text(subjects));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text(hobby));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text(photoName));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text(address));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text(state+" "+city));
    }


}
