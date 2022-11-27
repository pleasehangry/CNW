package Model.DAO;

public class DatabaseConfig {
	public static String host = "localhost:3306";
	public static String name = "library";
	public static String username = "roor";
	public static String password = "";
	
	public static String getConnectionString() {
		return "jdbc:mysql//" + host + "/" + name + "?useSS=false";
	}
}
