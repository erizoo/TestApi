package by.boiko.erizo.testdes.ui;

import by.boiko.erizo.testdes.data.response.ResponseInfo;
import by.boiko.erizo.testdes.ui.base.MvpView;

public interface MainMvpView  extends MvpView {

    void onInfoGeted(ResponseInfo responseInfo);

}
