package lab8;


import java.io.*;
import java.net.*;
import java.security.SecureRandom;
import java.util.*;

public class Main {

    public static String generateRandomString(int length) {
        String randomString = "";

        final char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz01234567890".toCharArray();
        final SecureRandom random = new SecureRandom();
        for (int i = 0; i < length; i++) {
            randomString = randomString + chars[random.nextInt(chars.length)];
        }

        return randomString;
    }


    public static void main(String[] args) throws IOException {

        String login="login";
        String pass = "pass";
        String ID="";
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
      //  String inputLine= in.readLine();
        String ans;


        while(true)
        {
            String inputLine= in.readLine();
            if(state==1) {
                if (inputLine.equals("LOGIN "+login + ";" + pass)) {
                    ans = "CORRECT";
                    ID = generateRandomString(4);
                    state = 2;
                  //  out.println(ans);
                    out.println("CORRECT, Your ID: "+ID);
                } else {
                    ans = "WRONG";
                    out.println(ans);
                    try {
                        Thread.currentThread().sleep(1000);
                    }
                    catch(InterruptedException e)
                    {

                    }
                    while(in.ready())System.out.println(in.readLine());
                    out.flush();
                }
            }
            if(state == 2)//waiting for commands
            {
                if(inputLine.startsWith("LOGOUT"))
                {
                    if(inputLine.equals("LOGOUT "+ID))
                    {
                        out.println("Logging out");
                        state=3;
                    }
                    else
                    {
                        out.println("FALSE");
                    }
                }

                if(inputLine.startsWith("LS")) {
                    if (inputLine.equals("LS " + ID))
                    {
                        String file_names = "";
                        File folder = new File(".\\Server_files");
                        if (folder.isDirectory())
                        {
                            for (final File file : folder.listFiles())
                            {
                                file_names = file_names + ";" + file.getName();
                                System.out.println(file.getName());
                            }
                            out.println(file_names);
                        }
                    }
                    else
                    {
                        out.println("FALSE");
                    }
                }
                if(inputLine.startsWith("GET"))
                {
                    if(inputLine.startsWith("GET "+ID))
                    {
                        String file_name = inputLine.substring(9);
                        file_name = ".\\Server_files\\"+file_name;
                        try {
                            File temp = new File(file_name);
                            boolean flag = temp.exists();
                            if (flag) {
                                FileReader fr = new FileReader(file_name);
                                String string_for_output = "";
                                int i;
                                while ((i=fr.read()) != -1)
                                {
                                    if(i==10 || i==13)
                                        i=32;
                                    string_for_output=string_for_output+(char)i;
                                }
                                out.println(string_for_output);
                            } else
                                out.println("FALSE");
                        }catch(IOException e)
                        {
                            out.println("FALSE");
                        }
                    }
                    else
                    {
                        out.println("FALSE");
                    }
                }
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

