package org.example.Locators;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.util.Arrays;
import java.util.List;

public class RelativeBelowLocators {
    public static void main(String[] args) throws InterruptedException {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://www.orangehrm.com/en/30-day-free-trial");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all")).click();
//            div.field.text:below(#Form_getForm_subdomain_Holder)
            page.locator("#Form_getForm_subdomain").fill("tomato");
            Locator locators = page.locator("input.text:below(#Form_getForm_subdomain_Holder)");
            List<String> values = Arrays.asList("NameOne", "demo@demo.com", "1234567890");
            if (locators.count() == values.size()) {
                for (int i = 0; i < locators.count(); i++) {
                    locators.all().get(i).fill(values.get(i));
                    Thread.sleep(2000);
                }
            }

        }
    }
}
