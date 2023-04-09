package com.atguigu.design.behavioral.interpreter;

/**
 * 终结符表达式
 *
 * 多少种解析规则就需要定义多少种规则类
 *
 */
public class TerminalExpression extends IDCardExpression {
    String[] data;
    String symbol; //定义解析用的符号如  ： -

    public TerminalExpression(String[] data,String symbol){
        this.data = data;
        this.symbol = symbol;
    }

    @Override
    boolean interpret(String expression) {

        return false;
    }
}
