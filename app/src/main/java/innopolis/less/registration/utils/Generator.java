package innopolis.less.registration.utils;

public class Generator {
    public static Long generateId() {
        return System.currentTimeMillis() + (long) (Math.random() * 100);
    }

    public static int generateHash(Object value) {
        return (21 + value.hashCode() * 41);
    }
}
