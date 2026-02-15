package org.example;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class VideoRecording {
    public static void main(String[] args) throws InterruptedException {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("testVideos/"))).newPage();
            page.navigate("https://www.bigbasket.com/");
            Locator first_ele = page.locator("footer > div:first-child > div:first-child li >> nth=0");
            System.out.println("First Element : " + first_ele.textContent());
            Locator last_ele = page.locator("footer > div:first-child > div:first-child li >> nth=-1");
            last_ele.click();
            Thread.sleep(5000);
        }
    }
}
