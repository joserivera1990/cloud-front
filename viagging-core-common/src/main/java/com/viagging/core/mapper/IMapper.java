package com.viagging.core.mapper;

import java.util.List;

public interface IMapper<S, T> {

	T mapObject(S source);
	
	List<T> mapObjectList(List<S> listaSource);
	
}
