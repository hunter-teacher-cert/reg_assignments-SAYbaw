# Think Different
### Strategies for Differentiation in CS Education 
### By Steve Sabaugh

We discussed last class whether or not the best strategy is to teach a baseline and/or differentiate up or differentiate down. I have no experience teaching
in the classroom, so my only experience comes from how I learned programming as a freshman during undergrad.  I think I would want to teach high school students
the same way. When it comes to straight-up writing code, I would teach at a moderate level to have my students understand the most essential concepts. I know
they are not all going to become developers, but I want to teach the basics as thoroughly as possible, while still teaching practical methods that they can use
in any vocation to give them more skills. So, my choices here are aimed at teaching programming primarily and not CS in general.

## Weening off block languages (Google Blockly, MS Makecode)

I'm sure some teachers can teach programming very effectively with block programming. If I have a choice as an instructor, I would not. I cannot prove it here, but
there is some evidence out there that it hinders students’ ability to "think computationally." I also think it is easier to learn just to write the code. In the 
short term, it is harder but will pay off later on. However, I understand that many of my students may be used to block languages so I still could use them as
support.

Scratch is terrible for this. While there is a version that is more verbose and you can write more code, it is not a robust language and is more of a toy or useful
in purely didactic situations. Google Blockly has a Python or a JavaScript code panel next to the block area that the students can use as a reference on how to 
write the code if they feel more comfortable with blocks. The problem with Blockly is that this is only a "one-way street." You cannot edit the Python or JS script
and create blocks. MS Makecode can, however, do this. You can write your code in either JS or Python, switch over to blocks and there are your blocks created from
your code. One drawback to Makecode is that it is limited to physical computing devices, such as micro:bit, etc., and game environments, like Minecraft and others.
All of the physical computing environments do come with a virtual software emulator of the device, so it can still be used without. I prefer the BBC micro:bit
environment. It is a fun little device that can teach all the basic concepts of programming (sequence, decision, iteration & IPO, and structured programming) and 
uses JS and Python. It is also inexpensive so if they want to buy one it is only $20 - $30. If you happen to be teaching another language, the syntax is "C-like" enough to help you with Java and any other curly bracket language. The micro:bit website has tons of teacher resources including classroom management. All of the MS Makecode environments have integrations with popular LMS.

I think of this as code-complete in an IDE. If a student's ability is holding them back, this could be a resource to help them.

## Alternative Languages (Sonic Pi and AWK)

If I think the problem is that my students are losing interest and therefore need to differentiate based on interest or ability,
I would turn to alternate languages. MS Makecode for game development or the micro:bit as mentioned above could pique my student's interest. As a musician who 
worked in music and sound production in my past career, Sonic Pi may inspire some students and the basic concepts are all there.

AWK is a little out of the box. Awk is an amazing programming language and command-line tool. If you look at my code for my Data teaching project that was like
100 lines of code and involved 5 methods. That whole program could essentially be replaced by this one line of code in AWK.

    {FS = ","} $2 == 2010 { printf("%4d %-15s%-52s%7d\n", $2, $1, $3, $4, $5, $6) > "2010Report.txt" }

AWK may not be "cool" like Sonic Pi, but it is a fun and very practical programming language. It is "C like" (the K in AWK is Brian Kernighan the guy who literally wrote the book on C). It is great for writing small useful programs. It is also good for rapid prototyping of functions that can help you design your program
in another language once you know the logic is sound. It can be used in a varity of applications in business. It is a skill that can make you a valuable office worker or temp. You can even make databases quickly. I know a few people whose job is dealing with data all day. Their boss doesn't realize they made a script to automate the progress and they spend 30 minutes a day working and the rest of the time looking busy. This could be good for the student that wants instant gratification. When we did our data project I was going to do my lesson on AWK. I still have not fully fleshed out how I would integrate this into my instruction yet, but it is very intriguing. With replit's built-in UNIX environment, it would not require much to include it. You can write algorithms in AWK. You can even build an assembler and interpreter with it. I would use AWK to build a tiny assembler so my CS students can get the idea of writing assembly instructions 
without having to teach a specific assembler.

AWK would be used for those who say "why do have to learn to program? I have no use for it." It may also help other students who are lacking in programming 
ability to see another way of writing conditionals and loops.

## Easier Languages (Quarum and RPN)

I've used Quorum because it has a lot of tools for the visually impaired and that is a special cause for me. It has a built-in voice synthesizer and the code is very clean with little punctuation and indents. This is the code for "Hello World!"

    output "Hello world!"

