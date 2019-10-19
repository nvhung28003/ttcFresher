package com.example.ttcfresher;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.icu.util.LocaleData;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Chronometer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
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
    private List<Integer> listNumber = new ArrayList<>();
    private List<Bill> billList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listNumber.add(2);
        listNumber.add(1);
        listNumber.add(5);
        listNumber.add(7);
        listNumber.add(10);
        listNumber.add(15);
        listNumber.add(20);

        billList.add(new Bill(0, "muaxe", 10000, "2019-90-11"));
        billList.add(new Bill(1, "muanha", 90000, "2019-03-10"));
        billList.add(new Bill(2, "muadoan", 2000000, "2018-04-11"));
        billList.add(new Bill(3, "muathucuong", 15022200, "2019-09-11"));
        billList.add(new Bill(4, "mualinhtinh", 2000, "2019-05-05"));
        billList.add(new Bill(4, "mualinhtinh", 20000, "2019-05-06"));
        billList.add(new Bill(4, "xxx", 20000, "2019-05-06"));
        billList.add(new Bill(4, "aaa", 20000, "2019-05-06"));

//bai1
        sumFrom0toN(20);

//bai2
        sortAscending(listNumber);
        for (int i = 0; i < listNumber.size(); i++) {
            Log.d("BAI2", listNumber.get(i).toString());
        }
//bai3

        moneySortAscending(billList);
        for (int i = 0; i < billList.size(); i++) {
            Log.d("BAI3", billList.get(i).getName() + "");
            Log.d("BAI3", billList.get(i).getMoney() + "");
        }
//bai4

        List<String> listDistinctDateBill = new ArrayList<>();
        listDistinctDateBill = getListDistinctDateBill(billList);

//bai5
        Log.d("BAI5", "bills >  1000000 :");
        List<Bill> listBillMoneyGreaterThanNumber = new ArrayList<>();
        listBillMoneyGreaterThanNumber = getListBillMoneyGreaterThanNumber(billList, 1000000);

        for (int i = 0; i < listBillMoneyGreaterThanNumber.size(); i++) {
            Log.d("BAI5", listBillMoneyGreaterThanNumber.get(i).getName());
        }

//bai 6
        HashMap<String, List<Bill>> hashMap = new HashMap<>();
        hashMap = inputListBillSameDay(billList);

//bai 7
        getListBillSameDay(hashMap, "2019-05-06");
//bai 8

        List<Bill> listBillDistinctIDAndName = new ArrayList<>();
        listBillDistinctIDAndName = getListBillDistinctIDAndName(billList);
        for (int i = 0; i < listBillDistinctIDAndName.size(); i++) {
            Log.d("BAI8", listBillDistinctIDAndName.get(i).getName());
            Log.d("BAI8", listBillDistinctIDAndName.get(i).getId() + "");
        }
        ;

//bai tap ve string

//bai 1
        countCharactersAppear("thiennhien123", "n");
//bai 2
        findCharacterAppearTheMost("thienn");
//bai 3
        List<String> stringList = new ArrayList<>();
        stringList.add("con gio");
        stringList.add("van thoi qua noi day");
        stringList.add("nhung lieu bay gio");
        stringList.add("no dang o noi dau");


        String textCombined = combineWords(stringList);

        Log.d("BAI3-String", textCombined + "");
//bai 4
        List<String> listTexts = new ArrayList<>();
        listTexts = getListTextFromInPutText(textCombined);

        for (String text : listTexts) {
            Log.d("BAI4-String", text.toString() + "");
        }
//bai 5
        replaceText("I am fresher ,rightttt, yep , fresher la fresher hay la senior ?", "fresher", "senior");

//bai tap ve date va simpledateformat

//bai 1
        String c = "2019-10-15 09:08:07";
        Date date = covertStringToDate(c);
