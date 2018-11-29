package by.boiko.erizo.testdes.ui.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import by.boiko.erizo.testdes.R;
import by.boiko.erizo.testdes.data.response.ResponseArticles;
import by.boiko.erizo.testdes.data.response.ResponseImages;
import by.boiko.erizo.testdes.data.response.ResponseInfo;
import by.boiko.erizo.testdes.ui.base.BaseViewHolder;

public class InfoAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    public Context context;
    private List<ResponseArticles> responseArticles = new ArrayList<>();
    private List<ResponseImages> responseImages = new ArrayList<>();
    private Callback callback;

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new InfoAdapter.InfoViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.items_info_rv, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return responseArticles.size();
    }

    public void setItems(ResponseInfo responseInfo) {
        this.responseArticles.addAll(responseInfo.getResponseArticles());
        this.responseImages.addAll(responseInfo.getResponseImages());
        notifyDataSetChanged();
    }

    public interface Callback{

        void showMoreInfo(int position);

    }

    public void setCallback(Callback callback){
        this.callback = callback;
    }

    public class InfoViewHolder extends BaseViewHolder {

        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.layout)
        RelativeLayout layout;
        @BindView(R.id.imageView)
        ImageView imageView;

        public InfoViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            context = itemView.getContext();
        }

        @Override
        public void onBind(int position) {
            layout.setOnClickListener(v -> callback.showMoreInfo(position));
            Glide.with(context)
                    .load(responseImages.get(position).getSmallImage())
                    .into(imageView);
            title.setText(responseArticles.get(position).getTitle());

        }
    }
}