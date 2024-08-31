public class UserValidator {

    public static void validateUser(String login, String password, String confirmPassword)
            throws WrongLoginException, WrongPasswordException {

        // Проверка логина
        if (login == null || login.length() == 0 || login.length() > 20 ||
                !login.matches("[a-zA-Z0-9_]+")) {
            throw new WrongLoginException("Invalid login: must be 20 characters or less and only contain letters, digits, and underscores.");
        }

        // Проверка пароля
        if (password == null || password.length() == 0 || password.length() > 20 ||
                !password.matches("[a-zA-Z0-9_]+")) {
            throw new WrongPasswordException("Invalid password: must be 20 characters or less and only contain letters, digits, and underscores.");
        }

        // Проверка на совпадение паролей
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Passwords do not match.");
        }
    }

    public static void main(String[] args) {
        try {
            validateUser("java_skypro_go", "D_1hWiKjjP_9", "D_1hWiKjjP_9");
            System.out.println("User is valid.");
        } catch (WrongLoginException | WrongPasswordException e) {
            System.err.println(e.getMessage());
        }
    }
}