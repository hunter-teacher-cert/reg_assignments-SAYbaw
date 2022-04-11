# Building A Statistical Baseball Model with UNIX and AWK
### By Steve Sabaugh

Outside of the UNIX kernel are several tiny programs. These programs are small due to the memory constraints of early computer systems. The UNIX philosophy was to make small, single-purpose programs that could be “stitched” together through pipelines. That is why this character “|” is called a pipe. For instance, there is a powerful calculator program called bc. It really is a language similar to C-like languages, and it comes in really handy if you want to use variables or control structures but don’t want to code up a program.  To use it, you escape the command line prompt, but if you want to do just a quick calculation you can just pipe an echo (echo is just a bash command for print) and pipe it through bc and you’ll get your answer back from bc to the command line prompt.

		echo 2^8 |bc

In our ‘awk’ folder we have our .txt file with Boston Red Sox’s Hall of Fame Left Fielder, Ted Williams’s lifetime stats. An easy way to look at this file is to use the command ‘cat,’ which is short for conCATenation. Cat is a “small program” that takes all the words in a text file and concatenates them (appends them one after) onto the terminal screen. In other words, it prints out the text file to the screen like thus.

		cat ted.txt 


We can do the same thing with a short AWK program from the command line prompt. First, we invoke awk in the command line, then type our AWK program code enclosed in single quotes [‘’] followed by the input file that our AWK program will process, in this case, ted.txt.

		awk '{print $0}' ted.txt

This AWK program did the same as the ‘cat’ command earlier.

Now, that is a lot of data to sift through so let us take a look just at the header. AWK is made up of pattern-action statements.

		pattern { action } 

Think of it like an ‘if statement’ without writing ‘if’ and parentheses () around the condition or in this case the pattern. The program will read the input file and “if” the current line in the file it is reading (NOTE: it is important to understand that AWK reads files line-by-line) matches the pattern, the action in curly brackets {} will be performed. So to print just the header, we use a built-in variable in AWK named NR that gives us the number of lines read.

		awk 'NR == 1 {print}' ted.txt 

Now you saw before I put $0 and this time I just used print. Anything after a $ is a field number and $0 is all the fields in a line, however, if you omit $0 AWK will assume you want to print the whole line. To print the second line we just compare NR equality to 2. We can also omit the action statement altogether and AWK will assume we want to print the whole line.
		
		awk 'NR == 2' ted.txt 

The file ted.txt has its fields separated by commas. By default, AWK separates fields by white space. To change the field separator to a comma we change the built-in variable FS. We do this by using a special pattern called BEGIN. In other words, “if you’re at the beginning of the file, change the field separator to a comma.”

		BEGIN {FS = ","}

Since there are many fields in our Ted Williams stats, we should count how many fields each line has. I will use another built-in AWK variable NF and print that variable's value to the screen after line 1 has been read.

		awk 'BEGIN {FS = ","} NR == 1 {print NF}' ted.txt

Now that we know we have 30 fields per line, it would be helpful to make a table to number the header so we know what the field numbers are without having to squint our eyes and count on the screen. We can do this with a simple ‘for’ loop in our action block.

		awk 'BEGIN {FS = ","} NR == 1 {for (i = 1;i < NF + 1;i++){ print $i, " = ", i, "\n"}}' ted.txt

Notice that I used commas in the print statement. I used those only for readability. There is no concatenation operator per se in AWK like in other languages. Simply appending a variable or string literal one after another will concatenate the string. Also, the ‘for’ loop in AWK is the same as it is in JAVA and other C languages.

Now let's do some data analysis on Ted Williams. Ted Williams, it has been argued, is the greatest left-handed hitter of all time. He was also the last hitter to hit .400 in a season. So let’s search for the season(s) he hit .400 and above. We’ll use our handy table we just printed to the screen to see that field 18 is BA or batting average. I will also print the year, field 1 followed by a blank space then the BA (notice this time I do not use commas).

		awk 'BEGIN {FS = ","} NR > 1 && $18 > .3999{print $1 " " $18}' ted.txt

