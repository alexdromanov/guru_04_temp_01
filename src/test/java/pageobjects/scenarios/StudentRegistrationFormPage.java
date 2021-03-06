package pageobjects.scenarios;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StudentRegistrationFormPage {

   private String firstName = "Alex",
     lastName = "Dent",
     gender = "Male",
     email = "test@gmail.com",
     phone = "0123456789",
     birthDay = "17",
     birthMonth = "August",
     birthYear = "1982",
     birthСheck ="17 August,1982",
     subjects = "English",
     hobby = "Sports",
     photoName = "11.jpg",
     address = "Russia" + "Moscow" + "Ostankino",
     state = "Haryana",
     city = "Karnal";

    public StudentRegistrationFormPage openPage(){
        open("https://demoqa.com/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));

       return this;
    }

    public StudentRegistrationFormPage fillForm(){
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#gender-radio-1").doubleClick();
        $("#userNumber").setValue(phone);
        setDate(birthYear, birthMonth, birthDay);


        $("#subjectsInput").setValue(subjects);
        $("#subjectsInput").pressEnter();


        $("[for='hobbies-checkbox-1']").click();


        $("#uploadPicture").uploadFromClasspath("11.jpg");
        $("#currentAddress").setValue(address);

        $("#react-select-3-input").setValue(state).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();

        $("#submit").click();

        return this;


    }
    public void setDate(String year, String month, String day) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(String.format("[aria-label='Choose Tuesday, %s %sth, %s']", month, day, year)).click();

    }

    public void checkData(){
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

