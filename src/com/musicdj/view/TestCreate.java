package com.musicdj.view;

import com.musicdj.controller.MusicDJController;

public final class TestCreate {

	public static void main(String[] args) {

		MusicDJController c = new MusicDJController();
		
		System.out.println(c.create("Mori", "Hip - Hop"));
		
	}

}
