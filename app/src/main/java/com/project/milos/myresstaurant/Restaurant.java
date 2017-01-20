package com.project.milos.myresstaurant;

import android.graphics.Bitmap;
import android.location.Address;

import java.net.URL;
import java.util.List;

/**
 * Created by Miloš on 1/6/2017.
 */

public class Restaurant {
    private int id;
    private String name;
    private String description;
    private Bitmap smallPhoto;
    private Bitmap largePhoto;
    private String address;
    private int startHour;
    private int startMinute;
    private int endHour;
    private int endMinute;
    private String phone;
    private String email;
    private String site;
    private List<Meal> meals;

    public Restaurant(){

    }

    public Restaurant(int id, String name, String description, String address, int startHour, int startMinute, int endHour, int endMinute, String phone, String email, String site, List<Meal> meals) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.address = address;
        this.startHour = startHour;
        this.startMinute = startMinute;
        this.endHour = endHour;
        this.endMinute = endMinute;
        this.phone = phone;
        this.email = email;
        this.site = site;
        this.meals = meals;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Bitmap getSmallPhoto() {
        return smallPhoto;
    }

    public void setSmallPhoto(Bitmap smallPhoto) {
        this.smallPhoto = smallPhoto;
    }

    public Bitmap getLargePhoto() {
        return largePhoto;
    }

    public void setLargePhoto(Bitmap largePhoto) {
        this.largePhoto = largePhoto;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStartHour() {
        return startHour;
    }

    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

    public int getStartMinute() {
        return startMinute;
    }

    public void setStartMinute(int startMinute) {
        this.startMinute = startMinute;
    }

    public int getEndHour() {
        return endHour;
    }

    public void setEndHour(int endHour) {
        this.endHour = endHour;
    }

    public int getEndMinute() {
        return endMinute;
    }

    public void setEndMinute(int endMinute) {
        this.endMinute = endMinute;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }
}
