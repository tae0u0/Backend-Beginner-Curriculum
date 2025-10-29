package com.gdgoc.xml;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;

import java.io.File;

public class TomcatStarter {

    // 올바른 경로로 수정
    private static final String WEBAPP_DIR_LOCATION = "src/main/webapp/";
    private final Tomcat tomcat;

    public TomcatStarter() {
        this(WEBAPP_DIR_LOCATION);
    }

    public TomcatStarter(final String webappDirLocation) {
        this.tomcat = new Tomcat();
        tomcat.setConnector(createConnector());

        String docBase = new File(webappDirLocation).getAbsolutePath();
        StandardContext context = (StandardContext) tomcat.addWebapp("", docBase);
    }

    public void start() {
        try {
            tomcat.start();
            System.out.println("===== tomcat server start - http://localhost:8080 =====");
        } catch (LifecycleException e) {
            System.err.println("tomcat server fail : " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void await() {
        System.out.println("===== server waiting.. =====");
        tomcat.getServer().await();
    }

    public void stop() {
        try {
            tomcat.stop();
            tomcat.destroy();
            System.out.println("===== tomcat server end =====");
        } catch (LifecycleException e) {
            throw new RuntimeException(e);
        }
    }

    private Connector createConnector() {
        Connector connector = new Connector();
        connector.setPort(8080);
        return connector;
    }
}