Oh wow, he did it in 3 seasons. The last two seasons are a bit odd if you know American history and anything about Ted William’s military career. 1952 & 1953 the US was in the thick of the Korean war. Did Ted Williams play full seasons those years? Let’s grab some more data. For .400 to be impressive you have to qualify for the batting title, meaning you have to play close to a full season. In his day a full season was 155 games, so a season with more than 100 games played would put Ted in contention for the batting title. We’ll also look at how old he was. To format these nicely, we’ll use a ‘printf()’ function, which is exactly the same as C or Java.

		awk 'BEGIN {FS = ","} NR > 1 && $18 > .3999 {printf("%d %d %3d %.3f\n",$1, $2, $5, $18)}' ted.txt

We see that in 1952 and 53 Ted only played in a few games. That is because Ted was fighting in the Korean War, which you probably learned about from social studies class. In 1941 he legitimately hit .406 on the season and won the batting title making him the last player to hit .400 or more in a season. Ted was in the Marine Corps as a Fighter Pilot. Despite being an all-star ballplayer, he was not in Korea as a goodwill ambassador. He saw real combat. In fact, his wingman was John Glenn, who would go on to be the first American to orbit the earth on Mercury 6 in 1962. He was too valuable of a pilot not to fight in Korea because he had many years of experience in America’s previous conflict, WW2. 

We’re going to use that built-in variable again NR to give us a handy reference of numbered lines in our data set. Let’s take another look at Ted’s stats.

		awk '{print NR " " $0}' ted.txt 

Notice lines 6-8. Those lines read

		Did not play in major or minor leagues (Military Service)

As you may have also learned in social studies class, WW2 was raging during 1942, 43, and 44. Baseball continued to be played as players came and went from military service or were disqualified from fighting.  One quality that Ted had that made him such a great hitter was superior eyesight. He could pick up the spin of the ball better than those with 20/20 vision. Thus, having more time to react if a ball would be in the strike zone or not. This superior vision made Ted an Ideal candidate as a pilot and he was in peak form for a fighter pilot at the age of 24. Unfortunately for baseball fans, he was also just reaching his peak form for playing baseball. Baseball writers and fans alike, from those who watched the “splendid splinter” play in person, as my dad did, or those who know him only from film, stats, and old box scores like myself, always debate and dream about what “could’ve been” if old “teddy ball game” didn’t miss those 3 years at his peak. Ted Williams is enshrined in Baseball’s Hall of Fame, so it is not like he’s cheated of any glory, just a world series title, but with AWK we can build a quick predictive model of “might’ve been.” 

The simplest way to do this is to do a regression analysis. Linear regression is one of the first predictive modeling techniques used in machine learning and modeling. The technique we’ll use for brevity and speed is the least-squares method. So, in a nutshell, a regression analysis takes 2 variables (NOTE: I mean variables in the statistical sense of the word as in data points, not in the programming sense as in a named memory location whose value changes as the program runs) x and y. The x variable is our independent variable, and our y variable is our dependent variable or the one we want to predict or analyze. In other words, based on past x,y relationships, what can we predict y will be if x = n. In our model, our independent x variable will be Ted’s age and our dependent y variable will be his batting average. We will base our model on his previous 4 full seasons, where x and y (age and avg) are both known and we will write a program that will give us a formula for the best fit for a “curve” that is a straight line (thus the linear in “linear regression”) that would match his positive trajectory of batting average through his prime years with only his age or x as the known variable. This model cannot, therefore, predict slumps.

So first, we need to manipulate the data from those first 4 seasons. Now they're a couple of ways to do that. There is a big concept in UNIX called *regular expressions*. This is a way to search for and manipulate strings as opposed to mathematical expressions thus the word regular. There are two programs in UNIX called grep and sed that use *regular expressions* to manipulate and search for data and AWK incorporates *regular expressions* in pattern matching. So instead of writing a conditional boolean statement, you can use a regular expression like thus.

		/regular expression/ {action}

As a slight diversion, I want to give another demonstration of UNIX pipes, small UNIX programs, and *regular expressions*, with a program called sort. Since our file is already sorted in order chronologically, we can sort our file in reverse by doing a pattern looking for all the lines that contain BOS the only team he ever played for, and piping that through sort with a reverse option. For this exercise, we’ll just look at Ted’s home runs, which is field 12, and the years he hit them field 1 in reverse order.

	awk 'BEGIN {FS = ","} /BOS/{print $12 " " $1}' ted.txt |sort -r

Now back to our model. We can search for a range of lines that begin with the integer 1939 and end at 1942 (inclusive). To prove that this pattern works we’ll print the lines first (NOTE: the comma between the two reg ex denotes a range). 

		awk '/1939/, /1942/ {print NR " " $0}' ted.txt 


