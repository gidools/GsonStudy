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

import butterknife.Bind;
import butterknife.ButterKnife;

public class ObjectSerializeFragment extends Fragment {

	private static final String TAG = ObjectSerializeFragment.class.getSimpleName();

	@Bind(R.id.text_view)
	TextView textView;

	public ObjectSerializeFragment() {
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_object_serialization, container, false);
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

	//transient field exclude automatically
	private void gsonTest() {

		String result = "Serialization" + "\n\n";

		Gson gson = new Gson();
		String jsonString = gson.toJson(new Foo1());

		result += "gson.toJson(new Foo1()) => " + jsonString + "\n\n\n";

		result += "Deserialization" + "\n\n";
		result += "Foo1 foo1 = gson.fromJson(\"{\"value1\":3,\"value2\":\"efg\",\"value3\":\"888\"}\",  Foo1.class)" + "\n";
		Foo1 foo1 = gson.fromJson("{\"value1\":3,\"value2\":\"efg\",\"value3\":\"888\"}", Foo1.class);
		result += "gson.toJson(foo1) => " + gson.toJson(foo1) + "\n";

		textView.setText(result);
	}

}
