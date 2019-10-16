package com.example.ttcfresher;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.icu.util.LocaleData;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class MainActivity extends AppCompatActivity {
    private List<Integer> list = new ArrayList<>();
    private List<Bill> billList = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//bai1
        Bai1TinhTong tinhTong = new Bai1TinhTong();
        Log.d("BAI1", tinhTong.Sum(10) + "");
//bai2
        list.add(2);
        list.add(1);
        list.add(5);
        list.add(7);
        list.add(10);
        list.add(15);
        list.add(20);
        Bai2SapXepTangDan bai2SapXepTangDan = new Bai2SapXepTangDan();
        bai2SapXepTangDan.SapXepTangDan(list);

        for (int i = 0; i < list.size(); i++) {
            Log.d("BAI2", list.get(i).toString());
        }
//bai3
        billList.add(new Bill(0, "muaxe", 10000, "2019-9-11"));
        billList.add(new Bill(1, "muanha", 90000, "2019-3-10"));
        billList.add(new Bill(2, "muadoan", 2000000, "2018-4-11"));
        billList.add(new Bill(3, "muathucuong", 15022200, "2019-9-11"));
        billList.add(new Bill(4, "mualinhtinh", 2000, "2019-5-5"));
        billList.add(new Bill(4, "mualinhtinh", 20000, "2019-5-6"));
        billList.add(new Bill(4, "xxx", 20000, "2019-5-6"));
        Bai3TangDanMoney bai3TangDanMoney = new Bai3TangDanMoney();
        bai3TangDanMoney.SapXepTangDanMoney(billList);

        for (int i = 0; i < billList.size(); i++) {
            Log.d("BAI3", billList.get(i).getName() + "");
            Log.d("BAI3", billList.get(i).getMoney() + "");
        }
//bai4
        for (int i = 0; i < billList.size(); i++) {
            int dem = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (billList.get(i).getDate().equals(billList.get(j).getDate()) == true) {
                    dem++;
                }
            }
            if (dem == 0) {
                Log.d("BAi4", billList.get(i).getDate());
            }
        }

//bai5
        for (int i = 0; i < billList.size(); i++) {
            if (billList.get(i).getMoney() > 1000000) {
                Log.d("BAI5", billList.get(i).getMoney() + "");
            }
        }

//bai 6

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
//bai 7
      List<Bill> cacbilltrungngay = new ArrayList<>();
    cacbilltrungngay.addAll(hashMap.get("2019-9-11"));

      for(int i=0;i<cacbilltrungngay.size();i++)
      {
          Log.d("BAI7", cacbilltrungngay.get(i).getName());
          Log.d("BAI7", cacbilltrungngay.get(i).getDate());
      }
//bai 8
        Set<Bill> billHashSet= new HashSet<>();
      for(int i=0;i<billList.size();i++)
      {
          billHashSet.add(billList.get(i));
      }
      List<Bill> listbillkhongtrung= new ArrayList<>(billHashSet);
      for(int i=0;i<listbillkhongtrung.size();i++)
      {
          Log.d("BAI8", listbillkhongtrung.get(i).getName());
          Log.d("BAI8", listbillkhongtrung.get(i).getId() + "");
          Log.d("BAI8", listbillkhongtrung.get(i).getMoney() + "");
      }

    ;

//bai tap ve string

//bai 1
        DemSoLanXuatHienKyTuTrongChuoi("thiennhien123", "n");
//bai 2
        TimKyTuXuatHienNhieuNhatTrongChuoi("thienn");
//bai 3
        List<String> stringList = new ArrayList<>();
        stringList.add("con gio");
        stringList.add("van thoi qua noi day");
        stringList.add("nhung lieu bay gio");
        stringList.add("no dang o noi dau");

        String ChuoiGhepLai = "";
        for (int i = 0; i < stringList.size(); i++) {
            ChuoiGhepLai += stringList.get(i).toString();
            if (i < stringList.size() - 1) {
                ChuoiGhepLai += ",";
            }

        }
        Log.d("BAI3-String", ChuoiGhepLai);
