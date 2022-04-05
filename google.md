# Google
## ASCII Right Triangles with Nested for Loops

Now that you understand nested ‘for’  loops, we are going to make some star patterns like the right triangle below.

    *****
    ****
    ***
    **
    *

Instead of using the loop variables i and j, notice how I use row and col to make the code clearer.

    int row;
    int col;
    
    System.out.println("Triangle 1");
    
    for (row = 1; row <= 5; row++){
            for (col = 5; col >= row; col--)
                System.out.print("*");
      System.out.println();
            
    }

Now try to create this pattern. HINT: You need to determine whether to print a “ “ or a “*” in your loops.
    
    *****
     ****
      ***
       **
        *
        
Now try this pattern

        *
       ** 
      ***
     ****
    ***** 
### After google

I was surprised I could not find a solution to my particular patterns. I remember doing this problem years ago when I learned about nested ‘for’ loops and I swear my triangles were upside down to start. It was strange that the only example I could find online was the one pattern I did not ask for, which was the one with the base toward the lower part of the screen and the hypotenuse toward the right part of the screen. 

When I did this exercise, I coded up the solution with what I thought was the best way to tackle it and an alternative method. For the patterns that had white space along the left margin I just used an ‘if’ statement. Looking at the solutions online they did it differently without using ‘if’ statements. So I did learn a lot doing this exercise. One of the online solutions used a prefix increment operator, which is very cool, but if a student used that I would be very suspicious because I do not know of a way I would teach optimizing iterations in a 'for' loop using perfix operators in the update. I think if I actually did this for a teaching assignment and not homework for Methods II, I would have done more due diligence in seeking out other solutions to this apparently popular problem, albeit with only one version of the triangle pattern. 

I searched the terms *java print out right triangle*, *java console star pattern triangles nested for loops*, and *java ascii right triangle nested for loops, Here were the top results from all 3 searches*.

https://www.geeksforgeeks.org/java-program-to-print-right-triangle-star-pattern/

https://codedost.com/java/star-patterns-in-java/java-program-to-print-a-pattern-of-right-triangle-using-star/

https://javatutoring.com/java-mirrored-right-triangle-star-pattern/

I thought the assignment was going to be too hard because I gave the easiest pattern as my example, but after reading the search results, I think it would be just enough of a challenge to use these results to do my assignment.  You could copy and paste it but you would definitely need to edit the logic to make the program work, so I’m not sure that would be beneficial.

### My Solutions
      
    /**
    *
    * @author Steve Sabaugh
    */
    public class TriangleDraw {
      public static void main(String[] args) {
        int row;
        int col;
        int count = 5;
        String space = "";
        
        System.out.println("Triangle 1 method 1");
        for (row = 1; row <= 5; row++){
            for (col = 5; col >= row; col--)
                System.out.print("*");
            System.out.println();
        }
        
        System.out.println("Triangle 1 method 2");
        for (row = 1; row <= 5; row++) {
            for (col = row; col <= 5; col++)
                System.out.print("*");
            System.out.println();
        }
        
        System.out.println("Triangle 2 method 1");
        for (row = 1; row <= 5; row++){
            System.out.print(space);
            for (col = 5; col >= row; col--)
                System.out.print("*");
            System.out.println();
            space += " "; 
        }
        
        System.out.println("Triangle 2 method 2");
        count = 0;

        for (row = 1; row <= 5; row++, count++){   
            for (col = 1; col <= 5; col++){
                if (col > count)
                    System.out.print("*");
                else
                    System.out.print(" "); 
            }
            System.out.println(); 
        }
        
        System.out.println("Triangle 3");
        count = 5;
        
        for (row = 1; row <= 5; row++, count--){   
            for (col = 1; col <= 5; col++){
                if (col < count)
                    System.out.print(" ");
                else
                    System.out.print("*");
            }
            System.out.println(); 
        }
      }
    }

