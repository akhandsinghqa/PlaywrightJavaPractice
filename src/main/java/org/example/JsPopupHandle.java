package org.example;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class JsPopupHandle {
    public static void main(String[] args) throws InterruptedException {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium()
                    .launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
            Page page = browser.newPage();
            page.navigate("https://the-internet.herokuapp.com/javascript_alerts");

            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Click for JS Alert")).click();
            System.out.println(page.locator("p#result").textContent());

            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Click for JS Confirm")).click();
            System.out.println(page.locator("p#result").textContent());

            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Click for JS Prompt")).click();
            System.out.println(page.locator("p#result").textContent());

            System.out.println("************** onDialog *****************");

            page.onDialog(dialog -> {
                String message = dialog.message();
                System.out.println(message);
//                dialog.accept();
                dialog.accept("This message is added by automation.");
//                dialog.dismiss();
            });

            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Click for JS Alert")).click();
            System.out.println(page.locator("p#result").textContent());

            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Click for JS Confirm")).click();
            System.out.println(page.locator("p#result").textContent());

            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Click for JS Prompt")).click();
            System.out.println(page.locator("p#result").textContent());

        }
    }
}
