package by.boiko.erizo.testdes.di.module;

import android.content.Context;



import javax.inject.Singleton;

import by.boiko.erizo.testdes.TestDes;
import by.boiko.erizo.testdes.data.RepositoryManager;
import by.boiko.erizo.testdes.data.RepositoryManagerImpl;
import by.boiko.erizo.testdes.di.ApplicationContext;
import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final TestDes application;

    public ApplicationModule(TestDes application) {
        this.application = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return application;
    }

    @Provides
    TestDes provideApplication() {
        return application;
    }

    @Provides
    @Singleton
    RepositoryManager provideRepositoryManager(RepositoryManagerImpl repositoryManager) {
        return repositoryManager;
    }
}

