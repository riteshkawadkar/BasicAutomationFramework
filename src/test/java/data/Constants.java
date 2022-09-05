package data;

import com.github.javafaker.Faker;

import java.nio.file.Paths;

public class Constants {

    static Faker faker = new Faker();

    //LoginPage
    public static final String LOGINPAGE_URL = "https://demo.openmrs.org/openmrs/referenceapplication/login.page";
    public static final String LOGINPAGE_URL_AFTER_LOGOUT = "https://demo.openmrs.org/openmrs/login.htm";
    public static final String USERNAME = "Admin";
    public static final String USERNAME_INVALID = "admin";
    public static final String PASSWORD = "Admin123";
    public static final String PASSWORD_INVALID = "Ad123";


    //HomePage
    public static final String HOMEPAGE_URL = "https://demo.openmrs.org/openmrs/referenceapplication/home.page";
    public static final String VALIDATION_MESSAGE = "Logged in as Super User (admin) at Inpatient Ward.";


    //RegisterPatient
    public static final String GIVEN = faker.name().firstName();
    public static final String FAMILYNAME = faker.name().lastName();
    public static final String GENDER = "Male";
    public static final String BIRTHDATE = String.valueOf(faker.number().numberBetween(1,28));
    public static final String BIRTHMONTH = String.valueOf(faker.number().numberBetween(1,12));
    public static final String BIRTHYEAR = String.valueOf(faker.number().numberBetween(1900,2022));
    public static final String ADDRESS1 = faker.address().buildingNumber();
    public static final String ADDRESS2 = faker.address().streetAddress();
    public static final String CITY = faker.address().city();
    public static final String STATE = faker.address().state();
    public static final String COUNTRY = faker.address().country();
    public static final String POSTALCODE = faker.address().zipCode();
    public static final String PHONE = faker.phoneNumber().subscriberNumber(10);
    public static final String RELATIONSHIPTYPE = "Parent";
    public static final String RELATIONSHIPPERSON = faker.name().fullName();




    //PatientPage
    public static String PatientIdentifier = "1000MJ";
    public static String InCorrectPatientIdentifier = "ZZZZZZ";


    //Appointment Page
    public static final String APPOINTMENT_TYPE = "General Medicine";
    public static final String NOTES = "General Notes";
    public static final String ATTACHMENT_PATH = Paths.get(".").normalize().toAbsolutePath() + "\\src\\test\\resources\\attachment.txt";


    //Delete
    public static final String DELETE_REASON = "Testing Purpose";
    


}
