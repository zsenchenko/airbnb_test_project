package tests.web.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ExplorePage {

    public SelenideElement
            mainMenuButton = $("[data-testid=cypress-headernav-profile]"),
            profileMenu = $("[data-testid=simple-header-profile-menu]"),
            heartButton = $(".bq05a0m"),
            flexibleDatesButton = $("._19471dk"),
            mapSection = $(".c12zlp1w"),
            oneWeekButton = $("#flexible_trip_lengths-one_week"),
            directionsInput = $("[data-testid=structured-search-input-field-query]"),
            guestsButton = $("[data-testid=structured-search-input-field-guests-button]"),
            experienceButton = $("[data-testid=header-tab-search-block-tab-EXPERIENCES]"),
            experienceInput = $("[data-testid=structured-search-input-field-query]"),
            increaseButton = $("[data-testid=stepper-adults-increase-button]"),
            searchButton = $("[data-testid=structured-search-input-search-button]");

    public ElementsCollection
            searchMenu = $$("[data-testid=little-search]"),
            listOfExperiences = $$("._1355n57e"),
            listOfLocations = $$("._1h6n1zu"),
            Months = $$("._1l1u7cl");

    public ExplorePage openMenu() {
        mainMenuButton.click();
        return this;
    }

    public ExplorePage addToFavorites() {
        heartButton.click();
        return this;
    }

    public ExplorePage checkAccount() {
        profileMenu.shouldHave(text("Аккаунт"));
        return this;
    }

    public ExplorePage selectDirection() {
        searchMenu.get(0).click();
        directionsInput.setValue("Maldives").pressEnter();
        return this;
    }

    public ExplorePage selectExperience() {
        searchMenu.get(0).click();
        experienceButton.click();
        experienceInput.setValue("France").pressEnter();
        return this;
    }

    public ExplorePage selectDate() {
        flexibleDatesButton.click();
        oneWeekButton.click();
        Months.get(1).click();
        return this;
    }

    public ExplorePage selectGuests() {
        guestsButton.click();
        increaseButton.click();
        return this;
    }

    public ExplorePage doSearch() {
        searchButton.click();
        return this;
    }

    public ExplorePage checkDirection() {
        searchMenu.get(0).shouldHave(text("Maldives"));
        return this;

    }

    public ExplorePage checkMap() {
        mapSection.shouldBe(visible);
        return this;
    }

    public ExplorePage checkExperiences() {
        listOfExperiences.shouldHave(CollectionCondition.sizeGreaterThan(1));
        return this;
    }

    public void openRoom() {
        listOfLocations.get(0).click();
        Selenide.switchTo().window(1);
    }
}
