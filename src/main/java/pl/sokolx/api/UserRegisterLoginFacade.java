package pl.sokolx.api;

import pl.sokolx.models.User;

public interface UserRegisterLoginFacade {

    public String registerUser(User user);

    public boolean loginUser(String login, String password);
}
