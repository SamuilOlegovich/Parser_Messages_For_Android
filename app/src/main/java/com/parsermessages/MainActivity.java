package com.parsermessages;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.fastloan.R;
import com.parsermessages.model.Agent;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private Button startButton;
    private TabItem perMonth;
    private TabItem perHour;
    private TabItem perWeek;
    private TabItem perDay;
    private TabItem all;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setButtons();
        listeners();
    }



    private void listeners() {
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Agent.setSortNumber(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        startButton.setOnClickListener(
                // Окна с вопросом и действиями
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // класс для перехода на другую страницу
                        Intent intent = new Intent(".StartMainActivity");
                        startActivity(intent);
                    }
                }
        );
    }

    private void setButtons() {
        startButton = (Button) findViewById(R.id.button_start);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        perMonth = (TabItem) findViewById(R.id.per_month);
        perWeek = (TabItem) findViewById(R.id.per_week);
        perHour = (TabItem) findViewById(R.id.per_hour);
        perDay = (TabItem) findViewById(R.id.per_day);
        all = (TabItem) findViewById(R.id.all);
    }
}