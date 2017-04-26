package com.cntv.service.serviceImpl;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public   class  TestLog4j  {
    public   static   void  main(String[] args)  {
       PropertyConfigurator.configure( " E:/EclipsejavaEE/workspace/SpringMybat/src/com/cntv/config/log4j.properties" );
       Logger logger  =  Logger.getLogger(TestLog4j. class );
       logger.debug( " debug " );
       logger.error( " error " );
   } 
}