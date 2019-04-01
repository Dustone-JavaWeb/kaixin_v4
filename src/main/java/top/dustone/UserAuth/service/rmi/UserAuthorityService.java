package top.dustone.UserAuth.service.rmi;

import top.dustone.UserAuth.pojo.User;
import top.dustone.UserAuth.util.SimpleMenuInfo;

import java.util.List;

public interface UserAuthorityService {
	public User userAuth(User user,String targetRoleName);
	public List<SimpleMenuInfo> getMenuTreeByRoleId(int roleId);
}
