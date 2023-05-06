package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class UserTest extends BaseTest {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    ViewSystemUserPage viewSystemUserPage = new ViewSystemUserPage();
    AddUserPage addUserPage = new AddUserPage();

    @Test
    public void adminShouldAddUserSuccessfully() throws InterruptedException {
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickOnLoginButton();
        homePage.clickOnAdminLink();
        Assert.assertEquals(viewSystemUserPage.getSystemUsersText(), "System Users");
        viewSystemUserPage.clickOnAddButton();
        Assert.assertEquals(addUserPage.getAddUserText(), "Add User");
        addUserPage.selectUserRoleAdminFromDropDown();
        addUserPage.enterEmployeeName("John Smith");
        addUserPage.enterUsername("JohnSmith");
        addUserPage.selectStatusDisableFromDropDown();
        addUserPage.enterPassword("Admin123@");
        addUserPage.enterConfirmPassword("Admin123@");
        addUserPage.clickOnSaveButton();

    }

    @Test
    public void searchTheUserCreatedAndVerifyIt() throws InterruptedException {
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickOnLoginButton();
        homePage.clickOnAdminLink();
        Assert.assertEquals(viewSystemUserPage.getSystemUsersText(), "System Users");
        addUserPage.enterUsername("JohnSmith");
        addUserPage.selectUserRoleAdminFromDropDown();
        addUserPage.selectStatusEnableFromDropDown();
        viewSystemUserPage.clickOnSearchButton();
        Assert.assertEquals(viewSystemUserPage.getResultListText(), "Admin");
    }

    @Test
    public void verifyThatAdminShouldDeleteTheUserSuccessfully() throws InterruptedException {

        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickOnLoginButton();
        homePage.clickOnAdminLink();
        Assert.assertEquals(viewSystemUserPage.getSystemUsersText(), "System Users");
        addUserPage.enterUsername("Admin");
        addUserPage.selectUserRoleAdminFromDropDown();
        addUserPage.selectStatusEnableFromDropDown();
        viewSystemUserPage.clickOnSearchButton();
        Assert.assertEquals(viewSystemUserPage.getResultListText(), "Admin");
        viewSystemUserPage.clickOnCheckbox();// Get xpath
        viewSystemUserPage.clickOnDeleteButton();//Get xpath

        Thread.sleep(2000);
    }

    @Test
    public void searchTheDeletedUserAndVerifyTheMessageNoRecordFound() throws InterruptedException {
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickOnLoginButton();
        homePage.clickOnAdminLink();
        Assert.assertEquals(viewSystemUserPage.getSystemUsersText(), "System Users");
        addUserPage.enterUsername("Admin");
        addUserPage.selectUserRoleAdminFromDropDown();
        addUserPage.selectStatusEnableFromDropDown();
        viewSystemUserPage.clickOnSearchButton();

    }
}
