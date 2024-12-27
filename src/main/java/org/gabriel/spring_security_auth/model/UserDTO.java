package org.gabriel.spring_security_auth.model;

public class UserDTO {

    private final Long id;
    private final String username;

    public UserDTO(User user) {
        this.id = user.getId();
        this.username = user.getUsername();

    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }
}
