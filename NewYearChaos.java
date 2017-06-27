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
import java.io.IOException;


public class NewYearChaos {

    
    public static void main(String[] args) {

        //Specifications of test files
        String fileName = "input00.txt";

        //File file = new File(args[0]);
        File file = new File("/home/raphael/Documents/Git/programming-challenge-"
                +"CC/new-year-chaos-testcases/input/" + fileName);
        
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
                if(currentLine.length() == 1){ //It's time to get next queue size
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
        } catch (IOException e) {
            e.printStackTrace();
        }
                  
    }

}
