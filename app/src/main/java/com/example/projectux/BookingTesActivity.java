package com.example.projectux;

import static com.example.projectux.R.id.cardforTime;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class BookingTesActivity extends AppCompatActivity {

    private GridLayout calendarGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bookingtes);

        View monthYearText = findViewById(R.id.monthYearText);
        calendarGrid = findViewById(R.id.calendarGrid);

        List<String> data = new ArrayList<>();
        data.add("Tes Lab");
        data.add("Home Service");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, data);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinner = findViewById(R.id.spinnerlayanan);
        spinner.setAdapter(adapter);

        Calendar calendar = Calendar.getInstance();
        generateCalendar(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH));

        GridLayout timeGrid = findViewById(R.id.timeGrid);


        timeGrid.removeAllViews();

        List<String> timeRanges = new ArrayList<>();
        timeRanges.add("00:00 - 02:00");
        timeRanges.add("02:00 - 04:00");
        timeRanges.add("04:00 - 06:00");
        timeRanges.add("06:00 - 08:00");
        timeRanges.add("08:00 - 10:00");

        LayoutInflater inflater = LayoutInflater.from(this);



        final TextView[] selectedTimeView = {null};

        for (int i = 0; i < timeRanges.size(); i++) {
            View timeCardView = inflater.inflate(R.layout.timecard, timeGrid, false);
            TextView cardforTime = timeCardView.findViewById(R.id.cardforTime);
            cardforTime.setText(timeRanges.get(i));

            // Set an OnClickListener for the cardforTime
            cardforTime.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // If there is a previously selected TextView, change its background back to the default background
                    if (selectedTimeView[0] != null) {
                        selectedTimeView[0].setBackgroundResource(R.drawable.boxborder);
                    }

                    // Change the background of the clicked TextView to timeselected
                    cardforTime.setBackgroundResource(R.drawable.timeselected);

                    // Update the currently selected TextView
                    selectedTimeView[0] = cardforTime;
                }
            });

            GridLayout.LayoutParams params = new GridLayout.LayoutParams();

            // margin between each timeCardView
            params.setMargins(20, 16,20,16);

            // Set the column of the TextView to the index of the time range modulo 3
            params.columnSpec = GridLayout.spec(i % 3);

            // Set the row of the TextView to the index of the time range divided by 3
            params.rowSpec = GridLayout.spec(i / 3);

            timeCardView.setLayoutParams(params);

            timeGrid.addView(timeCardView);
        }
    }

    private void generateCalendar(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        int firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;

        calendar.add(Calendar.MONTH, -1);
        int daysInPrevMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        LayoutInflater inflater = LayoutInflater.from(this);

        calendarGrid.removeAllViews();

        for (int day = daysInPrevMonth - firstDayOfWeek + 1; day <= daysInPrevMonth - 2; day++) {
            addDayToCalendar(inflater, day, true);
        }

        calendar.add(Calendar.MONTH, 1);
        for (int day = 1; day <= daysInMonth; day++) {
            if (day == 9) {
                addDayToCalendar(inflater, day, true);
            } else {
                addDayToCalendar(inflater, day, false);
            }
        }

        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        int firstDayOfNextMonth = calendar.get(Calendar.DAY_OF_WEEK) - 1;

        for (int day = 1; day <= 2 - firstDayOfNextMonth; day++) {
            addDayToCalendar(inflater, day, true);
        }
    }

    private TextView selectedDayView = null;

    private void addDayToCalendar(LayoutInflater inflater, int day, boolean isOutOfMonth) {
        View dayView = inflater.inflate(R.layout.daycard, calendarGrid, false);
        TextView dayTextView = dayView.findViewById(R.id.day);
        dayTextView.setText(String.valueOf(day));

        if (isOutOfMonth) {
            dayTextView.setTextColor(getResources().getColor(R.color.unactivetext));
            dayTextView.setBackgroundResource(R.drawable.unactiveday);
        } else {
            // Set an OnClickListener for the dayView
            dayView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (selectedDayView != null) {
                        selectedDayView.setBackgroundResource(R.drawable.day_background);
                    }

                    // Change the background of the clicked TextView to dayselected
                    dayTextView.setBackgroundResource(R.drawable.dayselected);

                    // Update the currently selected TextView
                    selectedDayView = dayTextView;

                    // When the dayView is clicked, update the bookingDay TextView to the day clicked
                    TextView bookingDay = findViewById(R.id.bookingDay);
                    bookingDay.setText(dayTextView.getText() + " Juli 2024");
                }
            });
        }

        GridLayout.LayoutParams params = new GridLayout.LayoutParams();

        params.columnSpec = GridLayout.spec(calendarGrid.getChildCount() % 7);
        params.rowSpec = GridLayout.spec(calendarGrid.getChildCount() / 7);

        params.setMargins(20, 16,20,16);

        dayView.setLayoutParams(params);

        calendarGrid.addView(dayView);
    }
}