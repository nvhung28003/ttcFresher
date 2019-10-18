package com.example.ttcfresher;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CacHoaDon {

    public List<String> DistinctNgayLapHoaDon(List<Bill> billList) {
        List<String> ListDistinctNgayLapHoaDon = new ArrayList<>();
        for (int i = 0; i < billList.size(); i++) {
            int dem = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (billList.get(i).getDate().equals(billList.get(j).getDate()) == true) {
                    dem++;
                }
            }
            if (dem == 0) {
               ListDistinctNgayLapHoaDon.add(billList.get(i).getDate());
            }
        }
        return ListDistinctNgayLapHoaDon;
    }
    public List<Bill> CacHoaDonTren1000000 (List<Bill> billList)
    {
        List<Bill> ListCacHoaDonTren1000000 = new ArrayList<>();
        for (int i = 0; i < billList.size(); i++) {
            if (billList.get(i).getMoney() > 1000000) {
                ListCacHoaDonTren1000000.add(billList.get(i));
            }
        }
        return ListCacHoaDonTren1000000;
    }

    public HashMap<String,List<Bill>> ListHoaDonCungNgay (List<Bill> billList)
    {
        HashMap<String, List<Bill>> hashMap = new HashMap<>();
        for(int i =billList.size()-1;i >=0;i--)
        {

            List<Bill> cacbilltrungngays = new ArrayList<>();
            for(int j=i;j<billList.size();j++)
            {
                if(billList.get(i).getDate().equals(billList.get(j).getDate()))
                {
                    cacbilltrungngays.add(billList.get(j));
                }
            }
            hashMap.put(billList.get(i).getDate(),cacbilltrungngays);
        }
        return hashMap;
    }
    public List<Bill> DistinctCacBillCungIdVaName (List<Bill> billList)
    {

        Set<Bill> billHashSet= new HashSet<>();
        for(int i=0;i<billList.size();i++)
        {
            billHashSet.add(billList.get(i));
        }
        List<Bill> listbillkhongtrung= new ArrayList<>(billHashSet);

        return listbillkhongtrung;
    }
}
