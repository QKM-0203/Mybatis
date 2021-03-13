package com.mybatis.Test;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * 日志可以很清楚的查看同时可以很清晰的判断
 */
public class Log4JTest {

    static Logger logger = Logger.getLogger(Log4JTest.class);

    @Test
    public void log4jTest(){
      logger.info("成功测试----info");
      logger.debug("成功测试----debug");
    }
}
