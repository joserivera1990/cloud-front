package com.viagging.rest.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.viagging.core.mapper.IMapper;
import com.viagging.core.model.Compra;
import com.viagging.rest.dto.CompraDTO;
import com.viagging.rest.dto.PaqueteDTO;
import com.viagging.rest.dto.ServicioDTO;

@Component
public class CompraDTOMapper implements IMapper<Compra, CompraDTO>{

	@Autowired
	private ProductoDTOMapper productoDTOMapper;
	
	@Autowired
	private PaqueteDTOMapper paqueteDTOMapper;
	
	@Autowired
	private ServicioDTOMapper servicioDTOMapper;
	
	@Override
	public CompraDTO mapObject(Compra compra) {
		CompraDTO compraDTO = new CompraDTO();
		compraDTO.setId(compra.getId());
		compraDTO.setCantidad(compra.getCantidad());
		compraDTO.setFecha(compra.getFecha());
		compraDTO.setHora(compra.getHora());
		if(compra.getPaquete() != null){
			PaqueteDTO paquete = paqueteDTOMapper.mapObject(compra.getPaquete());
			compraDTO.setProducto(productoDTOMapper.buildProductoFromPaquete(paquete));
		}
		if(compra.getServicio() != null){
			ServicioDTO servicio = servicioDTOMapper.mapObject(compra.getServicio());
			compraDTO.setProducto(productoDTOMapper.buildProductoFromServicio(servicio));
		}
		return compraDTO;
	}

	@Override
	public List<CompraDTO> mapObjectList(List<Compra> compras) {
		List<CompraDTO> comprasDTO = new ArrayList<>();
		for(Compra compra : compras){
			CompraDTO compraDTO = mapObject(compra);
			comprasDTO.add(compraDTO);
		}
		return comprasDTO;
	}

}
