package org.example.Locators;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ChildElementExample {
    public static void main(String[] args) throws InterruptedException {
        try (Playwright playwright = Playwright.create()) {
            Page page = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)).newContext().newPage();
//            page.navigate("https://www.orangehrm.com/en/30-day-free-trial");
//            Locator country = page.locator("select#Form_getForm_Country:has(option[value='India'])");
//            country.allInnerTexts().forEach(System.out::print);
            page.navigate("https://www.amazon.in/");
            Thread.sleep(5000);
            page.locator("div.navFooterLinkCol:has(a[href='https://www.amazon.science'])").allInnerTexts().forEach(System.out::print);
//            System.out.println(country.textContent());
        }
    }
}
