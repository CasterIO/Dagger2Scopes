package io.caster.daggerscopes.screens.settings;


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


public class SettingsFragment extends Fragment {

    @Inject protected Resources resources;
    @Inject protected SettingsService settingsService;

    public SettingsFragment() {
        // Required empty public constructor
    }

    public static SettingsFragment newInstance() {
        return new SettingsFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((DemoApplication) getActivity().getApplication()).createSettingsComponent().inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ((DemoApplication) getActivity().getApplication()).releaseSettingsComponent();
    }
}
