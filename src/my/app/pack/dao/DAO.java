package my.app.pack.dao;

import java.util.ArrayList;

public class DAO<T> {
    private final ArrayList<T> elements=new ArrayList<>();
    public ArrayList<T> findAll(){
        return elements;
    }
    public void save(T element){
        elements.add(element);
    }
}
