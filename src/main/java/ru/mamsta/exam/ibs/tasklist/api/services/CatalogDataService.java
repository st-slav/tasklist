package ru.mamsta.exam.ibs.tasklist.api.services;

import java.util.List;

public interface CatalogDataService<T> {

	List<T> getDataList();
	
	T getDataById(Long id);
}
