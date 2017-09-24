package com.mansoft.reflection.utils;

import jdk.internal.org.objectweb.asm.tree.InnerClassNode;

import java.util.*;

/**
 * Created by mangesh_y on 24/09/2017.
 */
public class TemplateObject {
    @PDFPrintable(classType = java.lang.Integer.class)
    private int id;
    @PDFPrintable()
    private long longId;
    @PDFPrintable
    private float floatTotalSales;
    @PDFPrintable
    private double doubleTotalSales;
    @PDFPrintable
    private Integer objId;
    @PDFPrintable
    private Long longObjId;
    @PDFPrintable
    private Float floatObjTotalSales;
    private Double doubleObjTotalSales;
    private String stringObject;
    @PDFPrintable
    private List<String> listString;
    @PDFPrintable
    private Set<String> setString;
    private Map<String,String> mapString;
     class innerClass {
         private int id=1;
     }
     private Map<String,innerClass> mapBespokeObject;
    TemplateObject() {
        this.id = 1;
        this.longId = 1;
        this.floatTotalSales = 100.00F;
        this.doubleTotalSales = 100.00D;
        this.objId = new Integer(1);
        this.longObjId = new Long(1);
        this.floatObjTotalSales = new Float(100.0F);
        this.doubleObjTotalSales = new Double((100.00F));
        this.stringObject = "StringObject";
        this.listString = new ArrayList<String>();
        listString.add("listString1");
        this.setString = new HashSet<>();
        this.setString.add("setString1");
        this.mapString = new HashMap<String, String>();
        this.mapString.put("stringObject1", "stringObject1");
        this.mapBespokeObject = new HashMap<String,innerClass>();
        this.mapBespokeObject.put("stringObject1",new innerClass());
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getLongId() {
        return longId;
    }

    public void setLongId(long longId) {
        this.longId = longId;
    }

    public float getFloatTotalSales() {
        return floatTotalSales;
    }

    public void setFloatTotalSales(float floatTotalSales) {
        this.floatTotalSales = floatTotalSales;
    }

    public double getDoubleTotalSales() {
        return doubleTotalSales;
    }

    public void setDoubleTotalSales(double doubleTotalSales) {
        this.doubleTotalSales = doubleTotalSales;
    }

    public Integer getObjId() {
        return objId;
    }

    public void setObjId(Integer objId) {
        this.objId = objId;
    }

    public Long getLongObjId() {
        return longObjId;
    }

    public void setLongObjId(Long longObjId) {
        this.longObjId = longObjId;
    }

    public Float getFloatObjTotalSales() {
        return floatObjTotalSales;
    }

    public void setFloatObjTotalSales(Float floatObjTotalSales) {
        this.floatObjTotalSales = floatObjTotalSales;
    }

    public Double getDoubleObjTotalSales() {
        return doubleObjTotalSales;
    }

    public void setDoubleObjTotalSales(Double doubleObjTotalSales) {
        this.doubleObjTotalSales = doubleObjTotalSales;
    }

    public String getStringObject() {
        return stringObject;
    }

    public void setStringObject(String stringObjectl) {
        this.stringObject = stringObjectl;
    }

    public List<String> getListString() {
        return listString;
    }

    public void setListString(List<String> listString) {
        this.listString = listString;
    }

    public Set<String> getSetString() {
        return setString;
    }

    public void setSetString(Set<String> setString) {
        this.setString = setString;
    }

    public Map<String, String> getMapString() {
        return mapString;
    }

    public void setMapString(Map<String, String> mapString) {
        this.mapString = mapString;
    }

    public Map<String, innerClass> getMapBespokeObject() {
        return mapBespokeObject;
    }

    public void setMapBespokeObject(Map<String, innerClass> mapBespokeObject) {
        this.mapBespokeObject = mapBespokeObject;
    }
}
