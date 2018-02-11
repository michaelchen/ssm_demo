package org.cdx.ssm.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    @Select("SELECT count(*) FROM user")
    int getUserCount();
}
