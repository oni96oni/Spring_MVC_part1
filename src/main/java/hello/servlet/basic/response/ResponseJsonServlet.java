package hello.servlet.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ResponseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Content-Type: application/json
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        HelloData helloData = new HelloData();
        helloData.setUsername("cha");
        helloData.setAge(27);

        // JSON형식으로 바꾸어주어야해
        // {"username":"cha","age":27} 이런식으로!! ObjectMapper가 필요하다.

        String result = objectMapper.writeValueAsString(helloData);
        response.getWriter().write(result);

        // 이런 과정을 json을 뿌린다고 한다. 나중에 스프링 mvc를 쓰면 코드가 대폭으로 감소한다.
    }
}
