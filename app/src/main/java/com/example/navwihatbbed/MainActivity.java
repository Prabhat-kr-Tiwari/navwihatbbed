package com.example.navwihatbbed;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity
{
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;

    TabLayout tabLayout;
    TabItem tab1,tab2,tab3;
    ViewPager viewPager;
    fragmentmanager fragmentmanager;
    Button settingButton;





    EditText otp_textbox_one, otp_textbox_two, otp_textbox_three, otp_textbox_four,otp_textbox_five,otp_textbox_six;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setTitle("Your Massenger");
        Toolbar toolbar=(Toolbar)findViewById(R.id.custom_toolbar);
        setSupportActionBar(toolbar);
        final View id1 = findViewById(R.id.id1);

        tabLayout=(TabLayout)findViewById(R.id.ctablayout);
        tab1=(TabItem)findViewById(R.id.ctab1);
        tab2=(TabItem)findViewById(R.id.ctab2);
        tab3=(TabItem)findViewById(R.id.ctab3);
        viewPager=(ViewPager)findViewById(R.id.pageholder);

        otp_textbox_one = findViewById(R.id.otp_edit_box1);
        otp_textbox_two = findViewById(R.id.otp_edit_box2);
        otp_textbox_three = findViewById(R.id.otp_edit_box3);
        otp_textbox_four = findViewById(R.id.otp_edit_box4);
        otp_textbox_five = findViewById(R.id.otp_edit_box5);
        otp_textbox_six = findViewById(R.id.otp_edit_box6);
        settingButton=findViewById(R.id.settingButton);




        drawerLayout=(DrawerLayout)findViewById(R.id.mydrawer);
        navigationView=(NavigationView)findViewById(R.id.cnav);
        toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        fragmentmanager=new fragmentmanager(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,tabLayout.getTabCount());
        viewPager.setAdapter(fragmentmanager);

        EditText[] edit = {otp_textbox_one, otp_textbox_two, otp_textbox_three, otp_textbox_four,otp_textbox_five,otp_textbox_six};
      /*  final View finalId = id1;
        id1=findViewById(R.id.id1);*/

       /* View finalId1 = id1;
        finalId1=findViewById(R.id.id1);

        final View finalId = finalId1;*/

        settingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id1.setVisibility(View.VISIBLE);

            }
        });




        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {
                if(item.getItemId()==R.id.home)
                    Toast.makeText(getApplicationContext(),"Home is clicked",Toast.LENGTH_LONG).show();

                if(item.getItemId()==R.id.call)
                    Toast.makeText(getApplicationContext(),"Call is clicked",Toast.LENGTH_LONG).show();

                if(item.getItemId()==R.id.setting)
                    Toast.makeText(getApplicationContext(),"Setting is clicked",Toast.LENGTH_LONG).show();

                drawerLayout.closeDrawer(GravityCompat.START);
                return false;
            }
        });


    }
}