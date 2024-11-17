package se.yrgo.libraryapp.validators;

import java.util.regex.Pattern;

/**
 * This validator checks that the username match our high standard for proper
 * names.
 * 
 * I.e. no funny characters or whitespace and at least four characters long.
 */
public final class Username {
    private static Pattern regex = Pattern.compile("[-_@.a-zA-Z0-9]{4,}"); // place the -_ first or it might interpret
                                                                           // the - wrongly.

    private Username() {
    }

    /**
     * Validates if the given name is a valid username.
     * 
     * A username should be at least four characters long and only
     * contain ASCII letters, numbers and the characters @, ., _ and -.
     * It should not contain any other letters, not even whitespace.
     * 
     * @param name the name to check
     * @return true if valid, false if not
     * 
     */
    public static boolean validate(String name) {
        return regex.matcher(name).matches();
    }
}
