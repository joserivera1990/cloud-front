package com.viagging.api.report.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.viagging.core.constant.ReportType;
import com.viagging.api.report.core.services.AbstractReportService;
import com.viagging.api.report.factory.ReportServiceFactory;
import com.viagging.core.services.MovimientoService;
import com.viagging.core.services.VariabilidadService;
import com.viagging.api.report.rest.dto.ReporteDTO;
import com.viagging.core.services.ServicioService;


@RestController
public class ReportController {
		   
	   @Autowired
	   private ReportServiceFactory reportServiceFactory;
	   
	   @Autowired
	   private MovimientoService movimientoService;
	   
	   @Autowired
	   private ServicioService servicioService;
	   
	   @Autowired
	   private VariabilidadService variabilidadService;
	   
	   public static final String ERROR_REPORT_NOT_FOUND = "Error reporte no válido";
		
	 
		@RequestMapping(value = "/createReport", method = RequestMethod.POST)
		@ResponseStatus(value = HttpStatus.OK)
		public ResponseEntity<byte[]> createReport(
				@RequestBody ReporteDTO reporteDTO) {
			byte[] outputReport;
			HttpHeaders headers = new HttpHeaders();

			AbstractReportService reportService = reportServiceFactory.getReportService(ReportType.valueOf(reporteDTO.getTipo()));
			if (reportService != null) {
				outputReport = reportService.createReport(reporteDTO);
			} else {
				throw new NotFoundException(ERROR_REPORT_NOT_FOUND);
			}
			return new ResponseEntity<>(outputReport, headers, HttpStatus.OK);
		}
		
				
	    @RequestMapping(value = "/createMovimiento", method = RequestMethod.GET)
		@ResponseStatus(value = HttpStatus.OK)
		public void createMovimiento() {
	    	System.out.println("ingreso");
	    	variabilidadService.getVariabilidad();
	    	List<String> listSe = new ArrayList<>();
	    	listSe.add("1");
	    	listSe.add("2");
	    	listSe.add("4");
	    	
	    	List<String> listPa = new ArrayList<>();
	    	listPa.add("325");
	    	movimientoService.createMovimientos(listSe, listPa, null,ReportType.QUERY.toString());
		}
	   
	    
}
