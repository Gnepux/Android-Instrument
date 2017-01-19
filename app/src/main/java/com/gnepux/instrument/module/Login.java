package com.gnepux.instrument.module;

import java.util.List;

/**
 * Created by xupeng on 17/1/18.
 */

public class Login {

    /**
     * STATUS : 0
     * MESSAGE :
     * LOGINSUCC : 0
     * STORAGEINFO : [{"lgnum":"NJ9"},{"lgnum":"NJ8"},{"lgnum":"NJ1"},{"lgnum":"7610"},{"lgnum":"8013"},{"lgnum":"837A"},{"lgnum":"837M"}]
     * FUNCTIONURL : [{"createBy":"","createDate":null,"funCode":"02","funId":25,"funName":"上架作业处理","funParentId":-1,"isParent":0,"lastModifyDate":null,"level":"","rate":0,"sortNO":0,"subCount":0,"url":""},{"createBy":"","createDate":null,"funCode":"05","funId":50,"funName":"查询","funParentId":-1,"isParent":0,"lastModifyDate":null,"level":"","rate":0,"sortNO":0,"subCount":0,"url":""},{"createBy":"","createDate":null,"funCode":"06","funId":56,"funName":"不良品管理","funParentId":-1,"isParent":0,"lastModifyDate":null,"level":"","rate":0,"sortNO":0,"subCount":0,"url":""},{"createBy":"","createDate":null,"funCode":"01","funId":18,"funName":"入库作业处理","funParentId":-1,"isParent":0,"lastModifyDate":null,"level":"","rate":0,"sortNO":0,"subCount":0,"url":""},{"createBy":"","createDate":null,"funCode":"03","funId":29,"funName":"出库作业处理","funParentId":-1,"isParent":0,"lastModifyDate":null,"level":"","rate":0,"sortNO":0,"subCount":0,"url":""},{"createBy":"","createDate":null,"funCode":"08","funId":144,"funName":"小件仓储流程变革RF功能","funParentId":-1,"isParent":0,"lastModifyDate":null,"level":"","rate":0,"sortNO":0,"subCount":0,"url":""},{"createBy":"","createDate":null,"funCode":"04","funId":40,"funName":"库内作业处理","funParentId":-1,"isParent":0,"lastModifyDate":null,"level":"","rate":0,"sortNO":0,"subCount":0,"url":""},{"createBy":"","createDate":null,"funCode":"07","funId":86,"funName":"分拨中心管理","funParentId":-1,"isParent":0,"lastModifyDate":null,"level":"","rate":0,"sortNO":0,"subCount":0,"url":""}]
     * SAVESESSION : 0
     */

    private String STATUS;
    private String MESSAGE;
    private String LOGINSUCC;
    private String SAVESESSION;
    /**
     * lgnum : NJ9
     */

    private List<STORAGEINFOBean> STORAGEINFO;
    /**
     * createBy :
     * createDate : null
     * funCode : 02
     * funId : 25
     * funName : 上架作业处理
     * funParentId : -1
     * isParent : 0
     * lastModifyDate : null
     * level :
     * rate : 0
     * sortNO : 0
     * subCount : 0
     * url :
     */

    private List<FUNCTIONURLBean> FUNCTIONURL;

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    public String getMESSAGE() {
        return MESSAGE;
    }

    public void setMESSAGE(String MESSAGE) {
        this.MESSAGE = MESSAGE;
    }

    public String getLOGINSUCC() {
        return LOGINSUCC;
    }

    public void setLOGINSUCC(String LOGINSUCC) {
        this.LOGINSUCC = LOGINSUCC;
    }

    public String getSAVESESSION() {
        return SAVESESSION;
    }

    public void setSAVESESSION(String SAVESESSION) {
        this.SAVESESSION = SAVESESSION;
    }

    public List<STORAGEINFOBean> getSTORAGEINFO() {
        return STORAGEINFO;
    }

    public void setSTORAGEINFO(List<STORAGEINFOBean> STORAGEINFO) {
        this.STORAGEINFO = STORAGEINFO;
    }

    public List<FUNCTIONURLBean> getFUNCTIONURL() {
        return FUNCTIONURL;
    }

    public void setFUNCTIONURL(List<FUNCTIONURLBean> FUNCTIONURL) {
        this.FUNCTIONURL = FUNCTIONURL;
    }

    public static class STORAGEINFOBean {
        private String lgnum;

        public String getLgnum() {
            return lgnum;
        }

        public void setLgnum(String lgnum) {
            this.lgnum = lgnum;
        }
    }

    public static class FUNCTIONURLBean {
        private String createBy;
        private Object createDate;
        private String funCode;
        private int funId;
        private String funName;
        private int funParentId;
        private int isParent;
        private Object lastModifyDate;
        private String level;
        private int rate;
        private int sortNO;
        private int subCount;
        private String url;

        public String getCreateBy() {
            return createBy;
        }

        public void setCreateBy(String createBy) {
            this.createBy = createBy;
        }

        public Object getCreateDate() {
            return createDate;
        }

        public void setCreateDate(Object createDate) {
            this.createDate = createDate;
        }

        public String getFunCode() {
            return funCode;
        }

        public void setFunCode(String funCode) {
            this.funCode = funCode;
        }

        public int getFunId() {
            return funId;
        }

        public void setFunId(int funId) {
            this.funId = funId;
        }

        public String getFunName() {
            return funName;
        }

        public void setFunName(String funName) {
            this.funName = funName;
        }

        public int getFunParentId() {
            return funParentId;
        }

        public void setFunParentId(int funParentId) {
            this.funParentId = funParentId;
        }

        public int getIsParent() {
            return isParent;
        }

        public void setIsParent(int isParent) {
            this.isParent = isParent;
        }

        public Object getLastModifyDate() {
            return lastModifyDate;
        }

        public void setLastModifyDate(Object lastModifyDate) {
            this.lastModifyDate = lastModifyDate;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public int getRate() {
            return rate;
        }

        public void setRate(int rate) {
            this.rate = rate;
        }

        public int getSortNO() {
            return sortNO;
        }

        public void setSortNO(int sortNO) {
            this.sortNO = sortNO;
        }

        public int getSubCount() {
            return subCount;
        }

        public void setSubCount(int subCount) {
            this.subCount = subCount;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
