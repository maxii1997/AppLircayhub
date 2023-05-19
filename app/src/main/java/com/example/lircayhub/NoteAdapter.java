package com.example.lircayhub;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NoteAdapter extends ArrayAdapter<Note> {

    private List<Note> notes;

    public void setFilteredList(List<Note> filteredList){
        this.notes = filteredList;
        notifyDataSetChanged();
    }

    public NoteAdapter(Context context, List<Note> notes){
        super(context, 0, notes);
        this.notes = notes;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Note note = getItem(position);
        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.note_cell, parent, false);

        TextView title = convertView.findViewById(R.id.cellTitle);
        TextView desc = convertView.findViewById(R.id.cellDesc);

        title.setText(note.getTitle());
        desc.setText(note.getDescription());

        return convertView;
    }
}
