package com.nowCoder.toutiao;


import com.nowCoder.toutiao.dao.LoginTicketDAO;
import com.nowCoder.toutiao.dao.NewsDAO;
import com.nowCoder.toutiao.dao.UserDAO;
import com.nowCoder.toutiao.moder.LoginTicket;
import com.nowCoder.toutiao.moder.News;
import com.nowCoder.toutiao.moder.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Random;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ToutiaoApplication.class)
//@Sql("init-schema.sql")
public class InitDatabaseTests {
    @Autowired
    UserDAO userDAO;

    @Autowired
    NewsDAO newsDAO;

    @Autowired
    LoginTicketDAO loginTicketDAO;
    @Test
    public void initData {
        Random random = new Random();
                for (int i = 0; i < 11; ++i) {
                    User user = new User();
                    user.setHeasUrl(String.format("http://images.nowcoder.com/head/%dt.png"，random.nextInt(1000)));
                    user.setName(String.format("USER%d",i));
                    user.setPassword(" ");
                    user.setSalt(" ");
                    userDAO.addUser(user);

                    News news = new News();
                    news.setCommentCount(i)；
                    Date date = new date();
                    date.setTime(date.get.getTime() + 1000*3600*5*i);
                    news.setCreateDate(date);
                    news.setImage(String.format("http://images.nowcoder.com/head/%dt.png"，random.nextInt(1000)));
                    news.setLikeCount(i+1);
                    news.setUserId(i+1);
                    news.setTitle(String.format("TITLE{%d}"，i));
                    news.setLkink(String.format("http://www.nowcoder.com/%d.html", i));
                    newsDAO.addNews(news);



                    user.setPassword("newpassword");
                    userDAO.updatePassword(user);

                    LoginTicket ticket = new LoginTicket();
                    ticket.setStatus(0);
                    ticket.setUserId(i+1);
                    ticket.setExpired(date);
                    ticket.setTicket(String.format("TICKET%d", i+1));
                    loginTicketDAO.addTicket(ticket);

                    loginTicketDAO.updateStatus(ticket.getTicket(), 2);
                }

        Assert.assertEquals("newpassword", userDAO.selectById(1).getPassword());
                userDAO.deleteById(1);
                Assert.assertNull(userDAO.selectById(1));

                Assert.assertEquals(1,loginTicketDAO.selectByTicket("TICKET1").getUser());
                Assert.assertEquals(2,loginTicketDAO.selectByTicket("TICKET1").getStatus());

    }
}













