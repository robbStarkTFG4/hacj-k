/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autoparts.named;

import com.autoparts.util.Car;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
import org.primefaces.json.JSONException;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;

/**
 *
 * @author NORE
 */
@Named("util")
@SessionScoped
public class UtilBean implements Serializable {

    private final static String[] colors;
    private final static String[] brands;
    private List<Car> getCars;
    private List<Review> reviewsList;
    private Object[] targetsArray;
    private String jsonData;

    static {
        colors = new String[10];
        colors[0] = "Black";
        colors[1] = "White";
        colors[2] = "Green";
        colors[3] = "Red";
        colors[4] = "Blue";
        colors[5] = "Orange";
        colors[6] = "Silver";
        colors[7] = "Yellow";
        colors[8] = "Brown";
        colors[9] = "Maroon";

        brands = new String[10];
        brands[0] = "BMW";
        brands[1] = "Mercedes";
        brands[2] = "Volvo";
        brands[3] = "Audi";
        brands[4] = "Renault";
        brands[5] = "Fiat";
        brands[6] = "Volkswagen";
        brands[7] = "Honda";
        brands[8] = "Jaguar";
        brands[9] = "Ford";
    }

    public UtilBean() {
        getCars = createCars(15);
        reviewsList = createReviews(5);
        constructList();

    }

    public List<Car> createCars(int size) {
        List<Car> list = new ArrayList<Car>();
        for (int i = 0; i < size; i++) {
            list.add(new Car(getRandomId(), getRandomBrand(), getRandomYear(), getRandomColor(), getRandomPrice(), getRandomSoldState()));
        }

        return list;
    }

    private List<Review> createReviews(int i) {
        List<Review> revs = new ArrayList<>();
        for (int j = 0; j < i; j++) {
            Review temp = new Review(5, "marco isaac", "The story begins as Don Vito Corleone, the head of a New York Mafia family, oversees his daughter's wedding. His beloved son Michael has just come home from the war, but does not intend to become part of his father's business. T hrough Michael's life the nature of the family business becomes clear. The business of the family is just like the head of the family, kind and benevolent to those who give respect, but given to ruthless violence whenever anything stands against the good of the family.");
            revs.add(temp);
        }
        return revs;
    }

    private String getRandomId() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

    private int getRandomYear() {
        return (int) (Math.random() * 50 + 1960);
    }

    private String getRandomColor() {
        return colors[(int) (Math.random() * 10)];
    }

    private String getRandomBrand() {
        return brands[(int) (Math.random() * 10)];
    }

    public int getRandomPrice() {
        return (int) (Math.random() * 100000);
    }

    public boolean getRandomSoldState() {
        return (Math.random() > 0.5) ? true : false;
    }

    public List<String> getColors() {
        return Arrays.asList(colors);
    }

    public List<String> getBrands() {
        return Arrays.asList(brands);
    }

    public List<Car> getGetCars() {
        return getCars;
    }

    public List<Review> getReviewsList() {
        return reviewsList;
    }

    private void constructList() {
        //var cars=[7.0, 6.9, 9.5, 14.5, 7, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9,9.6] ;
        List<Double> list = new ArrayList<>();
        list.add(7.0);
        list.add(6.9);
        list.add(9.5);
        list.add(7.0);
        list.add(7.0);
        list.add(7.0);
        list.add(7.0);
        list.add(7.0);
        list.add(7.0);
        list.add(7.0);
        list.add(7.0);
        list.add(7.0);
        targetsArray = list.toArray();
    }

    public String loadData() throws JSONException {
        RequestContext requestContext = RequestContext.getCurrentInstance();
        this.jsonData = new org.primefaces.json.JSONArray(targetsArray, true).toString();
        requestContext.addCallbackParam("tararray", jsonData);
        System.out.println("JSON: " + jsonData);
        return "dashboard2?faces-redirect=true";
    }

    public String getJsonData() {
        return jsonData;
    }

    public void setJsonData(String jsonData) {
        this.jsonData = jsonData;
    }
}
