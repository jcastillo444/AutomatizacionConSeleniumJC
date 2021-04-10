package co.com.sofka.data;

import co.com.sofka.log.Log4jData;
import co.com.sofka.pages.MainLogin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class UserDTO {
    private final Connection connection;
    Log4jData log4jData;

    public UserDTO() {
        this.connection = new MySQLConnection("localhost", "3306", "dataUsers",
                "root", "123Pormi").getMySQLConnection();
        log4jData = new Log4jData(MainLogin.class.getSimpleName());

    }

    public Map<Integer, User> getUsers() {

        Map<Integer, User> userMap = new HashMap<>();
        //ResultSet resultSet = connection.createStatement().executeQuery(sqlQuery);
        try {
            String sqlQuery = "Select * From dataUsers";

            ResultSet resultSet = connection.createStatement().executeQuery(sqlQuery);

            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String userName = resultSet.getString("user");
                String password = resultSet.getString("password");
                //String perro="";

                User user = new User(id, userName, password);
                //int num=email.getChars("s");
                //System.out.println("El precio obtenido es: " + num);
               // System.out.println("El dato obtenido es: " + email);

                //perro= esteperro.getEmail();
                userMap.put(id, user);
                //System.out.println("------------------"+perro);

               // System.out.println(Arrays.asList(userMap));

            }
            //System.out.println("El dato obtenidooooooooooooooooo es: " + userMap.get(2).getUserName());
            //String oso = userMap.get(2).getUserName();
            //fillOutTxtEmailCreate(oso);
        } catch (SQLException sqlException) {
            //sqlException.printStackTrace();
            log4jData.getLogger().error(sqlException.getMessage());
        }

        return userMap;
    }
}
