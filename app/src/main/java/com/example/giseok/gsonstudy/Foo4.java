package com.example.giseok.gsonstudy;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by Gidools on 2016-11-14.
 */

public class Foo4 {

	@SerializedName("user_id")
	String userId;

	@SerializedName("created_dt")
	Date createdDT;

	public Foo4() {
		userId = "susiri@bh.com";
		createdDT = new Date(System.currentTimeMillis());
	}
}
