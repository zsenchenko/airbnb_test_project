package tests.web.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RoomPage {

    public SelenideElement
            shareButton = $("._c2acbp"),
            copySection = $("._1ucy1zjv").$(byText("Скопировать ссылку")),
            textMessage = $("._1n6q029"),
            conveniencesButton = $(".b65jmrv"),
            conveniencesSection = $("._wheg71v");

    public RoomPage clickShare() {
        shareButton.click();
        return this;
    }

    public RoomPage copyLink() {
        copySection.click();
        return this;
    }

    public RoomPage copyCheck() {
        textMessage.shouldBe(visible).shouldHave(text("Ссылка скопирована"));
        return this;
    }

    public RoomPage checkFilterResult() {
        conveniencesButton.click();
        conveniencesSection.shouldHave(text("Камин"));
        return this;
    }
}
