package regi.core.util;

public record SqlConnector(String url, String username, String password) {
    public static SqlConnector getSqlConnector() {
        return new SqlConnector("jdbc:mysql://localhost:3306/humanfriends", "root", "31245");
        // Можно добавить дополнительную запись .property со свойствами подключения.
    }

}
