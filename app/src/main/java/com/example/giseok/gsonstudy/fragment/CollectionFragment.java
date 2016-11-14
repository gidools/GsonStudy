package com.example.giseok.gsonstudy.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.giseok.gsonstudy.Foo1;
import com.example.giseok.gsonstudy.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import butterknife.ButterKnife;

public class CollectionFragment extends Fragment {

	public CollectionFragment() {
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_main, container, false);
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

	private static final String TAG = CollectionFragment.class.getSimpleName();

	private void gsonTest() {
		Gson gson = new Gson();
		String [] desStringArray = gson.fromJson("[\"abc\"]", String[].class);
		Log.i(TAG, "Test End");

		List<Foo1> foo1List = new ArrayList<>();
		foo1List.add(new Foo1());
		foo1List.add(new Foo1());
		foo1List.add(new Foo1());

		String jsonString = gson.toJson(foo1List);
		Log.i(TAG, "JsonString : " + jsonString);

		// Array type
		Foo1 [] foo1Array = gson.fromJson("[{\"value1\":1,\"value2\":\"abc\"},{\"value1\":3,\"value2\":\"egf\"},{\"value1\":4,\"value2\":\"kkk\"}]", Foo1[].class);

		// Collection type
		Type collectionType = new TypeToken<Collection<Foo1>>(){}.getType();
		List<Foo1> foo1List2 = gson.fromJson("[{\"value1\":1,\"value2\":\"abc\"},{\"value1\":3,\"value2\":\"egf\"},{\"value1\":4,\"value2\":\"kkk\"}]", collectionType);

		Log.i(TAG, "test end");
	}
}
