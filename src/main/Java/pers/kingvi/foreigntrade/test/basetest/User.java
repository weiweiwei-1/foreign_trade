package pers.kingvi.foreigntrade.test.basetest;

import org.junit.Test;

public class User {
    private String username;
    private int age;
    private String address;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    @Test
    public void testUser() {
        User user = new User();
        user.setAddress("adad");
        user.setAge(18);
        System.out.println(user.toString());
    }
}
