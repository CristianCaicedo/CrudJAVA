package myJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MyJDBC {
    private String urlbase, puerto, dabaBaseName, Url, userName, userPassword;
    /*Conexiones*/
    private Connection connection;
    /*Declaraciones SQL*/
    private Statement statement;
    /*Guardar los resultados de las consultas*/
    private ResultSet resultSet;

    public MyJDBC(String dabaBaseName, String userName, String userPassword) {
        urlbase = "jdbc:mysql://localhost:";
        puerto = "3306";
        this.dabaBaseName = "/" + dabaBaseName;
        Url = urlbase + puerto + this.dabaBaseName;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public boolean ConnectionMyDB() {
        boolean salida = false;
        try {
            connection = DriverManager.getConnection(Url, userName, userPassword);
            statement = connection.createStatement();
            salida = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return salida;
    }

    public boolean CREATE(String myQuery) {
        boolean salida = true;
        try {
            statement.executeUpdate(myQuery);
        } catch (Exception e) {
            e.printStackTrace();
            salida = false;
        }
        return salida;
    }

    public void READ(String myQuery, String[] listaCabeceras, int cantidadCabeceras) {
        if (cantidadCabeceras == 1) {
            try {
                resultSet = statement.executeQuery(myQuery);
                while (resultSet.next()) {
                    System.out.println(resultSet.getString(listaCabeceras[0]));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (cantidadCabeceras == 2) {
            try {
                resultSet = statement.executeQuery(myQuery);
                while (resultSet.next()) {
                    System.out.print(resultSet.getString(listaCabeceras[0] + "\t"));
                    System.out.println(resultSet.getString(listaCabeceras[1]));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
            else if (cantidadCabeceras==3){
                try {
                    resultSet = statement.executeQuery(myQuery);
                    while (resultSet.next()) {
                        System.out.print(resultSet.getString(listaCabeceras[0] + "\t"));
                        System.out.print(resultSet.getString(listaCabeceras[1] + "\t"));
                        System.out.println(resultSet.getString(listaCabeceras[2]));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        else if (cantidadCabeceras==4){
            try {
                resultSet = statement.executeQuery(myQuery);
                while (resultSet.next()) {
                    System.out.print(resultSet.getString(listaCabeceras[0] + "\t"));
                    System.out.print(resultSet.getString(listaCabeceras[1] + "\t"));
                    System.out.print(resultSet.getString(listaCabeceras[2] + "\t"));
                    System.out.println(resultSet.getString(listaCabeceras[3]));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        }
        public boolean UPDATE(String myQuery){
            return CREATE(myQuery);
        }

    public boolean DELETE(String myQuery){
        return CREATE(myQuery);
    }
    }

