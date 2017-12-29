package com.wat.pl;

//import org.json.JSONObject;
import net.sf.json.JSONObject;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

@WebServlet(name = "Servlet")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

            //odczyt danych od klienta i zapis w postaci json
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String jsonString = "";

        if(br != null){
            jsonString = br.readLine();
        }

        JSONObject json = JSONObject.fromObject(jsonString);
        String login = (String) json.get("login");
        String password = json.getString("pass");

    //    String login = request.getParameter("login");
   //     String password = request.getParameter("pass");

        out.println("TEST " + User.Loggin(login, password));
        //wyslanie danych do klienta jako json w stringu
        response.getWriter().println(json.toString() );

        /*komentarze w konsoli klienta *////////////////////////////////////////////
        response.getWriter().println("Hello from servlet" );

        System.out.println("json.toString() : " + json.toString() );
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String login = request.getParameter("login");
        String password = request.getParameter("pass");

        out.println("TEST " + User.Loggin(login, password));
    }
}
