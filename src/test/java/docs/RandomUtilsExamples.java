package docs;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static utils.RandomUtils.getRandomMessage;
import static utils.RandomUtils.getRandomString;

public class RandomUtilsExamples {

    @Test
    void randomExamples(){
        String randomString = getRandomString(11);
        String emailDomain = "@qa.guru";

//        $("#firstName").setValue(randomString);
        System.out.println(randomString);

        String randomMessage = getRandomMessage(22, 100);
        System.out.println(randomMessage);

    }
}
