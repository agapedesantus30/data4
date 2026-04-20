import java.io.File;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Scanner;

public class WebInputFileOutput {

	public static final String QUERY = "http://download.finance.yahoo.com/d/" +
			"quotes.csv?s=BAC,FCX,SIRI,CHK,AAPL,GE,F,NVDA&f=sl1d1t1c1ohgv&e=.csv";
	
	public static void main(String[] args) { 
		
		System.out.println("print out desired stock value");
			
		//establish a url object for the web service end point
			URL url;
			Scanner input = null;
			
			// open an output file
			File outputFile = new File("report.txt");
			PrintWriter output = null;
		
			try {
				//need to convert the url to a stream to scanner constructors
				input = new Scanner(new URL(QUERY).openStream());
				output = new PrintWriter(outputFile);
				
				//read input files line by line output each line
				while(input.hasNext()) {
					String line = input.nextLine();
					
					String[] tokens = line.split(",");		
					output.println("<html>\n" +
							"<h1>Agapitus Stock Report</h1>\n" +
							"<thead>" + 
							"<table border=\"3\" cellpadding=\"3\" cellspacing='3'>\n" +
							"<tr><th><p><strong>Ticker</strong></p></th><th>" +
									"<p><strong>Price</strong></p></th><th>" +
									"<p><strong>Volume</strong></p></th></tr>" +
							"</thead> \n" +
							tokens[0].substring(1, tokens[0].length()-1)
							+ " " + "$" + tokens[1] +  " " + tokens[8] +
							
							"</table> \n" +
							"<h2>Porfolio value = $22,864.50</h2>" +
							"</html>\n");
						
//					output.close();
									
				}
				
			} catch (Exception e) {
				System.out.println("Unable to read or write files");
				e.printStackTrace();
			}
			
			System.out.println("done");
			
			input.close();
			output.close();
			
	}


}
