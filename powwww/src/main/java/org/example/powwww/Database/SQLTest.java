package org.example.powwww.Database;

import org.example.powwww.med.Pill;

import java.sql.*;
import java.util.ArrayList;

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
        String userInfo = weight + "#" + height + "#" + age + "#" + name + "#" + x + "#" + y + "#" + encriptedPassword + "#-";
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

    public static boolean updateUser(String userName, String encryptedPassword, String age, String name, String weight, String height, String x, String y, String remainders) {
        String userInfo = weight + "#" + height + "#" + age + "#" + name + "#" + x + "#" + y + "#" + encryptedPassword + "#" + remainders;

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String sql = "UPDATE Patients SET info = ? WHERE userName = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, userInfo);
                stmt.setString(2, userName);

                int rowsInserted = stmt.executeUpdate();

                if (rowsInserted > 0) {
                    System.out.println("A new row has been inserted successfully!");
                    return true;
                } else {
                    System.out.println("Failed to insert a new row!");
                    return false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean pastOrderAssign(String userName, int price, String product, ArrayList<Pill> meds){
        StringBuilder userInfoBuild = new StringBuilder(product + "#" + price);
        for(Pill med : meds){
            userInfoBuild.append("#" + med.getName());
        }
        String userInfo = userInfoBuild.toString();
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

    public static String[] getPastOrder(String userName) throws NullPointerException{
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            String sql = "SELECT pastOrder FROM Patients WHERE userName = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, userName);

            rs = stmt.executeQuery();

            if (rs.next()) {
                String userInfo = rs.getString("pastOrder");
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

    /**
     * weight + "#" + height + "#" + age + "#" + name + "#" + x + "#" + y + "#" + encriptedPassword;
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
        if(SQLTest.encryptPassword(enteredPassword).equals(infoOfUser[infoOfUser.length - 2])){
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
