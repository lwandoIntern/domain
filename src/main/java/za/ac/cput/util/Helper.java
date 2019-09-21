package za.ac.cput.util;

import java.util.UUID;

public class Helper {
    public static String generateRandomGivenSuffix(String suffix) {
        return suffix + "-" + UUID.randomUUID().toString();
    }

    public static String getClassName(Class<?>  aClass) {
        return aClass.getSimpleName();
    }

    public static String getSuffixFromClassName(Class<?> aClass) {
        String className = getClassName(aClass);
        String suffix = "";
        int length = className.length();
        for (int i = 0; i < length; i++) {
            char c = className.charAt(i);
            if (Character.isUpperCase(c)) suffix += c;
        }
        return suffix;
    }
}
