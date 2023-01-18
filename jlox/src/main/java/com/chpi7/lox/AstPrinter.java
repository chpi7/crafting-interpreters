package com.chpi7.lox;

import com.chpi7.lox.Expr.Assign;
import com.chpi7.lox.Expr.Binary;
import com.chpi7.lox.Expr.Call;
import com.chpi7.lox.Expr.Grouping;
import com.chpi7.lox.Expr.Literal;
import com.chpi7.lox.Expr.Logical;
import com.chpi7.lox.Expr.Unary;
import com.chpi7.lox.Expr.Variable;

public class AstPrinter implements Expr.Visitor<String> {

    String print(Expr expr) {
        return expr.accept(this);
    }

    @Override
    public String visitCallExpr(Call expr) {
        return parenthesize("call (todo printing :))");
    }

    @Override
    public String visitBinaryExpr(Binary expr) {
        return parenthesize(expr.operator.lexeme, expr.left, expr.right);
    }

    @Override
    public String visitGroupingExpr(Grouping expr) {
        return parenthesize("group", expr.expression);
    }

    @Override
    public String visitLiteralExpr(Literal expr) {
        if (expr.value == null) return "nil";
        return expr.value.toString();
    }

    @Override
    public String visitUnaryExpr(Unary expr) {
        return parenthesize(expr.operator.lexeme, expr.right);
    }

    @Override
    public String visitVariableExpr(Variable expr) {
        return expr.name.lexeme;
    }

    @Override
    public String visitAssignExpr(Assign expr) {
        return parenthesize("assign " + expr.name, expr.value);
    }

    @Override
    public String visitLogicalExpr(Logical expr) {
        return parenthesize(expr.operator.lexeme, expr.left, expr.right);
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
