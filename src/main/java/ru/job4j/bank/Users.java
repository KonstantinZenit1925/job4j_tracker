package ru.job4j.bank;

import java.util.Objects;

public class Users {
    private String passport;
    private String username;

    public Users(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    public String getPassports() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getUsernames() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users user = (Users) o;
        return Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
