package com.example.lab1.models;

public class Author {
    private long _id;
    private String _fullName;

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String get_fullName() {
        return _fullName;
    }

    public void set_fullName(String _fullName) {
        this._fullName = _fullName;
    }

    public Author(int id, String fullName) {
        this._id = id;
        this._fullName = fullName;
    }
}
