package tests.mobile;

import io.qameta.allure.AllureId;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Tag("Android")
public class SearchTests extends TestBase {
    @Test
    @AllureId("11980")
    @DisplayName("Search and selection of location")
    void searchDestination() {
        step("Search page open check", () -> {
            explorePage.checkExploreButton();
        });
        step("Location search", () -> {
            explorePage.searchInput();
        });
        step("Location selection and open", () -> {
            explorePage.selectLocation("Maldives");
        });
    }
}
