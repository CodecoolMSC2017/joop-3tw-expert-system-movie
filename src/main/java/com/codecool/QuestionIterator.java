package com.codecool;

import java.util.ArrayList;
import java.util.Iterator;

public class QuestionIterator implements Iterator<Question> {

    private Question[] arrayList;
    private int currentSize;

    public QuestionIterator(Question[] newArray) {
        this.arrayList = newArray;
        this.currentSize = arrayList.length;
}

    @Override
    public Iterator<Question> iterator() {
        Iterator<Question> it = new Iterator<Question>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < currentSize && arrayList[currentIndex] != null;
            }

            @Override
            public Question next() {
                return arrayList[currentIndex++];
            }

            /*@Override
            public void remove() {
                throw new UnsupportedOperationException();
            }*/
        };
        return it;

}
