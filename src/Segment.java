import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.Map;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.wltea.analyzer.lucene.IKAnalyzer;


public class Segment {
	
	public static void main(String[] args) throws FileNotFoundException, IOException{
		
		//String inputPath ="E:/Workspaces/MyEclipse 8.5/DataCleaning/short";
		//String outputPath ="E:/Workspaces/MyEclipse 8.5/DataCleaning/xumingyileianoutput";
		
		//Map<Integer, String> fileMap = ReadFiles.readFileMap(inputPath);
		
		for(int i=1; i<348; i++){
			String inputPath ="/Users/formula/Resource/DataCleaning/xumingyileian/"+i+".txt";
			String outputPath ="/Users/formula/Resource/DataCleaning/xumingyileianSegment/"+i+".txt";
			 String text=new String();  
		        
		        FileReader fr = new FileReader(inputPath);
		        FileWriter fw = new FileWriter(outputPath);
				BufferedReader br = new BufferedReader(fr);
				String line = new String();
				while( (line = br.readLine()) != null){
					//line = line.replaceAll("\r\n", "");
					text +=line;
				}
		        //创建分词对象  
		        Analyzer anal=new IKAnalyzer(true);       
		        StringReader reader=new StringReader(text);  
		        //分词  
		        TokenStream ts=anal.tokenStream("", reader);  
		        CharTermAttribute term=ts.getAttribute(CharTermAttribute.class);  
		        //遍历分词数据  
		        while(ts.incrementToken()){  
		            System.out.print(term.toString()+" "); 
		            fw.write(term.toString()+" ");
		        }  
		        fw.flush();
		        fw.close();
		        fr.close();
		        reader.close();  
		        System.out.println();  
		    }  
		}
	}


