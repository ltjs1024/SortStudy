package com.stone;

public class DataWrap implements Comparable<DataWrap> {

    int data;
    String flag;

    public DataWrap(int data, String flag) {
        this.data = data;
        this.flag = flag;
    }

    @Override
    public String toString() {
        return data + flag;
    }

    @Override
    public int compareTo(DataWrap o) {
        return Integer.compare(this.data, o.data);
    }


}
