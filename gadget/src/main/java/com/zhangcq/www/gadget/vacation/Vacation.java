package com.zhangcq.www.gadget.vacation;

import java.io.Serializable;
import java.util.Date;
/**
 * @Description: No Description
 * @author: zhangcq
 * @Time: 2019/3/20 14:27
 * @Version 1.0
 */

public class Vacation implements Serializable {

    private static final long serialVersionUID = 1L;
    private Date date;
    private int days;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

}