package com.example.giseok.gsonstudy.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.giseok.gsonstudy.Foo1;
import com.example.giseok.gsonstudy.Foo2;
import com.example.giseok.gsonstudy.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ExposeFragment extends Fragment {

	private static final String TAG = ExposeFragment.class.getSimpleName();

	@Bind(R.id.title_text)
	TextView textView;

	public ExposeFragment() {
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

		textView.setText("Expose annotation example");
		gsonTest();
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();

		ButterKnife.unbind(this);
	}

	private void gsonTest() {
		// Serialization
		List<Foo2> foo2List = new ArrayList<>();
		foo2List.add(new Foo2());
		foo2List.add(new Foo2());
		foo2List.add(new Foo2());

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		Log.i(TAG, "gson.toJson(foo2List) : " + gson.toJson(foo2List));

		Type collectionType = new TypeToken<Collection<Foo2>>(){}.getType();
		foo2List = gson.fromJson("[{\"value1\":1,\"value2\":\"aaa\",\"value3\":3}," +
				"{\"value1\":2,\"value2\":\"bbb\",\"value3\":4}," +
				"{\"value1\":5,\"value2\":\"ccc\",\"value3\":6}]", collectionType);

		Log.i(TAG, "Test end");
	}
}
