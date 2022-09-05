package exceptions;

public class PatientNotFoundException extends Exception {

    public PatientNotFoundException(String id) {
        super("Patient with identifier - '" + id + "' Not Found");
    }

}
