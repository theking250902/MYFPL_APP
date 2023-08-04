package com.example.my_app.oderframent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class OderViewFragment extends FragmentStatePagerAdapter {

    public OderViewFragment(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new ThongBaoFragment();
            case 1:
                return new HoatDongFragment();
            default:
                return new ThongBaoFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Thông Báo";
            case 1:
                return "Hoạt Động";
            default:
                return "Thông Báo";
        }
    }
}
