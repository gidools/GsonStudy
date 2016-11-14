package com.example.giseok.gsonstudy;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

/**
 * Created by Gidools on 2016-11-14.
 */

public class Foo5 {

	String listName = "5";
	List<Foo4> foo4List;

	public Foo5() {
	}

	public void setFoo4List(List<Foo4> list) {
		foo4List = list;
	}
}
