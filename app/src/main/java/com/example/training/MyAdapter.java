package com.example.training;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class MyAdapter extends FragmentStateAdapter {
    private ArrayList<ModelFragment> fragments;
    public void setFragments(ArrayList<ModelFragment> fragments){
        this.fragments = fragments;
    }

    public MyAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public MyAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    public MyAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragments.get(position).getFragment();
    }

    @Override
    public int getItemCount() {
        return fragments==null ?0 :fragments.size();
    }
}
