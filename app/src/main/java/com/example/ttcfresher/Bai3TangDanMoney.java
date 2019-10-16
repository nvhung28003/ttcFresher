package com.example.ttcfresher;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Bai3TangDanMoney {
    public void SapXepTangDanMoney(List<Bill> bills) {
        Collections.sort(bills, new Comparator<Bill>() {
            @Override
            public int compare(Bill o1, Bill o2) {
                if (o1.getMoney() > o2.getMoney()) {
                    return 1;
                } else {
                    if (o1.getMoney() == o2.getMoney()) {
                        return 0;
                    } else {
                        return -1;
                    }
                }
            }
        });
    }
}
