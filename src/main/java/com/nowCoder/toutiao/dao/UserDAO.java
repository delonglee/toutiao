
package com.nowCoder.toutiao.dao;

import com.nowCoder.toutiao.moder.User;
import org.springframework.web.bind.annotation.Mapping;

@Mapping
public interface UserDAO {
    String TABLE_NAME = "user";
    String INSET_FIELDS = "name, password, salt, head_url";
    String SELECT_FIELDS = "id, name, password, salt, head_url";

    @Insert({"insert into", TABLE_NAME, "(", INSET_FIELDS,
            ") value (#{name}, #{password}, #{salt}, #{headUrl})"})
    int addUser(User user);

    @Select({"select", SELECT_FIELDS, "from", TABLE_NAME, "where id = #{id}"})
    User selectById(int id);

    @Select({"select", SELECT_FIELDS, "from", TABLE_NAME, "where namae = #{name}"})
    User selectByName(String name);

    @Update({"update", TABLE_NAME, "set password = #{password} where id = #{id}"})
    void updatePassword(User user);

    @Delete({"delete from", TABLE_NAME, "where id = #{id}"})
    void deleteById(int id);

}












