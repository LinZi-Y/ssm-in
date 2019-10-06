package com.lz.conteoller;

import com.lz.entity.Admin;
import com.lz.entity.Article;
import com.lz.service.IArticleService;
import com.lz.utils.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 未判断当前用户是否登陆,权限未设置,
 * @author
 * @date
 */
@Controller
@RequestMapping("/article")
public class ArticleController {
    @Resource
    private IArticleService iArticleService;

    /**
     * 当前用户

    private Admin currentuser;
    */

    /*@RequestMapping(value = "/indexUI")
    public String find(){
        return "index";
    }*/

    @RequestMapping(value = "/art")
    public String art(){
        return "article";
    }

    @RequestMapping(value = "/add")
    public String add(){
        return "addArticle";
    }

    @RequestMapping(value = "/update")
    public String update(){
        return "updateArticle";
    }

    /**
     * test 暂时为登陆页面
     * @return
     */
    @RequestMapping(value = "/toLogin")
    public String toLogin(){
        return "test";
    }

    /**
     * 根据文章id删除对应文章,局部刷新article.html页面
     *  return "article"; 通过视图解析器找到相应的页面
     * @param id
     * @return
     */
    @RequestMapping("/deleteArticle")
    public String deleteArticle(int id){
        iArticleService.deleteByPrimaryKey(id);
        return "article";
    }

    /**
     * 文章的增加 ajax提交数据到后台
     * @param article
     * @return
     *点击<a href="add">添加</a> 跳转到 addArticle.html
     *
     * No converter found for return value of type: class java.lang.Integer
     * 未找到类型为java.lang.Integer的返回值的转换器
     * int 返回数据 习惯性错误
     *
     * int count = iArticleService.insert(article);
     * return String.valueOf(count) ;
     *
     * iArticleService.insert(article);
     * return new JsonResult("OK");
     *
     * 均可使用,二选一
     */
    @RequestMapping(value = "/addArticle",method= RequestMethod.GET)
    @ResponseBody
    public String insertArticle(Article article){
        int count = iArticleService.insert(article);
        return String.valueOf(count) ;
    }

    /**
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
     * @param pageStart
     * @param pageEnd
     * @return
     *
     * 前端判断 if(list.data!=null)
     *
     * return new JsonResult(articleList);  取决于是否为空
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public JsonResult articleList(int pageStart, int pageEnd){
        List<Article> articleList = null;
       // if (currentuser != null){
            articleList = iArticleService.selectByList(pageStart,pageEnd);
            return new JsonResult(articleList);
        //}
      // return new JsonResult(articleList);
    }

    /**
     * 根据文章id查询文章信息并展示到修改页面
     * @param id
     * @return
     */
    @RequestMapping("/selectById")
    @ResponseBody
    public JsonResult selectById(Integer id){
        Article article = iArticleService.selectByPrimaryKey(id);
        return new JsonResult(article);
    }

    /**
     * 修改页面   修改文章信息,ajax提交数据到后台进行修改
     * "OK" == 200  HTTP状态码 已建立连接  state
     * @param article
     * @return
     */
    @RequestMapping(value = "/updateArticle", method=RequestMethod.GET)
    @ResponseBody
    public JsonResult updateArticle(Article article){
        iArticleService.updateByPrimaryKey(article);
        return new JsonResult("OK");
    }
}
