package io.caster.daggerscopes.screens.profile;


import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import io.caster.daggerscopes.DemoApplication;
import io.caster.daggerscopes.R;
import io.caster.daggerscopes.models.SomeBigObject;

public class ProfileFragment extends Fragment {

    @Inject protected Resources resources;
    @Inject protected SomeBigObject someBigObject;

    public ProfileFragment() {
        // Required empty public constructor
    }

    public static ProfileFragment newInstance() {
        ProfileFragment fragment = new ProfileFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((DemoApplication) getActivity().getApplication()).createProfileComponent().inject(this);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_profile, container, false);
        return v;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ((DemoApplication) getActivity().getApplication()).releaseProfileComponent();
    }

}
