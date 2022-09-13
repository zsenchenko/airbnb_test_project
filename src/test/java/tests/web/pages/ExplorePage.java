package tests.web.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ExplorePage {

    public SelenideElement
            mainMenuButton = $("[data-testid=cypress-headernav-profile]"),
            heartButton = $(".bq05a0m");

    public void openMenu() {
        mainMenuButton.click();
    }

    public void addToFavorites() {
        heartButton.click();
    }
}
