package Utilities;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
public class InputData {


	public static List<Element> getTestData(String csvFile) throws IOException{
		List<Element> csvLines = new ArrayList<Element>();
		BufferedReader br = null;
	    String line = "";
	    String csvDelimiter = ",";
	    
	    try{
	    	br = new BufferedReader(new FileReader (csvFile));
	    	while ((line = br.readLine())!=null){
	    		if (line.trim().length()==0){
	    			break;
	    		}
	    		String[] columnsInLine = line.split(csvDelimiter);
	    		List<Element> eachRow = new ArrayList<Element>();	   
	    		for (int pos=0; pos < 3; pos++){
	    			
	    			Element individualObj = new Element();	   
	    			individualObj.setAge(columnsInLine[pos++]);
	    			individualObj.setOccurance1(columnsInLine[pos++]);
	    			individualObj.setOccurance2(columnsInLine[pos++]);
	    			
	    			
	    			eachRow.add(individualObj);
	    			individualObj = null;
	    		}
	    		csvLines.addAll(eachRow);
	    	 }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
		return csvLines;
	}

}

