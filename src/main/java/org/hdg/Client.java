package org.hdg;

import org.hdg.dao.impl.CheckRuleImpl;
import org.hdg.service.CheckRuleService;

/**
 * @auther: huangxiaojun
 * @date: 2019/04/08 20:22
 */
public class Client {

    public static void main(String[] args) {
        CheckRuleService checkRuleService = new CheckRuleService(new CheckRuleImpl());
        checkRuleService.checkRule();
    }
}
