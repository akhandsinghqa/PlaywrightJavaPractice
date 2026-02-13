package org.example.Locators;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FrameExamples {
    public static void main(String[] args){
        try(Playwright playwright = Playwright.create()){
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            page.navigate("https://www.londonfreelance.org/courses/frames/index.html");

            System.out.println(page.frame("main").locator("h2:has-text('Title bar')").textContent());
            System.out.println(page.frameLocator("frame[name='main']").locator("h2").textContent());
            page.frames().forEach(frame ->System.out.println(frame.name()));
            System.out.print(page.frameByUrl("top.html").locator("h2:has-text('Title bar')").textContent());
        }
    }

}
