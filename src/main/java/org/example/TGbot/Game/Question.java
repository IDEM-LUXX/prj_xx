package org.example.TGbot.Game;



import java.io.*;


public class Question {

    public String question;
    public String ans1;
    public String ans2;
    public String ans3;
    public String ans4;
    public String check_right;

    public Question(){

    }

    public Question(String[][] strings, int index){
        this.question = strings[index][0];
        this.ans1 = strings[index][1];
        this.ans2 = strings[index][2];
        this.ans3 = strings[index][3];
        this.ans4 = strings[index][4];
        this.check_right = strings[index][5];
    }

    public static Question[] BuildQuestions(int number) {


        String[][] strings = new String[number][6];


            try {
                File file = new File("src/main/resources/questions.txt");
                //создаем объект FileReader для объекта File
                FileReader fr = new FileReader(file);
                //создаем BufferedReader с существующего FileReader для построчного считывания
                BufferedReader reader = new BufferedReader(fr);


                for (int k = 0; k<number; k++) {
                    for (int z = 0; z <6; z++) {
                        strings[k][z] = reader.readLine();
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        Question[] questions = new Question[number];

        for(int i=0; i<number; i++){
            questions[i] = new Question(strings, i);
        }

        return questions;
    }

}
