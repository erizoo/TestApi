package by.boiko.erizo.testdes.ui;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import by.boiko.erizo.testdes.R;
import by.boiko.erizo.testdes.ui.base.BaseActivity;

public class MoreInfoActivity extends BaseActivity {

    @BindView(R.id.title)
    TextView titleTextView;
    @BindView(R.id.description)
    TextView descriptionTextView;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;
    @BindView(R.id.layout)
    RelativeLayout relativeLayout;

    private String title;
    private String description;
    private String imageUrl;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);


        title = Objects.requireNonNull(getIntent().getExtras()).getString("TITLE", "");
        description = Objects.requireNonNull(getIntent().getExtras()).getString("DESCRIPTION", "");
        imageUrl = Objects.requireNonNull(getIntent().getExtras()).getString("IMAGE", "");

        Glide.with(getContext())
                .load(imageUrl)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        progressBar.setVisibility(View.GONE);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        titleTextView.setText(title);
                        descriptionTextView.setText(description);
                        progressBar.setVisibility(View.GONE);
                        relativeLayout.setVisibility(View.VISIBLE);
                        return false;
                    }
                })
                .into(imageView);

    }

    @Override
    protected int getContentView() {
        return R.layout.more_info_activity;
    }
}
