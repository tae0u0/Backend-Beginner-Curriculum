package com.gdgoc.webServlet;

public class ServerApplication {
    public static void main(String[] args) {
        final TomcatStarter tomcatStarter = new TomcatStarter();
        tomcatStarter.start();
        tomcatStarter.await();
    }
}
