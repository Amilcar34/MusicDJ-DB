package com.musicdj.view;

import com.musicdj.controller.MusicDJController;
import com.musicdj.enteties.Client;

public final class TestList {

	public static void main(String[] args) {

		MusicDJController l = new MusicDJController();

		
		for (Client c : l.read()) {
			System.out.println(c.getId() + c.getMusicGen());
		}
	}

}
