package com.bb.myfragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Person> personList;
    private TextView mTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = findViewById(R.id.message);

        // add base fragment when activity starts
        getSupportFragmentManager().beginTransaction()
                .add(R.id.main_container, new ColorsFrags()).commit();


        // bottom navigation ref
        BottomNavigationView navigation = findViewById(R.id.navigation);
        // set listener
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    // create listener
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    setMyFrag(new ColorsFrags());
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    setMyFrag(new GoogleFragment());
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    private void setMyFrag(Fragment myFrag) {
        // find more about flexible ui in -> https://developer.android.com/training/basics/fragments/fragment-ui

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack so the user can navigate back
        transaction.replace(R.id.main_container, myFrag);
        transaction.addToBackStack(null);

        // Commit the transaction
        transaction.commit();
    }

    private void createPersons(){
        personList = new ArrayList<>();
        personList.add(new Person("Adi", 70.7, 18, true));
        personList.add(new Person("Efrat", 60.3, 21, false));
        personList.add(new Person("Jon", 76.7, 43, true));
        personList.add(new Person("moti", 71.5, 16, true));
        personList.add(new Person("Shay", 75.2, 74, true));
        personList.add(new Person("Yael", 63.9, 34, false));
        personList.add(new Person("Itai", 78.2, 23, true));
        personList.add(new Person("Sharon", 53.4, 56, false));
        personList.add(new Person("Shalom", 76.2, 18, true));
        personList.add(new Person("Olga", 47.0, 63, false));
        personList.add(new Person("Bibi", 74.9, 45, true));
        personList.add(new Person("Miri", 48.7, 66, false));
        personList.add(new Person("Revital", 84.5, 53, false));
        personList.add(new Person("Nitzan", 79.2, 42, true));
        personList.add(new Person("Yechiel", 73.1, 36, true));
    }

}
