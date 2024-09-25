package orgg.dao.quote;

import orgg.entities.Quote;
import orgg.DbConfig;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class PgQuoteDAO extends QuoteDAO {
    private final DbConfig dbConfig = DbConfig.getInstance();

    @Override
    public void addQuote(Quote quote) {
        String sql = "INSERT INTO quotes (project_id, estimatedAmount, issueDate, validityDate, accepted) " +
                "VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = dbConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, quote.getProjectId());
            statement.setDouble(2, quote.getEstimatedAmount());
            statement.setDate(3, java.sql.Date.valueOf(quote.getIssueDate()));
            statement.setDate(4, java.sql.Date.valueOf(quote.getValidityDate()));
            statement.setBoolean(5, quote.isAccepted());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Quote> displayQuotes(int projectId) {
        List<Quote> quotes = new ArrayList<>();
        String sql = "SELECT * FROM quotes WHERE project_id = ?";

        try (Connection connection = dbConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, projectId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    int project_id = resultSet.getInt("project_id");
                    double estimatedAmount = resultSet.getDouble("estimatedAmount");
                    LocalDate issueDate = resultSet.getDate("issueDate").toLocalDate();
                    LocalDate validityDate = resultSet.getDate("validityDate").toLocalDate();
                    boolean accepted = resultSet.getBoolean("accepted");

                    quotes.add(new Quote(id, project_id, estimatedAmount, issueDate, validityDate, accepted));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return quotes;
    }
}
