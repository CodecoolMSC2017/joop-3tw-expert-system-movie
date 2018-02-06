package com.codecool;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class FactIterator implements Iterator<Fact> {
    private Fact[] arr;
    private int index = 0;

    public FactIterator(Fact[] arr){
        this.arr = arr;
    }

    @Override
    public boolean hasNext(){
        return index < arr.length;
    }

    @Override
    public Fact next(){
        if (!hasNext()){
            throw new NoSuchElementException();
        }
        Fact fact = arr[index];
        index++;

        return fact;
    }

}
