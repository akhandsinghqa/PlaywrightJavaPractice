package org.example.Locators;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class NthElementLocator {
    public static void main(String[] args) throws InterruptedException {
        try (Playwright playwright = Playwright.create()) {
            Page page = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)).newPage();
            page.navigate("https://www.bigbasket.com/");
            Locator first_ele = page.locator("footer > div:first-child > div:first-child li >> nth=0");
            System.out.println("First Element : "+first_ele.textContent());
            Locator last_ele = page.locator("footer > div:first-child > div:first-child li >> nth=-1");
            last_ele.click();
            Thread.sleep(2000);
        }
    }
}
