package com.example.pigeo.testsimpson;


import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

public class ListFragment extends Fragment {
    ListFramentInterface client;
    private static String chars[] = {
            "Bart", "Flanders",
            "Homer", "Lisa",
            "Marge", "Mr. Burns"};
    private static int images[] = {
            R.drawable.bart, R.drawable.flanders,
            R.drawable.homer, R.drawable.lisa,
            R.drawable.marge, R.drawable.mrburns};

    public ListFragment() {
        // Required empty public constructor
    }

    public interface ListFramentInterface {
        void onItemSelected(int i);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_list, container, false);

        ArrayAdapter adapter = new ArrayAdapter<String>(
                v.getContext(), android.R.layout.simple_list_item_1, chars);

        ListView lv = (ListView) v.findViewById(R.id.listView);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                client.onItemSelected(images[position]);
            }
        });
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        client = (ListFramentInterface)context;
    }

}
