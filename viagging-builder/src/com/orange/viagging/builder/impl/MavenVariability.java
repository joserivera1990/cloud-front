package com.orange.viagging.builder.impl;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.orange.viagging.builder.utils.Utils;

/**
 * Implementación de la variabilidad con maven
 * @author karenvega
 *
 */
public class MavenVariability {
	
	/**
	 * Modifica el pom para agregar la dependencia de reportes
	 * @param fileName nombre del archivo de configuración del proyecto
	 * @param path ruta de la carpeta raiz de los proyectos viagging
	 */
	public void modifyPom(String fileName, String path, String moduleName, boolean active) {

		String file = Utils.getAttributeConfiguration(fileName, path);
		try {
			File fXmlFile = new File(file);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("modules");
			
			for (int i = 0; i < nList.getLength(); i++) {
				Node modulesElement = nList.item(i);
				
				boolean moduleExists = false;
				Node moduleNode = null;
				for(int j = 0; j < modulesElement.getChildNodes().getLength(); j++){
					Node moduleElement = modulesElement.getChildNodes().item(j);
					String nodeContent = moduleElement.getTextContent();
					if(nodeContent.equals(moduleName)){
						moduleExists = true;
						moduleNode = moduleElement;
					}
				}
				
				if(moduleExists && !active){
					System.out.println("Removiendo dependencia " + moduleName);
					modulesElement.removeChild(moduleNode);
				} else if(!moduleExists && active) {
					System.out.println("Agregando dependencia " + moduleName);
					Element reporte = doc.createElement("module");
					reporte.appendChild(doc.createTextNode(moduleName));
					modulesElement.appendChild(reporte);
				}
			}
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(file));
			transformer.transform(source, result);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void modifyMvcConfig(String fileName, String path, String idBean, String classBean, boolean active) {

		String file = Utils.getAttributeConfiguration(fileName, path);
		try {
			File fXmlFile = new File(file);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("beans");
			
			for (int i = 0; i < nList.getLength(); i++) {
				Node modulesElement = nList.item(i);
				
				boolean moduleExists = false;
				Node moduleNode = null;
				for(int j = 0; j < modulesElement.getChildNodes().getLength(); j++){
					Node moduleElement = modulesElement.getChildNodes().item(j);
					if(moduleElement.getNodeName().equals("bean") && moduleElement.getAttributes().getLength() > 1 ) {
						String _class = moduleElement.getAttributes().item(0).getTextContent();
						String id = moduleElement.getAttributes().item(1).getTextContent();
						if (id.equals(idBean) && _class.equals(classBean)) {
							moduleExists = true;
							moduleNode = moduleElement;
							break;
						}
					}
				}
				
				if(moduleExists && !active){
					System.out.println("Removiendo dependencia " + idBean);
					modulesElement.removeChild(moduleNode);
				} else if(!moduleExists && active) {
					System.out.println("Agregando dependencia " + idBean);
					Element bean = doc.createElement("bean");
					bean.setAttribute("id", idBean);
					bean.setAttribute("class", classBean);
					modulesElement.appendChild(bean);
				}
			}
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(file));
			transformer.transform(source, result);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
