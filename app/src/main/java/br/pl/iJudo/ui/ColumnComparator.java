package br.pl.iJudo.ui;

import java.util.Comparator;

public class ColumnComparator implements Comparator {
    int columnToSort;
    public ColumnComparator(int columnToSort) {
        this.columnToSort = columnToSort;
    }
    //overriding compare method
    public int compare(Object o1, Object o2) {
        String[] row1 = (String[]) o1;
        String[] row2 = (String[]) o2;
        //compare the columns to sort
        return row1[columnToSort].compareTo(row2[columnToSort]);
    }
}