//bai 4
        List<String> cacchuois = new ArrayList<>();
        String[] cacchuoi = ChuoiGhepLai.split(",");
        for (int i = 0; i < cacchuoi.length; i++) {
            cacchuois.add(cacchuoi[i].toString());
        }
        for (int i = 0; i < cacchuois.size(); i++) {
            Log.d("BAI4-String", cacchuois.get(i).toString());
        }
//bai 5
        Bai5String("I am fresher ,rightttt, yep , fresher la fresher hay la senior ?", "fresher", "senior");


//bai tap ve date va simpledateformat

//bai 1
        String c = "2019-10-15 09:08:07";
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(c);
            Log.d("BAI1-Date", date.toString());

        } catch (ParseException e) {
            e.printStackTrace();
        }
//bai 2
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        calendar.set(Calendar.DAY_OF_MONTH, 1);

        Date date1 = calendar.getTime();
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy/MM/dd");
        String NgayDauTienCuaThang = format1.format(date1);
        Log.d("BAI2-Date", "ngay dau tien cua thang:" + NgayDauTienCuaThang);

        String NgaycuoicungCuaThang;
        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        date1 = calendar.getTime();
        NgaycuoicungCuaThang = format1.format(date1);
        Log.d("BAI2-Date", "ngay cuoi cung cua thang:" + NgaycuoicungCuaThang);


        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, 100);
        date1 = calendar.getTime();
        String mottramngaysau = format1.format(date1);
        Log.d("BAI2-Date", "100 ngay sau:" + mottramngaysau);

//        calendar.setTime(date);
//        calendar.add(Calendar.DAY_OF_WEEK,1);
//        date1 = calendar.getTime();
//        String dautuan = format1.format(date1);
//        Log.d("!122","dau tuan:" + dautuan);

