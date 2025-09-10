package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Playlist;

public interface PlaylistRepository extends JpaRepository<Playlist,Integer>{
	public Playlist findByName(String name);
}
