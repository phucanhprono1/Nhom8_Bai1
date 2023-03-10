package org.example;

import java.sql.*;

public class PaymentService {

    public boolean checkCreditCard(String cardHolderName, String cardType, String cardNumber, String cardCVC, String expirationMonth, String expirationYear) {
        boolean result = false;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            // Connect to database
            conn = getConnection();
            // Prepare SQL statement
            String sql = "SELECT * FROM credit_card WHERE card_number=? AND expiration_month=? AND expiration_year=? AND card_cvc=?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cardNumber);
            stmt.setString(2, expirationMonth);
            stmt.setString(3, expirationYear);
            stmt.setString(4, cardCVC);
            // Execute SQL statement
            rs = stmt.executeQuery();
            // Check if credit card information is valid
            if (rs.next()) {
                String dbCardHolderName = rs.getString("card_holder_name");
                String dbCardType = rs.getString("card_type");
                if (cardHolderName.equals(dbCardHolderName) && cardType.equals(dbCardType)) {
                    result = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close database connection
            closeConnection(conn, stmt, rs);
        }
        return result;
    }

    public boolean processPayment(String cardHolderName, String cardType, String cardNumber, String cardCVC, String expirationMonth, String expirationYear, double amount) {
        boolean result = false;
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            // Connect to database
            conn = getConnection();
            // Begin database transaction
            conn.setAutoCommit(false);
            // Prepare SQL statement to insert payment information
            String sql = "INSERT INTO payment (card_holder_name, card_type, card_number, card_csc, expiration_month, expiration_year, amount, date_time) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cardHolderName);
            stmt.setString(2, cardType);
            stmt.setString(3, cardNumber);
            stmt.setString(4, cardCVC);
            stmt.setString(5, expirationMonth);
            stmt.setString(6, expirationYear);
            stmt.setDouble(7, amount);
            stmt.setTimestamp(8, new Timestamp(System.currentTimeMillis()));
            // Execute SQL statement to insert payment information
            int rowsAffected = stmt.executeUpdate();
            // Check if payment information was successfully inserted
            if (rowsAffected == 1) {
                // Commit database transaction
                conn.commit();
                result = true;
            }
        } catch (SQLException e) {
            try {
                // Rollback database transaction
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            // Close database connection
            closeConnection(conn, stmt, null);
        }
        return result;
    }

    private Connection getConnection() throws SQLException {
        // Create database connection
        String url = "jdbc:mysql://localhost:3306/payment";
        String username = "root";
        String password = "root";
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }

    private void closeConnection(Connection conn, Statement stmt, ResultSet rs) {
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}