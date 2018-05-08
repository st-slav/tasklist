package ru.mamsta.exam.ibs.tasklist.api.converters;

public interface Converter<T, E> {

	T getDto(E e);
	
	E getData(T t);
}
