package com.hw4;

public class TaskThreadDemo {
    public static void main(String[] args) {
        String[] sa = {"a", "X", "+", "."};
        for(String s : sa) {
            Runnable ps = new PrintChar(s, 200);
            Thread ts = new Thread(ps);
            ts.start();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e.getMessage());
            }
        }
    }
}

class PrintChar implements Runnable { 
    String ch;
    int times;

    public PrintChar (String c, int n) { 
        ch=c;
        times = n;
    } // end constructor

    public void run () { 
        for(int i = 0; i < times; i ++){
            System.out.print (ch); 
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e.getMessage());
            }
        } // end for loop
    } // end method run 
} // end class PrintChar