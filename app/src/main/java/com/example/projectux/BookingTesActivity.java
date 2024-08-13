package com.example.projectux;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class BookingTesActivity extends AppCompatActivity {

    private GridLayout calendarGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bookingtes);

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

            // In your onCreate method, after generating the initial calendar:

            // Get references to the buttons
            ImageView buttonNextMonth = findViewById(R.id.buttonnextmonth);
            ImageView buttonBackMonth = findViewById(R.id.buttonbackmonth);

            // Create a Calendar instance for the current month
            Calendar currentMonth = Calendar.getInstance();
            currentMonth.set(Calendar.YEAR, calendar.get(Calendar.YEAR));
            currentMonth.set(Calendar.MONTH, calendar.get(Calendar.MONTH));

            // Format the current month and year
            SimpleDateFormat sdf = new SimpleDateFormat("MMMM yyyy", new Locale("in","ID"));
            String formattedDate = sdf.format(currentMonth.getTime());

            // Set the monthYearText to the formatted date
            TextView monthYearText = findViewById(R.id.monthYearText);
            monthYearText.setText(formattedDate);

            // Set the OnClickListener for buttonNextMonth
            buttonNextMonth.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Increment the month
                    currentMonth.add(Calendar.MONTH, 1);
                    // Regenerate the calendar
                    generateCalendar(currentMonth.get(Calendar.YEAR), currentMonth.get(Calendar.MONTH));

                    String formattedDate = sdf.format(currentMonth.getTime());

                    // Set the monthYearText to the formatted date
                    monthYearText.setText(formattedDate);
                }
            });

            // Set the OnClickListener for buttonBackMonth
            buttonBackMonth.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Decrement the month
                    currentMonth.add(Calendar.MONTH, -1);
                    // Regenerate the calendar
                    generateCalendar(currentMonth.get(Calendar.YEAR), currentMonth.get(Calendar.MONTH));

                    String formattedDate = sdf.format(currentMonth.getTime());

                    // Set the monthYearText to the formatted date
                    monthYearText.setText(formattedDate);
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

        int firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK); // 1 for Sunday, 2 for Monday, etc.

        // If the first day of the month is not Sunday
        if (firstDayOfWeek != Calendar.SUNDAY) {
            // Calculate the dates for the days of the previous week up to and including Saturday
            for (int i = 1; i < firstDayOfWeek; i++) {
                calendar.add(Calendar.DAY_OF_MONTH, -1); // previous day
                addDayToCalendar(LayoutInflater.from(this), calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.MONTH), calendar.get(Calendar.YEAR), true, 0);
            }
            // Reset the calendar to the first day of the current month
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, month);
            calendar.set(Calendar.DAY_OF_MONTH, 1);
        }

        int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        calendar.add(Calendar.MONTH, -1);

        LayoutInflater inflater = LayoutInflater.from(this);

        calendarGrid.removeAllViews();


        // Add views for the days of the current month
        for (int day = 1; day <= daysInMonth; day++) {
            addDayToCalendar(inflater, day, month, year, false,firstDayOfWeek-1);
        }


    }

    private TextView selectedDayView = null;


    private void addDayToCalendar(LayoutInflater inflater, int day, int month, int year, boolean isOutOfMonth, int firstDayOfWeek) {
        View dayView = inflater.inflate(R.layout.daycard, calendarGrid, false);
        TextView dayTextView = dayView.findViewById(R.id.day);
        dayTextView.setText(String.valueOf(day));

        // Create a Calendar instance for the day
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, day);

        // Create a Calendar instance for today
        Calendar today = Calendar.getInstance();

        // If the day is today or after today, make it unactive
        if (calendar.before(today)) {
            dayTextView.setBackgroundResource(R.drawable.unactiveday);
            dayView.setClickable(false);
        } else {
            // Set an OnClickListener for the dayView
            dayView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // If there is a previously selected dayView, change its background back to the default background
                    if (selectedDayView != null) {
                        selectedDayView.setBackgroundResource(R.drawable.day_background);
                    }
                    
                    dayTextView.setBackgroundResource(R.drawable.dayselected);

                    selectedDayView = dayTextView;

                    TextView bookingDay = findViewById(R.id.bookingDay);

                    // Format the date
                    SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy", new Locale("in","ID"));
                    String formattedDate = sdf.format(calendar.getTime());

                    // Set the bookingDay text to the formatted date
                    bookingDay.setText(formattedDate);
                }
            });
        }

        GridLayout.LayoutParams params = new GridLayout.LayoutParams();

        // Set the column of the TextView to the day of the week
        params.columnSpec = GridLayout.spec((firstDayOfWeek + day - 1) % 7);

        // Set the row of the TextView to the week of the month
        params.rowSpec = GridLayout.spec((firstDayOfWeek + day - 1) / 7);

        params.setMargins(20, 16,20,16);

        dayView.setLayoutParams(params);

        calendarGrid.addView(dayView);
    }
}