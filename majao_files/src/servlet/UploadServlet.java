package servlet;

import com.sun.nio.zipfs.ZipPath;

import javax.naming.ldap.PagedResultsControl;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

@WebServlet("/upload_servlet")
@MultipartConfig
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");

        Part part = request.getPart("majiao_file");
        String disposition = part.getHeader("Content-Disposition");
        System.out.printf("part:[%s]\n", part.toString());
        System.out.printf("disp:[%s]\n", disposition);
        PrintWriter out = response.getWriter();
        out.printf("disp:[%s]\n<br/>", disposition);


        InputStream in = part.getInputStream();
        Date date = new Date();
        String file_name = part.getSubmittedFileName();
        Path path = Paths.get("D:/ubuntu", new String(file_name.getBytes("gbk"), "utf-8"));

        System.out.printf("写入文件:[%s]\n", path);
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path.toString()));
        try {
            byte buf[] = new byte[1024];
            int len = -1;
            while((len=in.read(buf, 0, 1024)) != -1) {
                bos.write(buf, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bos.close();
            in.close();
        }
        out.printf("<br/>写入文件:[<font color='red'>%s</font>]\n<br/>", path.toString());
        in.close();
        System.out.printf("%s", "写入完成");
    }
}
