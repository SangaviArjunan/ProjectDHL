package task1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleCalculator {
	private BigDecimal output;

	public String compute(double x, double y, char operator) {
   		switch (operator) {
		case '+': 
			output = new BigDecimal(x+y);
			break;
		case '-':
			output = new BigDecimal(x-y);
			break;
		case '*':
			output = new BigDecimal(x*y);
			break;
		case '/':
			output = new BigDecimal(x/y);
			break;
		default:
			return "Error";
		}
		return  ""+ new BigDecimal(x) + operator + new BigDecimal(y) + "=" + output;
	}

	public static void main(String[] args) {
		
		SimpleCalculator calc = new SimpleCalculator();
		
		//To create a file
		File outputFile = new File("output.txt");
		try {
			if(outputFile.createNewFile()) {
				System.out.println("Output file has been created");
			}else {
				System.out.println("Output file already exists!");
			}
		// To write into a file	
		FileWriter writer = new FileWriter("output.txt");
		
		//To read a file
		File inputFile = new File("input.txt");
		Scanner scanner = null;
		try {
			scanner = new Scanner(inputFile);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}	
		while(scanner.hasNext()) {
			double d1 = 0.0, d2 = 0.0;
			char operator = 0 ;
			String str = scanner.nextLine();

			//terminal operation upon reaching end of document
			if("=".equals(str)) break; 
			
			/*datatype conversion 
			 * Ex : 
			 * input ---> String str = 2+3;
			 * output---> double d1 =2, d2 = 3; char operator = '+'
			 */
			Pattern pt = Pattern.compile("[-+*/]");
			Matcher mt = pt.matcher(str);
			int flag= 0;
			if(mt.find()) {
				if (flag != mt.start()) {
					 d1 = Double.parseDouble(str.substring(flag, mt.start()));
				}
				flag = mt.start()+1;
				operator = mt.group().charAt(0);
				if(flag != str.length()) {
					 d2 = Double.parseDouble(str.substring(flag));
				}
			}
			//file write operation
			str = calc.compute(d1,d2, operator);
			writer.write("" + str + "\n");
		}
		
		System.out.println("Output file is updated, You may check the result");
		writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
