package com.coding.exercise.util;

import com.coding.exercise.model.BalanceTestResult;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BalancedBracketTest {

    @Test
    public void checkWithSpaces() {
        BalanceTestResult balancedBrackets = BalancedBracket.isBalancedBrackets("{}{}[]   ");
        assertEquals(true, balancedBrackets.isIsBalanced());
    }

    @Test
    public void checkWithInvalidMixBracket() {
        BalanceTestResult balancedBrackets = BalancedBracket.isBalancedBrackets("{[()}]");
        assertEquals(false, balancedBrackets.isIsBalanced());
    }

    @Test
    public void checkWithValidMixBracket() {
        BalanceTestResult balancedBrackets = BalancedBracket.isBalancedBrackets("{[()]}");
        assertEquals(true, balancedBrackets.isIsBalanced());
    }

    @Test
    public void checkWithLongInput() {
        BalanceTestResult balancedBrackets = BalancedBracket.isBalancedBrackets("[{()()}({[]})]({}[({})])" +
                "((((((()[])){}))[]{{{({({({{{{{{}}}}}})})})}}}))[][][]");
        assertEquals(true, balancedBrackets.isIsBalanced());
    }

    @Test
    public void checkWithLongInvalidInput() {
        BalanceTestResult balancedBrackets = BalancedBracket.isBalancedBrackets("[{({)()}({[]})]({}[({})])(((" +
                "(((()[])){}))[]{{{({({({{{{{{}}}}}})})})}}}))[][][]");
        assertEquals(false, balancedBrackets.isIsBalanced());
    }


    @Test
    public void checkWithSmallInput() {
        BalanceTestResult balancedBrackets = BalancedBracket.isBalancedBrackets("{");
        assertEquals(false, balancedBrackets.isIsBalanced());
    }


}