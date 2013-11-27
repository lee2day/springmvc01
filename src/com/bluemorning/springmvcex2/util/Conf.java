/*
 * @(#)Conf.java	2010. 4. 14
 * 
 * Copyright(c) 2009 Lee Chang Yeol.
 * 
 * NOTICE:
 * This source code that is confidential and proprietary to Lee Chang Yeol.
 * No part of this source code may be reproduced in any form 
 * whatsoever without prior approval by Lee Chang Yeol.
 */
package com.bluemorning.springmvcex2.util;

import java.util.Properties;
import java.io.File;
import java.io.InputStream;
import java.io.IOException;
import java.io.FileInputStream;


/**
 * The Class Conf.
 */
public class Conf {

    /** The m pro. */
    private static Properties mPro = null;

    /** The m pp url. */
    public static String propFile = "properties/conf.properties";
    public static String confFilePath = null;
    
    /**
     * Instantiates a new conf.
     */
    public Conf() {
    }

    /**
     * Inits the.
     * 
     * @param propertyPath the property path
     * 
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void init(String propertyPath) throws IOException
    {
        FileInputStream fIn = new FileInputStream(propertyPath+File.separator+propFile);
        Conf conf = new Conf();
        mPro = conf.loadProperties(fIn);
    }

    /**
     * Inits the.
     * 
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void init() throws IOException
    {
        InputStream in = Conf.class.getClassLoader().getResourceAsStream(propFile);
        Conf conf = new Conf();
        mPro = conf.loadProperties(in);
    }

    /**
     * Load properties.
     * 
     * @param in the in
     * 
     * @return the properties
     * 
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private Properties loadProperties(InputStream in) throws IOException {
        Properties p = new Properties();
        p.load(in);
        return p;
    }

    /**
     * Gets the value.
     * 
     * @param key the key
     * 
     * @return the value
     */
    public static String getValue(String key) {
        return mPro.getProperty(key);
    }

    /**
     * The main method.
     * 
     * @param args the arguments
     * 
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void main(String[] args) throws IOException {
    	Conf.init();
	}
    
    /**
     * Gets the value to int
     * @param string
     * @return
     */
    public static int getIntValue(String string) {
		String value = mPro.getProperty(string);
		if(value!=null)
			return Integer.parseInt(value);
		return 0;
	}
}
