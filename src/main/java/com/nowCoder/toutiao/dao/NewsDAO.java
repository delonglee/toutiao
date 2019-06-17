package com.nowCoder.toutiao.dao;

import com.nowCoder.toutiao.moder.News;
import org.jboss.logging.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface NewsDAO {
    String TABLE_NAME = "news";
    String INSET_FIELDS = "title, link, image, like_count,comment_count, created_date, user_id";
    String SELECT_FIELDS = "id," +INSET_FIELDS;
    @Insert({"insert into", TABLE_NAME, "(", INSET_FIELDS,
            ") value (#{title}, #{link}, #{image}, #{likeCount}, #{commentCount}, #{creatDate}, #{userId})"})
    int addNews(News news);


    @Param("userId")
    @Param("limit")
    @Param("offest")
    List<News> selectByUserIdAndOffset(int userId, int offest, int limit);

}
