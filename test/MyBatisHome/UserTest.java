/**
 * 
 */
package MyBatisHome;

import java.util.List;

import me.karthy.dao.UserDAO;
import me.karthy.model.User;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author KXS8055
 * 
 */
public class UserTest {

	static UserDAO userdao = null;

	@BeforeClass
	public static void setup() {
		userdao = new UserDAO();
	}

	@AfterClass
	public static void teardown() {
		userdao = null;
	}

	@Test
	public void testGetUserById() {
		User user = userdao.getUserById(1);
		Assert.assertNotNull(user);
		System.out.println(user);
	}

	@Test
	public void testGetAllUsers() {
		List<User> users = userdao.getAllUsers();
		Assert.assertNotNull(users);
		for (User user : users) {
			System.out.println(user);
		}

	}

	@Test
	public void testInsertUser() {
		User user = new User();
		user.setEmailId("email_" + System.currentTimeMillis() + "@mail.com");
		user.setPassword("password");
		user.setFirstName("TestFirstName");
		user.setLastName("TestLastName");

		userdao.insertUser(user);
		Assert.assertTrue(user.getUserId() != 0);
		User createdUser = userdao.getUserById(user.getUserId());
		Assert.assertNotNull(createdUser);
		Assert.assertEquals(user.getEmailId(), createdUser.getEmailId());
		Assert.assertEquals(user.getPassword(), createdUser.getPassword());
		Assert.assertEquals(user.getFirstName(), createdUser.getFirstName());
		Assert.assertEquals(user.getLastName(), createdUser.getLastName());

	}

	@Test
	public void testUpdateUser() {
		long timestamp = System.currentTimeMillis();
		User user = userdao.getUserById(2);
		user.setFirstName("TestFirstName" + timestamp);
		user.setLastName("TestLastName" + timestamp);
		userdao.updateUser(user);
		User updatedUser = userdao.getUserById(2);
		Assert.assertEquals(user.getFirstName(), updatedUser.getFirstName());
		Assert.assertEquals(user.getLastName(), updatedUser.getLastName());
	}

	@Test
	public void testDeleteUser() {
		User user = userdao.getUserById(4);
		userdao.deleteUser(user.getUserId());
		User deletedUser = userdao.getUserById(4);
		Assert.assertNull(deletedUser);

	}

}
