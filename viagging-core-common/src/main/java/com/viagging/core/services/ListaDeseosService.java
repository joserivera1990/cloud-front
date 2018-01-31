package com.viagging.core.services;

import java.util.List;

import com.viagging.core.model.ListaDeseos;

public interface ListaDeseosService {
	
	ListaDeseos getListaDeseosById(Integer idListaDeseos);
	
	List<ListaDeseos> getAllListaDeseos();

	ListaDeseos createListaDeseos(ListaDeseos listaDeseos);

	ListaDeseos updateListaDeseos(ListaDeseos listaDeseos);

	ListaDeseos deleteListaDeseos(Integer idListaDeseos);
}
