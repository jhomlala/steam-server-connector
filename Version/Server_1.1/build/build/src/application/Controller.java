package application;

import javafx.fxml.FXML;
import java.awt.datatransfer.*;
import java.awt.Toolkit;

import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import java.awt.Desktop;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import net.sourceforge.rconed.SourceRcon;
import net.sourceforge.rconed.exception.BadRcon;
import net.sourceforge.rconed.exception.ResponseEmpty;

public class Controller implements Initializable
{
	
	   @FXML
	    private static TextField Field1;
	    
	    @FXML
	    private static TextField Field2;
	    
	    @FXML
	    private static TextField Field3;
	    
	    @FXML
	    private static TextField Field4;
	    
	    @FXML
	    private static TextField Field5;
	    
	    @FXML
	    private static TextField Field6;
	    
	    @FXML
	    private static TextArea Area1;
	    
	    @FXML
	    private ComboBox changeMap;
	    
	    @FXML
	    private ComboBox changeConfig;
	    
	    @FXML
	    private static ComboBox lastServers;
	
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
    	changeMap.getItems().addAll(
    			"pl_badwater",
    			"pl_upward",
    			"cp_gullywash_final1",
    			"koth_pro_viaduct_rc4",
    			"pl_swiftwater_ugc",
    			"koth_lakeside_final",
    			"pl_borneo_rc3",
    			"cp_gravelpit",
    			"cp_granary",
    			"cp_steel",
    			"cp_process_final",
    			"cp_snakewater_final1",
    			"cp_warmfront",
    			"koth_ashville_rc3",
    			"koth_coalplant_b7",
    			"cp_badlands",
    			"cp_metalworks_rc5"
    			);
    	
