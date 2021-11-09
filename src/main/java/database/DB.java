package database;

import java.sql.*;

public class DB {
    private Statement stmt;
    private Connection con;

    public void MedDB(){
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/med", "user", "password");
            this.stmt = this.con.createStatement();
            System.out.println("DB connected...");
        } catch (SQLException e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }

    public boolean login(String username, String password){
        try {
            String queryString = "SELECT COUNT(*) FROM USER WHERE user_name = '"+username+"' and password = '"+password+"'";
            ResultSet result = this.stmt.executeQuery(queryString);
            int flag = -1;
            while(result.next()){
                flag = result.getInt(1);
            }
            if(flag == 0){
                return false;
            }
            return true;
        } catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
