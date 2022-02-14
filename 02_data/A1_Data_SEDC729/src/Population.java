/*File Reading and Data Processing in Java by Steve Sabaugh
 * 
 * This lesson will teach you how to grab raw data from the Internet, read 
 * it into a Java program using the Scanner, FileReader and BufferedReader
 * classes. Split Data up into arrays using split() and other methods, 
 * creating an ASCII table in console/terminal, and processing the data by
 * writing a min/max algorithm and averaging the data. Other key java concepts like modularization 
 * passing arrays as arguments are covered as are different versions of 
 * exception handling (since file manipulation must be done in Java with 
 * try/catch or other exception techniques).*/

 /* Step1 
 * Download https://data.cityofnewyork.us/City-Government/
 * New-York-City-Population-By-Neighborhood-Tabulatio/swpk-hqdp
 * csv file. Open it a text editor and remove first line or "header"
 * and make sure that data begins at very top of the file. Rename 
 * file "populations.txt" for simplicity sake and add file to same folder 
 * as your source file.
 */

/* Step 2 
 * Create a public class named Population but for your main()
 * method after your parameters write "throws FileNotFoundExcetion" before
 * the curly braces as shown below. This is an alternative to a try/catch 
 * block
 */
import java.io.*;
import java.util.*;


public class Population {

	public static void main(String[] args) throws FileNotFoundException  {
		//displayRawData();//Step 4 call in main to see result
		//System.out.println(lineCt());//data dump for step 5
		getData();
		
	}
	/*Step 3 
	 * create a static method to read and display the raw data from
	 * the file using the Scanner class
	 */
	public static void displayRawData() throws FileNotFoundException {
		Scanner sc = new Scanner(new File("populations.txt"));
		sc.useDelimiter(",");
		
		
		while (sc.hasNext()){ 
			//add a pipe "|" so data is easier to read
			System.out.print(sc.next() + "|");
		  
		  }
		  
	    sc.close();//ALWAYS MAKE SURE TO CLOSE YOUR FILE WHEN DONE!!!
		
	}
	/*Step 5
	 * create a method that will count the lines in the file. This will tell
	 * us how big our arrays need to be. When you're done with the method 
	 * create a println with a call to the method in main for testing. 
	 * Notice here, we will not write the exception throw in the method
	 * definition line, instead we'll just use a more traditional try/catch
	 * block.
	 */
	public static int lineCt() {
		int count = 0;
		try {
			FileReader file = new FileReader("populations.txt");
			BufferedReader br = new BufferedReader(file);
			
			
			
			while (br.readLine() != null ) {
				count++;
			}
			br.close();
			
		}
	
		catch (IOException e ) {
			System.out.println("A read error has occured");
		}
		return count;
	}
	/*Step 6
	 * This method will read and sort the data into arrays so we can
	 * manipulate and display the data in our program.
	 */
	public static void getData() {
		String line = ""; //temp string to hold the data while it is read 
		String splitBy = ",";//Delimiter that separates our values
		int size = lineCt();//number of elements in our arrays
		String[] boros = new String[size];
		String[] years = new String[size];
		String[] counties = new String[size];
		String[] codes = new String[size];
		String[] names = new String[size];
		/*the reader will read all the data as Strings, including the 
		 * populations numbers, however, we'll need to perform math
		 * on these numbers, so we need another array of integers to
		 * parse from the String of popStrings.
		 */
		String[] popStrings = new String[size];
		int[] populations = new int[size];
		
		try {  
		int idx = 0; //this variable will increment row by row
		// thus incrementing each element number for our arrays
		BufferedReader br = new BufferedReader(new FileReader("populations.txt"));  
			while ((line = br.readLine()) != null){ 
				//temporary array that splits each line into an array
				String[] records = line.split(splitBy); 
				boros[idx] = records[0];
				years[idx] = records[1];
				counties[idx] = records[2];
				codes[idx] = records[3];
				names[idx] = records[4];
				popStrings[idx] = records[5];
				idx++;
				  
			}
			br.close();
		}   
		catch (IOException e)   {  
		e.printStackTrace(); //alternative to typing your own error message 
		} 
	    /*This loop converts the population strings into integers.
		 *This could've been done in the loop above,
		 *but for clarity I'm showing it separately here.
		 */
	    for(int i = 0;i < size;i++) {
	    	populations[i] = Integer.parseInt(popStrings[i]);
	    }
	    displayData(boros,years,counties,codes,names,populations);
	    displayFooter(boros,years,counties,codes,names,populations);
	}
	/*Step7
	 * create a method called displayData with 6 of our data arrays as
	 * parameters. Only use the int populations[] array. We no longer need
	 * the String popString[] array.
	 */
	public static void displayData(String bor[], String yr[], String cty[],
			String code[], String name[], int pops[]) {
		System.out.println("+----------------------------- NYC Population"
				+ " by Neighborhood -----------------------------+");
				
		System.out.println("|Borough      |Year|FIPS|NTA|NAME               "
				+ "                                |Population|");
		System.out.println("+----------------------------------------------"
				+ "--------------------------------------------+");
		/*Step 8
		 * Create for loop using printf to create a neat table of data. Do a 
		 * function call to displayData at the bottom of getData(), making sure
		 * to pass the appropriate arrays as arguments. 
		 * After your done and you make sure all is aligned correctly and your
		 * fields are the correct size and properly justified, you can
		 * create a nice ASCII header above the for loop as I have done 
		 * here with column headings. 
		 */
		//This one loop here is 99% of the output of your program
		for(int i = 0;i < bor.length;i++) {
			System.out.printf("|%-13s|%4s|%s|%s|%-51s|%9d |\n",bor[i], yr[i], cty[i],
					code[i], name[i], pops[i]);
		}
		//bottom line for ASCII Table
		System.out.println("+----------------------------------------------"
				+ "--------------------------------------------+");
	}
	/*Step 9
	 * Finally, we make a footer for our table to display at the bottom.
	 * This is where all the processing and statistical number crunching
	 * of the program happens. Again the parameters will be the same as
	 * displayData(), and we will call it immediately after displayData()
	 * in the getData() method with the same exact arguments.
	 */
	public static void displayFooter(String bor[], String yr[], String cty[],
			String code[], String name[], int pops[]) {
		//min must be init. bigger than any possible number in your program
		int min = 10000000;
		int max = 0;
		int total = 0;
		double avg = 0.0;
		String minBoro = "";
		String maxBoro = "";
		String minName = "";
		String maxName = "";
		
		for(int i = 0;i < bor.length;i++) {
			/*NOTE:
			 * Normally for this algorithm to work we would not need to test
			 * both pops[i] < min && pops[i] > 0, but because some of our 
			 * neighborhoods having no permanent or living residents like 
			 * airports and cemeteries, we want our code to only count 
			 * neighborhoods that have actual living residents in them, so 
			 * no 0 populated neighborhoods will be chosen for min.
			 */
			if (pops[i] < min && pops[i] > 0) {
				min = pops[i];
				minBoro = bor[i];
				minName = name[i];
			}
			if (pops[i] > max) {
				max = pops [i];
				maxBoro = bor[i];
				maxName = name[i];
				
			}
			total += pops[i];
		}
		avg = (double) total/bor.length;
				
		System.out.printf("Smallest: %s, %s at %d residents.\n", minName, 
				minBoro, min);
		System.out.printf("Largest: %s, %s at %d residents.\n", maxName, 
				maxBoro, max);
		System.out.printf("Average: %.1f residents per neighborhood.\n", avg);
		
		
		
		
		
	}
}
