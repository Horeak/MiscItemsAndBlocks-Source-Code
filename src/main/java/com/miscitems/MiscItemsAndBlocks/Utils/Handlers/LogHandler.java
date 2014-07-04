package com.miscitems.MiscItemsAndBlocks.Utils.Handlers;

import com.miscitems.MiscItemsAndBlocks.Utils.Config.ConfigUtils;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogHandler {

    public static final Logger LOGGER = LogManager.getLogger("MiscItemsLogger");


    public static void OutputMessage(String Text, Level level, int Priority){
        if(Priority <= ConfigUtils.LeveOfLogging)
        LOGGER.log(level, Text);
    }

    public static void Error(String Text, int Priority){
        if(Priority <= ConfigUtils.LeveOfLogging)
            LOGGER.log(Level.ERROR, Text);
    }

    public static void Debug(String Text, int Priority){
        if(Priority <= ConfigUtils.LeveOfLogging)
            LOGGER.log(Level.DEBUG, Text);
    }

    public static void All(String Text, int Priority){
        if(Priority <= ConfigUtils.LeveOfLogging)
            LOGGER.log(Level.ALL, Text);
    }


    public static void Error(String Text){
            LOGGER.log(Level.ERROR, Text);
    }

    public static void Debug(String Text){
            LOGGER.log(Level.DEBUG, Text);
    }

    public static void All(String Text){
            LOGGER.log(Level.ALL, Text);
    }


}
