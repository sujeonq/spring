package com.ch04.dao;


import com.ch04.dto.user4DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class User4DAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public User4DAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insertuser4(user4DTO dto) {

        String sql = "insert into `user4` values (?,?,?,?,?)";
        Object[] params = {
                dto.getUid(),
                dto.getName(),
                dto.getBirth(),
                dto.getHp(),
                dto.getAge()
        };

        jdbcTemplate.update(sql, params);
    }

    public user4DTO selectuser4(String uid) {
        String sql = "select * from user4 where uid=?";
        user4DTO dto = (user4DTO) jdbcTemplate.queryForObject(sql, new user4RowMapper(), uid);
        return dto;
    }

    public List<user4DTO> selectuser4s() {
        String sql = "select * from user4";
        return jdbcTemplate.query(sql, new user4RowMapper());
    }

    public void updateuser4(user4DTO dto) {
        String sql = "update user4 set name = ?, birth = ?, hp = ?, age = ? where uid = ?";
        Object[] params = {
                dto.getName(),
                dto.getBirth(),
                dto.getHp(),
                dto.getAge(),
                dto.getUid()
        };

        jdbcTemplate.update(sql, params);
    }

    public void deleteuser4(String uid) {
        String sql = "delete from user4 where uid = ?";
        jdbcTemplate.update(sql, uid);

    }
}