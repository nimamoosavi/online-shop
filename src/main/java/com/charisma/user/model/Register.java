package com.charisma.user.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public final class Register {

    private final String user;

    private final String password;

}
