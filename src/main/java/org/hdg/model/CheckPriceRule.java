package org.hdg.model;

/**
 * @author huangxiaojun
 * @email huangxiaojun@hyx.com
 * @create 2018-06-12 10:41
 **/
public class CheckPriceRule {
    private Integer mzCinemaId;//卖座影院ID
    private String mzCinemaName;//卖座影院名称
    private String invalidRuleIds;//无效的规则ID,用','分隔的

    public Integer getMzCinemaId() {
        return mzCinemaId;
    }

    public void setMzCinemaId(Integer mzCinemaId) {
        this.mzCinemaId = mzCinemaId;
    }

    public String getMzCinemaName() {
        return mzCinemaName;
    }

    public void setMzCinemaName(String mzCinemaName) {
        this.mzCinemaName = mzCinemaName;
    }

    public String getInvalidRuleIds() {
        return invalidRuleIds;
    }

    public void setInvalidRuleIds(String invalidRuleIds) {
        this.invalidRuleIds = invalidRuleIds;
    }

    @Override
    public String toString() {
        return "CheckPriceRule{" +
                "mzCinemaId=" + mzCinemaId +
                ", mzCinemaName='" + mzCinemaName + '\'' +
                ", invalidRuleIds='" + invalidRuleIds + '\'' +
                '}';
    }
}
