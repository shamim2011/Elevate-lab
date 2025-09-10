package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Songs;

public interface SongService {
	public String addSongs(Songs song);
	
	public boolean songExist(String name);
	
	List<Songs> fetchAllSongs();

	public void updateSong(Songs song);
}
