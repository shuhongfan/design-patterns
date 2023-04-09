package com.atguigu.design.behavioral.interpreter;


/**
 * 环境类：
 * 风景区
 */
public class Area {
    String[] city = {"武汉市","上海市"};//免费城市
    String[] type = {"医生","老人","儿童"};//免费人群

    //环境类持有表达式

    public Area(){
        TerminalExpression city = new TerminalExpression(this.city, ":");
        TerminalExpression type = new TerminalExpression(this.type, "-");

    }

    /**
     * 传入表达式，判断当前表达式是否指定为免费人群
     * @param expression
     */
    void getTicket(String expression){

    }
}
