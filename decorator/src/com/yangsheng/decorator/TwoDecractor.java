package com.yangsheng.decorator;


import com.yangsheng.base.report;

public class TwoDecractor extends Decorator {
    private report r;
    public  TwoDecractor(report re){
        this.r = re;
    }
    @Override
    public double reportResult() {
        return r.reportResult() +2;
    }

    @Override
    public  String getdescription() {
        return r.getdescription()+"with two";
    }
}
