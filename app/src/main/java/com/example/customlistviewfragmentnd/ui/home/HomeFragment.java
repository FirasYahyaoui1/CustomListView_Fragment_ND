package com.example.customlistviewfragmentnd.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.customlistviewfragmentnd.R;

import java.util.ArrayList;
import java.util.HashMap;

public class HomeFragment extends Fragment {


    private HomeViewModel homeViewModel;
    private ListView maList;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);

        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }

        });
        maList = root.findViewById(R.id.listviewperso);
        ArrayList<HashMap<String,String>> listItem = new ArrayList<>();
        HashMap<String, String> map;
        map = new HashMap<>();
        map.put("titre","word");
        map.put("description","Editeur de text");
        map.put("img", String.valueOf(R.drawable.word));
        listItem.add(map);

        map = new HashMap<>();
        map.put("titre","exel");
        map.put("description","tableur");
        map.put("img", String.valueOf(R.drawable.excel));
        listItem.add(map);

        map = new HashMap<>();
        map.put("titre","Powerpoint");
        map.put("description", String.valueOf(R.string.text_description));
        map.put("img",String.valueOf(R.drawable.powerpoint));
        listItem.add(map);
        map = new HashMap<>();
        map.put("titre","outlook");
        map.put("description","Client de courrier");
        map.put("img",String.valueOf(R.drawable.outlook));
        listItem.add(map);



        SimpleAdapter adapter = new SimpleAdapter(getActivity().getBaseContext(),listItem,R.layout.activity_list_item,
                new String[] {"img", "titre", "description"},
                new int[] {R.id.img, R.id.titre, R.id.description});
        maList.setAdapter(adapter);
        return root;




    }



}