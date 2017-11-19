package com.musicdj.view;

import com.musicdj.controller.MusicDJController;

public final class TestDelete {

	public static void main(String[] args) {

		MusicDJController d = new MusicDJController();
		if(d.delete(3)){
			System.out.println("Deleted");
			
		}else{
			System.out.println("Unable not delete");
		}
	}

}
