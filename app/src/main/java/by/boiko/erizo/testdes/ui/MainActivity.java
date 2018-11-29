package by.boiko.erizo.testdes.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import by.boiko.erizo.testdes.R;
import by.boiko.erizo.testdes.data.response.ResponseInfo;
import by.boiko.erizo.testdes.ui.adapters.InfoAdapter;
import by.boiko.erizo.testdes.ui.base.BaseActivity;

public class MainActivity extends BaseActivity implements MainMvpView, InfoAdapter.Callback {

    @Inject
    MainMvpPresenter<MainMvpView> presenter;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    private InfoAdapter infoAdapter;
    private ResponseInfo responseInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        getScreenComponent().inject(this);
        presenter.onAttach(this);

        responseInfo = new ResponseInfo();
        presenter.getInfo();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        infoAdapter = new InfoAdapter();
        infoAdapter.setCallback(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(infoAdapter);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    public void onInfoGeted(ResponseInfo responseInfo) {
        this.responseInfo = responseInfo;
        infoAdapter.setItems(responseInfo);
        recyclerView.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showMoreInfo(int position) {
        Intent intent = new Intent(this, MoreInfoActivity.class);
        intent.putExtra("IMAGE", responseInfo.getResponseImages().get(position).getBigImage());
        intent.putExtra("TITLE", responseInfo.getResponseArticles().get(position).getTitle());
        intent.putExtra("DESCRIPTION", responseInfo.getResponseArticles().get(position).getBody());
        startActivity(intent);
    }
}
