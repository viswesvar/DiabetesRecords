package com.assignment.diabetesrecords.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.assignment.diabetesrecords.R;
import com.assignment.diabetesrecords.fragments.DoctorFragment;
import com.assignment.diabetesrecords.fragments.EntriesFragment;
import com.assignment.diabetesrecords.fragments.FoodExerciseFragment;
import com.assignment.diabetesrecords.fragments.GraphFragment;
import com.assignment.diabetesrecords.fragments.MedicineFragment;
import com.assignment.diabetesrecords.fragments.SummaryFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements
        FragmentManager.OnBackStackChangedListener {

    /** The Drawer toggle. */
    private ActionBarDrawerToggle mDrawerToggle;

    /** The Drawer layout. */
    private DrawerLayout mDrawerLayout;

    private ImageView ivProfile;

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private int[] tabIcons = {
            R.drawable.summary,
            R.drawable.entries,
            R.drawable.graph,
            R.drawable.medicine,
            R.drawable.doctor,
            R.drawable.exercisse
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();

        ivProfile = (ImageView) findViewById(R.id.ivProfile);
        ivProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in= new Intent(MainActivity.this, MyProfileActivity.class);
                startActivity(in);
            }
        });

        initLeftSlidingMenu(); //LK: Added here..
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        //=================================================
        initActionbar();



    }



    /**
     * Inits the actionbar.
     */
    private void initActionbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        LayoutInflater inflater = LayoutInflater.from(this);
        View toolbarLayout = (RelativeLayout) inflater.inflate(
                R.layout.ab_custom, null);



        Toolbar.LayoutParams layoutParams = new Toolbar.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        toolbar.addView(toolbarLayout, layoutParams);
        toolbar.bringToFront();

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                toolbar, R.string.drawer_open, R.string.drawer_close) {

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

                super.onDrawerSlide(drawerView, slideOffset);
            }

            /** Called when a drawer has settled in a completely closed state. */
            @Override
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getSupportActionBar().setTitle(getString(R.string.app_name));
            }

            /** Called when a drawer has settled in a completely open state. */
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle(
                        getString(R.string.app_name));
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);

        mDrawerToggle
                .setToolbarNavigationClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                       // checkForBackStackCounter(); //LK2
                    }
                });

    }




    /**
     * Inits the left sliding menu.
     */
    public void initLeftSlidingMenu() {



        RelativeLayout RLMyProfile;
        RLMyProfile = (RelativeLayout) findViewById(R.id.RLMyProfile);
        RLMyProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.closeDrawer(GravityCompat.START);

                Intent in= new Intent(MainActivity.this, MyProfileActivity.class);
                startActivity(in);

            }
        });




        RelativeLayout RLEntries;
        RLEntries  = (RelativeLayout) findViewById(R.id.RLEntries);

        RLEntries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mDrawerLayout.closeDrawer(GravityCompat.START);
                tabLayout.getTabAt(1).select();
            }
        });



        RelativeLayout RLGraph;
        RLGraph  = (RelativeLayout) findViewById(R.id.RLGraph);

        RLGraph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mDrawerLayout.closeDrawer(GravityCompat.START);
                tabLayout.getTabAt(2).select();
            }
        });



        RelativeLayout RLReminder;
        RLReminder = (RelativeLayout) findViewById(R.id.RLReminder);
        RLReminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.closeDrawer(GravityCompat.START);

                Intent in= new Intent(MainActivity.this, AddReminderActivity.class);
                startActivity(in);

            }
        });

    }


    /*
     * (non-Javadoc)
     *
     * @see android.app.Activity#onPostCreate(android.os.Bundle)
     */
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        mDrawerToggle.syncState();
    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
        tabLayout.getTabAt(3).setIcon(tabIcons[3]);
        tabLayout.getTabAt(4).setIcon(tabIcons[4]);
        tabLayout.getTabAt(5).setIcon(tabIcons[5]);


    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new SummaryFragment(), "Summary");
        adapter.addFrag(new EntriesFragment(), "Entries");
        adapter.addFrag(new GraphFragment(), "Graph");
        adapter.addFrag(new MedicineFragment(), "Medicine");
        adapter.addFrag(new DoctorFragment(), "Doctor");
        adapter.addFrag(new FoodExerciseFragment(), "Food & Exercise");
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onBackStackChanged() {

    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }



}