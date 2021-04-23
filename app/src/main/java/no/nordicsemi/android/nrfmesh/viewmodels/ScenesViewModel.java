package no.nordicsemi.android.nrfmesh.viewmodels;

<<<<<<< HEAD
import androidx.annotation.NonNull;
<<<<<<<< HEAD:app/src/main/java/no/nordicsemi/android/nrfmesh/viewmodels/ScenesViewModel.java
import androidx.hilt.lifecycle.ViewModelInject;
========
import androidx.lifecycle.MutableLiveData;
import dagger.hilt.android.lifecycle.HiltViewModel;
import no.nordicsemi.android.mesh.NetworkKey;
>>>>>>>> master-nordic:app/src/main/java/no/nordicsemi/android/nrfmesh/viewmodels/AddNetKeyViewModel.java
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
<<<<<<<< HEAD:app/src/main/java/no/nordicsemi/android/nrfmesh/viewmodels/ScenesViewModel.java
public class ScenesViewModel extends BaseViewModel {
========
@HiltViewModel
public class AddNetKeyViewModel extends BaseViewModel {

    private final NetworkKey networkKey;
    private final MutableLiveData<NetworkKey> networkKeyLiveData = new MutableLiveData<>();
>>>>>>>> master-nordic:app/src/main/java/no/nordicsemi/android/nrfmesh/viewmodels/AddNetKeyViewModel.java

    @ViewModelInject
    ScenesViewModel(@NonNull final NrfMeshRepository nrfMeshRepository) {
        super(nrfMeshRepository);
        networkKey = getNetworkLiveData().getMeshNetwork().createNetworkKey();
        networkKeyLiveData.setValue(networkKey);
    }

    /**
     * Returns the LiveData object containing the NetworkKey.
     */
    public MutableLiveData<NetworkKey> getNetworkKeyLiveData() {
        return networkKeyLiveData;
    }

    /**
     * Sets the Network Key.
     *
     * @param key Key
     */
    public void setKey(@NonNull final byte[] key) {
        networkKey.setKey(key);
        networkKeyLiveData.setValue(networkKey);
    }

    /**
     * Sets the name.
     *
     * @param name name.
     */
    public void setName(@NonNull final String name) {
        networkKey.setName(name);
        networkKeyLiveData.setValue(networkKey);
    }

    /**
     * Adds the network key
     */
    public boolean addNetKey() {
        return getNetworkLiveData().getMeshNetwork().addNetKey(networkKey);
=======
@HiltViewModel
public class ScenesViewModel extends BaseViewModel {

    @Inject
    ScenesViewModel(@NonNull final NrfMeshRepository nrfMeshRepository) {
        super(nrfMeshRepository);
>>>>>>> master-nordic
    }
}
