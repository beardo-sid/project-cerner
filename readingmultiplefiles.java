import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.File;
 
import java.io.FileWriter;

public class readingmultiplefiles {
	
	static int translation(int count1 , int count2) //function to calculate the translation percentage of the files
	{	int perc = 0;
	   if(count1 == count2) 
	   {perc = 100;}
	  
	   if(count1>count2) 
	   {
		   perc = (count2 *100)/count1;
	   }
	
		
	    return perc;
	}
	
	
	
	
	
	

    public static void main(String[] args) throws IOException {
        String target_dir = "C:\\New folder - Copy\\src\\main\\resources\\properties\\cerner";
        File dir = new File(target_dir);
        File[] files = dir.listFiles();
        
        
        int linecount = 0;
        int[] no_of_lines = {0,0,0,0,0,0};
        int k=0,d=1;
        
        try {
            FileWriter fw=new FileWriter("C:\\Users\\SS078312\\Documents\\hello.txt",true);
            // path of the folder where all .properties files are stored
            
            
            for (File f : files) {
            	
            if(f.isFile()) { //loop used to open each file one by one
            					BufferedReader inputStream = null;

							    try {
										  inputStream = new BufferedReader(
											            new FileReader(f));
											                    
											                    
											                    
											                    
											                    
											                    
											                    //getting the names of the files
											                    String name = f.getName();
											                    
											                    
											                    //writing data to the file
											                    fw.write(d + ","+"\t");
											                    fw.write(name+",\t"); 
											                    fw.write(f.getAbsolutePath() + ",\t");
											                    fw.write(f.length() +",\t"+ "\n");
											                    d++;
											                 
											                    
											                    
											                    
											
											                   
											          	      while((inputStream.readLine())!=null)   
											          	      {
											          	         linecount++;     //reading the no of lines of opened file         
											          	             
											          	      }
											          	      
											          	      no_of_lines[k] = linecount;  // storing the no of lines of each file in an array
											          	      k++;
											          	   
											                    
									  }
											                
											                finally {
											                    if (inputStream != null) {
											                        inputStream.close();
											                    }
											                }
                           }
            
            
            linecount = 0; //after counting and storing no of lines in each file the linecount is intialized to 0 for next file.
        }
            
            
              
         
            		System.out.println("Success in writing the data to file\n\n");
        
            		
			        for(int i=1;i<no_of_lines.length;i++)
			        {
			        	//getting the translation percentage of the files
			        	int translation_percentage = translation(no_of_lines[0], no_of_lines[i]);
			        	System.out.println("translation percentage done is: "+translation_percentage +"\n");
			        
			        	
			        	
			        //storing the translation percentage of the files in text file
			           
			        fw.write(translation_percentage+"\n");    
			         
			        
			       }
			        
			        fw.close(); 
        }
        
        
        
        catch(Exception e)
        
        {System.out.println(e);}  
          
        
        
         
       System.out.println(" \n Success writing all data to the file \n");  
        
        }
    
    
    
        
        
        
        
        
        
    }

