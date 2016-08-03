package main.java.ua.test.simple;

import java.io.*;

class Test {


    public static void main(String[] args) {

    }

    public void test() throws IOException {

        File res = new File("/home/igor/Programming/workspace/tryAgain/src/information/info.txt");

        PrintWriter result = new PrintWriter(new BufferedWriter(new FileWriter(res, true)));

        try {
            result.println("Hello ~~~~~~~");
        } finally {
            result.close();
        }
    }
}
