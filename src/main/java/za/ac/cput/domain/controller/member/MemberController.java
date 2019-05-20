package za.ac.cput.domain.controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.domain.domain.member.Member;
import za.ac.cput.domain.services.member.impl.MemberServiceImpl;

@RestController
@RequestMapping("/domain/controller/member")
public class MemberController {
    @Autowired
    private MemberServiceImpl service;

    @GetMapping("/create/")
    @ResponseBody
    public Member create(Member member){
        return service.create(member);
    }

    @GetMapping("/read/")
    @ResponseBody
    public Member read(Member member){
        return service.read(member);
    }

    @GetMapping("/update/")
    @ResponseBody
    public Member update(Member member){
        return service.update(member);
    }

    @GetMapping("/delete/")
    @ResponseBody
    public void delete(String id){
        service.delete(id);
    }
}
