//import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

class Question {

    private String text;
    private String answer;
    private int difficulty;



    public Question (String text, String answer, int difficulty){
        this.text = text;
        this.answer = answer;
        this.difficulty = difficulty;
    }



    public void setAnswer(String answer) {
        this.answer = answer;
    } public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    } public void setText(String text) {
        this.text = text;
    }


    public int getDifficulty() {
        return difficulty;
    } public String getAnswer() {
        return answer;
    } public String getText() {
        return text;
    }




}

class Quiz {

    ArrayList<Question> list = new ArrayList<>();
    Scanner sc = new Scanner(System.in);


    public void add_question() {

        System.out.println("What is the question Text?");
        String userText = sc.nextLine();
        System.out.println("What is the answer?");
        String userAnswer = sc.nextLine();
        System.out.println("How Difficult (1-3)?");
        int userDiff = Integer.parseInt(sc.nextLine());

        Question addQ = new Question(userText, userAnswer, userDiff);

        list.add(addQ);
    }

    public void remove_question() {

       for (int i = 0; i < list.size(); i++) {
           System.out.println(i + " " + list.get(i).getText());
        }

        System.out.println("Choose the question to remove?");
        int responseRemove = Integer.parseInt(sc.nextLine());

        list.remove(responseRemove);
    }

    public void modify_question() {

        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + " " + list.get(i).getText());
        }

        System.out.println("Choose the question to modify?");
        int responseModify = Integer.parseInt(sc.nextLine());

        System.out.println("What is the question Text?");
        String modifyQuestion = sc.next();

        list.get(responseModify).setText(modifyQuestion);
    }

    public void give_quiz() {
        int score = 0;
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getText());
            System.out.println("what is the answer?");
            String response = sc.nextLine();
            if (response.equals(list.get(i).getAnswer())){
                System.out.println("YAY GOOD JOB");
            score++;
            } else System.out.println("NOOOOOOOO");
        }
        System.out.println("You got " + score + " out of " + list.size());
    }
}

public class Lab3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Quiz yippie = new Quiz();
        boolean quit = false;

        do {


            System.out.println("What would you like to do? \n" +
                    "1. Add a question to the quiz \n" +
                    "2. Remove a question from the quiz \n" +
                    "3. Modify a question in the quiz \n" +
                    "4. Take the quiz \n" +
                    "5. Quit");
            String toDo = sc.nextLine();

            switch (toDo) {
                case "1":
                    yippie.add_question();
                    break;
                case "2":
                    yippie.remove_question();
                    break;
                case "3":
                    yippie.modify_question();
                    break;
                case "4":
                    yippie.give_quiz();
                    break;
                case "5":
                    quit = true;
                    break;

            }
        }while (quit == false);
    }
}
