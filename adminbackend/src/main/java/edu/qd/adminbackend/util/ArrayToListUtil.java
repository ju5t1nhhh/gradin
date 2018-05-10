package edu.qd.adminbackend.util;

import java.util.List;

public class ArrayToListUtil {

    public static List listARemoveListB(List<Integer> listA, List<Integer> listB) {
        listA.removeAll(listB);
        return listA;
    }

}
