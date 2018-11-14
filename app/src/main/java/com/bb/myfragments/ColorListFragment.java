package com.bb.myfragments;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;


public class ColorListFragment extends Fragment {
    ListView listCbColors;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_color_list, container, false);
        final String[] colors = {"Red", "Green", "Blue", "Black", "White", "Gray", "Magenta", "Yellow",
                            "Light Gray", "Dark Gray", "Light Grey", "Dark Grey", "Olive",
                            "Teal", "Silver", "Purple", "Cyan", "Aqua", "Fuchsia", "Lime", "Maroon", "Navy"};


        listCbColors = view.findViewById(R.id.listColors);
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, colors);
        listCbColors.setAdapter(adapter);
        listCbColors.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                BgColorFragment bgColorFragment = (BgColorFragment) getFragmentManager().findFragmentById(R.id.bgColorFragments);
                setBgColor(bgColorFragment, colors[position].toLowerCase().replace(" ", ""));
                FrameLayout frameLayout = bgColorFragment.getView().findViewById(R.id.bgColorFragments);
                TextView lblColor = new TextView(bgColorFragment.getContext());
                lblColor.setText(colors[position]);
                lblColor.setTextSize(20);
                frameLayout.removeAllViews();
                frameLayout.addView(lblColor);
            }
        });


        return view;
    }

    public void setBgColor(Fragment fragment, String color){
        fragment.getView().setBackgroundColor(Color.parseColor(color));
    }

}
