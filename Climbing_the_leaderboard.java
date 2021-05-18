import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int[] scores = new int[size];
        //mesta igrokov v otdelnii massiv
        int[] ranks = new int[size]; 
        
        //zapolnyaem oba massiva
        for(int i=0, rank=1; i < size; i++){
            
            int scor = input.nextInt();
            scores[i] = scor;
            
            if(i > 0 && scores[i-1] != scor){
                rank++; 
            }
               
            ranks[i] = rank;    
        }
        
        //prisvaem vsem igrokam rank na odin nizhe hudshego v tablitse
        int playersRank = ranks[ranks.length-1] + 1;
        int leaderboardIndex = size-1;
        int psize = input.nextInt();
        
        int lastScore = -1; //suda pishem poslednii record s kotorim rabotali 
        
        for(int playerScores=0; playerScores < psize; playerScores++)
        {
            int levelScore = input.nextInt();
        
            //teper prosto obhodim vsu tablitsu proveryaya odin record kazhdogo igroka
            for(int i = leaderboardIndex; i >= -1; i--){
                
                
                if(i < 0 || scores[i] > levelScore){
                    System.out.println(playersRank);
                    break;
                } else if(scores[i] < levelScore){
                    //zdes proveryaem vishe li rank
                    if(scores[i] != lastScore){
                        playersRank--;    
                    }
                    //podnimayemsya po tablitse liderov
                    leaderboardIndex--;
                } else{
                    leaderboardIndex--;
                    playersRank = ranks[i];
                }
                
                lastScore = scores[i];
            }
        }
    }
}
