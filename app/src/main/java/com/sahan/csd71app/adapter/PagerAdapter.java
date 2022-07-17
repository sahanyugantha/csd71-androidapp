package com.sahan.csd71app.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.sahan.csd71app.view.MoviesFragment;
import com.sahan.csd71app.view.NotificationsFragment;
import com.sahan.csd71app.view.TvShowsFragment;

public class PagerAdapter extends FragmentStateAdapter {

    public PagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = null;

        switch (position){
            case 0:
                fragment = new MoviesFragment();
                break;
            case 1:
                fragment = new TvShowsFragment();
                break;
            case 2:
                fragment = new NotificationsFragment();
                break;
        }

        return fragment;
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
