package com.example.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.application.entity.MenuTop;
import com.example.application.repository.MenuTopRpository;


@Service
public class dbservice {
	private final MenuTopRpository mrepo;

	public dbservice(MenuTopRpository mrepo) {
		super();
		this.mrepo = mrepo;
	}
	
	public List<MenuTop> getMenuList(long level){
		return mrepo.findByLevel(level);
	}
	public long getMenuCount(long level) {
		return mrepo.findByLevel(level).size();
	}
	public List<MenuTop> getMenuList(long level, long id){
		return mrepo.findByLevelAndId(level, id);
	}
}
