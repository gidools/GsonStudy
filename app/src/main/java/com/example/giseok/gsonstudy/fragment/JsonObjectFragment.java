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
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class JsonObjectFragment extends Fragment {

	private static final String TAG = JsonObjectFragment.class.getSimpleName();

	@Bind(R.id.title_text)
	TextView textView;

	public JsonObjectFragment() {
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
		textView.setText("JsonObject sample");
		gsonTest();
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();

		ButterKnife.unbind(this);
	}

	private void gsonTest() {
		// JsonObject or JsonArray well fit to retrofit library
		List<Foo1> foo1List = new ArrayList<>();
		foo1List.add(new Foo1());
		foo1List.add(new Foo1());
		foo1List.add(new Foo1());

		Gson gson = new Gson();

		JsonArray jsonArray = new JsonParser()
				.parse(gson.toJson(foo1List))
				.getAsJsonArray();

		// TODO : Server need "entities" as key of json string data
		// Reference site : https://docs.google.com/document/d/1qTgjdPHP2mZCMvZbZlR6JspPUW2XrZ3elI97qLKplTk/edit
		JsonObject jsonObject = new JsonObject();
		jsonObject.add("entities", jsonArray); // Array entity
		Log.i(TAG, "jsonObject string : " + jsonObject.toString());

		JsonObject jsonObject1 = new JsonObject();
		jsonObject1.addProperty("entities", gson.toJson(foo1List));
		jsonObject1.addProperty("userId", "Sunsiri");
		jsonObject1.addProperty("Permission", "President");

		Log.i(TAG, "jsonObject1 string : " + jsonObject1.toString());
	}
}
