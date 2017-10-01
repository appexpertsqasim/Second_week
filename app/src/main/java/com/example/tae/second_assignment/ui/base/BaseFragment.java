/*
 * Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://mindorks.com/license/apache-v2
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package com.example.tae.second_assignment.ui.base;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tae.second_assignment.R;
import com.example.tae.second_assignment.ui.utils.CommonUtils;
import com.example.tae.second_assignment.ui.utils.NetworkUtils;

import io.reactivex.annotations.Nullable;


/**
 * Created by kalpesh on 20/09/2017.
 */
public abstract class BaseFragment extends Fragment implements MvpView {
    private ProgressDialog mProgressDialog;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }
    @Override
    public void onError(String message) {
        if (message != null) {
            showSnackBar(message);
        } else {
            showSnackBar(getString(R.string.some_error));
        }
    }

    private void showSnackBar(String message) {
        Snackbar snackbar = Snackbar.make(getView().findViewById(android.R.id.content),
                message, Snackbar.LENGTH_SHORT);
        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView
                .findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(ContextCompat.getColor(getActivity(), R.color.colorPrimaryDark));
        snackbar.show();
    }
    @Override
    public void showMessage(String message) {
        if (message != null) {
            Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(), getString(R.string.some_error), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showLoading() {
        hideLoading();
        mProgressDialog = CommonUtils.showLoadingDialog(this.getActivity());
    }

    @Override
    public void hideLoading() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.cancel();
        }
    }

    @Override
    public boolean isNetworkConnected() {
        return NetworkUtils.isNetworkConnected(getActivity().getApplicationContext());
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}
