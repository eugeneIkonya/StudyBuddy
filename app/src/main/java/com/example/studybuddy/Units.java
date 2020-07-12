package com.example.studybuddy;

public class Units {

    private String unit_name;
    private String lecturer;
    private String lecturer_email;
    private String unit_progress;
    private String image;

    public Units(String unit_name, String lecturer, String lecturer_email, String unit_progress, String image) {
        this.unit_name = unit_name;
        this.lecturer = lecturer;
        this.lecturer_email = lecturer_email;
        this.unit_progress = unit_progress;
        this.image = image;
    }

    public String getUnit_name() {
        return unit_name;
    }

    public String getLecturer() {
        return lecturer;
    }

    public String getLecturer_email() {
        return lecturer_email;
    }

    public String getUnit_progress() {
        return unit_progress;
    }

    public String getImage() {
        return image;
    }
}
