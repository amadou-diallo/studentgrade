
package studentgrades1;


import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author amadou
 */
public class Studentgrades1 {
    
   
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
       
    System.out.println("welcome to Amadou student grades program.");
        String sid; //student id
    
        sid = getStudentID();// priming read for Student ID
       
        while(!sid.equalsIgnoreCase("Quit")) { //while sid != quit:
              calcGrade(sid); //calculate grade(sid)
              sc.nextLine();
              sid = getStudentID();// obtain next student ID
        }//end of while
              
       System.out.println("Thanks for using the grade calculator.");
       
      }//end of main
    
      public static String getStudentID() {
          String sid= "";
          boolean goodval = false; // to control loop
          
          do { 
                System.out.print("Student ID ('quit' to exit):");
          
              try {
                  sid = sc.nextLine();
                                
                  if(sid.isEmpty()) {
                   System.out.println("Please enter a value for student ID");
                  } else if(sid.equalsIgnoreCase("Quit")) {
                     goodval = true;
                     
                     
                 } else if (!sid.substring(0,1).equalsIgnoreCase("A")) {
                     System.out.println("Student ID must start with 'A'");
                 } else if (sid.length() != 9) {
                 System.out.println("illegal student #: must be 9 characters");
                 } else {
                     long id = Long.parseLong(sid.substring(1));
                     if (id > 0) {
                         goodval = true;
                     } else {
               System.out.print("Digits after 'A' must be > 0");
                          
                     }
                 }
                         
                 
              } catch (NumberFormatException e) {
              System.out.println("illegal ID: value after 'A' must be digits");
              
             }
              
            }  while (!goodval);
          return sid;
       
    }//end of getstudentID
        
        public static void calcGrade (String sid) {
            double q1,q2,q3,q4,q5,qm,mt,pr,fe,qavg,cavg;
            String Igrade;
            
            q1 = getScore("quiz 1 Score:");
            q2 = getScore("quiz 2 Score:");
            q3 = getScore("quiz 3 Score:");
            q4 = getScore("quiz 4 Score:");
            q5 = getScore("quiz 5 Score:");
            qm = getScore("Make-up quiz score:");
            mt = getScore("Midterm Score:");
            pr = getScore("Problems Score:");
            
          double[] q = { q1,q2,q3,q4,q5,qm };
               Arrays.sort(q);// sorts quiz array lowest to highest
    qavg = ( q[2] + q[3] + q[4] + q[5]) / 4.0 ;  //System.out.print("Quiz Avg = " + qavg);
               if (qavg >= 89.5 && mt >= 89.5 && pr >= 89.5) {
                   //exempt from final...
                   cavg = (qavg + mt + pr) / 3.0;
                   Igrade = "A";
               } else {
                   //must include final exam & weight scores
                   fe = getScore("Final Exam Score: ");
                   cavg = (qavg * .5) + (mt * .15) + (pr * .1) + (fe * .25);
                   if (cavg >= 89.5) {
                       Igrade = "A";
                  } else if (cavg >= 79.5) {
                      Igrade = "B";
                  } else if (cavg >= 69.5) {
                      Igrade = "C";
                      
                  } else if (cavg >= 59.5) {
                      Igrade = "D";
                  } else {
                       Igrade = "F";
                      
                  }
               }//end of outer else
               System.out.println("Student" + sid + 
                         " earned a quiz average of: " + qavg + ", " +
                         " a course average of: " + cavg +
                         " for a letter grade of: " + Igrade);
               
               //check on requirement for final
               //if not taking final:
               // calculate sim
        }
    
        
       public static double getScore(String prompt) {
            System.out.print(prompt);
             double s = 0;
             boolean goodval = false;
             
             do { 
                 try {
                     System.out.print(prompt);
                     s = sc.nextDouble();
                     
                     if (s < 0 || s > 125) {
            System.out.println("Score is out of range - please re-entrer.");
                      
                     } else {
                         goodval = true;
                     }
                 } catch (Exception e) {
            System.out.println("Illegal score entry - not numeric.");
                   goodval = false;
                   sc. nextLine();
                 }
             } while (!goodval);
             
              return s;
             
               
            }
}


    


          
          
              
    
          
