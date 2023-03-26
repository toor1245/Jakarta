package com.example.lab1;

public class StudentViewModel {
    private String _name;
    private String _imageUrl;

    public String get_name() {
        return _name;
    }

    public String get_imageUrl() {
        return _imageUrl;
    }

    public StudentViewModel(String name, String imageUrl) {
        _name = name;
        _imageUrl = imageUrl;
    }
}
