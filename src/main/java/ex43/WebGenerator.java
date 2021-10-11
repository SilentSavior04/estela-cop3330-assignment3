package ex43;

import java.io.*;
import java.util.Scanner;

import static java.lang.System.*;

public class WebGenerator {
    public static void main(String[] args)
    {
        Scanner SC = new Scanner(in);
        String author, siteName;
        char js;
        char css;
        out.print("Author Name: ");
        siteName = SC.nextLine();
        out.print("Website Title: ");
        author = SC.nextLine();
        out.print("Would you like a folder for JavaScript? ");
        js = SC.next().charAt(0);
        out.print("Would you like a folder for CSS? ");
        css = SC.next().charAt(0);
        String currentPath;
        currentPath = getProperty("user.dir");
        currentPath += "\\"+siteName;
        File website = new File(currentPath);
        boolean websiteCreated = website.mkdir();
        if(websiteCreated)
        {
            out.println("Created " + currentPath);
            try {
                try (FileWriter skeletonWriter = new FileWriter(currentPath + "\\index.html")) {
                    skeletonWriter.write("<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n");
                    skeletonWriter.write("\t<meta author=\"" + author + "\">\n");
                    skeletonWriter.write("\t<title>" + siteName + "</title>\n");
                    skeletonWriter.write("</head>\n<body>\n\n</body>\n</html>");
                    skeletonWriter.close();
                }
                out.println("Created " + currentPath+"\\index.html");
                if(js == 'y' || js == 'Y')
                {
                    File jsFolder = new File(currentPath+"\\js");
                    boolean jsCreated = jsFolder.mkdir();
                    if(jsCreated)
                    {
                        out.println("Created " + jsFolder+"\\");
                    }
                    else
                    {
                        out.println("Js folder not created!!");
                    }
                }
                if(css == 'y' || css == 'Y') {
                    File cssFolder = new File(currentPath+"\\css");
                    boolean cssCreated = cssFolder.mkdir();
                    if(cssCreated) {
                        out.println("Created " + cssFolder+"\\");
                    }
                    else out.println("CSS folder not created!!");
                }
            }
            catch(IOException e) {
                out.println("index.html not created as required!!");
            }
        }
        else out.println("Website folder not created!!");
        SC.close();
    }
}

