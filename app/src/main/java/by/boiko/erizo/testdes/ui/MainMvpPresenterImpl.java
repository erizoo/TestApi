package by.boiko.erizo.testdes.ui;

import javax.inject.Inject;

import by.boiko.erizo.testdes.data.RepositoryManager;
import by.boiko.erizo.testdes.data.network.ServiceNetwork;
import by.boiko.erizo.testdes.data.response.ResponseInfo;
import by.boiko.erizo.testdes.ui.base.BasePresenter;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class MainMvpPresenterImpl <V extends MainMvpView> extends BasePresenter<V>
        implements MainMvpPresenter<V>{

    @Inject
    public MainMvpPresenterImpl(RepositoryManager repositoryManager, CompositeDisposable compositeDisposable) {
        super(repositoryManager, compositeDisposable);
    }

    @Override
    public void getInfo() {
        ServiceNetwork serviceNetwork = getRepositoryManager().getServiceNetwork();
        getCompositeDisposable().add(
                Observable.zip(
                        serviceNetwork.getText(),
                        serviceNetwork.getImages(),
                        ResponseInfo::new
                )
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                getMvpView()::onInfoGeted,
                                Throwable::printStackTrace
                        )
        );
    }
}
