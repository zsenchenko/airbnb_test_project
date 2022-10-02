package tests.web.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class FilterPage {

    public SelenideElement
            filterButton = $(".v1tureqs"),
            expandButton = $("._edqkt1v"),
            fireplaceFlag = $("._16je9le").$(byText("Камин")),
            applyFilterButton = $("._1ku51f04");

    public FilterPage applyFilter() {
        filterButton.click();
        expandButton.click();
        fireplaceFlag.click();
        applyFilterButton.click();
        return this;
    }
}

