package tests.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Tag("WEB")
public class ShareRoomTest extends TestBase {

    @Test
    @DisplayName("Checking the ability to share a link to a room")
    void shareLink() {
        step("Open any room page", () -> {
            explorePage.openRoom();
        });
        step("Click share and copy the link", () -> {
            roomPage
                    .clickShare()
                    .copyLink();
        });
        step("Checking that the link is copied", () -> {
            roomPage.copyCheck();
        });

    }
}
