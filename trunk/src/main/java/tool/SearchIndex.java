package tool;

import java.io.File;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Fieldable;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.SortField;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.SimpleFragmenter;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

public class SearchIndex {
	private static String INDEX_DIR = "G:\\index";// 索引所在的路径
	private static String KEYWORD = "wsyy is wsyyy";// 关键词
	private static int TOP_NUM = 10;// 显示前10条结果
	private static File indexDir = new File(INDEX_DIR);
    public static void main(String[] args) throws Exception {
    	
		List<Lucene> list2 = search( KEYWORD);		//在索引目录下查询KRYEORD
	}
    /**
     * 查找方法
     * @param indexDir
     * @param q
     * @throws Exception
     */
    public static List<Lucene> search( String q) throws Exception {
    	List<Lucene> list = new ArrayList<Lucene>();
		Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_30);// 设定分词器
		Query query = new QueryParser(Version.LUCENE_30, "postTitle", analyzer).parse(q);//指定查询域
		IndexReader reader = IndexReader.open(FSDirectory.open(indexDir));//创建读取对象
		IndexSearcher searcher = new IndexSearcher(reader);//根据keyword查询title域
	//	Sort sort = new Sort(new SortField("postTitle", SortField.DOC, true));//返回的查询类型字段
		TopDocs topDocs = searcher.search(query, null, TOP_NUM);	// 搜索相似度最高的记录
		ScoreDoc[] hits3 = topDocs.scoreDocs;  
		System.out.println(hits3.length);
		for (int i = 0; i < hits3.length; i++) {
			Lucene post = new Lucene();
			Document doc = searcher.doc(hits3[i].doc);
			String postContent = doc.get("postContent");			
			String postTitle = doc.get("postTitle");  
			post.setAaaaa(postContent);
			post.setBbbbb(postTitle);
			list.add(post);
			System.out.println(postTitle);
			
		}
		searcher.close();
		return list;
		
	}
    

}
