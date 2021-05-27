package net.slipp.dao.users;

import org.apache.ibatis.session.SqlSession;

import net.slipp.domain.users.User;

public class MybatisUserDao implements UserDao {

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
