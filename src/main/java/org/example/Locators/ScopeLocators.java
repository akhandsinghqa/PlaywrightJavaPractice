package org.example.Locators;

import com.microsoft.playwright.*;

public class ScopeLocators {
    public static void main(String[] args) throws InterruptedException {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
            Page page = browser.newPage();
            page.navigate("https://datatables.net/extensions/select/examples/checkbox/checkbox.html");
            Locator row = page.locator("#example tr");
            row.locator(":scope", new Locator.LocatorOptions().setHasText("Ashton Cox"))
                    .locator(".dt-select-checkbox").click();

            row.locator(":scope").allInnerTexts().forEach(System.out::println);

        }
    }
}
