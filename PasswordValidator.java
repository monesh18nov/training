public class PasswordValidator {

    public boolean isValid(String password) {

        if (password == null) {
            return false;
        }

        String regex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z0-9]).{8,}$";

        return password.matches(regex);
    }
}