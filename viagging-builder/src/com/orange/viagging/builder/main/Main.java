package com.orange.viagging.builder.main;

import java.util.List;

import com.orange.viagging.builder.IFeatureReader;
import com.orange.viagging.builder.IPropertiesVariability;
import com.orange.viagging.builder.impl.ComponentScanVariability;
import com.orange.viagging.builder.impl.FeatureTxtReader;
import com.orange.viagging.builder.impl.MavenVariability;
import com.orange.viagging.builder.impl.PropertiesVariability;
import com.orange.viagging.builder.utils.Utils;

/**
 * Principal que ejecuta la aplicación
 * @author karenvega
 *
 */
public class Main {

	public static final String CONFIG_FILE_NAME = "config";
	public static final String VIAGGING_PATH = "VIAGGING_PATH";
	public static final String VIAGGING_API_PATH = "VIAGGING_API_PATH";
	public static final String FEATURES_PATH = "FEATURES_PATH";
	public static final String VARIABILITY_PROPERTIES_PATH = "VARIABILITY_PROPERTIES_PATH";
	
	//FeatureIDE 
	public static final String REPORT_FEATURE = "Reportes";
	public static final String MESSAGING_FEATURE = "Mensajeria";
	public static final String COMMENTS_FEATURE = "PCalificar";
	public static final String FACEBOOK_FEATURE = "Facebook";
	public static final String TWITTER_FEATURE = "Twitter";
	public static final String PUBLISH_FACEBOOK_FEATURE = "PFacebook";
	public static final String PUBLISH_TWITTER_FEATURE = "PTwitter";
	public static final String WEATHER_FEATURE = "Clima";
	
	//Properties
	public static final String REPORTES_FRONT = "derivador.reportes";
	public static final String MESSAGING_FRONT = "derivador.mensajes";
	public static final String COMMENTS_FRONT = "derivador.comentarios";
	public static final String FACEBOOK_FRONT = "derivador.facebook";
	public static final String TWITTER_FRONT = "derivador.twitter";
	public static final String PUBLISH_FACEBOOK_FRONT = "derivador.pfacebook";
	public static final String PUBLISH_TWITTER_FRONT = "derivador.ptwitter";
	public static final String WEATHER_FRONT = "derivador.clima";
	
	//MVC
	public static final String COMMENTS_CTRL_COMPONENT = "com.viagging.api.controllers.*ComentarioCalificacionController";
	
	public static void main(String[] args) {
		Main m = new Main();
		m.run();
	}

	public void run() {
		System.out.println("--> INICIO PROCESO DE DERIVACIÓN DE PRODUCTO\n");
		IFeatureReader reader = new FeatureTxtReader();
		IPropertiesVariability propertiesVariability = new PropertiesVariability();
		MavenVariability maven = new MavenVariability();
		ComponentScanVariability componentVariability = new ComponentScanVariability();
		
		System.out.println("Leyendo archivo de features\n");
		String featuresPath = Utils.getAttributeConfiguration(CONFIG_FILE_NAME, FEATURES_PATH);
		List<String> features = reader.readFeatures(featuresPath);
		Processor processor = new Processor(features);
		
		System.out.println("Implementando variabilidad\n");
		
		String variabilityPropertiesPath = Utils.getAttributeConfiguration(CONFIG_FILE_NAME, VARIABILITY_PROPERTIES_PATH);
		
		boolean isReportFeature = processor.isFeature(REPORT_FEATURE);
		propertiesVariability.changeProperties(variabilityPropertiesPath, REPORTES_FRONT, isReportFeature);
		maven.modifyPom(CONFIG_FILE_NAME, VIAGGING_PATH, "viagging-api-report", isReportFeature);
		maven.modifyMvcConfig(CONFIG_FILE_NAME, VIAGGING_API_PATH, "ReportAspect", "com.viagging.api.aspects.ReportAspect", isReportFeature);
		
		boolean isMessagingFeature = processor.isFeature(MESSAGING_FEATURE);
		propertiesVariability.changeProperties(variabilityPropertiesPath, MESSAGING_FRONT, isMessagingFeature);
		maven.modifyPom(CONFIG_FILE_NAME, VIAGGING_PATH, "viagging-api-message", isMessagingFeature);
		
		boolean isCommentsFeature = processor.isFeature(COMMENTS_FEATURE);
		propertiesVariability.changeProperties(variabilityPropertiesPath, COMMENTS_FRONT, isCommentsFeature);
		componentVariability.modifyMvcConfig(CONFIG_FILE_NAME, VIAGGING_API_PATH, COMMENTS_CTRL_COMPONENT, isCommentsFeature);
		
		boolean isFacebookFeature = processor.isFeature(FACEBOOK_FEATURE);
		propertiesVariability.changeProperties(variabilityPropertiesPath, FACEBOOK_FRONT, isFacebookFeature);

		boolean isTwitterFeature = processor.isFeature(TWITTER_FEATURE);
		propertiesVariability.changeProperties(variabilityPropertiesPath, TWITTER_FRONT, isTwitterFeature);
		
		boolean isPublishFacebookFeature = processor.isFeature(PUBLISH_FACEBOOK_FEATURE);
		propertiesVariability.changeProperties(variabilityPropertiesPath, PUBLISH_FACEBOOK_FRONT, isPublishFacebookFeature);
		
		boolean isPublishTwitterFeature = processor.isFeature(PUBLISH_TWITTER_FEATURE);
		propertiesVariability.changeProperties(variabilityPropertiesPath, PUBLISH_TWITTER_FRONT, isPublishTwitterFeature);
		
		boolean isWeatherFeature = processor.isFeature(WEATHER_FEATURE);
		propertiesVariability.changeProperties(variabilityPropertiesPath, WEATHER_FRONT, isWeatherFeature);
		maven.modifyPom(CONFIG_FILE_NAME, VIAGGING_PATH, "viagging-api-weather", isWeatherFeature);
		
		System.out.println("\n--> FIN PROCESO DE DERIVACI�N DE PRODUCTO ");
	}
}
