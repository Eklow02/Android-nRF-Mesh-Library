/*
 * Copyright (c) 2018, Nordic Semiconductor
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 *
 * 3. Neither the name of the copyright holder nor the names of its contributors may be used to endorse or promote products derived from this
 * software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE
 * USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package no.nordicsemi.android.nrfmesh.scenes.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
<<<<<<< HEAD
import android.util.Log;
=======
>>>>>>> master-nordic

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import no.nordicsemi.android.mesh.Scene;
<<<<<<< HEAD
import no.nordicsemi.android.mesh.utils.MeshAddress;
import no.nordicsemi.android.nrfmesh.R;
import no.nordicsemi.android.nrfmesh.databinding.DialogFragmentCreateSceneBinding;
import no.nordicsemi.android.nrfmesh.scenes.SceneCallbacks;
import no.nordicsemi.android.nrfmesh.utils.HexKeyListener;
import no.nordicsemi.android.nrfmesh.utils.Utils;

import static no.nordicsemi.android.mesh.Scene.isValidSceneNumber;
=======
import no.nordicsemi.android.nrfmesh.R;
import no.nordicsemi.android.nrfmesh.databinding.DialogFragmentCreateSceneBinding;
import no.nordicsemi.android.nrfmesh.utils.HexKeyListener;
>>>>>>> master-nordic


public abstract class DialogFragmentScene extends DialogFragment {

    protected static final String SCENE = "SCENE";
    protected DialogFragmentCreateSceneBinding binding;
    protected Scene mScene;
    protected AlertDialog.Builder alertDialogBuilder;

<<<<<<< HEAD

=======
>>>>>>> master-nordic
    @Override
    public void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mScene = getArguments().getParcelable(SCENE);
<<<<<<< HEAD
            Log.v("TAG", mScene.toString());
=======
>>>>>>> master-nordic
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(final Bundle savedInstanceState) {
        binding = DialogFragmentCreateSceneBinding.inflate(getLayoutInflater());

        if (savedInstanceState != null) {
            mScene = savedInstanceState.getParcelable(SCENE);
        }
<<<<<<< HEAD

        if (mScene != null) {
            binding.nameInput.setText(mScene.getName());
            binding.numberInput.setText(MeshAddress.formatAddress(mScene.getNumber(), false));
        }
=======
>>>>>>> master-nordic
        updateScene();

        binding.numberInput.setKeyListener(new HexKeyListener());
        binding.numberInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(final CharSequence s, final int start, final int count, final int after) {

            }

            @Override
            public void onTextChanged(final CharSequence s, final int start, final int before, final int count) {
<<<<<<< HEAD
                mScene = null;
=======
>>>>>>> master-nordic
                if (TextUtils.isEmpty(s.toString())) {
                    binding.sceneNumberLayout.setError(getString(R.string.error_empty_group_address));
                } else {
                    binding.sceneNumberLayout.setError(null);
                }
            }

            @Override
            public void afterTextChanged(final Editable s) {

            }
        });

        alertDialogBuilder.setView(binding.getRoot());
        return alertDialogBuilder.show();
    }

    @Override
    public void onSaveInstanceState(@NonNull final Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(SCENE, mScene);
    }

    protected void updateScene() {
<<<<<<< HEAD
        if (mScene == null) {
            mScene = ((SceneCallbacks) requireParentFragment()).createScene();
        }
        binding.nameInput.setText(mScene.getName());
        binding.numberInput.setText(Scene.formatSceneNumber(mScene.getNumber(), false));
    }

    protected final boolean validateInput(@NonNull final String name, @NonNull final String input) {
        try {
            if (TextUtils.isEmpty(name)) {
                binding.sceneNameLayout.setError(getString(R.string.error_empty_group_name));
                return false;
            }
            if (input.length() % 4 != 0 || !input.matches(Utils.HEX_PATTERN)) {
                binding.sceneNameLayout.setError(getString(R.string.invalid_scene_number));
                return false;
            }

            return (isValidSceneNumber(Integer.parseInt(input, 16)));
=======
        binding.nameInput.setText(mScene.getName());
        binding.numberInput.setText(Scene.formatSceneNumber(mScene.getNumber(), false));
        binding.sceneNumberLayout.setEnabled(false);
    }

    protected final boolean validateInput(@NonNull final String name) {
        try {
            if (TextUtils.isEmpty(name)) {
                binding.sceneNameLayout.setError(getString(R.string.error_empty_scene_name));
                return false;
            }
            return true;
>>>>>>> master-nordic
        } catch (IllegalArgumentException ex) {
            binding.sceneNumberLayout.setError(ex.getMessage());
            return false;
        }
    }
}
