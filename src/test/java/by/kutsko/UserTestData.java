package by.kutsko;

import by.kutsko.domain.User;
import by.kutsko.matcher.ModelMatcher;

import java.util.Objects;

import static by.kutsko.domain.BaseEntity.START_SEQ;

/**
 * Created by vasily on 23.01.2017.
 */
public class UserTestData {

    public static final int USER_ID = START_SEQ;
    public static final int ADMIN_ID = START_SEQ + 1;

    public static final User USER = new User(USER_ID, "User", "user@yandex.ru", "password");
    public static final User ADMIN = new User(ADMIN_ID, "Admin Василий", "admin@gmail.com", "admin");

    public static final ModelMatcher<User> MATCHER = ModelMatcher.of(User.class,
            (expected, actual) -> expected == actual ||
                    (Objects.equals(expected.getId(), actual.getId())
                            && Objects.equals(expected.getName(), actual.getName())
                            && Objects.equals(expected.getEmail(), actual.getEmail())
                    )
    );
}
