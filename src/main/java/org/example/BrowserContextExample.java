package org.example;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class BrowserContextExample {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext context_one = browser.newContext();
        Page page_one = context_one.newPage();
        page_one.navigate("https://www.amazon.in/");
        page_one.getByRole(AriaRole.SEARCHBOX, new Page.GetByRoleOptions().setName("Search Amazon.in")).fill("flowers");
        page_one.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Go").setExact(true)).click();
        Thread.sleep(5000);
        System.out.println(page_one.title());
        page_one.close();

        BrowserContext context_two = browser.newContext();
        Page page_two = context_two.newPage();
        page_two.navigate("https://duckduckgo.com/");
        page_two.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Search with DuckDuckGo")).fill("playwright java");
//        page_two.getByTestId("searchbox-form").getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Search").setExact(true)).click();
        Locator searches = page_two.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Search"));
        int num = searches.count();
        searches.first().click();
        Thread.sleep(5000);
        System.out.println(page_two.title());
        page_two.close();

        BrowserContext context_three = browser.newContext();
        Page page_three = context_three.newPage();
        page_three.navigate("https://www.amazon.in/");
        page_three.getByRole(AriaRole.SEARCHBOX, new Page.GetByRoleOptions().setName("Search Amazon.in")).fill("laptops");
        page_three.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Go").setExact(true)).click();
        Thread.sleep(5000);
        System.out.println(page_three.title());
        page_three.close();

        context_one.close();
        context_two.close();
        context_three.close();
        browser.close();
        playwright.close();
    }
}
