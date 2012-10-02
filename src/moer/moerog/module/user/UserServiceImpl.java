package moer.moerog.module.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired private UserRepository userRepository;
	
	@Override
	public User adminLogin(User user) {
		User tempUser = userRepository.findByUserId(user.getUserId());
		
		if (tempUser.getPassword().equals(user.getPassword())) {
			user = tempUser;
			user.setAdmin(true);
			user.setLogin(true);
			return user;
		}
		
		return null;
	}
	
	@Override
	public User login(User user) {
		User tempUser = userRepository.findByUserId(user.getUserId());
		
		if (tempUser.getId().equals(user.getId()) && tempUser.getPassword().equals(user.getPassword())) {
			user = tempUser;
			user.setLogin(true);
			return user;
		}
		
		return null;
	}
	
	@Override
	public void register(User user) {
		userRepository.save(user);
	}
	
}
