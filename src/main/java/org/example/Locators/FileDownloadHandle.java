package org.example.Locators;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Download;
import com.microsoft.playwright.options.AriaRole;

import java.nio.file.Paths;

public class FileDownloadHandle {
    public static void main(String[] args){
        try(Playwright playwright=Playwright.create()){
            Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page= browser.newContext().newPage();
            page.navigate("https://github.com/mozilla/geckodriver/releases");
            Download download = page.waitForDownload(()->{
               page.getByRole(AriaRole.LINK,new Page.GetByRoleOptions().setName("geckodriver-v0.36.0-linux64.tar.gz").setExact(true)).click();
            });
            System.out.println(download.suggestedFilename());
            System.out.println(download.url());
            System.out.println(download.path());
            download.saveAs(Paths.get(download.suggestedFilename()));
        }
    }
}
