import java.util.*;
public class Student<T>{
    String name;
    double height;
    double weight;
    Student(String name,double height,double weight){
        this.name=name;
        this.height=height;
        this.weight=weight;
    }
    public String toString(){
        return name+" "+height+" "+weight;
    }
}


