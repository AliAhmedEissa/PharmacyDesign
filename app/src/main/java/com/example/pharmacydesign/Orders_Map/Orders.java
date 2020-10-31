package com.example.pharmacydesign.Orders_Map;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pharmacydesign.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class Orders extends Fragment {

    private Orders_VM mViewModel;
    View view;
    ViewPager viewPager;
    protected TabLayout tablayout;
    List<String> tabList;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.fr_orders, container, false);

//        getActivity().setTitle("Orders");
//        tablayout = view.findViewById(R.id.tabLayout);
//        viewPager = view.findViewById(R.id.viewPager);

        return view;
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(Orders_VM.class);
        // TODO: Use the ViewModel
    }

    private void initTabLayout() {
        for (String source : tabList) {
            TabLayout.Tab tab = tablayout.newTab();
            tab.setText(source);
            tab.setTag(source);

            tablayout.addTab(tab);
        }
    }




}