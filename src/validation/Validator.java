package validation;

import exception.NotInRangeException;
import exception.NotNullException;

public class Validator {

    public static void validateString(String value, String fieldName)
            throws NotNullException {

        if (value == null || value.trim().isEmpty()) {
            throw new NotNullException(fieldName + " cannot be null or empty.");
        }
    }

    public static void validatePositiveAmount(double amount)
            throws NotInRangeException {

        if (amount <= 0) {
            throw new NotInRangeException("Amount must be greater than 0.");
        }
    }

    public static void validateNip(int nip)
            throws NotInRangeException {

        if (nip < 1000 || nip > 99999) {
            throw new NotInRangeException("NIP must be between 1000 and 99999.");
        }
    }

    public static void validateId(long id)
            throws NotInRangeException {

        if (id <= 0) {
            throw new NotInRangeException("ID must be greater than 0.");
        }
    }
}