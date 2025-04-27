package com.slash.copsboot.user;

public record CreateUserParameters(AuthServerId authServerId, String email, String mobileToken) {
}
