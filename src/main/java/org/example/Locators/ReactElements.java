package org.example.Locators;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class ReactElements {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://www.netflix.com/in/");
            page.locator("[id=':Rajalalalb96:']").selectOption("hi-IN");
            page.navigate("https://www.netflix.com/in-hi/");
            page.locator("[id=':Rajalalalb96:']").selectOption("en-IN");
            page.navigate("https://www.netflix.com/in/");
//            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email address")).first().click();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email address")).first().fill("demo@user.com");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Get Started")).first().click();
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Send Link")).click();
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Resend Link")).click();
            page.getByText("Link Sent").click();
        }
    }
}
