package com.yangsheng.decorator;

import com.yangsheng.base.basereport;
import com.yangsheng.base.report;

public class DecoratorDemo {
    public static void main(String[] args) {
        basereport bs = new basereport();
        report r = new OneDecorator(new TwoDecractor(bs));
        System.out.println((r.getdescription()));
        System.out.println(r.reportResult());
    }
}
