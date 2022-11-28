package com.tz.todolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton buttonAddNote;
    LinearLayout linearLayoutNotes;

    ArrayList<Note> notes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            Note note = new Note(i, String.format("Note %s", i), random.nextInt(3));
            notes.add(note);
        }

        showNotes();
    }

    private void initViews() {
        buttonAddNote = findViewById(R.id.buttonAddNote);
        linearLayoutNotes = findViewById(R.id.linearLayoutNotes);
    }

    private void showNotes() {
        for (Note note : notes) {
            View view = getLayoutInflater().inflate(R.layout.note_item, linearLayoutNotes, false);
            TextView textViewNote = view.findViewById(R.id.textViewNote);
            textViewNote.setText(note.getText());

            int colorId;
            switch (note.getPriority()) {
                case 1:
                    colorId = android.R.color.holo_green_light;
                    break;
                case 2:
                    colorId = android.R.color.holo_orange_light;
                    break;
                default:
                    colorId = android.R.color.holo_red_light;
            }
            int color = ContextCompat.getColor(this, colorId);
            textViewNote.setBackgroundColor(color);
            linearLayoutNotes.addView(view);
        }

    }
}