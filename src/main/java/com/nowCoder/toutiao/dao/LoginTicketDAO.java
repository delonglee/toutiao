package com.nowCoder.toutiao.dao;

import com.nowCoder.toutiao.moder.LoginTicket;
import com.nowCoder.toutiao.moder.News;
import com.nowCoder.toutiao.moder.User;
import org.jboss.logging.Param;

public interface LoginTicketDAO {
    String TABLE_NAME = "login_ticket";
    String INSERT_FIELDS = "user_id, expired, status, ticket";
    String SELECT_FIELDS = "id," + INSERT_FIELDS;
    @Insert({"insert into", TABLE_NAME, "(", INSERT_FIELDS,
            ") value (#{userId}, #{expired}, #{status}, #{ticket})"})
    int addTicket (LoginTicket ticket);

    @Select({"select", SELECT_FIELDS, "from", TABLE_NAME, "where ticket = #{ticket}"})
    LoginTicket selectByTicket(String ticket);

    @Update({"update", TABLE_NAME, "set status = #{password} where ticket = #{ticket}"})
    void updateStatus(@Param("ticket") String ticket, @Param("status") int status);

}
