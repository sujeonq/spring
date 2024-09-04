package com.ch04.dao;


import com.ch04.dto.user5DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class User5DAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public User5DAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insertuser5(user5DTO dto) {

        String sql = "insert into `user5` values (?,?,?,?,?)";
        Object[] params = {
                dto.getUid(),
                dto.getName(),
                dto.getBirth(),
                dto.getHp(),
                dto.getAge()
        };

        jdbcTemplate.update(sql, params);
    }

    public user5DTO selectuser5(String uid) {
        String sql = "select * from user5 where uid=?";
        user5DTO dto = (user5DTO) jdbcTemplate.queryForObject(sql, new user5RowMapper(), uid);
        return dto;
    }

    public List<user5DTO> selectuser5s() {
        String sql = "select * from user5";
        return jdbcTemplate.query(sql, new user5RowMapper());
    }

    public void updateuser5(user5DTO dto) {
        String sql = "update user5 set name = ?, birth = ?, hp = ?, age = ? where uid = ?";
        Object[] params = {
                dto.getName(),
                dto.getBirth(),
                dto.getHp(),
                dto.getAge(),
                dto.getUid()
        };

        jdbcTemplate.update(sql, params);
    }

    public void deleteuser5(String uid) {
        String sql = "delete from user5 where uid = ?";
        jdbcTemplate.update(sql, uid);

    }
}