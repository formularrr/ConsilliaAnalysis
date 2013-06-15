
	import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;  
	import java.io.StringReader;  
	import org.apache.lucene.analysis.Analyzer;  
	import org.apache.lucene.analysis.TokenStream;  
	import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;  
import org.wltea.analyzer.lucene.IKAnalyzer;  
	  
	public class Test {  
	    public static void main(String[] args) throws IOException {  
	        String text=new String();  
	        
	        FileReader fr = new FileReader("/Users/formula/Resource/DataCleaning/xumingyileian/2.txt");
			BufferedReader br = new BufferedReader(fr);
			String line = new String();
			while( (line = br.readLine()) != null){
				line = line.replaceAll("\r\n", "");
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
	            System.out.print(term.toString()+"|");  
	        }  
	        reader.close();  
	        System.out.println();  
	    }  
	}
	  

