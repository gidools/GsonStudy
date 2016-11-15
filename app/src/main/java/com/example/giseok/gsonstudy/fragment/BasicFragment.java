package com.example.giseok.gsonstudy.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.giseok.gsonstudy.R;
import com.google.gson.Gson;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BasicFragment extends Fragment {

	private static final String TAG = BasicFragment.class.getSimpleName();

	@Bind(R.id.text_view)
	TextView textView;

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
		// TODO : First. Modify build.gradle

		String result = "Serialization" + "\n\n";

		Gson gson = new Gson();
		result += "gson.toJson(1) : " + gson.toJson(1) + "\n" +
				"gson.toJson(\"abcd\") : " + gson.toJson("abcd") + "\n" +
				"gson.toJson(Long.valueOf(10)) : " + gson.toJson(Long.valueOf(10)) + "\n" +
				"gson.toJson(new int[] {1, 0}) : " + gson.toJson(new int[]{1, 0}) + "\n";

		result += "\n\n";

		//	Deserialization
		result += "Deserialization" + "\n\n";
		result += "gson.fromJson(\"1\", int.class) : " + gson.fromJson("1", int.class) + "\n" +
				"gson.fromJson(\"1\", Integer.class)" + gson.fromJson("1", Integer.class) + "\n" +
				"gson.fromJson(\"1\", Long.class)" + gson.fromJson("1", Long.class) + "\n" +
				"gson.fromJson(\"false\", Boolean.class)" + gson.fromJson("false", Boolean.class) + "\n" +
				"gson.fromJson(\"abc\", String.class)" + gson.fromJson("abc", String.class) + "\n" +
				"gson.fromJson(\"[\"abc\"]\", String.class)" + gson.fromJson("[\"abc\"]", String[].class) + "\n";

		textView.setText(result);

		Log.i(TAG, "Test end");
	}
}