This is the code for the computer to speak "Hello World!"

    say "Hello world!"
    
As you can see the code looks like pseudo-code. This could also be a training wheels language. If I were to teach pseudo-code, I may just write it as Quarum, 
and the students could actually run the pseudo-code. There is also the novel factor of having the computer speak. That could pique students’ interest also. You 
can download it or use a web interpreter.

RPN or Reverse Polish Notation, yes, old HP calculator programming language. Although it is unstructured because it has the dreaded "GOTO" command, it is very
simple and it covers all of the important features of programming, including methods/functions/subroutines, iteration, decision, branching, IPO, and variables, which are literally calculator memory slots. It is the least verbose language there is, there is no punctuation, and you can do some complex mathematical 
programming. You can also do simple little math programs. Each program line is one command or one digit. There are web or desktop RPN environments. The following
is an example of a Gamma Function program on the HP 67 or HP 15. This obviously would not be a project for differentiation. I'm just showing it so you can see all
of the programming concepts it covers. 

NOTE: Ignore the number(s) after the line number and before the mnemonic. Those numbers are the key codes of the calculator
used for debugging on a calculator. (e.g. in line 001, 31 is the LBL (label) key, 25 is the shift key 11 is the A key. First digit row, second digit column on 
keypad)

    001  31 25 11	LBL A //main
    002  01		1
    003  35 52	x-y
    004  31 25 02	LBL 2 //subroutine
    005  31 81	x>0? //if statement
    006  22 01	GTO 1 //branch
    007  41		ENTER
    008  35 53	Rv
    009  71		×
    010  35 54	R^
    011  01		1
    012  61		+
    013  22 02	GTO 2 //function call
    014  31 25 01	LBL 1
    015  33 15	STO E // Variable assignment
    016  35 52	x-y
    017  33 14	STO D
    018  07		7
    019  06		6
    020  83		.
    021  01		1
    022  08		8
    023  00		0
    024  00		0
    025  09		9
    026  01		1
    027  07		7
    028  03		3
    029  34 15	RCL E //load "variable" to X register (the main window)
    030  01		1
    031  61		+
    032  81		÷
    033  08		8
    034  06		6
    035  83		.
    036  05		5
    037  00		0
    038  05		5
    039  03		3
    040  02		2
    041  00		0
    042  03		3
    043  03		3
    044  34 15	RCL E
    045  02		2
    046  61		+
    047  81		÷
    048  51		-
    049  02		2
    050  04		4
    051  83		.
    052  00		0
    053  01		1
    054  04		4
    055  00		0
    056  09		9
    057  08		8
    058  02		2
    059  04		4
    060  34 15	RCL E
    061  03		3
    062  61		+
    063  81		÷
    064  61		+
    065  01		1
    066  83		.
    067  02		2
    068  03		3
    069  01		1
    070  07		7
    071  03		3
    072  09		9
    073  05		5
    074  07		7
    075  02		2
    076  34 15	RCL E
    077  04		4
    078  61		+
    079  81		÷
    080  51		-
    081  01		1
    082  83		.
    083  02		2
    084  00		0
    085  08		8
    086  06		6
    087  05		5
    088  00		0
    089  09		9
    090  07		7
    091  04		4
    092  43		EEX //Scientific notation
    093  03		3
    094  42		CHS //negate
    095  34 15	RCL E
    096  05		5
    097  61		+
    098  81		÷
    099  61		+
    100  05		5
    101  83		.
    102  03		3
    103  09		9
    104  05		5
    105  02		2
    106  03		3
    107  09		9
    108  03		3
    109  08		8
    110  05		5
    111  43		EEX
    112  06		6
    113  42		CHS
    114  34 15	RCL E
    115  06		6
    116  61		+
    117  81		÷
    118  51		-
    119  01		1
    120  61		+
    121  35 73	π // pi does not not need to be entered one line at a time
    122  02		2
    123  71		×
    124  31 54	√ // SQRT function (built-in funtions)
    125  71		×
    126  34 15	RCL E
    127  81		÷
    128  31 52	LN
    129  34 15	RCL E
    130  05		5
    131  83		.
    132  05		5
    133  61		+
    134  31 52	LN
    135  34 15	RCL E
    136  83		.
    137  05		5
    138  61		+
    139  71		×
    140  61		+
    141  34 15	RCL E
    142  51		-
    143  05		5
    144  83		.
    145  05		5
    146  51		-
    147  32 52	ex
    148  34 14	RCL D
    149  81		÷
    150  35 22	RTN //return to A (mian)

