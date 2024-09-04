package com.ch04.dao;


import com.ch04.dto.user3DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class User3DAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public User3DAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insertuser3(user3DTO dto) {

        String sql = "insert into `user3` values (?,?,?,?,?)";
        Object[] params = {
                dto.getUid(),
                dto.getName(),
                dto.getBirth(),
                dto.getHp(),
                dto.getAge()
        };

        jdbcTemplate.update(sql, params);
    }

    public user3DTO selectuser3(String uid) {
        String sql = "select * from user3 where uid=?";
        user3DTO dto = (user3DTO) jdbcTemplate.queryForObject(sql, new user3RowMapper(), uid);
        return dto;
    }

    public List<user3DTO> selectuser3s() {
        String sql = "select * from user3";
        return jdbcTemplate.query(sql, new user3RowMapper());
    }

    public void updateuser3(user3DTO dto) {
        String sql = "update user3 set name = ?, birth = ?, hp = ?, age = ? where uid = ?";
        Object[] params = {
                dto.getName(),
                dto.getBirth(),
                dto.getHp(),
                dto.getAge(),
                dto.getUid()
        };

        jdbcTemplate.update(sql, params);
    }

    public void deleteuser3(String uid) {
        String sql = "delete from user3 where uid = ?";
        jdbcTemplate.update(sql, uid);

    }
}