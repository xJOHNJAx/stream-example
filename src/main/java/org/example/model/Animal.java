package org.example.model;

public class Animal {
    private int id;

    private String breed;

    private int age;

    private String origin;

    private String gender;

    public Animal() {}

    public Animal(int id, String breed, int age, String origin, String gender) {
        this.id = id;
        this.breed = breed;
        this.age = age;
        this.origin = origin;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getbreed() {
        return breed;
    }

    public void setbreed(String breed) {
        this.breed = breed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Animal{id=" + id + ", breed='" + breed + "', age=" + age + ", origin='" + origin + "', gender='"
            + gender +  "'}";
    }
}
