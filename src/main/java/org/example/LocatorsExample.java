package org.example;

import com.microsoft.playwright.*;

import java.util.List;

public class LocatorsExample {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext context_one = browser.newContext();
        Page page = context_one.newPage();
        page.navigate("https://www.orangehrm.com/en/30-day-free-trial");

//        Locator contact_sales = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Contact Sales"));
//        contact_sales.first().click();

        Locator countries_loc = page.locator("select#Form_getForm_Country option");
//        countries_loc.first().click();
        System.out.println(countries_loc.count());
        for (int i = 0; i < countries_loc.count(); i++) {
            String text = countries_loc.nth(i).textContent();
            System.out.print(text);
        }

        System.out.println("**************** For Loop *******************");
        List<String> list_countries = countries_loc.allTextContents();
        for (String country : list_countries) {
            System.out.print(country);
        }

        System.out.println("*********************** For Each ***********************");
        list_countries.forEach(country_name -> System.out.print(country_name));
//        list_countries.forEach(System.out::print);

        page.close();
        context_one.close();
        browser.close();
        playwright.close();
    }
}
