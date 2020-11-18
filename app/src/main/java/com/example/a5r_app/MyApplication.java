package com.example.a5r_app;
import android.app.Application;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MyApplication extends Application {

    /*
        MAIN CODES:
        P = Plastics
        M = Metals
        E = Electronics
        G = Glass

        SUB CODES:
        DB = Drink Bottles
        B = Batteries
     */

     public ArrayList<String> prodNames = new ArrayList<String>();
     //public ArrayList<Integer> prodIds = new ArrayList<Integer>();
     private String mainCode;
     private String subCode;
     private int productCode;
     private String zipText;
     private int locCode;

    public String getMainCode() {
        return mainCode;
    }

    public void setMainCode(String someVariable) {
        this.mainCode = someVariable;
    }

    public String getSubCode() {
        return subCode;
    }

    public void setSubCode(String someVariable) {
        this.subCode = someVariable;
    }

    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int someVariable) {
        this.productCode = someVariable;
    }

    public int getLocCode() {
        return locCode;
    }

    public void setLocCode(int someVariable) {
        this.locCode = someVariable;
    }

    public void setZipText(String someVariable) {
        this.zipText = someVariable;
    }

    public String getZipText() {
        return zipText;
    }

}