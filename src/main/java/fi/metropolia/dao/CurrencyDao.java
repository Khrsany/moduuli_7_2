package fi.metropolia.dao;

import fi.metropolia.database.MariaDbConnection;
import fi.metropolia.model.Currency;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CurrencyDao {

    public Currency getCurrencyByCode(String code) {
        String sql = "SELECT * FROM currency WHERE code = ?";
        try (Connection conn = MariaDbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, code);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Currency(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("code"),
                        rs.getDouble("rate")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
