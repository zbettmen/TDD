package org.example;

public class IntArray implements IIntArray{

    public IntArray(int[] array) {
        this.array = array;
    }
    private int[] array;

    @Override
    public double getAverage() {
        if(array.length <1 ) throw new IllegalArgumentException("Array empty");
        double sum = 0;
        for(int i: array ){
            sum += i;
        }
        return sum/array.length;
    }

    @Override
    public int[] findPositions(int val) {
        int size = 0,counter = 0,index = 0;
        for (int value: array) {
            if (value == val){
                size++;
            }
        }
        if (size != 0){
            int[] found = new int[size];
            for (int value: array) {
                if (value == val){
                    found[index] = counter;
                    index++;
                }
                counter++;
            }
            return found;
        }else
            throw new IllegalArgumentException("Array is empty");
    }

    @Override
    public void appendLast(int value) {
        int size = array.length;
        int[] newArray = new int[size +1];
        System.arraycopy(array, 0, newArray, 0, size);
        newArray[size] = value;
        this.array = newArray;
    }

    @Override
    public void insertAt(int pos, int value) throws ArrayIndexOutOfBoundsException,NullPointerException {
        int[] insertArray = new int[array.length + 1];
        for (int i = insertArray.length - 1; i >= 0 ; i--) {
            if (i > pos){
                insertArray[i] = array[i - 1];
            }
            else if (i == pos){
                insertArray[i] = value;
            }
            else if  (i < pos){
                insertArray[i] = array[i];

            }
        }
        array = insertArray;

    }

    @Override
    public int getAt(int pos) {
        return array[pos];
    }

    @Override
    public void setAt(int pos, int element) {
        array[pos] = element;
    }

    @Override
    public int deleteAt(int pos) throws ArrayIndexOutOfBoundsException,NullPointerException {
        int[] delete = new int[array.length-1];
        int counter = 0;
        int index = 0;
        int found = 0;
        for (int value: array) {
            if (index == pos){
                found = value;
            }
            else {
                delete[counter] = value;
                counter++;
            }
            index++;
        }
        array = delete;
        return found;
    }

    public int[] getIntArray() {
        return array;
    }
    public void setArray(int[] intArray) {
        this.array = intArray;
    }
}
