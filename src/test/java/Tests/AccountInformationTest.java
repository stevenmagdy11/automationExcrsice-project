package Tests;

import BaseTest.BaseTest;
import Pages.AccountInformationPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AccountInformationTest extends BaseTest
{
    @DataProvider(name = "accountInfoData")
    public Object[][] accountInfoData() {
        return new Object[][] {
                {
                        "male", "steven", "steve123@gmail.com", "steve123456",
                        "10", "May", "1995", true,
                        "Steven", "maged", "TechCompany", "123 Street", "Suite 5",
                        "Egypt", "Cairo", "Helwan", "12345", "0123456789"
                },
                {
                        "female", "anna", "anna123@gmail.com", "anna123456",
                        "20", "June", "1990", true,
                        "Anna", "Taylor", "BizCorp", "456 Avenue", "Apt 10",
                        "USA", "New York", "Brooklyn", "54321", "0987654321"
                }
        };
    }
    @Test(dataProvider = "accountInfoData")
    public void fillAccountInformationTest(
            String gender, String name, String email, String password,
            String day, String month, String year,
            boolean newsletter,
            String firstName, String lastName, String company,
            String address1, String address2,
            String country, String state, String city,
            String zipcode, String mobileNumber
    ) {

            signUpPage=homePage.signUpPage();
            signUpPage.setNameUserSignupLocator("steve");
            signUpPage.setEmailOfSignUpLocator("steve122@gmail.com");
           signUpPage.clickSignUpButton();
        AccountInformationPage accountPage = new AccountInformationPage(driver);

        Assert.assertEquals(accountPage.getActualTitleOfAccountPage(),accountPage.getExpectedTitleOfAccountPage(),"invalidation ");



        if (gender.equalsIgnoreCase("male"))
        {
            accountPage.selectMaleGender();
        }
        else
        {
            accountPage.selectFemaleGender();
        }

        accountPage.setName(name);
        accountPage.setEmail(email);
        accountPage.setPassword(password);
        accountPage.setDay(day);
        accountPage.setMonth(month);
        accountPage.setYear(year);

        if (newsletter)
        {
            accountPage.clickNewsletter();
        }


        accountPage.setFirstName(firstName);
        accountPage.setLastName(lastName);
        accountPage.setCompany(company);
        accountPage.setAddressOne(address1);
        accountPage.setAddressTwo(address2);
        accountPage.setCountry(country);
        accountPage.setState(state);
        accountPage.setCity(city);
        accountPage.setZipcode(zipcode);
        accountPage.setMobileNumber(mobileNumber);

        accountPage.clickCreateAccount();
    }



}