//bai 3
        String a = "2021-11-20";
        String b = "2021-12-15";
        Date datea = null;
        Date dateb = null;
        try {
            datea = new SimpleDateFormat("yyyy-MM-dd").parse(a);
            dateb = new SimpleDateFormat("yyyy-MM-dd").parse(b);
            Log.d("BAI2-Date", datea.toString());
            Log.d("BAI2-Date", dateb.toString());
            if (datea.compareTo(dateb) > 0) {
                Log.d("BAI2-Date", "ngay a lon hon ngay b");
            } else if (datea.compareTo(dateb) == 0) {
                Log.d("BAI2-Date", "ngay a bang ngay b");
            } else {
                Log.d("BAI2-Date", "ngay a nho hon ngay b");
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

        // bai 4

        long ONE_DAY = 1000 * 60 * 60 * 24;
        long difference_ms = Math.abs(datea.getTime() - dateb.getTime());
        Log.d("BAI3-Date", "so ngay giua a va b :" + Math.round(difference_ms / ONE_DAY));

//bai 5
        String date5 = "2019/10/16 09:29:40";

        Date datebai5 = null;
        long timestamp = 0;
        try {
            datebai5 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(date5);
            Log.d("BAI5-Date", datebai5.toString());
            Calendar calendar5 = Calendar.getInstance();
            calendar5.setTime(datebai5);
             timestamp = calendar5.getTimeInMillis();
            Log.d("BAI5-Date", "timestamp la :" + timestamp);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        datebai5 = new Date(timestamp);
        SimpleDateFormat format5 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            String ngaytutimestamp = format5.format(datebai5);
        Log.d("BAI5-Date", "ngay tu timestamp la :" + ngaytutimestamp);

//bai 6
        String date6 = "2019/10/16 09:29:40";

        Date datebai6 = null;
        long timestamp6 = 0;
        try {
            datebai6 = new SimpleDateFormat("yyyy/MM/dd HH:mm").parse(date5);
            Log.d("BAI6-Date", datebai6.toString());
            Calendar calendar6 = Calendar.getInstance();
            calendar6.setTime(datebai6);
            timestamp6 = calendar6.getTimeInMillis();
            Log.d("BAI6-Date", "timestamp la :" + timestamp6);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        datebai6 = new Date(timestamp6);
        SimpleDateFormat format6 = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        String ngaytutimestamp6 = format6.format(datebai6);
        Log.d("BAI6-Date", "ngay tu timestamp la :" + ngaytutimestamp6);

//bai 7
        String date7 = "2019/10/16 10:33:40";
        Date datebai7;
        try {
             datebai7  = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(date7);
            SimpleDateFormat format7 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat format7khac = new SimpleDateFormat("MMM yyyy,dd HH:mm:ss");
            String dinhdangngaykhac = format7.format(datebai7);
            String dinhdangngaykhac1 = format7khac.format(datebai7);
            Log.d("BAI7-Date", dinhdangngaykhac);
            Log.d("BAI7-Date", dinhdangngaykhac1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    private void DemSoLanXuatHienKyTuTrongChuoi(String chuoi, String kytu) {
        int dautien = -1;
        int cuoicung = 0;
        int dem = 0;
        for (int i = 0; i <= chuoi.length() - kytu.length(); i++) {
            if (kytu.equals(chuoi.substring(i, i + kytu.length()))) {
                dem++;
                Log.d("BAI1-String", "vi tri xuat hien trong chuoi la: " + i);
                if (dautien == -1) {
                    dautien = i;
                }
                if (i > cuoicung) {
                    cuoicung = i;
                }
            }
        }
        if (dem > 0) {
            Log.d("BAI1-String", "so lan  xuat hien trong chuoi:" + dem);
//            Log.d("BAI1-String", "ky tu dau tien cua chuoi la:" +chuoi.substring(0,1));
//            Log.d("BAI1-String", "ky tu cuoi cung cua chuoi la:" +chuoi.substring(chuoi.length()-1));
            Log.d("BAI1-String", "vi tri dau tien xuat hien la:" + dautien);
            Log.d("BAI1-String", "vi tri cuoi cung xuat hien la:" + cuoicung);
        } else {
            Log.d("BAI1-String", "khong co ky tu hoac chuoi nao xuat hien trong chuoi");
        }

    }

    private void TimKyTuXuatHienNhieuNhatTrongChuoi(String chuoi) {

        int solanxuathien = 0;
        for (int i = 0; i < chuoi.length(); i++) {
            int dem = 0;
            for (int j = i; j < chuoi.length(); j++) {
                if (chuoi.charAt(i) == chuoi.charAt(j)) {
                    dem++;
                }
            }
            if (dem > solanxuathien) {
                solanxuathien = dem;
            }
        }

        for (int i = 0; i < chuoi.length(); i++) {
            int demlai = 0;
            for (int j = i; j < chuoi.length(); j++) {
                if (chuoi.charAt(i) == chuoi.charAt(j)) {
                    demlai++;
                }
            }
            if (demlai == solanxuathien) {
                Log.d("BAI2-String", "ky tu xuat hien nhieu nhat trong chuoi la: " + chuoi.charAt(i));
            }
        }
        List<String> chuoicons = new ArrayList<>();
        for (int i = 0; i < chuoi.length(); i++) {
            for (int j = i; j <= chuoi.length(); j++) {
                if (chuoi.substring(i, j).equals(chuoi) == false) {
                    if (chuoicons.size() == 0) {

                        chuoicons.add(chuoi.substring(i, j));
                    } else {
                        int dem = 0;
                        for (int k = 0; k < chuoicons.size(); k++) {

                            if (chuoi.substring(i, j).equals(chuoicons.get(k)) == true) {
                                dem++;
                            }
                        }
                        if (dem == 0) {
                            chuoicons.add(chuoi.substring(i, j));
                        }
                    }
                }
            }
        }

        for (int i = 0; i < chuoicons.size(); i++) {
            Log.d("BAI2-String", chuoicons.get(i).toString());
        }
    }

    private void Bai5String(String raw, String from, String to) {
        String Result = raw;
        for (int i = 0; i <= Result.length() - from.length(); i++) {
            if (from.equals(Result.substring(i, i + from.length()))) {
                Result = Result.substring(0, i) + to + Result.substring(i + from.length());
            }
        }
        Log.d("BAI5-String", Result);
    }
}
