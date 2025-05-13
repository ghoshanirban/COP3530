package tester;

import java.util.concurrent.TimeUnit;

import stacksandqueues.BrowserTab;

public class TestBrowserTab {
    public static void main(String[] args) throws InterruptedException {

        System.out.println(BrowserTab.getTimeStamp() + "Launching browser simulator...");
        BrowserTab newTab = new BrowserTab();

        newTab.clickOnGoBackButton();

        TimeUnit.SECONDS.sleep(5);
        newTab.typeAndGoNewSite("https://www.google.com/");
        TimeUnit.SECONDS.sleep(2);

        newTab.typeAndGoNewSite("https://www.unf.edu/");
        TimeUnit.SECONDS.sleep(1);

        newTab.typeAndGoNewSite("https://stackoverflow.com");
        TimeUnit.SECONDS.sleep(3);

        newTab.typeAndGoNewSite("https://www.amazon.com");

        newTab.clickOnGoBackButton();
        newTab.clickOnGoBackButton();
        newTab.clickOnGoBackButton();

        System.out.println(BrowserTab.getTimeStamp() + newTab);
        newTab.clickOnGoForward();
        System.out.println(BrowserTab.getTimeStamp() + newTab);
        newTab.clickOnGoForward();

        System.out.println(BrowserTab.getTimeStamp() + "Terminating browser simulator. ");
    }
}
