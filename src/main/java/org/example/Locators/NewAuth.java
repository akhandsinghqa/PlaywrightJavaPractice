package org.example.Locators;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.nio.file.Paths;

public class NewAuth {
    public static void main(String[] args) throws InterruptedException {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions()
                    .setStorageStatePath(Paths.get("applogin.json")));
            Page page = browserContext.newPage();
            page.navigate("https://automationexercise.com/");
            Thread.sleep(2000);
            page.getByRole(AriaRole.LINK,new Page.GetByRoleOptions().setName(" Logout")).click();
        }
    }
}
