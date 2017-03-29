package bjut.edu.cn.rsss.feed;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;

import java.util.ArrayList;
import java.util.List;

import bjut.edu.cn.rsss.R;
import bjut.edu.cn.rsss.common.entity.Feed;
import bjut.edu.cn.rsss.common.util.Utils;

/**
 * Created by ray on 2017/3/29.
 */

public class FeedAdapter extends RecyclerView.Adapter<FeedViewHolder> {

    private FeedsFragment feedsFragment;
    private List<Feed> mFeeds = new ArrayList<>();


    private static final int ANIMATED_ITEMS_COUNT = 4;
    private boolean animateItems = false;
    private int lastAnimatedPosition = -1;
    private final int mBackground;
    private final TypedValue mTypedValue = new TypedValue();


    public FeedAdapter(FeedsFragment f, Context context) {
        this.feedsFragment = f;
        context.getTheme().resolveAttribute(R.attr.selectableItemBackground, mTypedValue, true);
        mBackground = mTypedValue.resourceId;
    }


    private void runEnterAnimation(View view, int position) {
        if (!animateItems || position >= ANIMATED_ITEMS_COUNT - 1) {
            return;
        }

        if (position > lastAnimatedPosition) {
            lastAnimatedPosition = position;
            view.setTranslationY(Utils.getScreenHeight(feedsFragment.getActivity()));
            view.animate()
                    .translationY(0)
                    .setStartDelay(100 * position)
                    .setInterpolator(new DecelerateInterpolator(3.f))
                    .setDuration(700)
                    .start();
        }
    }


    public void updateItems(List<Feed> feeds, boolean animated) {
        animateItems = animated;
        lastAnimatedPosition = -1;
        mFeeds.addAll(feeds);
        notifyDataSetChanged();
    }

    public void clearItems() {
        mFeeds.clear();
        notifyDataSetChanged();
    }

    @Override
    public FeedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.feed_item, parent, false);
        FeedViewHolder fvh = new FeedViewHolder(v);

        return fvh;
    }

    @Override
    public void onBindViewHolder(FeedViewHolder holder, int position) {
        runEnterAnimation(holder.itemView, position);
        Feed feed = mFeeds.get(position);
        holder.textView.setText(feed.getTitle());
    }

    @Override
    public int getItemCount() {
        return mFeeds.size();
    }
}
