package hello.servlet.web.frontcontroller.v1.controller;

import hello.servlet.web.frontcontroller.v1.ControllerV1;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberFormControllerV1 implements ControllerV1 {

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String viewPath = "/WEB-INF/views/new-form.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath); // 컨트롤러에서 뷰로 이동할때 사용하는 메서드
        dispatcher.forward(request, response); // 서블릿에서 jsp를 호출할때 사용, 다시 클라이언트에 응답이 갔다 다시 요청이오는 리다이렉트가 아니라 서버 내부에서 다시 호출이 발생한다.
    }

}
