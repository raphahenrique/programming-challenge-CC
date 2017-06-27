/* 
** Raphael Henrique Fontes da Silva
**
** Program: New Year Chaos 
** Purpose: Based on the current state of a queue, it determines how many
** swaps took place(with the maximum number of 2 swaps per person).
*
*/

package newyearchaos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class NewYearChaos {

    public static void main(String[] args) throws IOException {

        //Specifications of input test files
        String fileName = "input01.txt";
        //File file = new File(args[0]); //If we opt by passing test file in args
        File file = new File("/home/raphael/Documents/Git/programming-challenge-"
                +"CC/new-year-chaos-testcases/input/" + fileName);
        
        
        //Output files
        String outputName = "output01.txt";
        //File outputFile = new File(args[1]);//If we wish to specify the output location
        File outputFile = new File("/home/raphael/Documents/Git/programming-challenge-"
                +"CC/new-year-chaos-testcases/output/" + outputName);
        //Where file will be written
        PrintWriter pw = new PrintWriter(new FileWriter(outputFile));

        
        
        int T = 0; //Number of test cases in file
        int n = 0; //Number of people queued up
        
        String result = ""; //Resulting string to be saved
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
 
            //Read first line to get T
            if((T = Integer.parseInt(br.readLine())) == -1)
                return;
            
            String currentLine; 
            int t = -T;
            
            //Reading line by line
            while(T > t){
                currentLine = br.readLine();
                if(!currentLine.contains(" ")){//It's time to get next queue size
                    n = Integer.parseInt(currentLine);
                }else{
                    //Fills the queue
                    int[] queue = new int[n];
                    String[] array = currentLine.split(" ");
                    for(int i = 0; i < n;i++)
                        queue[i] = Integer.parseInt(array[i]);
                    
                    int bribes = 0; //Number of bribes
                    boolean chaotic = false; 
                    
                    //For each position in queue
                    for(int i = 0; i < n; i++ ){ 
                        if((queue[i] - 1) > i+2){
                            chaotic = true;//If person bribed more than 2 others
                        }        
                    }
                    if(!chaotic){
                        bribes = 0;
                        for(int j = 0; j < n; j++) {
                            //When we subtract the final queue from our
                            //original queue, if we only get the positive
                            //values, we have the number of bribes
                            int sub = ((j+1)- queue[j]);
                            if(sub > 0){
                                bribes += sub;
                            }else if((sub == -2) && ((j+2) - queue[j+1] == 0)){
                            //This special case happens when we have values that
                            //'walked' and end up in their original places
                            //example: Final queue-> (3 2 1), here 2, first swapped
                            //with 3, and later with 1, returning to original pos.
                                bribes += 1;
                            }
                        }
                    }
                    
                    if(!chaotic)
                        result += bribes + "\n";
                    else
                        result += "Too chaotic" + "\n";
                    
                }
                T--;
            }
            
            System.out.println(result);
            
            br.close();
            
            pw.print(result);
            pw.flush();
            pw.close();
        

        } catch (IOException e) {
            e.printStackTrace();
        }
                  
    }

}
