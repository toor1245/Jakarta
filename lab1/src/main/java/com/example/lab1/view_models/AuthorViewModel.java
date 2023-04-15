package com.example.lab1.view_models;

public class AuthorViewModel {
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

    public AuthorViewModel(int id, String fullName) {
        this._id = id;
        this._fullName = fullName;
    }
}
