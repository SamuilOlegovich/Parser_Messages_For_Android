package com.parsermessages.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.fastloan.R;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.parsermessages.model.Agent;
import com.parsermessages.model.AppAdapter;
import com.parsermessages.model.LoadApplications;

import androidx.appcompat.app.AppCompatActivity;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;


public class StartMainActivity extends AppCompatActivity {
    private PackageManager packageManager = null;
    private List<ApplicationInfo> applist = null;
    private TabLayout tabLayout;
    private Button buttonStop;
    private ListView listView;
    private TabItem perMonth;
    private TabItem perHour;
    private TabItem perWeek;
    private TabItem perDay;
    private TabItem all;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity_main);

        setButtons();
        Agent.setStartMainActivity(this);

        packageManager = getPackageManager();
        Agent.setPackageManager(packageManager);

        new LoadApplications().execute();

        listeners();
    }

    public void setListAdapter(ArrayAdapter<AppAdapter> in) {
        listView.setAdapter(in);
    }



//    private void setStartList() {
//        ArrayAdapter<CreditOrganization> adapter = new CreditOrganizationArrayAdapter(this,
//                0, creditOrganizationArrayList1);
//        listView.setAdapter(adapter);
//         для того чтобы лист показывался сверху вниз
//        listView.setSelection(0);
//    }


    private void listeners() {
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switchTabs(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        buttonStop.setOnClickListener(
                // Окна с вопросом и действиями
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // класс для перехода на другую страницу
                        Intent intent = new Intent(".MainActivity");
                        startActivity(intent);
                    }
                }
        );

    }


    private void switchTabs(int in) {
        switch (in) {
            case 0:
//                selectTabButton(creditOrganizationArrayList1);
//                list = 1;
                break;
            case 1:
//                selectTabButton(creditOrganizationArrayList2);
//                list = 2;
                break;
            case 2:
//                selectTabButton(creditOrganizationArrayList3);
//                list = 3;
                break;
            case 3:
//                selectTabButton(creditOrganizationArrayList4);
//                list = 4;
                break;
        }
    }


    private void setButtons() {
        listView = (ListView) findViewById(R.id.list_of_company_tab);
        buttonStop = (Button) findViewById(R.id.button_stop);
        perMonth = (TabItem) findViewById(R.id.per_month);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        perWeek = (TabItem) findViewById(R.id.per_week);
        perHour = (TabItem) findViewById(R.id.per_hour);
        perDay = (TabItem) findViewById(R.id.per_day);
        all = (TabItem) findViewById(R.id.all);

    }


//    private void createObjects() {
//        getStringDataApi();
//        ObjectCreator objectCreator = new ObjectCreator();
////        creditOrganizationArrayList = new ArrayList<>(new ObjectCreator().createObjects(DataExchange.getStringDataApi()));
//        creditOrganizationArrayList = new ArrayList<>(objectCreator.createObjects(DataExchange.getStringDataApi()));
//        ArrayList<CreditOrganization> top = new ArrayList<>();
//        ArrayList<Integer> integers = new ArrayList<>();
//
//        for (CreditOrganization creditOrganization : creditOrganizationArrayList) {
//            if (creditOrganization.getTop().equals("true")) {
//                top.add(creditOrganization);
//                integers.add(creditOrganizationArrayList.indexOf(creditOrganization));
//            }
//        }
//        Collections.reverse(integers);
//        for (Integer integer : integers) {
//            creditOrganizationArrayList.remove(integer);
//        }
//
//        creditOrganizationArrayList1 = new ArrayList<>();
//        creditOrganizationArrayList2 = new ArrayList<>();
//        creditOrganizationArrayList3 = new ArrayList<>();
//        creditOrganizationArrayList4 = new ArrayList<>();
//
//        for (CreditOrganization creditOrganization : top) {
//            if (creditOrganization.getAll().equalsIgnoreCase("true")) {
//                creditOrganizationArrayList1.add(creditOrganization);
//            }
//            if (creditOrganization.getZero().equalsIgnoreCase("true")) {
//                creditOrganizationArrayList2.add(creditOrganization);
//            }
//            if (creditOrganization.getBadCreditHistory().equalsIgnoreCase("true")) {
//                creditOrganizationArrayList3.add(creditOrganization);
//            }
//            if (creditOrganization.getNoCalls().equalsIgnoreCase("true")) {
//                creditOrganizationArrayList4.add(creditOrganization);
//            }
//        }
//
//        for (CreditOrganization creditOrganization : creditOrganizationArrayList) {
//            if (creditOrganization.getAll().equalsIgnoreCase("true")) {
//                creditOrganizationArrayList1.add(creditOrganization);
//            }
//            if (creditOrganization.getZero().equalsIgnoreCase("true")) {
//                creditOrganizationArrayList2.add(creditOrganization);
//            }
//            if (creditOrganization.getBadCreditHistory().equalsIgnoreCase("true")) {
//                creditOrganizationArrayList3.add(creditOrganization);
//            }
//            if (creditOrganization.getNoCalls().equalsIgnoreCase("true")) {
//                creditOrganizationArrayList4.add(creditOrganization);
//            }
//        }
//        creditOrganizationArrayList.clear();
//        integers.clear();
//        top.clear();
//        list = 1;
//    }




//    private void selectTabButton(ArrayList<CreditOrganization> in) {
//        ArrayAdapter<CreditOrganization> adapter = new CreditOrganizationArrayAdapter(this,
//                0, in);
//        listView.setAdapter(adapter);
//        // для того чтобы лист показывался сверху вниз
//        listView.setSelection(0);
//    }



//    public void showInfoThisTable(int index) {
//        if (list == 1) {
//            DataExchange.setCreditOrganization(creditOrganizationArrayList1.get(index));
//        } else if (list == 2) {
//            DataExchange.setCreditOrganization(creditOrganizationArrayList2.get(index));
//        } else if (list == 3) {
//            DataExchange.setCreditOrganization(creditOrganizationArrayList3.get(index));
//        } else if (list == 4) {
//            DataExchange.setCreditOrganization(creditOrganizationArrayList4.get(index));
//        }
//
//        if (DataExchange.getCountryCode() != 255 || !DataExchange.getNetworkCountry().equals("ua")) {
//            Intent intent = new Intent(".InfoCreditPage");
//            startActivity(intent);
//        } else {
//            Intent intent = new Intent(".WebPage");
//            startActivity(intent);
//        }
//    }

}
