package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Playlist;
import com.example.demo.entity.Songs;
import com.example.demo.service.PlaylistService;
import com.example.demo.service.SongService;

@Controller
public class PlaylistController {
	@Autowired
	PlaylistService pservice;
	
	@Autowired
	SongService sservice;
	
	@GetMapping("/map-createPlaylist")
	public String createPlaylist(Model model) {
		// Fetching the songs using SongService
		List<Songs> songlist=sservice.fetchAllSongs();
		// Adding the model into the models
		model.addAttribute("songlist",songlist);
		//Sending to createPlaylist
		return "createPlaylist";
	}
	@PostMapping("/addPlaylist")
	public String addPlaylist(@ModelAttribute Playlist playlist) {
		String name=playlist.getName();
		boolean status=pservice.playlistExist(name);
		if(status==false) {
			pservice.addPlaylist(playlist);
			List<Songs> songl=playlist.getSong();
			for(Songs song:songl) {
				song.getPlaylist().add(playlist);
				sservice.updateSong(song);
			}
			return "playlistSuccess";
		}
		return "playlistFail";
	}
	@GetMapping("/viewPlaylist")
	public String fetchAllPlaylist(Model model) {
		List<Playlist> playlist=pservice.fetchPlaylist();
		model.addAttribute("playlist",playlist);
		return "viewPlaylist";
	}
}
