package com.example.giseok.gsonstudy;

import com.google.gson.annotations.Expose;

import java.util.Date;

/**
 * Created by Gidools on 2016-11-14.
 */

public class Foo3 {

	String email;
	Date createDT;

	public Foo3() {
		email = "susiri@bh.com";
		createDT = new Date(System.currentTimeMillis());
	}
}
