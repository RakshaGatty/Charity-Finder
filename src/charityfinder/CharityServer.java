
package charityfinder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;
//import libraryman.AddLibrarian;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class CharityServer {
   
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(9889)) {
            System.out.println("Server started. Waiting for client requests............");

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                    String enteredUsername = in.readLine();
                    String enteredPassword = in.readLine();

                    boolean loginSuccessful = CharityLao.validate(enteredUsername, enteredPassword);

                    if (loginSuccessful) {
                        System.out.println("Login successful for user: " + enteredUsername);
                        out.println("Login successful.");
                    } else {
                        System.out.println("Login failed for user: " + enteredUsername);
                        out.println("Login failed. Please check your username and password.");
                    }
                }
            }
        }
    }
}










