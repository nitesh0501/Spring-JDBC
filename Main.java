package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(Appconfig.class);

        Daoclass obj=context.getBean(Daoclass.class);

        //Create table
        obj.createTable();



        //Inserting values into table
        obj.insertValues(new Student(1,"Nitesh",24));
        obj.insertValues(new Student(2,"Naveen",23));
        obj.insertValues(new Student(3,"Ram",24));
        obj.insertValues(new Student(4,"Rani",60));
        obj.insertValues(new Student(5,"abc",12));
        obj.insertValues(new Student(6,"cde",30));

        // Select all Values
        List<Map<String,Object>> list=obj.selectAll();
        for(Map<String,Object> row:list){
            System.out.println(row);
        }

        // Select single value
        Map<String,Object> map=obj.selectOne(4);
        for (Map.Entry<String, Object> row : map.entrySet()) {
            System.out.print(row.getKey() + " = " + row.getValue());
        }



        // Update values
        obj.updateValues("Raju",3);

        //Delete Values
        obj.deleteValues(2);

        System.out.println("CRUD Success");

    }
}