package com.viagging.api.report.core.services.impl;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.viagging.api.report.core.services.AbstractReportService;
import com.viagging.api.report.rest.dto.ReporteDTO;
import com.viagging.core.services.MovimientoService;

@Component("SaleReportService")
public class SaleReportService extends AbstractReportService {
    
	@Value("${reportes.ruta}")
	private String rutaReportes;
	
	@Value("${reportes.sale}")
	private String reporteSale;
	
	@Autowired
	private MovimientoService movimientoService; 
	
	@Override
	public JasperReport getFileReport() throws JRException{
		return JasperCompileManager.compileReport(rutaReportes+reporteSale);	
     }
	
	@Override
	public DefaultTableModel  fillDataReport(List<Object[]> listData ) {
    	
        int i = 0;
    	String[] columnNames = {"Tipo", "Producto", "Fecha", "Usuario","Cantidad","Precio"};
        Object [][] data = new Object [listData.size()][6];
     
        for (Object[] objectData : listData) {
      	    data[i][0] = objectData[0];
     	    data[i][1] = objectData[1];
     	    data[i][2] = objectData[2].toString();
     	    data[i][3] = buildName(objectData[3], objectData[4]);
     	    data[i][4] = objectData[5].toString();
     	    data[i][5] = objectData[6].toString();
        	i++;
		}
        return new DefaultTableModel(data, columnNames);       
    }
    
	 @Override
     public  List<Object[]> getInfo(ReporteDTO reporteDTO){  	
    	return  movimientoService.findInfoReport(buildQuery(reporteDTO));
     }
	    
	    public String buildQuery(ReporteDTO datosConsulta){
	    	StringBuilder queryString = new StringBuilder();
			queryString.append("select case when com.idservicio IS NULL then 'Paquete' else 'Servicio' END as tipo, ");
			queryString.append("case when com.idservicio IS NULL then paq.nombrepaquete else serv.nombre END as nombre, ");
			queryString.append("ord.fechacompra as fechacompra, usr.primernombre as primernombre, usr.primerapellido as primerapellido, ");
			queryString.append("com.cantidad as cantidad, ");
			queryString.append("case when com.idservicio IS NULL then paq.precio * com.cantidad else serv.precio * com.cantidad END as precio ");
			queryString.append(" from tp_compra as com ");
			queryString.append("INNER JOIN tp_orden as ord ON com.idorden = ord.id ");
			queryString.append("LEFT JOIN tp_servicio as serv ON com.idservicio = serv.id ");			
			queryString.append("LEFT JOIN tp_paquete as paq ON com.idpaquete = paq.id ");
			queryString.append("INNER JOIN tp_usuario as usr ON ord.idusuario = usr.id ");
			
			if(StringUtils.isNotEmpty(datosConsulta.getFechaInical())) {
				queryString.append("where (ord.fechacompra BETWEEN '" +datosConsulta.getFechaInical() + "' and '" + datosConsulta.getFechaFinal() + "') and ");
			}else{
				queryString.append("where");
			}

			if(CollectionUtils.isNotEmpty(datosConsulta.getListaServicios())) {
				queryString.append("(serv.id IN (" + buildList(datosConsulta.getListaServicios()) + ")" );
			}else{
				queryString.append("(serv.id IN (select id from tp_servicio)" );
			}
			
			if(CollectionUtils.isNotEmpty(datosConsulta.getListaPaquetes())) {
			   queryString.append(" or  paq.id IN (" + buildList(datosConsulta.getListaPaquetes()) + "))");
			}else{
			   queryString.append(" or  paq.id IN (select id from tp_paquete) ) ");
			}

			queryString.append("ORDER BY ord.fechacompra ASC ");
			
			return queryString.toString();
			
	    }
}
