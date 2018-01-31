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

@Component("SearchReportService")
public class SearchReportService extends AbstractReportService {
    
	@Value("${reportes.ruta}")
	private String rutaReportes;
	
	@Value("${reportes.search}")
	private String reporteSearch;
	
	@Autowired
	private MovimientoService movimientoService; 
	
	@Override
	public JasperReport getFileReport() throws JRException{
		return JasperCompileManager.compileReport(rutaReportes+reporteSearch);	
     }
	
    @Override
	public DefaultTableModel  fillDataReport(List<Object[]> listData ) {
    	
        int i = 0;
    	String[] columnNames = {"Tipo", "Producto", "Fecha", "Usuario"};
        Object [][] data = new Object [listData.size()][4];
     
        for (Object[] objectData : listData) {
      	    data[i][0] = objectData[0];
     	    data[i][1] = objectData[1];
     	    data[i][2] = objectData[2].toString();
     	    data[i][3] = buildName(objectData[3], objectData[4]);
        	i++;
		}
        return new DefaultTableModel(data, columnNames);   
    }
    
    @Override
    public  List<Object[]> getInfo(ReporteDTO reporteDTO){  	
    	return   movimientoService.findInfoReport(buildQuery(reporteDTO));
    }
    
    public String buildQuery(ReporteDTO datosConsulta){
    	StringBuilder queryString = new StringBuilder();
		queryString.append("select case when mov.idservicio IS NULL then 'Paquete' else 'Servicio' END as tipo, ");
		queryString.append("case when mov.idservicio IS NULL then paq.nombrepaquete else ser.nombre END as nombre, ");
		queryString.append("mov.fecha as fecha, us.primernombre as primernombre, us.primerapellido as primerapellido from tr_movimiento as mov ");
		queryString.append("INNER JOIN tp_usuario as us ");
		queryString.append("ON mov.idusuario = us.id ");
		queryString.append("LEFT JOIN tp_servicio ser ");
		queryString.append("ON mov.idservicio = ser.id ");			
		queryString.append("LEFT JOIN tp_paquete as paq ");
		queryString.append("ON mov.idpaquete = paq.id ");
		
		if(StringUtils.isNotEmpty(datosConsulta.getFechaInical())) {
			queryString.append("where (mov.fecha BETWEEN '" +datosConsulta.getFechaInical() + "' and '" + datosConsulta.getFechaFinal() + "') and ");
		}else{
			queryString.append("where");
		}
		
		if(CollectionUtils.isNotEmpty(datosConsulta.getListaServicios())){
			queryString.append("(ser.id IN (" + buildList(datosConsulta.getListaServicios()) + ")" );
		}else{
			queryString.append("(ser.id IN (select id from tp_servicio)" );
		}
		
		if(CollectionUtils.isNotEmpty(datosConsulta.getListaPaquetes())){
		   queryString.append(" or  paq.id IN (" + buildList(datosConsulta.getListaPaquetes()) + ")) and ");
		}else{
		   queryString.append(" or  paq.id IN (select id from tp_paquete) ) and ");
		}
		
		queryString.append("  mov.accion = '" + datosConsulta.getTipo() + "' ");
		
		queryString.append("ORDER BY mov.fecha ASC ");
		
		return queryString.toString();
    }
       
}
