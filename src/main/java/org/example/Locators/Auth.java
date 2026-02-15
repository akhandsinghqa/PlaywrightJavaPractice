package org.example.Locators;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.nio.file.Paths;

public class Auth {
    public static void main(String[] args) throws InterruptedException {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext browserContext = browser.newContext();
            Page page = browserContext.newPage();
            page.navigate("https://automationexercise.com/");
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Signup / Login")).click();
            page.locator("input[data-qa='login-email']").fill("playwrightautoz@gmail.com");
            page.locator("input[data-qa='login-password']").fill("password12345");
            page.locator("button[data-qa='login-button']").click();

            browserContext.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("applogin.json")));

//            page.getByRole(AriaRole.LINK,new Page.GetByRoleOptions().setName(" Logout")).click();
//            Thread.sleep(2000);

        }
    }
}
