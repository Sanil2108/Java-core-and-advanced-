import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class Networking7 {
    static ArrayList<URL> allUrls;

    public static int exists(char[] src, String toFind){
        char[] srcArr=src;
        char[] toFindArr=toFind.toCharArray();

        for(int i=0;i<srcArr.length-toFind.length()+1;i++){
            boolean found=true;
            for(int j=0;j<toFindArr.length;j++){
                if(toFindArr[j] != srcArr[i+j]){
                    found=false;
                }
            }
            if(found){
                return i;
            }
        }
        return -1;
    }

    public static int exists(String src, String toFind){
        char[] srcArr=src.toCharArray();
        char[] toFindArr=toFind.toCharArray();

        for(int i=0;i<srcArr.length-toFind.length()+1;i++){
            boolean found=true;
            for(int j=0;j<toFindArr.length;j++){
                if(toFindArr[j] != srcArr[i+j]){
                    found=false;
                }
            }
            if(found){
                return i;
            }
        }
        return -1;
    }

    public static String getLink(int i, char[] tempArr){
        int linkLength=0;
        int i2=i;
        while(tempArr[i2]!='\''){
            linkLength++;
            i2++;
        }
        char[] link=new char[linkLength];
        for(int i3=0;i3<linkLength;i3++){
            link[i3]=tempArr[i+i3];
        }

        return new String(link);
    }

    public static ArrayList<URL> getLinks(URL relative, URL url){
        ArrayList<URL> arrayList=new ArrayList<>();

        try{
            BufferedReader in=new BufferedReader(new InputStreamReader(url.openStream()));
            String temp;
            String toFind="<a";
            while((temp = in.readLine()) != null) {
                int i;
                if((i = exists(temp, toFind))!=-1){
                    char[] tempArr=temp.toCharArray();
                    i=exists(tempArr, "href=\'")+("href=\'").length();

                    String link=getLink(i, tempArr);
//                    System.out.println(link);
                    arrayList.add(new URL(relative, link));

                }
            }
        }catch (Exception e){

        }

        return arrayList;
    }

    static final int MAX_LEVEL=3;

    public static void crawl(URLConnection conn, int level) throws Exception{
        ArrayList<URL> urls=getLinks(conn.getURL(), conn.getURL());
        for(int i=0;i<urls.size();i++){


            for(int j=0;j<level-1;j++){
                System.out.print("\t");
            }
            System.out.print(urls.get(i));
            System.out.println();


            if(level<MAX_LEVEL){
                crawl(urls.get(i).openConnection(), ++level);
            }
        }

    }

    public static void main(String[] args) throws Exception{
        if(args.length<1) {
            System.out.println("please enter a website");
            return;
        }
        allUrls=new ArrayList<>();
        URL myUrl = new URI(args[0]).toURL();
        URLConnection conn=myUrl.openConnection();
        crawl(conn, 0);
    }
}
