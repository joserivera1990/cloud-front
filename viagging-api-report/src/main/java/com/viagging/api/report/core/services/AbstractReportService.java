package com.viagging.api.report.core.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.viagging.api.report.rest.dto.ReporteDTO;
import com.viagging.rest.dto.PaqueteDTO;
import com.viagging.rest.dto.ServicioDTO;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;


public abstract class AbstractReportService {
   	
	public abstract JasperReport getFileReport() throws JRException;
    
	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractReportService.class);
	
	private static final String USUARIO_NO_REGISTRADO = "Usuario sin registro";
	
    private JasperPrint fillReport(Map<String, Object> map,JasperReport report,DefaultTableModel tableModel ) throws JRException{
    	return JasperFillManager.fillReport(report, map, new JRTableModelDataSource(tableModel));
     }

    public byte[] createReport( ReporteDTO reporteDTO ){		
    	byte[] output = null;
    	try {
			Map<String, Object> map = new HashMap<>();
			List<Object[]> listDatos = getInfo(reporteDTO);
	        DefaultTableModel dataReport = fillDataReport(listDatos);
	        JasperReport report = getFileReport();
		    JasperPrint print = fillReport(map, report,dataReport);
		    output = JasperExportManager.exportReportToPdf(print);
		    //JasperExportManager.exportReportToPdfFile(print, "D:\\ANDES\\Fabricas_Software\\reportes\\InformePaisesMySQ1L.pdf");
		    //JasperViewer.viewReport(print, false);
		} catch (JRException e) {
			LOGGER.error(e.getMessage());	
		} catch (Exception e) {
			LOGGER.error(e.getMessage());	
		}	
		return output;
	}
    
    public abstract  DefaultTableModel  fillDataReport(List<Object[]> listData);

    public abstract  List<Object[]> getInfo(ReporteDTO reporteDTO); 
    
    public static String buildList(List<?> listItems){
       StringBuilder concatenadoServicios = new StringBuilder();  
	   for (int i = 0; i < listItems.size(); i++) {
		   if(listItems.get(i) instanceof ServicioDTO){
		      concatenadoServicios.append(((ServicioDTO)listItems.get(i)).getId());
		   }else if (listItems.get(i) instanceof PaqueteDTO){
			   concatenadoServicios.append(((PaqueteDTO)listItems.get(i)).getId());
		   }
		     
		   if( i != listItems.size()-1){
			   concatenadoServicios.append(",");   
		   }
	   }	
       return concatenadoServicios.toString();
    }
    
    public String buildName(Object firstName, Object lastName ){
    	String name = "";
    	if(firstName != null && lastName != null){
    		return  firstName.toString() + " " + lastName.toString();
    	}else if(firstName != null && lastName == null){
    		name = firstName.toString();
    	}else if(firstName == null && lastName != null){
    		name = lastName.toString();
    	}else{
    		name = USUARIO_NO_REGISTRADO;
    	}
    	
    	return name;
    }
    
}
