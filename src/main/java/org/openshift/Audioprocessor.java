package org.openshift;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.util.Random;

import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class Audioprocessor {
    
        public Connection getConnection(){
            try{
                    String databaseURL = "jdbc:postgresql://";
                    databaseURL += System.getenv("POSTGRESQL_SERVICE_HOST");
                    databaseURL += "/" + System.getenv("POSTGRESQL_DATABASE");
                    String username = System.getenv("POSTGRESQL_USER");
                    String password = System.getenv("PGPASSWORD");
                    Connection connection = DriverManager.getConnection(databaseURL, username,
                    password);
                    return connection;
            }
            catch(Exception e){e.printStackTrace();
            return null;
            }
        }
        
	public String getData() {
	
                Connection connection=null;
                try{
                    connection = getConnection();
                    if (connection != null) {
			//return "tlukt!!!";
                        String res = "tmacheert";
                        //res=connection.toString();
                        
                        
                        String SQL = "select sample from audiosamples";
                        Statement stmt = connection.createStatement();
                        stmt.setMaxRows(100);
    
                        ResultSet rs = stmt.executeQuery(SQL);
                        res= rs.toString();
                        //return res;
                        while (rs.next()) {
                            res += "<br>"+rs.getString("sample");
                        }
                        return res;
                        //theInsult = String.format("Thou art %s %s %s %s!", article,
                        //rs.getString("first"), rs.getString("second"), rs.getString("noun"));
                    }
                    connection.close();
                }
                catch(Exception e){
                    return "Database connection error!!";
                }
                    //rs.close();
                return null;
                
        }
        public String getDPData() throws IOException, PropertyVetoException{
            String res="";
            DataSource ds=null;
            Connection connection = null;
            Statement statement = null;
            ResultSet rs = null;
            try {
                res = "tmacheert";
                ds = DataSource.getInstance();
                connection= ds.getConnection();
                res += "<br>"+ connection.toString();
                String SQL ="select sample from audiosamples";
                PreparedStatement st= connection.prepareStatement(SQL);
                st.setMaxRows(100);
                rs=st.executeQuery();
                res= rs.toString();
                while (rs.next()) {
                    res += "<br>"+rs.getString("sample");
                }
                return res;
            } catch (SQLException e) {
                e.printStackTrace();
                res = "db connection error";
            } finally {
                if (rs != null) try { rs.close(); } catch (SQLException e) {e.printStackTrace();}
                if (statement != null) try { statement.close(); } catch (SQLException e) {e.printStackTrace();}
                if (connection != null) try { connection.close(); } catch (SQLException e) {e.printStackTrace();}
            }
            return res;
        }

}
