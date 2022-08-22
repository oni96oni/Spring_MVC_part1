package hello.servlet.web.springmvc.old;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component("/springmvc/old-controller") // 이 스프링 빈의 이름을 지정해주는것! 없으면은 자연스럽게 OldController로 지정됨.
public class OldController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("OldController.handleRequest");
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("old");
//        mv.addObject("message", "Hello World");
//        return mv;
        return new ModelAndView("new-form");
    }

}
