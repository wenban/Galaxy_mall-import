package tool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class testMethod {
	public static void pickUp() {
		String html = "<p>An <a href='http://www.jb51.net/'><b>www.jb51.net</b></a> link.</p>";
		Document doc = Jsoup.parse(html);//解析HTML字符串返回一个Document实现
		Element link = doc.select("a").first();//查找第一个a元素
		String text = doc.body().text(); // "An www.jb51.net link"//取得字符串中的文本
		String linkHref = link.attr("href"); // "http://www.jb51.net/"//取得链接地址
		String linkText = link.text(); // "www.jb51.net""//取得链接地址中的文本
		String linkOuterH = link.outerHtml();// "<a href="http://www.jb51.net"><b>www.jb51.net</b></a>"
		String linkInnerH = link.html(); // "<b>www.jb51.net</b>"//取得链接内的html内容
	}
	
	private static List<String> titles;
	private static List<String> imgs;
	private static List<String> descriptions;
	
	
	private static void inserDB() {
		try {
			// SELECT FORM DB
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demo1?user=root&password=");
			
			String sql = "insert into bbs_topic (TITLE,DESCRIPTION,CATEGORY_ID,AUTHOR_ID,IMAGES_PATH,CREATE_TIME,UPDATE_TIME) values (?,?,?,?,?,now(),now())";
			PreparedStatement smt = conn.prepareStatement(sql);
			int rs = 0;
			for(int i=0;i<titles.size();i++){
			smt.setString(1, titles.get(i));
			smt.setString(2, descriptions.get(i));
			if ((i<65)) {
				smt.setInt(3, 19);
			} else if (i<121) {
				smt.setInt(3, 20);
			} else {
				smt.setInt(3, 22);
			}
			int userId=(int)(Math.random()*10);
			while(userId==0) {
				userId=(int)(Math.random()*10);
			}
			smt.setInt(4,userId);
			smt.setString(5, imgs.get(i));						
			rs = smt.executeUpdate();
			}
			
			 smt.close();
			 conn.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	
	
	
	
	private static void getValues() throws ClientProtocolException, IOException {
		titles=new ArrayList<String>();
		descriptions=new ArrayList<String>();
		imgs=new ArrayList<String>();
		int i=0;
		for (String href : analyzeHTML()) {
			i++;
			if (i>65) {
				return;
			}
			String html =httpClientDemo(href);
			Document doc = Jsoup.parse(html);
			Element titlelink = doc.select("#artibodyTitle").first();
			if (titlelink!=null) {
				String title = titlelink.text(); 
				System.out.println(title);
				titles.add(title);
			}
			Element descriptionlink = doc.select("#artibody").first();
			if (descriptionlink!=null) {
				String description = descriptionlink.html();; 
				Element imglink = doc.select(".img_wrapper img").first();
				if (imglink!=null) {
					String img=imglink.attr("src");
					imgs.add(img);
				}
				descriptions.add(description);
			}			
		}
	}
		
	
	
	
	
	
	
	private static List<String> analyzeHTML() throws ClientProtocolException, IOException {
		String html =httpClientDemo("http://sports.sina.com.cn/");
		Document doc = Jsoup.parse(html);//解析HTML字符串返回一个Document实现
		List<Element> links = doc.select(".list01 a");//查找第一个a元素
		List<String>  hrefs = new ArrayList<String>();
		for (Element element : links) {
			String linkHref = element.attr("href"); // "http://www.jb51.net/"//取得链接地址
			hrefs.add(linkHref);
		}
		return hrefs;
	}
	
	

	private static String httpClientDemo(String url) throws ClientProtocolException, IOException {
	      HttpClient httpclient = new DefaultHttpClient();  
	      HttpGet httpgets = new HttpGet(url);  
	      HttpResponse state=httpclient.execute(httpgets);
	      HttpEntity entity = state.getEntity();    
	      if (entity != null) {    
	            InputStream instreams = entity.getContent();    
	            String str = convertStreamToString(instreams); 
	            httpgets.abort();
	            return str;
	      }  
	      return null;
	}
	
	public static String convertStreamToString(InputStream is) {      
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));      
        StringBuilder sb = new StringBuilder();      
       
        String line = null;      
        try {      
            while ((line = reader.readLine()) != null) {  
                sb.append(line + "\n");      
            }      
        } catch (IOException e) {      
            e.printStackTrace();      
        } finally {      
            try {      
                is.close();      
            } catch (IOException e) {      
               e.printStackTrace();      
            }      
        }      
        return sb.toString();      
    }  
}
