package by.kutsko;

import by.kutsko.domain.BaseEntity;

/**
 * Created by Vasili on 029 29.01.17.
 */
public class AuthorizedUser {
    public static int id = BaseEntity.START_SEQ;

    public static int id() {
        return id;
    }

    public static void setId(int id) {
        AuthorizedUser.id = id;
    }
}
