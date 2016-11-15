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

public class CollectionFragment extends Fragment {

	@Bind(R.id.text_view)
	TextView textView;

	public CollectionFragment() {
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_collection, container, false);
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

		String result = "Serialization" + "\n\n";

		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		List<Foo1> foo1List = new ArrayList<>();
		foo1List.add(new Foo1());
		foo1List.add(new Foo1());
		foo1List.add(new Foo1());

		String jsonString = gson.toJson(foo1List);
		result += "gson.toJson(foo1List) => " + "\n" + jsonString + "\n";

		// Array type
		Foo1 [] foo1Array = gson.fromJson(
				"[" +
						"{\"value1\":1,\"value2\":\"abc\"}," +
						"{\"value1\":3,\"value2\":\"egf\"}," +
						"{\"value1\":4,\"value2\":\"kkk\"}]",
				Foo1[].class);

		// Collection type
		Type collectionType = new TypeToken<Collection<Foo1>>(){}.getType();
		List<Foo1> foo1List2 = gson.fromJson(
				"[" +
						"{\"value1\":1,\"value2\":\"abc\", \"value3\":4}," +
						"{\"value1\":3,\"value2\":\"egf\", \"value3\":5}," +
						"{\"value1\":4,\"value2\":\"kkk\", \"value3\":6}]",
				collectionType);

		textView.setText(result);
	}
}
