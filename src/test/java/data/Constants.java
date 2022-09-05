package data;

import com.github.javafaker.Faker;

public class Constants {

    Faker faker = new Faker();
    public static final String APPLICATION_URL = "https://demo.openmrs.org/openmrs/";

    //LoginPage
    public static final String LOGINPAGE_URL = "https://demo.openmrs.org/openmrs/referenceapplication/login.page";
    public static final String LOGINPAGE_URL_AFTER_LOGOUT = "https://demo.openmrs.org/openmrs/login.htm";
    public static final String USERNAME = "Admin";
    public static final String USERNAME_INVALID = "admin";
    public static final String PASSWORD = "Admin123";
    public static final String PASSWORD_INVALID = "Ad123";
    public static final String LOCATION = "Inpatient ward";

    //HomePage
    public static final String HOMEPAGE_URL = "https://demo.openmrs.org/openmrs/referenceapplication/home.page";
    public static final String VALIDATION_MESSAGE = "Logged in as Super User (admin) at Inpatient Ward.";

    //RegisterPatient
    public static final String REGISTERPAGE_URL = "https://demo.openmrs.org/openmrs/registrationapp/registerPatient.page?appId=referenceapplication.registrationapp.registerPatient";
    public static final String GIVEN = "TestName";
    public static final String FAMILYNAME = "TestFamily";
    public static final String GENDER = "Male";
    public static final String BIRTHDATE = "11";
    public static final String BIRTHMONTH = "October";
    public static final String BIRTHYEAR = "1988";
    public static final String ADDRESS1 = "Flat - 111";
    public static final String ADDRESS2 = "Test Steet";
    public static final String CITY = "City";
    public static final String STATE = "State";
    public static final String COUNTRY = "Country";
    public static final String POSTALCODE = "411057";
    public static final String PHONE = "1234567890";
    public static final String RELATIONSHIPTYPE = "Parent";
    public static final String RELATIONSHIPPerson= "Parent name";



    //PatientPage
    public static final String PATIENTPAGE_URL = "https://demo.openmrs.org/openmrs/coreapps/clinicianfacing/patient.page?patientId=";


}
