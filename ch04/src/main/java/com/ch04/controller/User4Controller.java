package com.ch04.controller;

import com.ch04.dto.user4DTO;
import com.ch04.service.user4Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class User4Controller {

    private user4Service service;

    @Autowired
    public User4Controller(user4Service service) {
        this.service = service;
    }

    @GetMapping("/user4/register")
    public String register() {
        return "/user4/register";
    }

    @PostMapping("/user4/register")
    public String register(user4DTO dto) {
        System.out.println(dto);

        // 등록
        service.insertuser4(dto);

        // 리다이렉트
        return "redirect:/user4/list";
    }


    @GetMapping("/user4/list")
    public String list(Model model) {

        // 조회
        List<user4DTO> users = service.selectuser4s();
        System.out.println(users);

        // 모델참조(Controller 데이터를 View에서 참조)
        model.addAttribute("users", users);

        return "/user4/list";
    }

    @GetMapping("/user4/modify")
    public String modify(@RequestParam("uid") String uid, Model model) {
        System.out.println("uid : " + uid);

        // 수정 회원 조회
        user4DTO user = service.selectuser4(uid);

        // 모델 참조
        model.addAttribute(user); // 타입명으로 저장(소문자 시작 -> user4DTO)


        return "/user4/modify";
    }

    @PostMapping("/user4/modify")
    public String modify(@ModelAttribute user4DTO dto, Model model) { // ModelAttribute 생략가능
        System.out.println(dto);

        // 수정
        service.updateuser4(dto);

        // 리다이렉트
        return "redirect:/user4/list";
    }

    @GetMapping("/user4/delete")
    public String delete(user4DTO user) {
        System.out.println("uid : " + user.getUid());

        // 삭제
        service.deleteuser4(user.getUid());

        // 리다이렉트
        return "redirect:/user4/list";
    }
}