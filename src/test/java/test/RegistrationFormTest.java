package test;

import pages.component.RegistrationPage;
import org.junit.jupiter.api.Test;

public class RegistrationFormTest extends BaseTest {

    RegistrationPage registrationPage = new RegistrationPage();
    UserData userData = new UserData();

    @Test
    void regFormFillAllSuccessTest() {

        registrationPage.openPage()
                .removeBanners()
                .setFirstName(userData.firstName)
                .setLastName(userData.lastName)
                .setEmail(userData.userEmail)
                .setGender(userData.gender)
                .setMobile(userData.mobile)
                .setDateOfBirth(userData.birthDay, userData.birthMonth, userData.birthYear)
                .setSubjects(userData.selectedSubjects)
                .setHobbies(userData.selectedHobbies)
                .uploadPicture(userData.picture1)
                .setAddress(userData.address1)
                .setState(userData.state)
                .setCity(userData.city)
                .submitForm();

        registrationPage.checkResultTableOpened()
                .checkSubmittedValue("Student Name", userData.firstName + " " + userData.lastName)
                .checkSubmittedValue("Student Email", userData.userEmail)
                .checkSubmittedValue("Gender", userData.gender)
                .checkSubmittedValue("Mobile", userData.mobile)
                .checkSubmittedValue("Date of Birth", userData.birthDay + " " + userData.birthMonth + "," + userData.birthYear)
                .checkSubmittedValue("Subjects", String.join(", ", userData.selectedSubjects))
                .checkSubmittedValue("Hobbies", String.join(", ", userData.selectedHobbies))
                .checkSubmittedValue("Picture", userData.picture1)
                .checkSubmittedValue("Address", userData.address1)
                .checkSubmittedValue("State and City", userData.state + " " + userData.city);
    }

    @Test
    void regFormFillMinSuccessTest() {

        registrationPage.openPage()
                .removeBanners()
                .setFirstName(userData.firstName)
                .setLastName(userData.lastName)
                .setGender(userData.gender)
                .setMobile(userData.mobile)
                .submitForm();

        registrationPage.checkResultTableOpened()
                .checkSubmittedValue("Student Name", userData.firstName + " " + userData.lastName)
                .checkSubmittedValue("Gender", userData.gender)
                .checkSubmittedValue("Mobile", userData.mobile);

    }


}