package com.example.SpringJDBCDemo.repository;

import com.example.SpringJDBCDemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepo {
    private JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }

    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public void save(User user){
        String sql="insert into users (id,name,tech) values (?,?,?)";
        int rows=template.update(sql,user.getId(),user.getName(),user.getTech());
        System.out.println(rows+" row(s) are affected");
    }

    public List<User> findAll(){
        String sql="select * from users";

        RowMapper<User> mapper=new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User u=new User();
                u.setId(rs.getInt(1));
                u.setName(rs.getString(2));
                u.setTech(rs.getString(3));
                return u;
            }
        };

        List<User> us=template.query(sql,mapper);
        return us;
    }
}
