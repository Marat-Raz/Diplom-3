package usermodel;

import org.apache.commons.lang3.RandomStringUtils;

public class UserGenerator {
    public static String email = RandomStringUtils.randomAlphabetic(8) + "@ya.ru";
    public static String password = RandomStringUtils.randomAlphabetic(8);
    public static String name = RandomStringUtils.randomAlphabetic(7);

    public static User getUser() {
        return new User(email, password, name);
    }

    public static User getUserWithIncorrectPassFive() {
        return new User(email + "@yandex.ru", RandomStringUtils.randomAlphabetic(5), name);
    }


}