    	changeConfig.getItems().addAll(
    			"etf2l_9v9.cfg",
    			"etf2l_9v9_5cp",
    			"etf2l_9v9_ctf",
    			"etf2l_9v9_koth",
    			"etf2l_9v9_stopwatch",
    			"ugc_HL_standard.cfg",
    			"ugc_HL_stopwatch.cfg",
    			"ugc_HL_koth.cfg",
    			"ugc_HL_ctf.cfg",
    			"ugc_HL_tugofwar.cfg",
    			"etf2l_6v6_5cp.cfg",
    			"etf2l_6v6_ctf.cfg",
    			"etf2l_6v6_koth.cfg",
    			"etf2l_6v6_stopwatch.cfg"
    			);
    	
    	
    }
    
 
    
    
    @FXML
    private void But1Click(ActionEvent event) throws BadRcon, ResponseEmpty, IOException
    {
    	 if (isDataValid())
    	{
        String ip = Field1.getText();
        String rcon = Field2.getText();
        String Command = Field3.getText();
        int port = Integer.valueOf(Field4.getText());
        
        SourceRcon.send(ip, port, rcon, "say ***************************");
        SourceRcon.send(ip, port, rcon, "say Using Steam Server Connector");
        SourceRcon.send(ip, port, rcon, "say Using command :"+Command+"!");
        SourceRcon.send(ip, port, rcon, "say ***************************");
        
        System.out.println("IP:" +ip + " rcon " + rcon + " Command:" + Command);
        String output = SourceRcon.send(ip, port, rcon, Command);
        StringTest.test(output);
        ConsoleError(output);
    	}
    }
    
    @FXML
    private void But2Click(ActionEvent event) throws BadRcon, ResponseEmpty, IOException , SocketTimeoutException
    {
    	
        if (isDataValid())
        {
        	String ip = Field1.getText();
            String rcon = Field2.getText();
            String Command = (String) changeMap.getValue();
            int port = Integer.valueOf(Field4.getText());
            ConsoleError("Changing map to: "+ Command);
            
            SourceRcon.send(ip, port, rcon, "say ***************************");
            SourceRcon.send(ip, port, rcon, "say Using Steam Server Connector");
            SourceRcon.send(ip, port, rcon, "say Changing map to:"+Command+"!");
            SourceRcon.send(ip, port, rcon, "say ***************************");
            
            String output = SourceRcon.send(ip, port, rcon, "changelevel "+Command);

            ConsoleError(output);
        }
        
        	
       
    }
    
    
    @FXML
    private void But3Click(ActionEvent event) throws BadRcon, ResponseEmpty, IOException
    {
    	
        if (isDataValid())
        {
        	String ip = Field1.getText();
            String rcon = Field2.getText();
            String Command = (String) changeConfig.getValue();
            int port = Integer.valueOf(Field4.getText());
            ConsoleError("Changing config to: "+ Command);
            
            SourceRcon.send(ip, port, rcon, "say ***************************");
            SourceRcon.send(ip, port, rcon, "say Using Steam Server Connector");
            SourceRcon.send(ip, port, rcon, "say Changing config to:"+Command+"!");
            SourceRcon.send(ip, port, rcon, "say ***************************");
            String output = SourceRcon.send(ip, port, rcon, "exec "+Command);
            ConsoleError(output);
        }
        
        	
       
    }
    
    @FXML
    private void But4Click(ActionEvent event) throws BadRcon, ResponseEmpty, IOException
    {
    	if (isDataValid2())
    	{
    		Saver.saveServer(Field1.getText(),Field4.getText(),Field2.getText(),Field5.getText());
    	}
       
        
        	
       
    }
    
    @FXML
    private void But5Click(ActionEvent event) throws BadRcon, ResponseEmpty, IOException, ParserConfigurationException, SAXException
    {
    	
    	 String value = (String) lastServers.getValue();
    	 Saver.findInSave(value);
        	
       
    }
    @FXML
    private void But6Click(ActionEvent event) throws BadRcon, ResponseEmpty, IOException, ParserConfigurationException, SAXException, URISyntaxException
    {
    	 if (isDataValid())
         {
         	String ip = Field1.getText();
             int port = Integer.valueOf(Field4.getText());
             ConsoleError("Connecting to server.");
     
             URI uri = new URI("steam://connect/"+ip+":"+port);
             if (Desktop.isDesktopSupported()) {
                  Desktop.getDesktop().browse(uri);
             }
             
         }
    	
    
       
    	 
    }
    @FXML
    private void But7Click(ActionEvent event) throws BadRcon, ResponseEmpty, IOException, ParserConfigurationException, SAXException
    {
    	if (isDataValid())
	    	{
	     	String ip = Field1.getText();
	        int port = Integer.valueOf(Field4.getText());
	        String pass = Field6.getText();
	        if (!pass.trim().isEmpty() && pass !=null )
	        {
	        	String connect = "connect "+ ip +":"+port+"; password "+pass;
	        	ConsoleError("Your connect is copied to clipboard.");
	        	ConsoleError(connect);
	        	ConsoleError("Generated connect:");
	        	StringSelection stringSelection = new StringSelection (connect);
	        	Clipboard clpbrd = Toolkit.getDefaultToolkit ().getSystemClipboard ();
	        	clpbrd.setContents (stringSelection, null);
	        }
	        else
	        	ConsoleError("Please insert password to generate connect");
    	}
       
    }
    
    
    
    private Boolean isDataValid() {
    	String ip = Field1.getText();
        if (!ip.trim().isEmpty() && ip !=null)
        {
        	String rcon = Field2.getText();
        	if (!rcon.trim().isEmpty() && rcon !=null)
        	{
        		String port_string = Field4.getText();
        		if (!port_string.trim().isEmpty() && port_string !=null && isInteger(port_string))
        		{
        			return true;
        		}
        		else
        		{
        			ConsoleError("Please insert server port!");
        			return false;
        		}
        	}
        	else
        	{
        		ConsoleError("Please insert server rcon!");
        		return false;
        	}
        	
        }
        else
        {
        	ConsoleError("Please insert server ip!");
        	return false;
        }
		
	}
    
    
    
    private Boolean isDataValid2() {
    	String ip = Field1.getText();
        if (!ip.trim().isEmpty() && ip !=null)
        {
        	String rcon = Field2.getText();
        	if (!rcon.trim().isEmpty() && rcon !=null)
        	{
        		String port_string = Field4.getText();
        		if (!port_string.trim().isEmpty() && port_string !=null && isInteger(port_string))
        		{
        			String name = Field5.getText();
        			if (!name.trim().isEmpty() && name !=null )
            		{
            			return true;
            		}
        			else
        			{
        				ConsoleError("Please insert server name!");
            			return false;
        			}
        		}
        		else
        		{
        			ConsoleError("Please insert server port!");
        			return false;
        		}
        	}
        	else
        	{
        		ConsoleError("Please insert server rcon!");
        		return false;
        	}
        	
        }
        else
        {
        	ConsoleError("Please insert server ip!");
        	return false;
        }
		
	}
    
    


    public static boolean isInteger(String s) {
        try { 
            Integer.parseInt(s); 
        } catch(NumberFormatException e) { 
            return false; 
        }
        // only got here if we didn't return false
        return true;
    }


	public static void ConsoleError(String error) {
		String text = Area1.getText();
		Area1.setText(error + "\n" + text);
		
	}

	static void addLastServers(String server_name)
	{
		lastServers.getItems().add(server_name);
	}


	static void setIP(String ip)
	{
		Field1.setText(ip);
	}
	 static void setPORT(String port)
	{
		Field4.setText(port);
	}
	static void setRCON(String rcon)
	{
		Field2.setText(rcon);
	}
	static void setNAME(String name)
	{
		Field5.setText(name);
	}




	public static void removeData() {
		ObservableList c = lastServers.getItems();
		lastServers.getItems().removeAll(c);
		
	}




	
    
}