package edu.qd.adminbackend.util;

import java.util.Arrays;
import java.util.List;

public class ArrayToListUtil {

    public static List listARemoveListB(int[] arrA, int[] arrB) {
        List listA = Arrays.asList(arrA);
        List listB = Arrays.asList(arrB);
        listA.removeAll(listB);
        return listA;
    }

}
