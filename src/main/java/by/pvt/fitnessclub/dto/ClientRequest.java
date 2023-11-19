package by.pvt.fitnessclub.dto;

import lombok.Data;

@Data
public class ClientRequest {
    private Long id;
    private String name;
    private String surname;
    private Integer age;
    private String login;
    private String password;
    private String role;
}
