package com.example.ttcfresher;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Bai2SapXepTangDan {

    public void SapXepTangDan(List<Integer> n) {
        Collections.sort(n, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 < o2) {
                    return -1;
                } else {
                    if (o1 == o2) {
                        return 0;
                    } else {
                        return 1;
                    }
                }
            }
        });
    }
}
