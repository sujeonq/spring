package com.ch04.controller;

import com.ch04.dto.User5DTO;
import com.ch04.service.User5Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class User5Controller {

    private User5Servicee service;

    @Autowired
    public User5Controller(User5Service service) {
        this.service = service;
    }

    @GetMapping("/user5/register")
    public String register() {
        return "/user5/register";
    }

    @PostMapping("/user5/register")
    public String register(User5DTO dto) {
        System.out.println(dto);

        // 등록
        service.insertuser5(dto);

        // 리다이렉트
        return "redirect:/user5/list";
    }


    @GetMapping("/user5/list")
    public String list(Model model) {

        // 조회
        List<User5DTO> users = service.selectuser5s();
        System.out.println(users);

        // 모델참조(Controller 데이터를 View에서 참조)
        model.addAttribute("users", users);

        return "/user5/list";
    }

    @GetMapping("/user5/modify")
    public String modify(@RequestParam("uid") String uid, Model model) {
        System.out.println("uid : " + uid);

        // 수정 회원 조회
        user5DTO user = service.selectuser5(uid);

        // 모델 참조
        model.addAttribute(user); // 타입명으로 저장(소문자 시작 -> user5DTO)


        return "/user5/modify";
    }

    @PostMapping("/user5/modify")
    public String modify(@ModelAttribute User5DTO dto, Model model) { // ModelAttribute 생략가능
        System.out.println(dto);

        // 수정
        service.updateuser5(dto);

        // 리다이렉트
        return "redirect:/user5/list";
    }

    @GetMapping("/user5/delete")
    public String delete(User5DTO user) {
        System.out.println("uid : " + user.getUid());

        // 삭제
        service.deleteuser5(user.getUid());

        // 리다이렉트
        return "redirect:/user5/list";
    }
}