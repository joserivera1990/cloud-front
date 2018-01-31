package com.viagging.api.report.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.viagging.api.report.core.services.AbstractReportService;
import com.viagging.api.report.core.services.impl.QueryReportService;
import com.viagging.api.report.core.services.impl.SaleReportService;
import com.viagging.api.report.core.services.impl.SearchReportService;
import com.viagging.core.constant.ReportType;

@Component
public class ReportServiceFactory {

	@Autowired
	private ApplicationContext applicationContext;

	public AbstractReportService getReportService(ReportType reportType){

		switch(reportType){
			case QUERY:
				return applicationContext.getBean(QueryReportService.class);
			case SALE:
				return applicationContext.getBean(SaleReportService.class);
			case SEARCH:
				return applicationContext.getBean(SearchReportService.class);
			default:
				return null;
		}
	}

}
