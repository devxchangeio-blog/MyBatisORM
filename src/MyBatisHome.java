import java.util.List;

import me.karthy.dao.UserDAO;
import me.karthy.model.User;

/**
 * 
 */

/**
 * @author KXS8055
 *
 */
public class MyBatisHome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		UserDAO dao = new UserDAO();
		List<User> userList = dao.getAllUsers();
		// User user = dao.getUserById(100);
		System.out.println(userList.get(0).getFirstName());

	}

}