//bai 2
        String fisrtDayOfMonth = getFisrtDayOfMonth(c);
        Log.d("BAI2-Date", "Fist day of month : " + fisrtDayOfMonth + "");

        String lastDayofMonth = getLastDayOfMonth(c);

        Log.d("BAI2-Date", "Last day of month : " + lastDayofMonth);

        String oneHundredDayLater = numberDayLater(c, 100);

        Log.d("BAI2-Date", "100 days later : " + oneHundredDayLater);

//bai 3
        String a = "2021-11-20";
        String b = "2025-12-15";
        String resultCompare = compareDate(a, b);
        Log.d("BAI3-Date", resultCompare);

        // bai 4

        countDay(a, b);
        countMonth(a, b);
        countYear(a, b);


//bai 5
        String date5 = "2019/10/18 10:57:20";
        covertToTimestamp(date5);

//bai 6
        convertToTimestampRoundToMinutes(date5);


//bai 7
        String date7 = "2019/10/16 10:33:40";
        covertFormatDate(date7);
    }

    private void countCharactersAppear(String inputText, String character) {
        int positionAppearsFirst = -1;
        int positionAppearsLast = 0;
        int countAppear = 0;
        for (int i = 0; i <= inputText.length() - character.length(); i++) {
            if (character.equals(inputText.substring(i, i + character.length()))) {
                countAppear++;
                Log.d("BAI1-String", "position of Character: " + i);
                if (positionAppearsFirst == -1) {
                    positionAppearsFirst = i;
                }
                if (i > positionAppearsLast) {
                    positionAppearsLast = i;
                }
            }
        }
        if (countAppear > 0) {
            Log.d("BAI1-String", "the number of appear:" + countAppear);
//            Log.d("BAI1-String", "ky tu dau tien cua chuoi la:" +chuoi.substring(0,1));
//            Log.d("BAI1-String", "ky tu cuoi cung cua chuoi la:" +chuoi.substring(chuoi.length()-1));
            Log.d("BAI1-String", "position Appear fisrt:" + positionAppearsFirst);
            Log.d("BAI1-String", "position Appear last:" + positionAppearsLast);
        } else {
            Log.d("BAI1-String", "no Appear in Text");
        }

    }

    private void findCharacterAppearTheMost(String inputText) {

        int mostAppear = 0;
        for (int i = 0; i < inputText.length(); i++) {
            int count = 0;
            for (int j = i; j < inputText.length(); j++) {
                if (inputText.charAt(i) == inputText.charAt(j)) {
                    count++;
                }
            }
            if (count > mostAppear) {
                mostAppear = count;
            }
        }

        for (int i = 0; i < inputText.length(); i++) {
            int countAgain = 0;
            for (int j = i; j < inputText.length(); j++) {
                if (inputText.charAt(i) == inputText.charAt(j)) {
                    countAgain++;
                }
            }
            if (countAgain == mostAppear) {
                Log.d("BAI2-String", "Most characters appear in the text : " + inputText.charAt(i));
            }
        }
        List<String> subText = new ArrayList<>();
        for (int i = 0; i < inputText.length(); i++) {
            for (int j = i; j <= inputText.length(); j++) {
                if (inputText.substring(i, j).equals(inputText) == false) {
                    if (subText.size() == 0) {

                        subText.add(inputText.substring(i, j));
                    } else {
                        int dem = 0;
                        for (int k = 0; k < subText.size(); k++) {

                            if (inputText.substring(i, j).equals(subText.get(k)) == true) {
                                dem++;
                            }
                        }
                        if (dem == 0) {
                            subText.add(inputText.substring(i, j));
                        }
                    }
                }
            }
        }

        for (int i = 0; i < subText.size(); i++) {
            Log.d("BAI2-String", subText.get(i).toString());
        }
    }

    private String combineWords(List<String> stringList) {

        String text = "";
        for (int i = 0; i < stringList.size(); i++) {
            text += stringList.get(i).toString();
            if (i < stringList.size() - 1) {
                text += ",";
            }

        }
        return text;
    }

    private List<String> getListTextFromInPutText(String inputText) {
        List<String> listText = new ArrayList<>();
        String[] cacchuoi = inputText.split(",");
        for (int i = 0; i < cacchuoi.length; i++) {
            listText.add(cacchuoi[i].toString());
        }
        return listText;
    }

    private void replaceText(String raw, String from, String to) {
        String Result = raw;
        for (int i = 0; i <= Result.length() - from.length(); i++) {
            if (from.equals(Result.substring(i, i + from.length()))) {
                Result = Result.substring(0, i) + to + Result.substring(i + from.length());
            }
        }
        Log.d("BAI5-String", Result);
    }


    private Date covertStringToDate(String inputDate) {

        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(inputDate);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    private String getFisrtDayOfMonth(String inputDate) {
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(inputDate);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        calendar.set(Calendar.DAY_OF_MONTH, 1);

        date = calendar.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String fistDayOfMonth = simpleDateFormat.format(date);

        return fistDayOfMonth;
    }

    private String getLastDayOfMonth(String inputDate) {
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(inputDate);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        String lastDayOfMonth;
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.DAY_OF_MONTH, -1);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        date = calendar.getTime();
        lastDayOfMonth = simpleDateFormat.format(date);
        return lastDayOfMonth;
    }

    private String numberDayLater(String inputDate, int number) {
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(inputDate);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        calendar.add(Calendar.DAY_OF_MONTH, number);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        date = calendar.getTime();
        String Result = simpleDateFormat.format(date);
        return Result;
    }

    private String compareDate(String inputDateA, String inputDateB) {
        String result = "";

        Date datea = null;
        Date dateb = null;
        try {
            datea = new SimpleDateFormat("yyyy-MM-dd").parse(inputDateA);
            dateb = new SimpleDateFormat("yyyy-MM-dd").parse(inputDateB);

            if (datea.compareTo(dateb) > 0) {
                result = inputDateB + " bigger than   " + inputDateB;
            } else if (datea.compareTo(dateb) == 0) {
                result = "Ngay " + inputDateB + " equal " + inputDateB;
            } else {
                result = "Ngay " + inputDateB + " smaller than " + inputDateB;
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void countDay(String inputDateA, String inputDateB) {

        Date datea = null;
        Date dateb = null;
        try {
            datea = new SimpleDateFormat("yyyy-MM-dd").parse(inputDateA);
            dateb = new SimpleDateFormat("yyyy-MM-dd").parse(inputDateB);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long ONE_DAY = 1000 * 60 * 60 * 24;

        long difference_ms = Math.abs(datea.getTime() - dateb.getTime());
        Log.d("BAI4-Date", "day between  " + inputDateA + " and " + inputDateB + ":" + Math.round(difference_ms / ONE_DAY));

    }

    public void countMonth(String inputDateA, String inoutDateB) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            long monthsBetween = ChronoUnit.MONTHS.between(
                    LocalDate.parse(inputDateA).withDayOfMonth(1),
                    LocalDate.parse(inoutDateB).withDayOfMonth(1));
            Log.d("BAI4-Date", "month between  " + inputDateA + " and" + inoutDateB + " : " + monthsBetween);
        }
    }

    public void countYear(String inputDateA, String inputDateB) {
        long yearsBetween = 0;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            yearsBetween = ChronoUnit.YEARS.between(
                    LocalDate.parse(inputDateA),
                    LocalDate.parse(inputDateB));
            Log.d("BAI4-Date", "year between  " + inputDateA + " and " + inputDateB + " : " + yearsBetween);
        }
    }

    public void covertToTimestamp(String inputDate) {

        Date date = null;
        long timestamp = 0;
        try {
            date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(inputDate);
            Log.d("BAI5-Date", date.toString());
            Calendar calendar5 = Calendar.getInstance();
            calendar5.setTime(date);
            timestamp = calendar5.getTimeInMillis();
            Log.d("BAI5-Date", "timestamp: " + timestamp);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        date = new Date(timestamp);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String dateFromTimestamp = simpleDateFormat.format(date);
        Log.d("BAI5-Date", "date from timestamp is :" + dateFromTimestamp);
    }

    public void convertToTimestampRoundToMinutes(String inputDate) {

        Date date = null;
        long timestamp = 0;
        try {
            date = new SimpleDateFormat("yyyy/MM/dd HH:mm").parse(inputDate);
            Log.d("BAI6-Date", date.toString());
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            timestamp = calendar.getTimeInMillis();
            Log.d("BAI6-Date", "timestamp :" + timestamp);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        date = new Date(timestamp);
        SimpleDateFormat format6 = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        String dateFromTimeStamp = format6.format(date);
        Log.d("BAI6-Date", "date from timestamp :" + dateFromTimeStamp);
    }

    private void covertFormatDate(String inputDate) {

        Date date;
        try {
            date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(inputDate);
            SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("MMM yyyy,dd HH:mm:ss");
            String otherFormat1 = simpleDateFormat1.format(date);
            String otherFormat2 = simpleDateFormat2.format(date);
            Log.d("BAI7-Date", otherFormat1);
            Log.d("BAI7-Date", otherFormat2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void sumFrom0toN(int Number) {
        int Result = 0;
        for (int i = 0; i <= Number; i++) {
            Result += i;
        }
        Log.d("BAI1", "Sum :" + Result + "");
    }

    public void sortAscending(List<Integer> ListNumber) {
        Collections.sort(ListNumber, new Comparator<Integer>() {
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

    public void moneySortAscending(List<Bill> billList) {
        Collections.sort(billList, new Comparator<Bill>() {
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

    public List<String> getListDistinctDateBill(List<Bill> billList) {
        List<String> listDistinctDateBill = new ArrayList<>();
        for (int i = 0; i < billList.size(); i++) {
            int dem = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (billList.get(i).getDate().equals(billList.get(j).getDate()) == true) {
                    dem++;
                }
            }
            if (dem == 0) {
                listDistinctDateBill.add(billList.get(i).getDate());
            }
        }
        return listDistinctDateBill;
    }

    public List<Bill> getListBillMoneyGreaterThanNumber(List<Bill> billList, int Number) {
        List<Bill> listBillMoneyGreaterThanNumber = new ArrayList<>();
        for (int i = 0; i < billList.size(); i++) {
            if (billList.get(i).getMoney() > Number) {
                listBillMoneyGreaterThanNumber.add(billList.get(i));
            }
        }
        return listBillMoneyGreaterThanNumber;
    }

    public HashMap<String, List<Bill>> inputListBillSameDay(List<Bill> billList) {
        HashMap<String, List<Bill>> listHashMap = new HashMap<>();

        for (Bill bill : billList) {
            List<Bill> listBillSameDays = new ArrayList<>();
            listBillSameDays.add(bill);
            if (listHashMap.containsKey(bill.getDate()) == true) {
                listBillSameDays.addAll(listHashMap.get(bill.getDate()));
            }
            listHashMap.put(bill.getDate(), listBillSameDays);
        }
        return listHashMap;
    }

    private void getListBillSameDay(HashMap<String, List<Bill>> hashMap, String Date) {
        List<Bill> listBillSameDay = new ArrayList<>();
        listBillSameDay.addAll(hashMap.get(Date));

        for (int i = 0; i < listBillSameDay.size(); i++) {
            Log.d("BAI7", listBillSameDay.get(i).getName());
            Log.d("BAI7", listBillSameDay.get(i).getDate());
        }
    }

    public List<Bill> getListBillDistinctIDAndName(List<Bill> billList) {

        Set<Bill> billHashSet = new HashSet<>();
        for (int i = 0; i < billList.size(); i++) {
            billHashSet.add(billList.get(i));
        }
        List<Bill> listBillDistinctIDAndName = new ArrayList<>(billHashSet);

        return listBillDistinctIDAndName;
    }

}
