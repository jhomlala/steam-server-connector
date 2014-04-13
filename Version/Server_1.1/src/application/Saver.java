package application;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;


public class Saver {
String SAVE_NAME = "ssc.cfg";
	
	public Saver()
	{
		loadData();
	}

	private static void loadData() 
		 {
		
		
		//zrob to w XML , MYKONG LADNIE TO POKAZUJE
		//http://www.mkyong.com/java/how-to-read-xml-file-in-java-dom-parser/
		
		try {
			 
			File fXmlFile = new File("data.xml");
		
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
		 
			
			doc.getDocumentElement().normalize();
		 
			System.out.println("Loading xml saved servers . Root element :" + doc.getDocumentElement().getNodeName());
		 
			NodeList nList = doc.getElementsByTagName("server");
		
			System.out.println("----------------------------");
		 
			for (int temp = 0; temp < nList.getLength(); temp++) 
			{
		 
				Node nNode = nList.item(temp);
	
				if (nNode.getNodeType() == Node.ELEMENT_NODE) 
				{
					Element eElement = (Element) nNode;
					
					Controller.addLastServers(eElement.getElementsByTagName("name").item(0).getTextContent());
				}
			}
			
		    } catch (Exception e)
		    {
		    	e.printStackTrace();
		    }

		 }

	public static void findInSave(String value) throws ParserConfigurationException, SAXException, IOException {
		File fXmlFile = new File("data.xml");
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
	 
		
		doc.getDocumentElement().normalize();
		
		
		NodeList nList = doc.getElementsByTagName("server");
		
		
	 
		for (int temp = 0; temp < nList.getLength(); temp++) 
		{
	 
			Node nNode = nList.item(temp);

			if (nNode.getNodeType() == Node.ELEMENT_NODE) 
			{
				Element eElement = (Element) nNode;
				
				if (value.equals(eElement.getElementsByTagName("name").item(0).getTextContent()))
				{
					Controller.setIP(eElement.getElementsByTagName("ip").item(0).getTextContent());
					Controller.setPORT(eElement.getElementsByTagName("port").item(0).getTextContent());
					Controller.setNAME(eElement.getElementsByTagName("name").item(0).getTextContent());
					Controller.setRCON(eElement.getElementsByTagName("rcon").item(0).getTextContent());
					Controller.ConsoleError("Loaded last server.");
				}
			}
		}
	}

	public static void saveServer(String ipz, String portz, String rconz,
			String namez)
	{
		
		
		
		 try {
				String filepath = "data.xml";
				DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
				Document document = docBuilder.parse(filepath);
		 
				
				 Element root = document.getDocumentElement();

			        // Root Element
			        Element rootElement = document.getDocumentElement();

			        
			            // server elements
			            Element server = document.createElement("server");
			            rootElement.appendChild(server);

			            Element name = document.createElement("name");
			            name.appendChild(document.createTextNode(namez));
			            server.appendChild(name);
			            
			            Element ip = document.createElement("ip");
			            ip.appendChild(document.createTextNode(ipz));
			            server.appendChild(ip);
			            
			            Element rcon = document.createElement("rcon");
			            rcon.appendChild(document.createTextNode(rconz));
			            server.appendChild(rcon);
			            
			            Element port = document.createElement("port");
			            port.appendChild(document.createTextNode(portz));
			            server.appendChild(port);

			            root.appendChild(server);
			        
		 
		 
				// write the content into xml file
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				DOMSource source = new DOMSource(document);
				StreamResult result = new StreamResult(new File(filepath));
				transformer.transform(source, result);
		 
				
				removeData();
				loadData();
		 
			   } catch (ParserConfigurationException pce) {
				pce.printStackTrace();
			   } catch (TransformerException tfe) {
				tfe.printStackTrace();
			   } catch (IOException ioe) {
				ioe.printStackTrace();
			   } catch (SAXException sae) {
				sae.printStackTrace();
			   }
			}

	private static void removeData() {
		Controller.removeData();
		
	}
		
		
		
		
		
	}

