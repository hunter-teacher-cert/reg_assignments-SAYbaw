### Files included in 02_data
Project folder: A1_Data_SEDC729

    populations.txt 
  Bin folder: bin
  
      Poulation.class
  Source folder: src
  
      Population.java

New_York_City_Population_By_Neighborhood_Tabulation_Areas.csv

output_wHeader.png

output_wFooter.png

README.md

# File Reading and Data Processing in Java
### By Steve Sabaugh

This lesson will teach you how to grab raw data from the Internet, read 
it into a Java program using the Scanner, FileReader and BufferedReader
classes. Split Data up into arrays using split() and other methods, 
creating an ASCII table in console/terminal, and processing the data by
writing a min/max algorithm and averaging the data. Other key java concepts 
like modularization and passing arrays as arguments are covered as are 
different versions of exception handling (since file manipulation must be 
done in Java with try/catch or other exception techniques).

The source code is marked up with comments of the step by step process of 
how the lesson will be taught. I will repeat those comments here.

Step1 
Download https://data.cityofnewyork.us/City-Government/New-York-City-Population-By-Neighborhood-Tabulatio/swpk-hqdp
csv file. Open it a text editor and remove first line or "header"
and make sure that data begins at very top of the file. Rename 
file "populations.txt" for simplicity sake and add file to same folder
as your source file.

Step 2 
Create a public class named Population but for your main()
method after your parameters write "throws FileNotFoundException" before
the curly braces as shown below. This is an alternative to a try/catch 
block.

	public static void main(String[] args) throws FileNotFoundException  {

Step 3 
Create a static method to read and display the raw data from
the file using the Scanner class.

Step 4
Call in main() method to see the result.

	Public static void main(String[] args) throws FileNotFoundException  {
		displayRawData();
	}

Step 5
Create a method that will count the lines in the file. This will tell
us how big our arrays need to be. When you're done with the method 
create a println with a call to the method in main() for testing. 
Notice here, we will not write the exception throw in the method
definition line, instead we'll just use a more traditional try/catch
block.

Step 6
This getData() method will read and sort the data into arrays so we can
manipulate and display the data in our program. We will call this from 
main(). This will also be the last method called from main as the rest
of the methods will be called from this method, because this is where
we create the most important variables, our data arrays.

Step7
Create a method called displayData() with 6 of our data arrays as
parameters.

Step 8
Create for loop using printf to create a neat table of data. Do a 
function call to displayData() at the bottom of getData(), making sure
to pass the appropriate arrays as arguments. After you're done and you 
make sure all is aligned correctly and your fields are the correct size 
and properly justified, you can create a nice ASCII header above the for 
loop as I have done here with column headings. 

	System.out.println("+----------------------------- NYC Population"
				+ " by Neighborhood -----------------------------+");
				
	System.out.println("|Borough      |Year|FIPS|NTA|NAME               "
				+ "                                |Population|");
	System.out.println("+----------------------------------------------"
				+ "--------------------------------------------+");

Step 9
Finally, we make a footer, writing a method called displayFooter(), for our 
table to display at the bottom. This is where all the processing and 
statistical number crunching of the program happens. Again the parameters 
will be the same as displayData(), and we will call it immediately after 
displayData() in the getData() method with the same exact arguments.

NOTE: For further instruction and comments, please see marked up
source code in this folder Population.java.
