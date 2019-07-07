package com.example.zdemo.Wg;

import com.example.zdemo.utils.HttpStreamUtil;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WController {

  @GetMapping("/jack/j.asp")
  public String test(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String a = "";

    String t = request.getParameter("t");
    System.out.println(t);
    String url = "http://103.123.162.118/jack/j.asp?act=login&l=f&maccode=22fcaa03bd2b26040f9b9e231309076e&card=HRY022334FC6EC772CB8760&t=101079&ver=2019031301";
    a = HttpStreamUtil.get(url,null);
    System.out.println(a);

    response.addHeader("Cache-Control","private");
    response.addHeader("Content-Encoding","gzip");
    response.addHeader("Content-Length","150");
    response.addHeader("Content-Type","text/html");
    response.addHeader("Server","Microsoft-IIS/8.5");
    response.addHeader("Vary","Accept-Encoding");
    response.addHeader("X-Powered-By","ASP.NET");

    return a;
  }
}
