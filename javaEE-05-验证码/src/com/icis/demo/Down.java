package com.icis.demo;

import sun.misc.BASE64Encoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

@WebServlet("/down")
public class Down extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fileName = request.getParameter("fileName");
        ServletContext con = request.getServletContext();

        String mimeType = con.getMimeType(fileName);
        response.setContentType(mimeType);


        //解决获得中文参数的乱码
        //        fileName = new String(fileName.getBytes("ISO8859-1"),"UTF-8");//美女.jpg
        //获得请求头中的User-Agent
        String agent = request.getHeader("User-Agent");
        //根据不同浏览器进行不同的编码
        String fileNameEncoder = "";
        if (agent.contains("MSIE")) {
           // IE浏览器
            fileNameEncoder = URLEncoder.encode(fileName, "utf-8");
            fileNameEncoder = fileNameEncoder.replace("+", " ");
        } else if (agent.contains("Firefox")) {
            // 火狐浏览器
            BASE64Encoder base64Encoder = new BASE64Encoder();
            fileNameEncoder = "=?utf-8?B?" + base64Encoder.encode(fileName.getBytes("utf-8")) + "?=";
        } else {
            // 其它浏览器
            fileNameEncoder = URLEncoder.encode(fileName, "utf-8");
        }

        response.setHeader("content-disposition", "attchment;filename="+ fileNameEncoder + "");

        String realPath = con.getRealPath(fileName);

        File file = new File(realPath);
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
        byte buf[] = new byte[1024];
        int len = 0;
        ServletOutputStream out = response.getOutputStream();
        while((len=bis.read(buf, 0, 1024)) != -1) {
            out.write(buf, 0, len);
        }
        out.flush();
        bis.close();
    }
}
