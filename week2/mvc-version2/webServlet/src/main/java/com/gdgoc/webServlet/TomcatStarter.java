package com.gdgoc.webServlet;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import java.io.File;

public class TomcatStarter {

    private static final String WEBAPP_DIR_LOCATION = "src/main/webapp/";
    private final Tomcat tomcat;

    public TomcatStarter() {
        this(WEBAPP_DIR_LOCATION);
    }

    public TomcatStarter(final String webappDirLocation) {
        this.tomcat = new Tomcat();
        tomcat.setConnector(createConnector());

        String currentDir = System.getProperty("user.dir");
        System.out.println("📁 현재 작업 디렉토리: " + currentDir);


        String docBase = new File(webappDirLocation).getAbsolutePath();
        StandardContext context = (StandardContext) tomcat.addWebapp("", docBase);

        context.setDelegate(true);

        // 클래스 스캔을 위한 리소스 설정
        setupWebResourceRoot(context);
    }

    private void setupWebResourceRoot(StandardContext context) {
        try {
            WebResourceRoot resources = new StandardRoot(context);

            // 컴파일된 클래스 디렉토리 추가
            File classesDir = new File("build/classes/java/main");
            if (classesDir.exists()) {
                resources.addPreResources(
                        new DirResourceSet(resources, "/WEB-INF/classes",
                                classesDir.getAbsolutePath(), "/"));
                System.out.println("✅ 클래스 디렉토리 추가: " + classesDir.getAbsolutePath());
            } else {
                System.out.println("❌ 클래스 디렉토리 없음: " + classesDir.getAbsolutePath());
            }

            context.setResources(resources);

        } catch (Exception e) {
            System.err.println("리소스 설정 실패: " + e.getMessage());
        }
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