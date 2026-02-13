package org.example.Locators;

import com.microsoft.playwright.*;

public class CommaSelectors {
    public static void main(String[] args){
        try(Playwright playwright = Playwright.create()){
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
            Page page = browser.newPage();
            page.navigate("https://academy.naveenautomationlabs.com/");
            Locator sigin_locator = page.locator("a:has-text('Login'),a:has-text('SignIn')");
            sigin_locator.click();
            Locator comma_locators = page.locator("a:has-text('Login'),a:has-text('Explore Courses'),a:has-text('Demo Site')");
            if(comma_locators.count() == 3){
                System.out.println("Pass");
            }
            else System.out.println("Fail");
//            Locator sigin_xlocator = page.locator("//a[contains(@class,'loginBtn')] | //a[contains(@class,'signBtn')] ");
//            sigin_locator.click();
        }
    }
}
