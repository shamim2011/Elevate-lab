package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Songs;
import com.example.demo.repository.SongRepository;

@Service
public class SongServiceImplementation implements SongService{
	@Autowired
	SongRepository srepo;
	@Override
	public String addSongs(Songs song) {
		srepo.save(song);
		return "Songs are added";
	}
	@Override
	public boolean songExist(String name) {
		Songs song=srepo.findByName(name);
		if(song==null) {
			return false;
		}
		return true;
	}
	@Override
	public List<Songs> fetchAllSongs() {
		List<Songs>sl=srepo.findAll();
		return sl;
	}
	@Override
	public void updateSong(Songs song) {
		srepo.save(song);
		
	}

}
