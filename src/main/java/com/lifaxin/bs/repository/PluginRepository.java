package com.lifaxin.bs.repository;

import com.lifaxin.bs.repository.entity.PluginEntity;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.facet.Facets;
import org.apache.lucene.facet.FacetsConfig;
import org.apache.lucene.facet.taxonomy.FastTaxonomyFacetCounts;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.UUID;

/**
 * 插件仓库
 *
 * @author FaXin.Li
 * @date 2023/3/23 14:58
 */
public class PluginRepository {

    private static final String BASE_STATION_HOME = System.getProperty("user.home") + "/.base-station/plugin";


    public Document createDocument(PluginEntity pluginEntity) {
        Document document = new Document();
        document.add(new StringField("ID", UUID.randomUUID().toString(), Field.Store.YES));
        document.add(new StringField("PLUGIN_CODE", pluginEntity.getPluginCode(), Field.Store.YES));
        document.add(new StringField("PLUGIN_NAME", pluginEntity.getPluginName(), Field.Store.YES));
        document.add(new StringField("PLUGIN_CATEGORY", pluginEntity.getPluginCategory(), Field.Store.YES));
        document.add(new StringField("PLUGIN_VERSION", pluginEntity.getPluginVersion(), Field.Store.NO));
        document.add(new IntField("PLUGIN_VERSION_CODE", pluginEntity.getPluginVersionCode()));
        document.add(new StringField("PLUGIN_DESCRIPTION", pluginEntity.getPluginDescription(), Field.Store.NO));
        document.add(new StringField("PLUGIN_ADDR", pluginEntity.getPluginAddr(), Field.Store.NO));
        document.add(new StringField("PLUGINS_STATUS", "0", Field.Store.YES));
        document.add(new StringField("DOWNLOAD_STATUS", "0", Field.Store.YES));
        return document;
    }



    public static void main(String[] args) throws IOException, ParseException {
        // 创建Document对象
//        Document document = new Document();
//        document.add(new StringField("ID", "1", Field.Store.YES));
//        document.add(new StringField("PLUGIN_CODE", "JSON_FORMAT_TOOL", Field.Store.YES));
//        document.add(new TextField("PLUGIN_NAME", "JSON格式化工具", Field.Store.YES));
//        document.add(new StringField("PLUGIN_CATEGORY", "生产效率", Field.Store.YES));
//        document.add(new StringField("PLUGIN_VERSION", "1.0.0", Field.Store.NO));
//        document.add(new IntField("PLUGIN_VERSION_CODE", 10));
//        document.add(new StringField("PLUGIN_DESCRIPTION", "JSON格式化工具, 非常人性化", Field.Store.NO));
//        document.add(new StringField("PLUGIN_ADDR", "http://baidu.com", Field.Store.NO));
//        document.add(new StringField("PLUGINS_STATUS", "0", Field.Store.YES));
//        document.add(new StringField("DOWNLOAD_STATUS", "0", Field.Store.YES));

        // 创建索引目录
        Directory indexDir = FSDirectory.open(Paths.get(BASE_STATION_HOME));

//        // 创建索引器
//        Analyzer analyzer = new SmartChineseAnalyzer();
//        IndexWriterConfig config = new IndexWriterConfig(analyzer);
//        IndexWriter writer = new IndexWriter(indexDir, config);
//        writer.addDocument(document);
////         关闭IndexWriter并提交更改
//        writer.close();


//        // 创建查询解析器
//        QueryParser parser = new QueryParser("PLUGIN_NAME", analyzer);
//        Query query = parser.parse("格式化");
////        // 执行查询
        IndexReader reader = DirectoryReader.open(indexDir);
//        IndexSearcher searcher = new IndexSearcher(reader);
//        TopDocs results = searcher.search(query, 10);
//
//        // 遍历结果
//        for (ScoreDoc scoreDoc : results.scoreDocs) {
//            Document resultDoc = searcher.doc(scoreDoc.doc);
//            System.out.println(resultDoc.get("PLUGIN_CODE"));
//        }




        FacetsConfig facetsConfig = new FacetsConfig();
        facetsConfig.setIndexFieldName("category", "PLUGIN_CATEGORY");

        IndexSearcher indexSearcher = new IndexSearcher(reader);
        Facets facets = new FastTaxonomyFacetCounts(taxonomyReader, facetsConfig, indexReader, categoryField);
        FacetResult result = facets.getTopChildren(Integer.MAX_VALUE, categoryField);
        System.out.println(result);
    }

}
