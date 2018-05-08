package ru.mamsta.exam.ibs.tasklist.api.services;

public interface DataService<T> extends CatalogDataService<T> {
	
	T addData(T t);
	
	T updateData(T t);
	
	boolean deleteData(Long id);
	
	boolean deleteData(T t);
}
