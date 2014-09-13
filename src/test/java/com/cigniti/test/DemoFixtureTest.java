package com.cigniti.test;

import org.junit.Test;

import java.io.IOException;
import java.net.MalformedURLException;

public class DemoFixtureTest {

    @Test
    public void shouldConnectAndLaunchApp() throws IOException {
        DemoFixture df = new DemoFixture();

        df.initiate();

    }

}
