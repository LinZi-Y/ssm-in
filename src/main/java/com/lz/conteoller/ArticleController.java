package com.lz.conteoller;

import com.lz.entity.Article;
import com.lz.service.IArticleService;
import com.lz.utils.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author
 * @date
 */
@Controller
@RequestMapping("/article")
public class ArticleController {
    @Resource
    private IArticleService iArticleService;

    @RequestMapping(value = "/indexUI")
    public String find(){
        return "index";
    }
    @RequestMapping(value = "/art")
    public String art(){
        return "article";
    }
    @RequestMapping(value = "/add")
    public String add(){
        return "addArticle";
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public String login(String name,String password){
        System.out.println(name+","+password);
        return "1";
    }
    /**
     *
     * 文章页面中的a标题的添加
     *
     *
     * 文章的增加
     * @param article
     * @return
     *
     * No converter found for return value of type: class java.lang.Integer
     * 未找到类型为java.lang.Integer的返回值的转换器
     * int 返回数据 习惯性错误
     *
     * article.html
     * 点击<a href="article.html">添加</a>
     *
     * 数据输入完ajax提交数据到后台
     */
    @RequestMapping(value = "/addArticle",method= RequestMethod.GET)
    @ResponseBody
    public String insertArticle(Article article){
        int count = iArticleService.insert(article);
        return String.valueOf(count) ;
    }

    /**
     * 点击文章<a herf></a>
     *
     * 查询文章总数
     * @return
     */
    @RequestMapping("/selectPage")
    @ResponseBody
    public JsonResult selectPage(){
        Integer page=iArticleService.selectPage();
        return new JsonResult(page);
    }
    /**
     * 分页查询展示数据
     * 、、@param model
     * @param pageStart
     * @param pageEnd
     * @return
     *
     * path = "/list"   <a herf="list"></a>
     *
     * return "articleList"
     * 根据视图解析器查找
     *
     * @ResponseBody不用写
     *
     * 返回String  return "articleList";
     *
     *
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public JsonResult articleList(int pageStart, int pageEnd){
        List<Article> articleList = iArticleService.selectByList(pageStart,pageEnd);
        return new JsonResult(articleList);
    }

    /**
     * 文章页面中a标签的修改
     *先选中要修改的文章,才能点击修改链接
     * <a herf="modify.html">修改</a>
     *
     * 文章id由前端JavaScript获取  选中事件
     *
     * 点击修改,根据文章id查询文章信息并展示到修改页面
     * @param id
     * @return
     */
    @RequestMapping("/selectById")
    @ResponseBody
    public Article selectById(Integer id){
        Article article = iArticleService.selectByPrimaryKey(id);
        return article;
    }

    /**
     * 修改页面   修改文章信息,ajax提交数据到后台进行修改
     *
     * 通过展示的文章数据进行修改,点击提交后提交回后台进行修改数据
     * @param article
     * @return
     */
    @RequestMapping(value = "/updateArticle", method=RequestMethod.GET)
    @ResponseBody
    public int updateArticle(Article article){
        int count = iArticleService.updateByPrimaryKey(article);
        return count;
    }

    /**
     * 根据文章id删除对应文章,并重定向到分页展示数据进行页面刷新
     * @param id
     * @return
     */
    @RequestMapping("/deleteArticle")
    public String deleteArticle(int id){
        iArticleService.deleteByPrimaryKey(id);
        return "redirect:/Article/list";
    }
}
