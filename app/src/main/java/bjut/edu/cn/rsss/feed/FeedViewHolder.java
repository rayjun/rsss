package bjut.edu.cn.rsss.feed;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import bjut.edu.cn.rsss.R;

/**
 * Created by ray on 2017/3/29.
 */

public class FeedViewHolder extends RecyclerView.ViewHolder {

    TextView textView;

    public FeedViewHolder(View itemView) {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.title);
    }
}
