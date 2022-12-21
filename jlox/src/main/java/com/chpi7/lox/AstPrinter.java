package com.chpi7.lox;

import com.chpi7.lox.Expr.Binary;
import com.chpi7.lox.Expr.Grouping;
import com.chpi7.lox.Expr.Literal;
import com.chpi7.lox.Expr.Unary;

public class AstPrinter implements Expr.Visitor<String> {

    String print(Expr expr) {
        return expr.accept(this);
    }

    @Override
    public String visitBinaryExpr(Binary expr) {
        return parenthesize(expr.operator.lexeme, expr.left, expr.right);
    }

    @Override
    public String visitGroupingExpr(Grouping expr) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String visitLiteralExpr(Literal expr) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String visitUnaryExpr(Unary expr) {
        // TODO Auto-generated method stub
        return null;
    }

    private String parenthesize(String name, Expr... exprs) {
        StringBuilder builder = new StringBuilder();

        builder.append("(").append(name);
        for (Expr expr : exprs) {
            builder.append(" ");
            builder.append(expr.accept(this));
        }
        builder.append(")");

        return builder.toString();
    }
}
