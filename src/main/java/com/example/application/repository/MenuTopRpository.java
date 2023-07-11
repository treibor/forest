package com.example.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.application.entity.MenuTop;
import java.util.List;


public interface MenuTopRpository extends JpaRepository<MenuTop, Long>{
	List<MenuTop> findByLevel(long level);
	List<MenuTop> findByLevelAndId(long level, long id);
}
