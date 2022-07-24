package com.sahan.csd71app.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.sahan.csd71app.R;
import com.sahan.csd71app.adapter.PagerAdapter;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        ViewPager2 viewPager2 = (ViewPager2) findViewById(R.id.viewPager);

        PagerAdapter pagerAdapter = new PagerAdapter(this);
        viewPager2.setAdapter(pagerAdapter);

        String[] titles = {"Movies", "Tv Shows", "Notifications"};
        TabLayoutMediator.TabConfigurationStrategy strategy = new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(titles[position]);
            }
        };

        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager2, strategy);
        tabLayoutMediator.attach();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        switch (id){
            case R.id.menuProfile:
                Toast.makeText(getApplicationContext(), "Profile will be visible", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuSettings:
                Toast.makeText(getApplicationContext(), "Settings...", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuAbout:
                Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
                startActivity(intent);
                break;

        }

        return super.onOptionsItemSelected(item);
    }
}