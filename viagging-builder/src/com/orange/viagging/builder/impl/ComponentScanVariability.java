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
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.orange.viagging.builder.utils.Utils;

public class ComponentScanVariability {

	public void modifyMvcConfig(String fileName, String path, String componentRegex, boolean active) {

		String file = Utils.getAttributeConfiguration(fileName, path);
		try {
			File fXmlFile = new File(file);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			NodeList components = doc.getElementsByTagName("context:component-scan");
			
			if(components != null){
				Node componentScan = components.item(0);
				
				boolean componentExists = false;
				Node componentNode = null;
				for(int i = 0; i < componentScan.getChildNodes().getLength(); i++){
					Node component = componentScan.getChildNodes().item(i);
					
					NamedNodeMap attributes = component.getAttributes();
					if(attributes != null){
						for(int j = 0; j < attributes.getLength(); j++){
							Node attribute = attributes.item(j);
							if(attribute.getNodeName().equals("expression")
								&& attribute.getNodeValue().equals(componentRegex)){
								componentNode = component;
								componentExists = true;
								break;
							}
						}
						
						if(componentNode != null){
							break;
						}
					}
				}
				
				if(componentExists && active){
					System.out.println("Removiendo exclude de componente " + componentRegex);
					componentScan.removeChild(componentNode);
				} else if(!componentExists && !active) {
					System.out.println("Excluyendo componente " + componentRegex);
					Element component = doc.createElement("context:exclude-filter");
					component.setAttribute("expression", componentRegex);
					component.setAttribute("type", "regex");
					componentScan.appendChild(component);
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
