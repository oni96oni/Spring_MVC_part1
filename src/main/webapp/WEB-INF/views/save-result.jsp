<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
</head>
<body>
성공
<ul>
  <%-- <li>id=<%=((Member)request.getAttribute("member")).getId()%></li>
  <li>username=<%=((Member)request.getAttribute("member")).getUsername()%></li>
  <li>age=<%=((Member)request.getAttribute("member")).getAge()%></li>
  이렇게도 사용하지만 캐스팅 포함 너무 많은 코드가 들어가 있다. 이럴떄는
  --%>

  <li>id=${member.id}</li>
  <li>username=${member.username}</li>
  <li>age=${member.age}</li>
  <%-- 이렇게 하면 조회할때는 get, 값을 넣으면 set이 호출이 된다. getProperty접근법이라고 한다. --%>
</ul>
<a href="/index.html">메인</a>
</body>
</html>