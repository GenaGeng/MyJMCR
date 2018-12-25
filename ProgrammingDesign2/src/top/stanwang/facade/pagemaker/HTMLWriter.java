package top.stanwang.facade.pagemaker;

import java.io.IOError;
import java.io.IOException;
import java.io.Writer;
import java.security.PublicKey;

public class HTMLWriter {
    private Writer writer;
    public HTMLWriter(Writer writer){
        this.writer= writer;
    }
    public void title(String title) throws IOException{
        writer.write("<html>");
        writer.write("<head>");
        writer.write("<title>"+title+"</title>");
        writer.write("</head>");
        writer.write("<body>\n");
        writer.write("<h1>" + title + "</h1>\n" );
    }

    public void paragraph(String msg) throws IOException{
        writer.write("<p>"+msg+"</p>\n");
    }

    public void link(String href, String caption) throws IOException {
        paragraph("<a href=\""+href+"\">" + caption + "</a>");
    }

    public void mailto(String mainaddr,String username) throws IOException {
        link("mailto:"+mainaddr,username);
    }

    public void close() throws IOException {
        writer.write("</body>");
        writer.write("</html>\n");
        writer.close();
    }
}
