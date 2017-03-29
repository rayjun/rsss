package bjut.edu.cn.rsss.feed;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.ArrayList;

import bjut.edu.cn.rsss.R;
import bjut.edu.cn.rsss.common.entity.Feed;
import butterknife.BindView;
import butterknife.ButterKnife;


public class FeedsFragment extends Fragment {

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    FeedAdapter feedAdapter;

    @BindView(R.id.progressBar)
    ProgressBar mProgressBar;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_feeds, null);
        ButterKnife.bind(this, view);

        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());


        feedAdapter = new FeedAdapter(this, getActivity());
        mRecyclerView.setAdapter(feedAdapter);

        Feed feed = new Feed();
        feed.setTitle("阮一峰");

        Feed feed1 = new Feed();
        feed1.setTitle("阮一峰");

        Feed feed2 = new Feed();
        feed2.setTitle("阮一峰");

        Feed feed3 = new Feed();
        feed3.setTitle("阮一峰");

        ArrayList<Feed> feeds = new ArrayList<>();
        feeds.add(feed);
        feeds.add(feed1);
        feeds.add(feed2);
        feeds.add(feed3);

        feedAdapter.updateItems(feeds, false);

        mProgressBar.setVisibility(View.GONE);

        return view;
    }
}
