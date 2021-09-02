package sample;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class DBConnection {
    private final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private final String db_version = "orcl";
    private final String URL = "jdbc:oracle:thin:@//localhost:1521/"+db_version;
    /**
     * Credentials Container for storing
     * the username and the password
     * to access the Local Database Server.
     */
    private final Map<String, String> credentials = new HashMap<>();

    /**
     * Used for executing all queries
     * to be sent to the Local Database
     */
    private Statement statement;
    /**
     * USed for connecting and preparing
     * Statements to be sent to the
     * Local Database Server
     */
    private Connection connection;
    /**
     * Used to store results from executed queries statements.
     */
    private ResultSet resultSet;

    /**
     * Default Constructor of DbConnection class.
     * It initialize implicitly the Database Connectivity
     * with default credentials of DBA User.
     * ::NB:: We are using ORACLE Database.
     */
    public DBConnection() {
        //Initializing default credentials to access the database
        credentials.put( "username", "yasser" );
        credentials.put( "password", "123" );
        init();
    }

    /**
     * Parameterized Constructor of DbConnection class.
     * It initialize implicitly the Database Connectivity.
     * ::NB:: We are using ORACLE Database.
     *
     * @param username Database username for root user
     * @param password Database password for root user
     */
    public DBConnection (String username, String password) {
        //Initializing user credentials for accessing the DB.
        credentials.put( "username", username );
        credentials.put( "password", password );
        init();
    }

    /**
     * Private Method that initialize and configure
     * the Oracle Database Connectivity
     * using some private variables like
     * ************** @driver
     * ************** @url
     * ************** @credentials
     */
    private void init() {
        boolean flag = true;
        try {
            //Initialize @DRIVER
            Class.forName( DRIVER );
            //Initialize Database Connection
            connection = DriverManager.getConnection( URL,
                    credentials.get( "username" ), credentials.get( "password" ) );
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
            System.err.println( throwables.getMessage() );
            flag = false;
        }
        if (flag) {
            System.out.println( "####################################" );
            System.out.println( "\t\t@GOOD TO GO :)" );
            System.out.println( "####################################" );
        }
    }


    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        resultSet.close();
        statement.close();
        connection.close();
        credentials.clear();
    }

/*    public static void main(String[] args) {
        // write your code here
//        DbConnection connection = new DbConnection( "yasser", "123" );
        DBConnection connection  = new DBConnection();
        System.out.println("connected");

        }
*/





}

