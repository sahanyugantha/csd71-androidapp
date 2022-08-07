package com.sahan.csd71app;

import com.sahan.csd71app.dao.LoginAsyncTask;

import org.junit.Assert;
import org.junit.Test;

public class TestAddNumbers {

    private int num1 = 59;
    private int num2 = 119;
    private int expected = 188;

    @Test
    public void testAdd(){
        LoginAsyncTask asyncTask = new LoginAsyncTask(null, null);
        int actual = asyncTask.addNumbers(num1,num2);

        Assert.assertEquals(expected,actual);
    }
}
