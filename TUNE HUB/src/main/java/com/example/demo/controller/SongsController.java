package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Songs;
import com.example.demo.service.SongService;


@Controller
public class SongsController {
	@Autowired
	SongService sgservice;
	
	@PostMapping("addSongs")
	public String addSong(@ModelAttribute Songs song) {
		String name=song.getName();
		boolean status=sgservice.songExist(name);
		if(status==false) {
			sgservice.addSongs(song);
			return "songSuccess";
		}
		return "songFail";
	}
	@GetMapping("map-viewsong")
	public String viewAllSongs(Model model) {
		List<Songs> sList=sgservice.fetchAllSongs();
		model.addAttribute("songlist",sList);
		return "displaySong";
	}
	
	@GetMapping("viewsong")
	public String viewCustomerSong(Model model) {
		boolean isPrimeCustomer=false;
		if(isPrimeCustomer==true) {
			List<Songs> sList=sgservice.fetchAllSongs();
			model.addAttribute("songlist",sList);
			return "displaySong";
		}
		return "makePayment";
	}
}
