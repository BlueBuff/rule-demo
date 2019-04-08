package org.hdg.util;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

/**
 * @auther: huangxiaojun
 * @date: 2019/04/08 19:57
 */
public class JDBCUtilTest {

    @Test
    public void test(){
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            // 获取连接
            conn = JDBCUtils.getConnection();

            // 编写sql
            String sql = "select * from tb_cinema";

            // 创建语句执行者
            st= conn.prepareStatement(sql);

            rs = st.executeQuery();

            while(rs.next()) {
                System.out.println(rs.getString(1)+"..."+rs.getString(2));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.colseResource(conn, st, rs);
        }
    }
}
