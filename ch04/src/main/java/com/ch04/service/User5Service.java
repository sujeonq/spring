package com.ch04.service;

import com.ch04.dao.User5DAO;
import com.ch04.dto.User5DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class User5Service {

    private User5DAO dao;

    @Autowired
    public User5Service(User5DAO dao) {
        this.dao = dao;
    }

    public void insertuser5(User5DTO dto) {
        dao.insertuser5(dto);
    }

    public User5DTO selectuser5(String uid) {
        return dao.selectuser5(uid);
    }

    public List<User5DTO> selectuser5s() {
        return dao.selectuser5s();
    }

    public void updateuser5(User5DTO dto) {
        dao.updateuser5(dto);
    }

    public void deleteuser5(String uid) {
        dao.deleteuser5(uid);
    }

}