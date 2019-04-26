package mytest;

public class Question {
    private static int  num;
    public static void main(String [] args){
        Question q = new Question();
        q.num=13;
        update(q);
        System.out.println(q.num);
    }
   public static void update(Question q){
        q.num=9;
    }
}