package org.example.Locators;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.FilePayload;

import java.nio.charset.StandardCharsets;

public class FileUploadHandle {
    public static void main(String[] args) throws InterruptedException {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
            Page page = browser.newPage();
//            page.navigate("https://davidwalsh.name/demo/multiple-file-upload.php");
//
//            page.setInputFiles("input#filesToUpload", Paths.get("applogin.json"));
//            System.out.println(page.locator("ul#fileList").textContent());
//            Thread.sleep(2000);
//            page.setInputFiles("input#filesToUpload", new Path[0]);
//
//            page.setInputFiles("input#filesToUpload", new Path[]{
//                    Paths.get("applogin.json"),
//                    Paths.get("trace.zip")
//            });
//            System.out.println(page.locator("ul#fileList").textContent());
            page.navigate("https://cgi-lib.berkeley.edu/ex/fup.html");
            Thread.sleep(2000);
//            page.setInputFiles("input[name='upfile']", Paths.get("applogin.json"));
//            page.locator("input[type='submit']").click();
//            Thread.sleep(4000);

            page.setInputFiles("input[name='upfile']",
                    new FilePayload("data.txt", "text/plain", "This file is created by FilePayload automation".getBytes(StandardCharsets.UTF_8)));
            page.locator("input[type='submit']").click();
            Thread.sleep(4000);

        }
    }
}
