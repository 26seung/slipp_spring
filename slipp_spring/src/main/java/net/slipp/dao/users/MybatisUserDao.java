package net.slipp.dao.users;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import net.slipp.domain.users.User;

@Repository("userDao")
public class MybatisUserDao implements UserDao {

	
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public User findById(String userId) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("UserMapper.findById", userId);
	}

	@Override
	public void create(User user) {
		// TODO Auto-generated method stub
		sqlSession.insert("UserMapper.create", user);
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		sqlSession.update("UserMapper.update", user);
	}

}
