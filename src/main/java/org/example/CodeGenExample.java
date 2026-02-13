package org.example;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class CodeGenExample {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://duckduckgo.com/");
            page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Search with DuckDuckGo")).click();
            page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Search with DuckDuckGo")).fill("naveen automation");
            page.getByText("naveen automation labs playwright").click();
            page.pause();
            page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("search")).click();
            page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("search")).fill("naveen automation labs playwright java");
            page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("search")).press("Enter");
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("naveenanimation20/Playwright-")).click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("src, (Directory)")).click();
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("More options")).click();
        }
    }
}