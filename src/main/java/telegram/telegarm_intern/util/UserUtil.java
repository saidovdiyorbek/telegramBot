package telegram.telegarm_intern.util;

public class UserUtil {

    public static boolean isValidPassword(String password) {
        if (password.length() < 6) {
            return false;
        }
        return true;
    }
}
