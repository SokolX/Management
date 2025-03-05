package pl.sokolx.models.parser;

import pl.sokolx.models.enums.RoleType;
import pl.sokolx.models.User;

public class UserParser {

    public static User stringToUser(String readLine) {
        String [] userInformations = readLine.split(User.USER_SEPARATOR);

        Long userId = Long.parseLong(userInformations[0]);
        String login = userInformations[1];
        String password = userInformations[2];
        String firstName = userInformations[3];
        String lastName = userInformations[4];
        RoleType roleType = RoleType.valueOf(userInformations[5]);

        return new User(userId, login, password, firstName, lastName, roleType);
    }
}
