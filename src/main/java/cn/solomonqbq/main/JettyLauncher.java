package cn.solomonqbq.main;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.xml.XmlConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map.Entry;
import java.util.Properties;

public class JettyLauncher {

    private static final Logger logger = LoggerFactory.getLogger(JettyLauncher.class);
    private static final String CLASSPATH_URL_PREFIX = "classpath:";

    public static void main(String[] args) throws Throwable {
        try {
            logger.info("## start the jetty server.");
            final JettyEmbedServer server = new JettyEmbedServer("config/jetty.xml");
            server.start();
            logger.info("## the jetty server is running now ......");
            Runtime.getRuntime().addShutdownHook(new Thread() {

                public void run() {
                    try {
                        logger.info("## stop the jetty server");
                        server.join();
                    } catch (Throwable e) {
                        logger.warn("##something goes wrong when stopping jetty Server:\n{}",
                                ExceptionUtils.getFullStackTrace(e));
                    } finally {
                        logger.info("## jetty server is down.");
                    }
                }

            });
        } catch (Throwable e) {
            logger.error("## Something goes wrong when starting up the jetty Server:\n{}",
                    ExceptionUtils.getFullStackTrace(e));
            System.exit(0);
        }
    }

    private static void mergeProps(Properties props) {
        for (Entry<Object, Object> entry : props.entrySet()) {
            if (StringUtils.isEmpty(System.getProperty((String) entry.getKey()))) {
                //外部启动命令优于配置文件
                System.setProperty((String) entry.getKey(), (String) entry.getValue());
            }
        }
    }
}

class JettyEmbedServer {

    private static final Logger logger = LoggerFactory.getLogger(JettyEmbedServer.class);
    private static final String DEFAULT_CONFIG = "jetty.xml";
    private Server server;
    private String config = DEFAULT_CONFIG;

    public JettyEmbedServer(String jettyXml) {
        this.config = jettyXml;
    }

    public void start() throws Exception {
        Resource configXml = Resource.newSystemResource(config);
        XmlConfiguration configuration = new XmlConfiguration(configXml.getInputStream());
        server = (Server) configuration.configure();
        Handler handler = server.getHandler();
        if (handler != null && handler instanceof WebAppContext) {
            WebAppContext webAppContext = (WebAppContext) handler;
            webAppContext.setResourceBase(JettyEmbedServer.class.getResource("/webapp").toString());
        }
        server.start();
        if (logger.isInfoEnabled()) {
            logger.info("##Jetty Embed Server is startup!");
        }
    }

    public void join() throws Exception {
        server.join();
        if (logger.isInfoEnabled()) {
            logger.info("##Jetty Embed Server joined!");
        }
    }

    public void stop() throws Exception {
        server.stop();
        if (logger.isInfoEnabled()) {
            logger.info("##Jetty Embed Server is stop!");
        }
    }

    // ================ setter / getter ================

    public void setConfig(String config) {
        this.config = config;
    }

}