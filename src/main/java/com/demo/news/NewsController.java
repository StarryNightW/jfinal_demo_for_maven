package com.demo.news;

import com.demo.common.model.NewsInfo;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;

public class NewsController extends Controller {
    private NewsInfo dao = new NewsInfo().dao();
    public Page<NewsInfo> paginate(int pageNumber,int pageSize){
        Page<NewsInfo> newsInfoVo = dao.paginate(pageNumber,pageSize,"select *","from news_info order by pubtime desc");
        return newsInfoVo;
    }
    public void index(){
        NewsController newsController = new NewsController();
        Page<NewsInfo> newsInfoPage = newsController.paginate(getParaToInt(0,1),10);
        System.out.println(newsInfoPage.getList());
        DataMessage msg = new DataMessage();
        msg.setCode(200);
        msg.setMessage("成功");
        msg.setData(newsInfoPage);
        System.out.println(msg);
        System.out.println(msg.getData());
        System.out.println("hello");
    }
}
