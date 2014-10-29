/**
 * 
 */
package me.karthy.mappers;

import java.util.List;

import me.karthy.model.User;

/**
 * 
 * @author KXS8055
 *
 */
public interface UserMapper {

	public void insertUser(User user);

	public User getUserById(Integer userId);

	public List<User> getAllUsers();

	public void updateUser(User user);

	public void deleteUser(Integer userId);

}