package com.example.giseok.gsonstudy.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.giseok.gsonstudy.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainFragment extends Fragment {

	public MainFragment() {
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_main, container, false);
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		ButterKnife.bind(this, view);
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();

		ButterKnife.unbind(this);
	}

	@OnClick(R.id.basic)
	public void basic() {
		clickedOn(new BasicFragment());
	}

	@OnClick(R.id.object_serialize)
	public void objectSerialize() {
		clickedOn(new ObjectSerializeFragment());
	}

	@OnClick(R.id.json_object)
	public void jsonObject() {
		clickedOn(new JsonObjectFragment());
	}

	@OnClick(R.id.collection)
	public void collection() {
		clickedOn(new CollectionFragment());
	}

	@OnClick(R.id.expose)
	public void expose() {
		clickedOn(new ExposeFragment());
	}

	@OnClick(R.id.date_serializer)
	public void dateSerializer() {
		clickedOn(new DateSerializeFragment());
	}

	private void clickedOn(@NonNull Fragment fragment) {
		final String tag = fragment.getClass().toString();
		getActivity().getSupportFragmentManager()
				.beginTransaction()
				.addToBackStack(tag)
				.replace(android.R.id.content, fragment, tag)
				.commit();
	}
}
