package org.example.Locators;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.util.List;

public class VisibleElements {
    public static void main(String[] args) throws InterruptedException {
        try (Playwright playwright = Playwright.create()) {
            Page page = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)).newContext().newPage();
            page.navigate("https://www.amazon.in/");
            Thread.sleep(5000);
            Locator all_links = page.locator("a");
            System.out.println("All Links : " + all_links.count());
            List<String> visible_links = page.locator("a:visible").allInnerTexts();
            System.out.println("Visible Links : " + visible_links.size());
            for (String link : visible_links) {
                System.out.println(link);
            }

            System.out.println("All Images : "+page.locator("img").count());
            System.out.println("Visible Images : "+page.locator("img:visible").count());
        }
    }
}
