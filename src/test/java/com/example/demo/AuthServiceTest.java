package com.example.demo;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestResultListener.class)
public class AuthServiceTest {

    @Test
    public void sanityTest() {
        Assert.assertTrue(true);
    }
}
