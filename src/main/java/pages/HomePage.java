package pages;

import org.openqa.selenium.By;
import utilities.Utility;

public class HomePage extends Utility {


    By searchLink = By.xpath("//input[@placeholder='Search']");
    By adminLink = By.linkText("Admin");
    By pIMLink = By.linkText("PIM");
    By leaveLink = By.linkText("Leave");
    By dashboardLink = By.linkText("Dashboard");


    public void clickOnSearchLink(String text) {
        sendTextToElement(searchLink,text);
    }

    public void clickOnAdminLink() {
        clickOnElement(adminLink);
    }

    public void clickOnPIMOLink() {
        clickOnElement(pIMLink);
    }

    public void clickOnLeaveLink() {
        clickOnElement(leaveLink);
    }

    public void clickOnDashboardLink() {
        clickOnElement(dashboardLink);
    }


}
