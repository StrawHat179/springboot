package com.strawhat.boot.controller;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * FreeMarker模板生成静态文件
 * @author: sxf
 * @Date:2021/04/13/10:22
 * @Description:
 */
@Controller
public class StaticController {
    @GetMapping("/news/{id}")
    public String getNews(@PathVariable("id") int id, HttpServletRequest req) throws IOException, TemplateException {

        String path = req.getServletContext().getRealPath("/");
        // 获取项目根目录（涉及中文目录，需要转码），并设置存放新闻页面的目录
        String resourcesPath = URLDecoder.decode(path,"utf-8");
        // 为了能够直接返回html页面，因此设置保存目录为static静态资源目录下，可以被SpringBoot直接解析
        //File newsFilePath = new File(resourcesPath + "src/main/resources/static/newsFile/");
        File newsFilePath = new File(resourcesPath + "newsFile/");

        if (!newsFilePath.exists()) {
            // 目录不存在则创建目录
            newsFilePath.mkdirs();
        }
        // 检测要访问的文件是否存在
        File newsFile = new File(newsFilePath, id + ".html");
        if (!newsFile.exists()) {
            // 不存在，则进行页面静态化处理
            // 模拟查询出新闻数据
            String title = "可爱的中国，今天为你缅怀";
            String source = "江西新闻客户端";
            String publishTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            String content = "“到那时，到处都是活跃跃的创造，到处都是日新月异的进步，这时，我们的民族 就可以无愧色地立在人类的面前。”\n" + "\n在《可爱的中国》文章中，方志敏字字泣血，唤醒着中国亿万同胞的爱国之情。这些用忠诚和热 血书写下来的文字，让许许多多的优秀青年走上救国道路，激励着一代代共产党人，为共产主义事业奋斗终身。";
            Map<String, Object> dataModel = new HashMap<>();
            dataModel.put("title", title);
            dataModel.put("source", source);
            dataModel.put("publishTime", publishTime);
            dataModel.put("content", content);
            // 创建FreeMarker配置实例-->加载模板-->生成输出
            Configuration config = new Configuration(Configuration.VERSION_2_3_31);
            config.setClassForTemplateLoading(this.getClass(), "/templates");
            Template template = config.getTemplate("news.ftl");
            template.process(dataModel, new FileWriter(newsFile));

        }
        // 返回静态页面文件
        return "forward:/newsFile/" + id + ".html";
    }

}
