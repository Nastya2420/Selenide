import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class QuestionnaireTest {

    @BeforeEach
    void setup() {
        Configuration.holdBrowserOpen = true;
        Calendar c = new GregorianCalendar();
        c.add(Calendar.DAY_OF_YEAR, 3);
        SimpleDateFormat formats = new SimpleDateFormat("dd.MM.yyyy");
        String str = formats.format(c.getTime());
        open("http://localhost:9999");
        $("[data-test-id='date'] input").sendKeys(str);
    }

    @Test
    void shouldTest(){
        Configuration.holdBrowserOpen = true;
        open("ttp://localhost:9999/");
        $("[data-test-id='city'] input").setValue("Москва");
        $("[data-test-id='name'] input").setValue("Анна Иванова-Петрова");
        $("[data-test-id='phone'] input").setValue("+79656667566");
        $("[data-test-id='agreement']").click();
        $(".button").click();
        $("[data-test-id=notification]").shouldBe(Condition.visible, Duration.ofSeconds(11));

    }
}
