package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class User {
    String userName;
    String email;
    String firstName;
    String lastName;
    String phone;
    String homePage;
    String password;
}
