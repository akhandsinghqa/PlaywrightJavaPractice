package org.example.Locators;

import com.microsoft.playwright.*;

public class XpathLocator {
    public static void main(String[] args) throws InterruptedException {
        try(Playwright playwright = Playwright.create()){
            Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
            Page page = browser.newPage();
            page.navigate("https://www.amazon.in/");
            page.locator("xpath=//input[@id='twotabsearchtextbox']").fill("laptop i9");
            page.locator("xpath=//input[@type='submit']").click();

            Thread.sleep(5000);
            Locator search_results_ele = page.locator("//div[@data-component-type='s-search-result']//h2/span");
            int total_search_ele=search_results_ele.count();
            System.out.println("Count : "+total_search_ele);
            for (int i = 0; i < total_search_ele;i++){
                String search_text = search_results_ele.nth(i).textContent().trim();
                if(search_text.contains("acer Predator Helios 16 Gaming Laptop 14th Gen Intel Core i9 Processor")){
                    System.out.println(search_text);
                    search_results_ele.nth(i).click();
                    break;
                }
            }
        }
    }
}
