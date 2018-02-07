package com.codecool;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class FactIterator implements Iterator<Fact> {
    private List<Fact> arr;
    Fact fact;
    private int index = 0;

    public FactIterator(List<Fact> arr){
        this.arr = arr;
    }

    @Override
    public boolean hasNext(){
        return index < arr.size();
    }

    @Override
    public Fact next(){
        if (!hasNext()){
            throw new NoSuchElementException();
        }
        else{
            fact = arr.get(index);
            index++;
        }

        return fact;
    }

}
