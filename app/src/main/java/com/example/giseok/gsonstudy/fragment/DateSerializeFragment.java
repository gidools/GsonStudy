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
import com.example.giseok.gsonstudy.Foo3;
import com.example.giseok.gsonstudy.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DateSerializeFragment extends Fragment {

	private static final String TAG = DateSerializeFragment.class.getSimpleName();

	@Bind(R.id.title_text)
	TextView textView;

	@Bind(R.id.text_view)
	TextView textPanel;

	public DateSerializeFragment() {
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
		textView.setText("Date serialize example");
		gsonTest();
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();

		ButterKnife.unbind(this);
	}

	private void gsonTest() {
		// JsonObject or JsonArray well fit to retrofit library

		Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new JsonSerializer<Date>() {
			@Override
			public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.US);
				return new JsonPrimitive(sdf.format(src));
			}
		}).registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
			@Override
			public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.US);
				Date date = null;
				try {
					date = sdf.parse(json.getAsString());
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return date;
			}
		}).setPrettyPrinting().create();

		List<Foo3> foo3List = new ArrayList<>();

		try {
			foo3List.add(new Foo3());

			Thread.sleep(100);

			foo3List.add(new Foo3());

			Thread.sleep(100);

			foo3List.add(new Foo3());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		String jsonString = gson.toJson(foo3List);

		textPanel.setText(jsonString);

//		Type collectionType = new TypeToken<Collection<Foo3>>(){}.getType();
		Foo3[] foo3Array = gson.fromJson(jsonString, Foo3[].class);

		Log.i(TAG, "Test end");
	}
}
