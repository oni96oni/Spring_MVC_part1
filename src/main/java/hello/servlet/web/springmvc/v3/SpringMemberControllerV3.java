package hello.servlet.web.springmvc.v3;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

//    @RequestMapping(value="/new-form", method = RequestMethod.GET)
    @GetMapping("/new-form")
    public String newForm() {
        return"new-form";
    }

//    @RequestMapping(method = RequestMethod.POST)
    @PostMapping("/save")
    public String save(
            @RequestParam("username") String username,
            @RequestParam("age") int age,
            Model model) {
        Member member = new Member(username, age);
        memberRepository.save(member);

//        ModelAndView mv = new ModelAndView("members");
//        mv.getModel().put("members", members);
//        mv.addObject("members", members);
        model.addAttribute("member", member);
        return "save-result";
    }

//    @RequestMapping(value = "/save" , method = RequestMethod.GET)
    @GetMapping
    public String members(Model model) {
//        String username = request.getParameter("username");
//        int age = Integer.parseInt(request.getParameter("age"));

        List<Member> members = memberRepository.findAll();
        model.addAttribute("members", members);
        return "members";


//        ModelAndView mv = new ModelAndView("save-result");
//        mv.getModel().put("member", member); 아래코드와 동일
//        mv.addObject("member", member);

    }
}
