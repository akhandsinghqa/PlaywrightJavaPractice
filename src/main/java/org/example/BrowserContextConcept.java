package org.example;

import com.microsoft.playwright.*;

public class BrowserContextConcept {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext browserContext1 = browser.newContext();
/*
        BrowserContext browserContext2 = browser.newContext();
        Page page1 = browserContext1.newPage();
        page1.navigate("https://www.google.com");
        Page page2 = browserContext2.newPage();
        page2.navigate("https://www.amazon.com");
        page1.close();
        page2.close();
*/

            Page page1 = browserContext1.newPage();
//        Page page2 = browserContext1.newPage();

            page1.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

            Page new_page = page1.waitForPopup(() -> page1.locator("a[href='https://www.linkedin.com/company/orangehrm/mycompany/']").click());
            new_page.waitForLoadState();
            System.out.println("New Tab title : " + new_page.title());
            System.out.println("Parent Tab title : " + page1.title());

            browser.close();
        }
    }
}
