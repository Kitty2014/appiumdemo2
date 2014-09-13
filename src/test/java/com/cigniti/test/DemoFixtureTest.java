package com.cigniti.test;

import org.junit.After;
import org.junit.Test;

import java.io.IOException;

public class DemoFixtureTest {

    private DemoFixture df;

    @Test
    public void shouldConnectAndLaunchApp() throws IOException {
        df = new DemoFixture();

        df.initiateSession();

    }

    @After
    public void Teardown() {
        df.cleanupSession();
    }

}
