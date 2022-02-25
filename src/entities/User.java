package entities;

import java.util.Objects;

public abstract class User {
    private String ownerName;
    private String email;
    private Long phoneNumber;
    private Double balance;

    public User() {}

    public User(String ownerName, String email, Long phoneNumber, Double balance) {
        this.ownerName = ownerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return ownerName.equals(user.ownerName) && email.equals(user.email) && phoneNumber.equals(user.phoneNumber) && balance.equals(user.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ownerName, email, phoneNumber, balance);
    }

    @Override
    public String toString() {
        return "User{" +
                "ownerName='" + ownerName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", balance=" + balance +
                '}';
    }
}