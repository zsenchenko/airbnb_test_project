package tests.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Tag("WEB")
public class FilterTest extends TestBase {

    @Test
    @DisplayName("Filter application check")
    void checkConvenienceFilter() {
        step("Add a filter for convenience", () -> {
            filterPage.applyFilter();
        });
        step("Checking the availability of convenience in the room", () -> {
            roomPage
                    .checkFilterResult();
        });
    }
}
