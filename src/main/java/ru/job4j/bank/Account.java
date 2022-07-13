package ru.job4j.bank;

import java.util.Objects;

/**
 *  Класс описывает модель банковского счета. Эта модель содержит поля: баланс и реквизиты.
 *  @author Konstantin Vyazovchenko
 *  @version 1.0
 */

public class Account {

    private String requisite;
    private double balance;

    /**
     * Конструктор аккаунта
     * @param
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Геттеры и сеттеры
     * @return
     */
    public String getRequisite() {
        return requisite;
    }

    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Переопределение equals и hashCode()
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}