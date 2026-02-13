package org.example.Locators;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;


public class TextSelectors {
    public static void main(String[] args) throws InterruptedException {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

            BrowserContext context_one = browser.newContext();
            Page page = context_one.newPage();
            page.navigate("https://www.orangehrm.com/en/30-day-free-trial");

//            page.locator("text=OrangeHRM AI Principles").click();

            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all")).click();

            System.out.println(page.locator("'Compensation'").first().textContent());
//            System.out.println(page.locator("text='Compensation')").first().textContent());
            System.out.println(page.locator("h3:has-text('Compensation')").textContent());
            System.out.println(page.locator("div.product-title h3:has-text('Compensation')").textContent());

            Locator privacy_locators = page.locator("text=Privacy Policy");
//            privacy_ele.first().click();
            int num_privacy = privacy_locators.count();
            System.out.println(num_privacy);
            for (int i = 0; i < num_privacy; i++) {
                Locator privacy_ele = privacy_locators.nth(i);
                String text = privacy_ele.textContent().trim();
                System.out.println(text);
                if (text.equals("Service Privacy Policy")) {
                    privacy_ele.click();
                    break;
                }
            }
            Thread.sleep(2000);
        }
    }
}

