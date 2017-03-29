package bjut.edu.cn.rsss;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import bjut.edu.cn.rsss.feed.FeedsFragment;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    ActionBarDrawerToggle mDrawerToggle;

    @BindView(R.id.navigation_view)
    NavigationView mNavigationView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_open,
                R.string.drawer_close);

        mDrawerToggle.syncState();
        mDrawerLayout.addDrawerListener(mDrawerToggle);
        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        mNavigationView.inflateHeaderView(R.layout.navigation_header);
        setupDrawerContent(mNavigationView);
        switchToFeeds();
    }


    private void switchToFeeds() {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new FeedsFragment()).commit();
        mToolbar.setTitle(R.string.feed);
    }

    private void setupDrawerContent(NavigationView navigationView) {

    }
}
