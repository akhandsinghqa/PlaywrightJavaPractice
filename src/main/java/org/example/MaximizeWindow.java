package org.example;

import com.microsoft.playwright.*;

import java.awt.*;

public class MaximizeWindow {
    public static void main(String[] args) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int width = dimension.width;
        int height = dimension.height;
        System.out.println(width + "," + height);

        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.firefox()
                    .launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext browserContext = browser
                    .newContext(new Browser.NewContextOptions().setViewportSize(width, height));
            Page page = browserContext.newPage();

            page.navigate("https://github.com/mozilla/geckodriver/releases");
        }
    }
}
