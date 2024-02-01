package arraysandLLs;

import java.util.*;

public class BrowserTab {
    String currentPage = "";
    private final DoublyLinkedList<String> previousPages = new DoublyLinkedList<>(),
                                               nextPages = new DoublyLinkedList<>();
    public static String getTimeStamp(){ return "[" + new Date() + "] "; }

    public BrowserTab() { System.out.println(getTimeStamp() + "New tab opened."); }
    
    public void typeAndGoNewSite(String newPage) {
        if( !currentPage.isEmpty() ) // some page is being viewed currently
            previousPages.addLast(currentPage); // send the current page to the previousPages DLL

        currentPage = newPage;
        System.out.println(getTimeStamp() + "Currently viewing: " + currentlyViewing());
    }

    public void clickOnGoBackButton() {
        if( previousPages.isEmpty() ) {
            System.out.println(getTimeStamp() + "Back button is greyed out (unavailable).");
            return;
        }
        else {
            nextPages.addFirst(currentPage);
            currentPage = previousPages.last();
            previousPages.removeLast();
        }
        System.out.println(getTimeStamp() + "Currently viewing: " + currentlyViewing());
    }

    public void clickOnGoForward() {
        if( nextPages.isEmpty() ) {
            System.out.println(getTimeStamp() + "Forward button is greyed out (unavailable).");
            return;
        }
        else {
            previousPages.addLast(currentPage);
            currentPage = nextPages.removeFirst();
        }
        System.out.println(getTimeStamp() + "Currently viewing: " + currentlyViewing());
    }

    public String currentlyViewing() { return currentPage; }

    public String toString() {
        StringBuilder prettyString = new StringBuilder();

        for (String site : previousPages)
            prettyString.append(site).append(" ");

        prettyString.append(" ***").append(currentPage).append("*** ");

        for (String site : nextPages)
            prettyString.append(site).append(" ");

        return prettyString.toString();
    }
}
