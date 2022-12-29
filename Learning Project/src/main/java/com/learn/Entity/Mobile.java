package com.learn.Entity;

public class Mobile {
    int id;
    String name;
    int ram;
    int externalStorage;

    public Mobile() {
    }

    public Mobile(int id, String name, int ram, int externalStorage) {
        this.id = id;
        this.name = name;
        this.ram = ram;
        this.externalStorage = externalStorage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getExternalStorage() {
        return externalStorage;
    }

    public void setExternalStorage(int externalStorage) {
        this.externalStorage = externalStorage;
    }
}
