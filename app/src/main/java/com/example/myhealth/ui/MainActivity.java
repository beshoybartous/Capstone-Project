package com.example.myhealth.ui;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.myhealth.Constants;
import com.example.myhealth.R;
import com.example.myhealth.databinding.ActivityMainBinding;
import com.example.myhealth.model.ExerciseDB;
import com.example.myhealth.ui.fragment.HomeFragment;
import com.example.myhealth.ui.fragment.MapsFragment;
import com.example.myhealth.ui.fragment.WorkoutFragment;
import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding= DataBindingUtil.setContentView( this, R.layout.activity_main);
        Toolbar toolbar = (Toolbar) mainBinding.toolbar;

        setSupportActionBar(toolbar);
        mainBinding.navView.setOnNavigationItemSelectedListener(navListener);
        if(savedInstanceState==null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment()).commit();
        }
        Intent intent=getIntent();
        if(intent!=null){
            if(intent.getBooleanExtra(Constants.OPEN_FROM_WDIGET,false)) {
                ExerciseDB exe;
                exe=intent.getParcelableExtra(Constants.SEND_EXERCISE);
                openExercise( exe );
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.log_out, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.log_out:
                AuthUI.getInstance().signOut(this)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            public void onComplete(@NonNull Task<Void> task) {
                                // user is now signed out
                                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                                Toast.makeText(MainActivity.this, "You're now signed out. Good Bye.", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        });
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private void openExercise(ExerciseDB exe) {
        if(exe!=null){
        Intent newIntent =new Intent(MainActivity.this, ExerciseDetailActivity.class);
        newIntent.putExtra(Constants.SEND_EXERCISE,exe);
        newIntent.putExtra(Constants.OPEN_FROM_WDIGET,true);
        startActivity(newIntent);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    Fragment selectedFragment;
    int currentFragment=-1;
    boolean newFrag=false;
    private BottomNavigationView.OnNavigationItemSelectedListener navListener=
            new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            selectedFragment= null;
            switch (menuItem.getItemId()) {
                case R.id.navigation_home:
                    if(currentFragment==-1||currentFragment!=R.id.navigation_home) {
                        selectedFragment = new HomeFragment();
                        newFrag=true;
                        currentFragment=R.id.navigation_home;
                    }
                    break;
                case R.id.navigation_gym_near_by:
                    if(currentFragment==-1||currentFragment!=R.id.navigation_gym_near_by) {
                        selectedFragment=new MapsFragment();
                        newFrag=true;
                        currentFragment=R.id.navigation_gym_near_by;
                    }
                    break;
                case R.id.navigation_notifications:
                    if(currentFragment==-1||currentFragment!=R.id.navigation_notifications) {
                        selectedFragment=new WorkoutFragment();
                        newFrag=true;
                        currentFragment=R.id.navigation_notifications;
                    }
                    break;
            }
            if(newFrag) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        selectedFragment).commit();
                newFrag=false;
            }
            return true;
        }
    };
}
