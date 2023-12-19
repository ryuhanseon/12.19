package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Member {

    private int memberId;
    private String userId;
    private String password;
    private String passwordConfirm;




}
