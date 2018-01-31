package com.viagging.core.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viagging.core.dao.ListaDeseosDAO;
import com.viagging.core.model.ListaDeseos;
import com.viagging.core.services.ListaDeseosService;


@Service
public class ListaDeseosServiceImpl implements ListaDeseosService{
	
	@Autowired
	private ListaDeseosDAO listaDeseosDAO;

	@Override
	public ListaDeseos getListaDeseosById(Integer idListaDeseos) {
		return listaDeseosDAO.getListaDeseosById(idListaDeseos);
	}

	@Override
	public List<ListaDeseos> getAllListaDeseos() {
		return listaDeseosDAO.getAllListaDeseos();
	}

	@Override
	public ListaDeseos createListaDeseos(ListaDeseos listaDeseos) {
		return listaDeseosDAO.createListaDeseos(listaDeseos);
	}

	@Override
	public ListaDeseos updateListaDeseos(ListaDeseos listaDeseos) {
		return listaDeseosDAO.updateListaDeseos(listaDeseos);
	}

	@Override
	public ListaDeseos deleteListaDeseos(Integer idListaDeseos) {
		return listaDeseosDAO.deleteListaDeseos(idListaDeseos);
	}
}