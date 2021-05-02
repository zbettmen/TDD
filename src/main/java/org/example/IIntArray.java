package org.example;

public interface IIntArray {

    double getAverage();

    int[] findPositions(int val);

    void appendLast(int value);

    void insertAt(int pos, int value);

    int getAt(int pos);

    void setAt(int pos, int element);

    int deleteAt(int pos);
}
