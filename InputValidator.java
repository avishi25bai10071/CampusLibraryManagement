
package library;

public class InputValidator {

    public static boolean isValidName(String name) {

        return name != null && !name.trim().isEmpty();
    }

    public static boolean isValidEmail(String email) {

        return email != null
                && email.matches(
                        "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"
                );
    }

    public static boolean isValidId(int id) {

        return id > 0;
    }

    public static boolean isValidText(String text) {

        return text != null && !text.trim().isEmpty();
    }
}