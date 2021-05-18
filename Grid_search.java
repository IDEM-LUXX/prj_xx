import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        
        
        //schitali kolichestvo testov iz vvoda
        Scanner input = new Scanner(System.in);
        int cases = input.nextInt();
        
        works:
        for(int cass = 0; cass < cases; cass++){
           
            //sdelali pole s ciframi
            int Rows = input.nextInt();
            int Cols = input.nextInt();
            input.nextLine();
            int[][] Field = new int[Rows][Cols];
            
            //zapolnili pole
            for(int i = 0; i < Rows; i++) {
                String row = input.nextLine();
                for(int j = 0; j < Cols; j++){
                    Field[i][j] = Character.getNumericValue(row.charAt(j));
                }
            }
            
            //sdelali malenkoe pole dlya patterna
            int rows = input.nextInt();
            int cols = input.nextInt();
            input.nextLine();
            int[][] Pattern = new int[rows][cols];
            for(int i = 0; i < rows; i++)
            {
                String row = input.nextLine();
                for(int j = 0; j < cols; j++)
                {
                    Pattern[i][j] = Character.getNumericValue(row.charAt(j));
                }
            }
            
            
            //ot kazhdogo chisla na pole proveryaem, nashli li pattern
            int start = Pattern[0][0];
            for(int i = 0; i < Field.length; i++) {
                
                for(int j = 0; j < Field[0].length; j++) {
                    
                    if(Field[i][j] == start) {
                        
                        //ischem, functsia nizhe
                        if(hasPattern(Field, i, j, Pattern)) {
                            System.out.println("YES");
                            continue works;
                        }
                        
                    }
                }
            }
            System.out.println("NO");
        }
    }
    
    
    
    //sobstvenno schitaem
    public static boolean hasPattern(int[][] Field, int i, int j, int[][] Pattern)
    {
        
        //esli pattern ne vlezaet v pole zakanchivaem zdes'
        if(i > Field.length-Pattern.length || j > Field[0].length-Pattern[0].length)
        {
            return false;
        } 


        int rowField = i;
        int colField = j;
        
        for(int rowPat = 0; rowPat < Pattern.length; rowPat++)
        {
            for(int colPat = 0; colPat < Pattern[0].length; colPat++)
            {
                if(Field[rowField][colField] != Pattern[rowPat][colPat])
                {
                    return false;
                }   
                colField++;
            }
            
            colField = j;
            rowField++;
        }
     
        return true;
    }
}
