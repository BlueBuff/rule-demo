package org.hdg.service;

import org.hdg.dao.ICheckRule;
import org.hdg.model.CheckPriceRule;

import java.util.List;

/**
 * @auther: huangxiaojun
 * @date: 2019/04/08 20:20
 */
public class CheckRuleService {

    private ICheckRule iCheckRule;

    public CheckRuleService(ICheckRule checkRule) {
        this.iCheckRule = checkRule;
    }

    public void checkRule() {
        List<CheckPriceRule> checkPriceRules = iCheckRule.checkPriceRuleList();
        if (checkPriceRules != null) {
            for (CheckPriceRule checkPriceRule : checkPriceRules){
                System.out.println(checkPriceRule);
            }
        }
    }
}
