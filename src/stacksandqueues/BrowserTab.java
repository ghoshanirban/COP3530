package stacksandqueues;

import java.util.*;

public class BrowserTab {
    String currentPage = "";
    private final LinkedStack<String> backPages = new LinkedStack<>(),
                                      forwardPages = new LinkedStack<>();
    public static String getTimeStamp(){ return "[" + new Date() + "] "; }

    public BrowserTab() { System.out.println(getTimeStamp() + "New tab opened."); }
    
    public void typeAndGoNewSite(String newPage) {
        if( !currentPage.isEmpty() ) // some page is being viewed currently
            backPages.push(currentPage); // send the current page to the previousPages DLL

        currentPage = newPage;
        System.out.println(getTimeStamp() + "Currently viewing: " + currentlyViewing());
    }

    public void clickOnGoBackButton() {
        if( backPages.isEmpty() ) {
            System.out.println(getTimeStamp() + "Back button is greyed out (unavailable).");
            return;
        }
        else {
            System.out.print(getTimeStamp() + "Back button is clicked. ");
            forwardPages.push(currentPage);
            currentPage = backPages.top();
            backPages.pop();
        }
        System.out.println("Currently viewing: " + currentlyViewing());
    }

    public void clickOnGoForward() {
        if( forwardPages.isEmpty() ) {
            System.out.println(getTimeStamp() + "Forward button is greyed out (unavailable).");
            return;
        }
        else {
            backPages.push(currentPage);
            currentPage = forwardPages.pop();
        }
        System.out.println(getTimeStamp() + "Forward button is clicked. Currently viewing: " + currentlyViewing());
    }

    public String currentlyViewing() { return currentPage; }

    public String toString() {
        StringBuilder prettyString = new StringBuilder();

        for (String site : backPages)
            prettyString.append(site).append(" ");

        prettyString.append(" ***").append(currentPage).append("*** ");

        for (String site : forwardPages)
            prettyString.append(site).append(" ");

        return prettyString.toString();
    }
}
