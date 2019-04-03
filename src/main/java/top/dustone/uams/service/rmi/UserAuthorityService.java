package top.dustone.uams.service.rmi;

import top.dustone.uams.pojo.User;
import top.dustone.uams.util.SimpleMenuInfo;

import java.util.List;

public interface UserAuthorityService {
	public User userAuth(User user,String targetRoleName);
	public List<SimpleMenuInfo> getMenuTreeByRoleId(int roleId);
}
