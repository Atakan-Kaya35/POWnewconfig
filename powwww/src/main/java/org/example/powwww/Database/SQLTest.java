package org.example.powwww.Database;

import java.sql.*;

public class SQLTest {
    // Database connection details
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://sql6.freesqldatabase.com:3306/sql6698722";
    static final String USER = "sql6698722";
    static final String PASS = "uS5iWg7v1N";

    public static void main(String[] args) {
        // Örnek kullanım
        /*int id = 0;
        String newVarcharValue = coder(0, 0, "aaaggghhhh");

        // Metodu çağırarak varchar değerini güncelle
        boolean success = updateVarcharColumn(id, newVarcharValue);

        // Sonucu kontrol et
        if (success) {
            System.out.println("Data updated successfully.");
        } else {
            System.out.println("Data could not be updated.");
        }*/
    }

    // Varchar değeri güncelleyen metot
    public static boolean updateVarcharColumn(int id, String newVarcharValue) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            // Load the JDBC driver
            Class.forName(JDBC_DRIVER);

            // Connect to the database
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // SQL query - Update the data
            String sql = "UPDATE nurse SET info = ? WHERE idNum = ?";
            stmt = conn.prepareStatement(sql);

            // Specify the new value and id number as parameters
            stmt.setString(1, newVarcharValue);
            stmt.setInt(2, id);

            // Execute the query
            int rowsAffected = stmt.executeUpdate();

            // Return whether the update was successful
            return rowsAffected > 0;
        } catch (SQLException | ClassNotFoundException se) {
            // Handle JDBC errors and class loading errors
            se.printStackTrace();
            return false;
        } finally {
            // Close the connection and statement object
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public static String coder(int x, int y, String ... vars){

        String answer = "";
        answer = answer + x + "#" + y + "#";
        for (String var : vars) {
            answer += var + "#";
        }
        return answer;
    }

    public static boolean addUser(String userName, String password, int age, String name, int weight, int height, int x, int y){
        String encriptedPassword = encryptPassword(password);
        String userInfo =weight + "#" + height + "#" + age + "#" + name + "#" + x + "#" + y + "#" + encriptedPassword;
        Connection conn = null;
        PreparedStatement stmt = null;

        if(!isUsernameTaken(userName)) {
            try {
                String sql = "INSERT INTO Patients (userName, info) VALUES (?, ?)";
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, userName);
                stmt.setString(2, userInfo);

                int rowsInserted = stmt.executeUpdate();

                if (rowsInserted > 0) {
                    System.out.println("A new row has been inserted successfully!");
                    return true;
                } else {
                    System.out.println("Failed to insert a new row!");
                    return false;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        else{
            return false;
        }
    }

    public static boolean pastOrderAssign(String userName, int price, int medName, String time){
        String userInfo = medName + "#" + time + "#" + price;
        Connection conn = null;
        PreparedStatement stmt = null;

        try {

            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            String sql = "UPDATE Patients SET pastOrder = ? WHERE userName = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, userInfo);
            stmt.setString(2, userName);

            int rowsUpdated = stmt.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Patient's info has been updated successfully!");
                return true;
            } else {
                System.out.println("Failed to update patient's info!");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * userName + "#" + weight + "#" + height + "#" + age + "#" + x + "#" + y + "#" + encriptedPassword;
     * @param userName
     * @return
     */

    public static String[] getUserInfo(String userName) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            String sql = "SELECT info FROM Patients WHERE userName = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, userName);

            rs = stmt.executeQuery();

            if (rs.next()) {
                String userInfo = rs.getString("info");
                System.out.println("Retrieved user info successfully!");
                return userInfo.split("#");
            } else {
                System.out.println("No user found with the provided username.");
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static boolean isUserAuthorised(String userName, String enteredPassword){
        String[] infoOfUser = getUserInfo(userName);
        if(SQLTest.encryptPassword(enteredPassword).equals(infoOfUser[infoOfUser.length - 1])){
            return true;
        }
        return false;
    }

    public static boolean isUsernameTaken(String userName) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT COUNT(*) AS count FROM Patients WHERE userName = ?";
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, userName);

            rs = stmt.executeQuery();

            if (rs.next()) {
                int count = rs.getInt("count");
                if(count > 0) System.out.println("Username already taken!");
                return count > 0;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static boolean removeUser(String userName) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            String sql = "DELETE FROM Patients WHERE userName = ?";
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, userName);

            int rowsDeleted = stmt.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("User deleted successfully!");
                return true;
            } else {
                System.out.println("No user found with the provided username.");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }


    public static String encryptPassword(String password) {
        StringBuilder encrypted = new StringBuilder();
        for (char ch : password.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                encrypted.append((char) ((ch - base + 2) % 26 + base));
            } else if (Character.isDigit(ch)) {
                encrypted.append((char) ((ch - '0' + 2) % 10 + '0'));
            } else {
                encrypted.append(ch);
            }
        }
        return encrypted.toString();
    }
}
