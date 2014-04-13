package application;
import java.net.* ;
public class DatagramClient 
	

	/**
	 *  A simple datagram client
	 *  Shows how to send and receive UDP packets in Java
	 *
	 *  @author  P. Tellenbach,  http://www.heimetli.ch
	 *  @version V1.00
	 */

	{
	   private final static int PACKETSIZE = 1400 ;

	   public DatagramClient(String ip,String srv_port)
	   {
	      DatagramSocket socket = null ;

	      try
	      {
	         // Convert the arguments first, to ensure that they are valid
	         InetAddress host = InetAddress.getByName( ip ) ;
	         int port         = Integer.parseInt( srv_port ) ;

	         // Construct the socket
	         socket = new DatagramSocket() ;

	         // Construct the datagram packet
	         byte [] data = "A2S_INFO".getBytes() ;
	         DatagramPacket packet = new DatagramPacket( data, data.length, host, port ) ;

	         // Send it
	         socket.send( packet ) ;

	         // Set a receive timeout, 2000 milliseconds
	         socket.setSoTimeout( 2000 ) ;

	         // Prepare the packet for receive
	         packet.setData( new byte[PACKETSIZE] ) ;

	         // Wait for a response from the server
	         socket.receive( packet ) ;

	         // Print the response
	         System.out.println( new String(packet.getData()) ) ;
	         
	      }
	      catch( Exception e )
	      {
	         System.out.println( e ) ;
	      }
	      finally
	      {
	         if( socket != null )
	            socket.close() ;
	      }
	   }
	}
	
	

