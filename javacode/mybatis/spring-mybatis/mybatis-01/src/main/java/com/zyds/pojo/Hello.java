package com.zyds.pojo;

public class Hello {
    private String world;

    public String getWorld() {
        return world;
    }

    public void setWorld(String world) {
        this.world = world;
    }

    @Override
    public String toString() {
        return "Hello{" +
                "world='" + world + '\'' +
                '}';
    }
}
