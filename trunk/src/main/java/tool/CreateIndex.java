package tool;

import java.io.File;
import java.io.IOException;


import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

public class CreateIndex {
	private static String INDEX_DIR = "G:\\index";// 索引存放目录
	public CreateIndex(String postTitle,String postContent){
		File indexDir = new File(INDEX_DIR);
		indexDir.mkdirs();
	    IndexWriter writer = null;
	    Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_30);
	    try {
			 writer = new IndexWriter(FSDirectory.open(indexDir),
			 analyzer, false, IndexWriter.MaxFieldLength.LIMITED);//此处可以设置是否覆盖原有的document，false是不覆盖
			 Document doc = new Document();
				doc.add(new Field("postTitle",postTitle,Field.Store.YES,Field.Index.ANALYZED));
				doc.add(new Field("postContent",postContent,Field.Store.YES,Field.Index.ANALYZED));
				writer.setUseCompoundFile(false);
				writer.addDocument(doc);
				writer.close();
				System.out.println("success");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    public static void main(String[] args) {
    	    new CreateIndex("wsyy is 哈哈哈哈","哈哈");
			
	
	}
}
