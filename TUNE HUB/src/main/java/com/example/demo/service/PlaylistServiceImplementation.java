package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Playlist;
import com.example.demo.repository.PlaylistRepository;

@Service
public class PlaylistServiceImplementation implements PlaylistService{
	@Autowired
	PlaylistRepository prepo;

	@Override
	public void addPlaylist(Playlist playlist) {
		prepo.save(playlist);
	}

	@Override
	public List<Playlist> fetchPlaylist() {
		List<Playlist> plist=prepo.findAll();
		return plist;
	}

	@Override
	public boolean playlistExist(String name) {
		Playlist plist=prepo.findByName(name);
		if(plist==null) {
			return false;
		}
		return true;
	}
}
