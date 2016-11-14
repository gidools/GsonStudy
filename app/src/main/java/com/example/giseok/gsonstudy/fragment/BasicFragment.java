package com.example.giseok.gsonstudy.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.giseok.gsonstudy.R;
import com.google.gson.Gson;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class BasicFragment extends Fragment {

	private static final String TAG = BasicFragment.class.getSimpleName();

	public BasicFragment() {
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_basic, container, false);
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		ButterKnife.bind(this, view);
		gsonTest();
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();

		ButterKnife.unbind(this);
	}

	private void gsonTest() {
		// Serialization
		Gson gson = new Gson();
		Log.i(TAG, "gson.toJson(1) : " + gson.toJson(1));
		Log.i(TAG, "gson.toJson(\"abcd\") : " + gson.toJson("abcd"));
		Log.i(TAG, "gson.toJson(Long.valueOf(10)) : " + gson.toJson(Long.valueOf(10)));
		Log.i(TAG, "gson.toJson(new int[] {1, 0}) : " + gson.toJson(new int[] {1, 0}));

		//	Deserialization
		int desInt = gson.fromJson("1", int.class);
		Integer desInteger = gson.fromJson("1", Integer.class);
		Long desLong = gson.fromJson("1", Long.class);
		Boolean desBool = gson.fromJson("false", Boolean.class);
		String desString = gson.fromJson("\"abc\"", String.class);
		String desStringArray = gson.fromJson("[\"abc\"]", String.class); // Runtime error. Begin array!!

		Log.i(TAG, "Test end");
	}
}
