package org.example.Locators;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class RelativeLocators {
    static Page page;
    public static void main(String[] args) throws InterruptedException {
        try(Playwright playwright = Playwright.create()){
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
            page = browser.newPage();
            page.navigate("https://selectorshub.com/xpath-practice-page/");
            Thread.sleep(2000);
//            page.locator("input[type='checkbox']:left-of(:text('Joe.Root'))").allInnerTexts().forEach(System.out::print);
//            page.locator("input[type='checkbox']:left-of(:text('Joe.Root'))").first().click();
            selectUser("Joe.Root");
            selectUser("Garry.White");
            System.out.println(getUserRole("Joe.Root"));
            System.out.println(getUserRole("Garry.White"));
            String above_user = page.locator("a:above(:text('Joe.Root'))").first().textContent();
            System.out.println(above_user);
            String below_user = page.locator("a:below(:text('Joe.Root'))").first().textContent();
            System.out.println(below_user);
            page.locator("td:near(:text('Joe.Root'),400)").allInnerTexts().forEach(System.out::print);
            Thread.sleep(2000);
        }
    }

    public static void selectUser(String userName){
        page.locator("input[type='checkbox']:left-of(:text('"+userName+"'))").first().click();
    }

    public static String getUserRole(String userName){
        return page.locator("td:right-of(:text('"+userName+"'))").first().textContent();
    }
}