However, since we have line numbers handy, we can also just use a traditional compound boolean statement with the built-in NR variable.

		awk 'NR >= 2 && NR < 6 {print NR " " $0}' ted.txt

Same thing. Again, AWK is about speed and shortcuts or readability and ease. You decide which is better.

So far, all of our awk programs have been done “in-line” or on the command line because they were very small. Our statistical model will still be a small program, but sometimes you might find it easier to write the program in a separate text file and you can write it out in a more traditional way you are used to writing programs in other languages that use curly braces {} like Java or the C languages. You could use any graphical text editor, but I would like to show you my favorite text editor that I use right from the command line, another UNIX tiny program that is called VIM. I’m going to open VIM and create a new file TedWarYears.txt.

		vi TedWarYears.txt

Then type [i] and the bottom of the screen will now say insert mode. We are now ready to enter our program

    BEGIN {
    		    FS = ",";
        	  count = 0
    }
    NR >= 2 && NR < 6 {
            x[NR] = $2;
            y[NR] = $18;
            count++

    }
    END{
            for(i = 1;i < count + 1;i++){
                    sumX = sumX + x[i];
                    sumX2 = sumX2 + x[i]*x[i];
                    sumY = sumY + y[i];
                    sumXY = sumXY + x[i]*y[i]
            }
            b = (count * sumXY - sumX * sumY) / ( count * sumX2 - sumX * sumX);
            a = (sumY - b*sumX) / count;

            for (i = 24; i < 27; i++){
                    pAvg = a + (b * i);
                    printf("Age %d: %.3f projected batting avg.\n",i, pAvg)
            }
    }

Notice in the BEGIN action I created a count variable. This was used to avoid using magic numbers. AWK is designed for doing “quick and dirty” number crunching and data analysis or creating small useful programs on the fly. Popular conventions and norms are not usually necessary because AWK is not meant for building enterprise-level solutions. However, due to the didactic nature of this exercise, I thought it was important to create a variable to “count” how many records I was counting. If I wrote this program for myself, I would have put 5 instead of count + 1 in my first ‘for’ loop header, and when solving for “a” I would’ve divided by 4, etc., but old habits are hard to break.

Notice that in the second ‘for’ loop I use “i” as my loop variable when it would’ve been more accurate to use x because 24 - 27 are the ages or x variables. Here, I thought it better to use “i” as the traditional abbreviation for index because x[] was already in use as my array name. So “i” takes x’s place in the traditional curve fitting formula y = a + (bx).

An important thing to consider with arrays in AWK. Note how I populate the x[] and y[] arrays in the BEGIN action statement. The array’s first subscript is the number 2, not 0 like most languages or 1 in BASIC or Visual Basic. That is because AWK uses associative arrays like dictionaries in Python or hash tables in JS or Java. A subscript could be essentially any data type (integer, float, string). This is a very powerful feature for creating quick databases and even creating your own programming language with AWK plus a whole lot of other useful programs but also is convenient for populating arrays with the NR variable and being able to skip the header.

We also did all of our number-crunching in a special AWK pattern called END. This is where you program after all of your input file has been read into your program.
 
When finished, hit [esc] then [:x!] to save and exit VIM. Now we run the program from a file from the command line we just have to use this command.

		awk -f "filename.ext" inputfile.ext

Now to see what our model predicts Ted Williams would have hit in his ages 24, 25 & 26 seasons if he had not gone and fought in WW2 and did not slump.

		
		 awk -f "TedWarYears.txt" ted.txt

There you have it. The debate and speculation are settled. If you are familiar at all with baseball statistics you may be able to tell that our model is a bit generous to the old “splendid splinter.” Die-hard fans of his, like my father, would say “yeah, that’s about right.” Teddy “Ballgame’s” legend is alive in me mostly because of hearing stories from my dad. Korean war era veterans like himself thought he was the greatest. Fresh from the air over the heat of the battle on the Korean peninsula, Ted came back from the war and finished the season by batting over .400 as if he never left. Now adding some weights and different regression methods would bring those numbers down to earth a little bit, especially those last two years, which seem impossible, but then again maybe our model is perfect because it just confirms the legend. This was a fun exercise, but this is exactly what you would do if your boss would ask you to predict sales agents on the floor to potential sales or cops on street to crimes committed.
