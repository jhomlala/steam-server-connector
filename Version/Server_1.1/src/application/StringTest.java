package application;

public class StringTest {

	public StringTest()
	{
		 

	  
	           
	       }
	     
	  public static void test(String word) {
		  
		   
	       //indexOf return -1 if String does not contain specified word
	       if(word.indexOf("(fs)") != -1){
	    	   int i;
	    	   i = word.indexOf("(fs)");
	    	   while(i >= 0) {
	    	        System.out.println(i+"to");
	    	        System.out.println(word.indexOf("PENDING",i));
	    	        i = word.indexOf("(fs)", i+1);
	    	        
	    	   }}
	    	   else
	    	   {
	    		   
	    	   }
	  }
}
	      
		
		
	

