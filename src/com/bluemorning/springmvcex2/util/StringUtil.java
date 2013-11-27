/*
 * @(#) StringUtil.java 2012. 3. 24.
 * 
 * Copyright(c) 2012 Lee Chang-Yeol.
 * 
 * NOTICE:
 * This source code that is confidential and proprietary to Lee Chang-Yeol.
 * No part of this source code may be reproduced in any form 
 * whatsoever without prior approval by Lee Chang-Yeol.
 */

package com.bluemorning.springmvcex2.util;

/**
 * <PRE>
 * 1. FileName : StringUtil.java
 * 2. Package  : com.bluemorning.springmvcex2.util
 * 3. Comment  : 
 * 4. Programmer   : BlueMorning
 * 5. Date   : 2012. 3. 24. 오전 9:08:26
 * </PRE>
 */
public class StringUtil {

	/**
	 * Checks if is null or empty.
	 *
	 * @param strObj the str obj
	 *
	 * @return true, if is null or empty
	 */
	public final static boolean isNullOrEmpty(String strObj) {
		if (strObj == null) {
			return true;
		}

		int iLength = strObj.length();
		int iStart = 0;

		while ((iStart < iLength) && (strObj.charAt(iStart) <= ' ')) {
			iStart++;
		}

		return (iStart == iLength);
	}
}
