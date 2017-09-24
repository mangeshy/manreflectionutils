package com.mansoft.reflection.utils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by mangesh_y on 24/09/2017.
 */
public class ReflectionUtility {

    public static void main(String[] args) throws  Exception{
    TemplateObject templateObject = new TemplateObject();
        templateObject.setId(10);
        templateObject.setLongId(100);

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("mangesh");
        arrayList.add("test");

        templateObject.setListString(arrayList);
    HashMap<String,String> fieldNameValues = new HashMap();
        List<String> printeableproperties = new ArrayList<>();
        printeableproperties.add("id");
        printeableproperties.add("longId");
        printeableproperties.add("listString");
    Field[] fields = templateObject.getClass().getDeclaredFields();

    HashMap<String,String> fieldValues = new HashMap<>();
    Stream.of(templateObject.getClass().getDeclaredFields()).
                filter(field -> printeableproperties.contains(field.getName())).forEach(field -> getValue(field, templateObject,fieldValues));
    fieldValues.keySet().stream().forEach(v->System.out.println("key is "+ v+ "the value is "+ fieldValues.get(v)));

}

public  static void getValue(Field field,Object parent,HashMap<String,String> fieldValueMap){
    Object value=null;
    try {
        Class<?> fieldType = field.getType();
        field.setAccessible(true);
        if (fieldType == java.lang.String.class) {
            value = (String) field.get(parent);
        }else if (fieldType == java.lang.Double.class) {
             value = (Double) field.get(parent);
            fieldValueMap.put(field.getName(),(value == null ? "" : value.toString()));

        }else if (fieldType == java.lang.Long.class || fieldType == long.class) {
            value = (Long) field.get(parent);

        }
        else if (fieldType == java.lang.Integer.class || fieldType == int.class) {
             value = (Integer) field.get(parent);

        } else if (fieldType == java.lang.String.class) {
             value = (String) field.get(parent);

        } else if (java.util.Map.class.isAssignableFrom(fieldType)) {
            ParameterizedType genericType = (ParameterizedType) field.getGenericType();
            Class<?> actualValueType = (Class<?>) genericType.getActualTypeArguments()[0];

            if (actualValueType == String.class) {
                System.out.println("the map value obtaines is" + actualValueType);
                List<String> stringList = null;
            }
        } else if (java.util.List.class.isAssignableFrom(fieldType)) {
            ParameterizedType genericType = (ParameterizedType) field.getGenericType();
            Class<?> actualValueType = (Class<?>) genericType.getActualTypeArguments()[0];
            System.out.println("Y     " +genericType.getTypeName());
            if(genericType.getTypeName().contains("ArrayList"))
            {
                System.out.println("Yes Arralylist is the generic rtoe");
            }
            if (actualValueType == String.class) {
                System.out.println("the map value obtaines is" + actualValueType);
                List<String> stringList = (ArrayList<String>) field.get(parent);
                StringBuffer stringBuffer = new StringBuffer(" ");
                stringList.stream().forEach(s->stringBuffer.append(s).append(","));
                value =          stringBuffer.toString().substring(0,stringBuffer.length());
            }
        }
    }catch (Exception e){
        e.printStackTrace();
    }
    fieldValueMap.put(field.getName(),(value == null ? "" : value.toString()));
}
}
