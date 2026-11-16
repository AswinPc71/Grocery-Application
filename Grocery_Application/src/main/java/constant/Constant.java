package constant;

public class Constant {
	
	public static final String CONFIGFILE = System.getProperty("user.dir")+"\\src\\main\\resources\\Config.property";
	public static final String TESTDATA = System.getProperty("user.dir")+"\\src\\test\\resources\\grocerytest.xlsx";
	public static final String VALIDCREDENTIALERROR = "User is unable to login with valid credentials";
	public static final String VALIDANDINVALIDERROR = "User is able to login with correct username and incorrect password";
	public static final String INVALIDANDVALIDERROR = "User is able to login with incorrect username and correct password";
	public static final String INVALIDCREDENTIALERROR = "User is able to login with invalid creedentials";
	public static final String LOGOUTERROR = "User is unable to logout";
	public static final String CATEGORYCREATIONERROR = "User was not able to create new Category";
	public static final String CATEGORYSEARCHERROR = "User was not able to find the category";
	public static final String ADMINUSERCREATIONERROR = "User is unable to create new user admin";
	public static final String ADMINUSESEARCHERROR = "Searched User Information Not Found";
	public static final String DELIVERYBOYCREATIONERROR = "User was unable to add new delivery boy details";
}