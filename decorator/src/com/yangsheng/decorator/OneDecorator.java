package com.yangsheng.decorator;

import com.yangsheng.base.report;

public class OneDecorator extends  Decorator{
    private report report1;
    public  OneDecorator(report re){
        this.report1 = re;
    }
    @Override
    public String  getdescription() {
        return report1.getdescription()+" with one";

    }

    @Override
    public double reportResult() {
        return report1.reportResult()+1;

    }
}