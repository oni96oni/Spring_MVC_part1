package hello.servlet.web.frontcontroller.v2.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v2.ControllerV2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberSaveControllerV2 implements ControllerV2 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    // 뷰로 던지기
    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 요청 정보를 받아와서
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        // 비즈니스 로직을 실행
        Member member = new Member(username, age);
        memberRepository.save(member);

        // Model에 데이터를 보관해야한다. 이 밑에 jsp뷰가 나와야 하기 때문에
        request.setAttribute("member", member);

        return new MyView("/WEB-INF/views/save-result.jsp");
    }

}
