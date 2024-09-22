package models;

import java.sql.*;

public class DbSeeder {

    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;

        DbConfig dbConfig = DbConfig.getInstance();
        try {
            connection = dbConfig.getConnection();
            statement = connection.createStatement();

            String createClientsTable = "CREATE TABLE IF NOT EXISTS clients (" +
                    "id SERIAL PRIMARY KEY, " +
                    "name VARCHAR(255) NOT NULL, " +
                    "address VARCHAR(255) NOT NULL, " +
                    "phone VARCHAR(20) NOT NULL, " +
                    "isProfessional BOOLEAN NOT NULL" +
                    ")";

            String createProjectsTable = "CREATE TABLE IF NOT EXISTS projects (" +
                    "id SERIAL PRIMARY KEY, " +
                    "client_id INTEGER NOT NULL, " +
                    "FOREIGN KEY (client_id) REFERENCES clients(id), " +
                    "name VARCHAR(255) NOT NULL, " +
                    "profitMargin DOUBLE PRECISION, " +
                    "totalCost DOUBLE PRECISION, " +
                    "status VARCHAR(50) CHECK (status IN ('PENDING', 'IN_PROGRESS', 'COMPLETED', 'CANCELED')), " +
                    "surface DOUBLE PRECISION, " +
                    "vatRate DOUBLE PRECISION" +
                    ")";

            String createQuotesTable = "CREATE TABLE IF NOT EXISTS quotes (" +
                    "id SERIAL PRIMARY KEY, " +
                    "project_id INTEGER NOT NULL, " +
                    "FOREIGN KEY (project_id) REFERENCES projects(id), " +
                    "estimatedAmount DOUBLE PRECISION NOT NULL, " +
                    "issueDate DATE NOT NULL, " +
                    "validityDate DATE NOT NULL, " +
                    "accepted BOOLEAN NOT NULL" +
                    ")";

            String createComponentsTable = "CREATE TABLE IF NOT EXISTS components (" +
                    "id SERIAL PRIMARY KEY, " +
                    "project_id INTEGER NOT NULL, " +
                    "FOREIGN KEY (project_id) REFERENCES projects(id), " +
                    "name VARCHAR(255) NOT NULL, " +
                    "quantity DOUBLE PRECISION NOT NULL, " +
                    "componentType VARCHAR(100)" +
                    ")";

            String createMaterialsTable = "CREATE TABLE IF NOT EXISTS materials (" +
                    "unitCost DOUBLE PRECISION NOT NULL, " +
                    "transportCost DOUBLE PRECISION NOT NULL, " +
                    "qualityCoefficient DOUBLE PRECISION NOT NULL" +
                    ") INHERITS (components)";

            String createLaborsTable = "CREATE TABLE IF NOT EXISTS labors (" +
                    "hourlyRate DOUBLE PRECISION NOT NULL, " +
                    "workHours DOUBLE PRECISION NOT NULL, " +
                    "workerProductivity DOUBLE PRECISION NOT NULL" +
                    ") INHERITS (components)";

            statement.execute(createClientsTable);
            statement.execute(createProjectsTable);
            statement.execute(createQuotesTable);
            statement.execute(createComponentsTable);
            statement.execute(createMaterialsTable);
            statement.execute(createLaborsTable);

            System.out.println("Database seeded successfully.");
        } catch (SQLException e) {
            System.err.println("Error during database seeding: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
