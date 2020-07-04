package com.example.studybuddy;

public class Unit {

    private String unit_name;
    private String lecturer;
    private String lecturer_email;
    private int unit_progress;
    private String unit_objectives;

    public Unit( String unit_name, String lecturer, String lecturer_email, int unit_progress, String unit_objectives) {

        this.unit_name = unit_name;
        this.lecturer = lecturer;
        this.lecturer_email = lecturer_email;
        this.unit_progress = unit_progress;
        this.unit_objectives = unit_objectives;
    }


    public String getUnitName() {
        return unit_name;
    }

    public String getLecturer() {
        return lecturer;
    }

    public String getLecturerEmail() {
        return lecturer_email;
    }

    public int getUnitProgress() {
        return unit_progress;
    }

    public String getUnitObjectives() {
        return unit_objectives;
    }
}
