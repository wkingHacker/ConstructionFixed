package com.hunau.servlet;


import javax.servlet.http.HttpServlet;


import com.bimface.sdk.BimfaceClient;
import com.hunau.Config;

/**
 * Servlet的抽象类
 * 
 * @author bimface, 2017-03-01
 */
public abstract class AbstractServlet extends HttpServlet {

    private static final long      serialVersionUID = -4500339978847437199L;

    // 初始化BimfaceClient
    protected static BimfaceClient bimfaceClient    = new BimfaceClient(Config.APP_KEY, Config.APP_SECRET);
}
