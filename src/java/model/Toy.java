/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author lequa
 */
public class Toy implements Serializable{
    private int id, idType;
    private String name, age, image;
    private float price;

    public Toy() {
    }

    public Toy(int id, int idType, String name, String age, String image, float price) {
        this.id = id;
        this.idType = idType;
        this.name = name;
        this.age = age;
        this.image = image;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
//    public Object[] toObject(){
//        return new Object[]{
//            id, idType, name, age,  price
//        };
//    }
    public Object[] toObject(){
        return new Object[]{
        
    };
    }
    
}
