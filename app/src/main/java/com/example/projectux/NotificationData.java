package com.example.projectux;

import java.util.ArrayList;

public class NotificationData {
    private static String [] reminderHari = {
            "H-10",
            "H-7",
            "H-3",
            "H-1"
    };

    private static String [] deskripsi = {
            "Sepuluh hari lagi tes kesehatan, mulai persiapkan diri dari sekarang!",
            "Satu minggu lagi kamu akan menjalani tes kesehatan. Catat tanggalnya.",
            "Tiga hari lagi kamu harus melakukan tes kesehatan. Jangan lupa!",
            "Besok adalah jadwal tes kesehatanmu. Pastikan kamu datang tepat waktu!"
    };

    private static  int[] logoApp = {
            R.drawable.logohealthyu,
            R.drawable.logohealthyu,
            R.drawable.logohealthyu,
            R.drawable.logohealthyu
    };

    static ArrayList<Reminder> getListData(){
        ArrayList<Reminder> list = new ArrayList<>();
        for (int position = 0; position < reminderHari.length; position++){
            Reminder reminder = new Reminder();
            reminder.setReminder(reminderHari[position]);
            reminder.setDeskripsi(deskripsi[position]);
            reminder.setLogo(logoApp[position]);

            list.add(reminder);
        }

        return list;
    }
}
