package no.nordicsemi.android.nrfmesh.viewmodels;

<<<<<<< HEAD
import androidx.annotation.NonNull;
<<<<<<<< HEAD:app/src/main/java/no/nordicsemi/android/nrfmesh/viewmodels/AddedScenesViewModel.java
import androidx.hilt.lifecycle.ViewModelInject;
========
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import dagger.hilt.android.lifecycle.HiltViewModel;
import no.nordicsemi.android.mesh.ApplicationKey;
>>>>>>>> master-nordic:app/src/main/java/no/nordicsemi/android/nrfmesh/viewmodels/EditAppKeyViewModel.java
=======
import javax.inject.Inject;

import androidx.annotation.NonNull;
import dagger.hilt.android.lifecycle.HiltViewModel;
>>>>>>> master-nordic
import no.nordicsemi.android.nrfmesh.keys.AppKeysActivity;

/**
 * ViewModel for {@link AppKeysActivity}
 */
<<<<<<< HEAD
<<<<<<<< HEAD:app/src/main/java/no/nordicsemi/android/nrfmesh/viewmodels/AddedScenesViewModel.java
public class AddedScenesViewModel extends BaseViewModel {
========
@HiltViewModel
public class EditAppKeyViewModel extends BaseViewModel {

    private ApplicationKey appKey;
    final MutableLiveData<ApplicationKey> appKeyLiveData = new MutableLiveData<>();
>>>>>>>> master-nordic:app/src/main/java/no/nordicsemi/android/nrfmesh/viewmodels/EditAppKeyViewModel.java

    @ViewModelInject
    AddedScenesViewModel(@NonNull final NrfMeshRepository nrfMeshRepository) {
        super(nrfMeshRepository);
    }

    /**
     * Returns the app key live data
     */
    public LiveData<ApplicationKey> getAppKeyLiveData() {
        return appKeyLiveData;
    }

    /**
     * Selects the key based on the application key index.
     *
     * @param index key index
     */
    public void selectAppKey(final int index) {
        appKey = getNetworkLiveData().getMeshNetwork().getAppKey(index);
        appKeyLiveData.setValue(appKey);
    }

    /**
     * Sets the application key
     *
     * @param key Key
     * @return true if successful or false otherwise
     */
    public boolean setKey(@NonNull final String key) {
        if (getNetworkLiveData().getMeshNetwork().updateAppKey(appKey, key)) {
            selectAppKey(appKey.getKeyIndex());
            return true;
        }
        return false;
    }

    /**
     * Sets the name.
     *
     * @param name Application key name.
     */
    public boolean setName(@NonNull final String name) {
        appKey.setName(name);
        if (getNetworkLiveData().getMeshNetwork().updateAppKey(appKey)) {
            selectAppKey(appKey.getKeyIndex());
            return true;
        }
        return false;
    }

    /**
     * Sets the bound net key index.
     */
    public void setBoundNetKeyIndex(final int index) {
        try {
            final ApplicationKey appKey = this.appKey.clone();
            appKey.setBoundNetKeyIndex(index);
            if (getNetworkLiveData().getMeshNetwork().updateAppKey(appKey)) {
                selectAppKey(appKey.getKeyIndex());
            }
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
=======
@HiltViewModel
public class AddedScenesViewModel extends BaseViewModel {

    @Inject
    AddedScenesViewModel(@NonNull final NrfMeshRepository nrfMeshRepository) {
        super(nrfMeshRepository);
    }
>>>>>>> master-nordic
}
