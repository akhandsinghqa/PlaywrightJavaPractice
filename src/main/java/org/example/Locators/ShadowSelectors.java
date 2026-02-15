package org.example.Locators;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ShadowSelectors {
    public static void main(String[] args) throws InterruptedException {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newContext().newPage();
            page.navigate("https://books-pwakit.appspot.com/explore");
            page.locator("#input").fill("datasearch");
            System.out.println(page.locator("book-explore div.books-desc").textContent());
        }
    }
}
