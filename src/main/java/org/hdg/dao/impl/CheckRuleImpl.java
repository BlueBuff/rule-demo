package org.hdg.dao.impl;

import org.hdg.dao.ICheckRule;
import org.hdg.model.CheckPriceRule;
import org.hdg.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @auther: huangxiaojun
 * @date: 2019/04/08 20:17
 */
public class CheckRuleImpl implements ICheckRule {


    public List<CheckPriceRule> checkPriceRuleList() {
        List<CheckPriceRule> checkPriceRules = null;
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            // 获取连接
            conn = JDBCUtils.getConnection();

            // 编写sql
            String sql = "select mzCinemaId,mzCinemaName,GROUP_CONCAT(a.id) as invalidRuleIds from tb_rule a LEFT JOIN tb_cinema b USING(mzCinemaId) WHERE a.`status`=1 AND b.`status`=1 AND endDate >= DATE_FORMAT(NOW(), '%Y-%m-%d') AND  hallId!='' AND !FIND_IN_SET(hallId,replace(hallIds,'-',',')) GROUP BY mzCinemaId,mzCinemaName;";

            // 创建语句执行者
            st= conn.prepareStatement(sql);

            rs = st.executeQuery();
            checkPriceRules = new ArrayList<CheckPriceRule>();
            while(rs.next()) {
                CheckPriceRule checkPriceRule = new CheckPriceRule();
                checkPriceRule.setMzCinemaId(rs.getInt("mzCinemaId"));
                checkPriceRule.setMzCinemaName(rs.getString("mzCinemaName"));
                checkPriceRule.setInvalidRuleIds(rs.getString("invalidRuleIds"));
                checkPriceRules.add(checkPriceRule);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.colseResource(conn, st, rs);
        }
        return checkPriceRules;
    }
}
