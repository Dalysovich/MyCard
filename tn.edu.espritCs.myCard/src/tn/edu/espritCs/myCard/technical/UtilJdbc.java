package tn.edu.espritCs.myCard.technical;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UtilJdbc {

 private Connection connection;
 private String url = "jdbc:mysql://localhost:3306/mycard";
 private String user = "root";
 private String password = "bifordecide";

 public Connection dataBaseConnetion() {

  try {
   Class.forName("com.mysql.jdbc.Driver");
   connection = DriverManager.getConnection(url, user, password);
  } catch (ClassNotFoundException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  } catch (SQLException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  }
  return connection;
 }

}