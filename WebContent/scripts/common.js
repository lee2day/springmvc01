/*
 * @(#) common.js 2012. 4. 6.
 * 
 * Copyright(c) 2012 Lee Chang-Yeol.
 * 
 * NOTICE:
 * This source code that is confidential and proprietary to Lee Chang-Yeol.
 * No part of this source code may be reproduced in any form 
 * whatsoever without prior approval by Lee Chang-Yeol.
 */

function isEmptyOrNull(text) {
	if ((text == null) || (text == "")) {
		return true;
	}
	return false;
}


function valFalseProc(fieldNm, fieldObj) {
	alert(fieldNm + "는(은) 필수입니다.");
	fieldObj.focus();
}

function chkNullOrEmpty(fieldNm, fieldObj){
	if (isEmptyOrNull(fieldObj.val())) {
		valFalseProc(fieldNm, fieldObj);
		return false;
	}
	return true;
}