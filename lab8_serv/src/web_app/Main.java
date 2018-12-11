package web_app;



import java.io.*;
import java.net.*;

public class Main {
    public static void main(String[] args) throws IOException {

        String login="login";
        String pass = "pass";
        String ID;
        int no_of_users =0;
        int state = 1; //1 - wait for login, 2 - waiting for command, 3 - close connection

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(6666);
        } catch (IOException e) {
            System.out.println("Could not listen on port: 6666");
            System.exit(-1);
        }

        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.out.println("Accept failed: 6666");
            System.exit(-1);
        }
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        clientSocket.getInputStream()));
        String inputLine= in.readLine();
        String ans;


        while(true)
        {
            if(state==1) {
                if (inputLine.equals(login + ";" + pass)) {
                    ans = "CORRECT";
                    no_of_users++;
                    ID = "ID"+no_of_users;
                    state = 2;
                    out.println(ans);
                    out.println("Your ID: "+ID);
                } else {
                    ans = "WRONG";
                    out.println(ans);
                }
            }
            if(state == 2)//waiting for commands
            {
             //   if(inputLine.equals())
            }
            if(state == 3) //logging out and closing connection
            {
                out.close();
                in.close();
                clientSocket.close();
                serverSocket.close();
                break;
            }
        }

    }
}

