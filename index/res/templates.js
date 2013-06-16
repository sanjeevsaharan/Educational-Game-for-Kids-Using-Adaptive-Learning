var showPop=1;
var setFAC=0;
var isIE4 = document.all? true : false;
var isIE6 = document.getElementById && document.all ? true : false;
var isNS4 = document.layers? true : false;
var isNS6 = document.getElementById && !document.all ? true : false;

function getDOMObject (documentID)
{
	if (isIE4)
	{
		return document.all[documentID];
	}
	else if(isIE6)
	{
		return document.getElementById(documentID);
	}
	else if (isNS4)
	{
		return document.layers[documentID];
	}
	else if (isNS6)
	{
		return document.getElementById(documentID);
	}
}

function clearSearchText(SrchObj)
{
	SrchObj.value = "";
	SrchObj.select();
}

function replaceString(string,text,by)
{
	var strLength = string.length, txtLength = text.length;
	if ((strLength == 0) || (txtLength == 0))
		return string;

	var i = string.indexOf(text);

	if ((!i) && (text != string.substring(0,txtLength)))
		return string;

	if (i == -1)
		return string;

	var newstr = string.substring(0,i) + by;

	if (i+txtLength < strLength)
		newstr += replaceString(string.substring(i+txtLength,strLength),text,by);

	return newstr;
}

function submitSearch(formname, type, strAppend)
{
	strAppend = strAppend + generateBrowLogURL('srcqry');
	d = document.forms[formname];
	if ((d.elements['q'].value.length == 0) || (d.elements['q'].value == "Enter Keyword"))
	{
		alert("Please enter a search keyword !");
		d.elements['q'].focus();
		return false;
	}
	else if(checkValidURLChars(d.elements['q'].value))
	{
		newstr = d.elements['q'].value;
		newstr = getEscapedString(newstr);
		d.action = "/display.cfm?s=" + newstr + "&" + strAppend+ "&kt=" + type;
	}
	else
	{
		newstr = d.elements['q'].value;
		newstr = getEscapedString(newstr);
		d.action = '/' + newstr +".cfm?" +strAppend+ "&kt=" + type;
	}
	if (typeof(d)!='undefined')
	{
		d.target = "_top";
	}
	return true;
}

function is_ie6()
{
	return ((window.XMLHttpRequest == undefined) && (ActiveXObject != undefined) && /msie|MSIE 6/.test(navigator.userAgent));
}

function sendRequest(strFormName, strElement)
{
	showPop=0;
	thisform = document.getElementById(strFormName);
	var strforms = strElement;
	var arrElement = new Array();
	arrElement = strforms.split("@@@@");
	for(var i=0; i< arrElement.length; i++)
	{
		var arrTemp = new Array();
		var strTemp = new String(arrElement[i]);
		arrTemp = strTemp.split("####");
		switch(arrTemp[0])
		{
			case "action":
				thisform.action = arrTemp[1] + generateBrowLogURL('adclk');
				break;
			case "data":
				thisform.params.value = arrTemp[1];
				break;
		}
	}
	thisform.method = "POST";
	if(is_ie6())
	{
		thisform.target = "";
	}
	thisform.submit();
	return(false);
}

function changeStatus(strKeyword)
{
	window.status = strKeyword;
	return true;
}

function addbookmark(strDomainName)
{
	bookmarkurl="http://www."+strDomainName;
	bookmarktitle="Welcome To "+strDomainName;

	if (window.sidebar)
	{ // Mozilla Firefox Bookmark
		window.sidebar.addPanel(bookmarktitle, bookmarkurl,"");
	}
	else if( window.external )
	{ // IE Favorite
		window.external.AddFavorite( bookmarkurl, bookmarktitle);
	}
	else if(window.opera && window.print)
	{ // Opera Hotlist
		return(true);
	}
	return(false);
}

function setAsHomePage(ctl, strDomainName)
{
	bookmarkurl="http://www."+strDomainName;

	if( window.external )
	{ // IE
		ctl.style.behavior='url(#default#homepage)';
		ctl.setHomePage(bookmarkurl);
	}
	return(false);
}

function HandleLoc()
{
	var strUrl;
	strUrl = 'http://images.bmnq.com';strUrl += '/lt.php?dn=';strUrl += '';strUrl += '&ck=';strUrl += '&isbn=';strUrl += '0';strUrl += '&uid=6&k=';
	location.href = strUrl;
	return true;
}

function getDate()
{
	var arrDay=new Array("Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday")
	var arrMonth=new Array("January","February","March","April","May","June","July","August","September","October","November","December")

	var objDate=new Date()
	var intYear=objDate.getYear()
	if (intYear < 1000)
	{
		intYear+=1900
	}
	var intDay=objDate.getDay()
	var intMonth=objDate.getMonth()
	var intDayMonth=objDate.getDate()
	if (intDayMonth<10)
	intDayMonth="0"+intDayMonth
	var strCurrerntDate=arrDay[intDay]+", "+arrMonth[intMonth]+" "+intDayMonth+", "+intYear
	document.write(strCurrerntDate)
}

function myPop(strPopupUrl, intShowToolbar)
{
		var d = new Date();
		pundername = 'newpop'+d.getTime();
		if( intShowToolbar == 0)
		{
			newpop = window.open(strPopupUrl, pundername, 'directories=0,menubar=0,width='+screen.width+',height='+screen.height);
		}
		else if ( intShowToolbar == 1 )
		{
			newpop = window.open(strPopupUrl, pundername, "status=1, location=1, toolbar=1,directories=1, top=0, left=0, resizable=1, scrollbars=1, width="+screen.width+",height="+screen.height+",menubar=1");

		}
		else if( intShowToolbar == -1)
		{
			newpop = window.open(strPopupUrl, pundername, "status=1, location=1, toolbar=1,directories=1, top=0, left=0, resizable=1, scrollbars=1, width="+screen.width+",height="+screen.height+",menubar=1");
		}
		else if( intShowToolbar == 2)
		{
			newpop = window.open(strPopupUrl, "fac"+pundername, "status=1, location=1, toolbar=1,directories=1, top=0, left=0, resizable=1, scrollbars=1, width="+screen.width+",height="+screen.height+", menubar=1");
		}		

		if (newpop!=null && typeof(newpop)!="undefined")
		{
			newpop.blur();
		}
		return newpop;
}

function showClkPopunder ( strPopupUrl )
{
	if(showPop==1)
	{ 
		var wopen = myPop(strPopupUrl, 2);
		if (!window.opera && (wopen==null || typeof(wopen)=="undefined"))
		{
			x= document.getElementById('popupbutton');
			x.onchange();
		}
	}
}

function renderFAC()
{
	if(showPop==1 && setFAC == 0)
	{ 
		try{
			if (typeof facl != "undefined" && facl.length>0)
			{
				facl = facl + generateBrowLogURL('adclk');
				myPop(facl, 2);
			}
		}catch(e){ }
	}
}

function addEventHandler(){
	if (document.addEventListener){
		document.addEventListener("click",renderFACP,false);	
	} else if(document.attachEvent){
		document.attachEvent("onclick",renderFACP);
	} else {
		document.onclick = renderFACP;
	}
}

function removeEventHandler(){
	if (document.removeEventListener){
		document.removeEventListener("click",renderFACP,false);
	} else if(document.detachEvent){
		document.detachEvent("onclick",renderFACP);
	} else {
		document.onclick = null;
	}
}

function renderFACP(e)
{
	if(showPop == 1 && setFAC == 0)
	{ 
		try{
			if (!e) { 
				var e = window.event || window.Event; 
				e.cancelBubble = true
			}
			if(e.button && e.button == 2) return;			
			if (typeof facl != "undefined" && facl.length>0)
			{
				facl = facl + generateBrowLogURL('adclk');
				myPop(facl, 2);
				removeEventHandler();
				setFAC = 1;
			}
		}catch(e){ 
			setFAC = 1; 
		}
	}
}
function showPopunder (strPopupUrl, intShowTool)
{
     if(showPop==1)
     {
		var wopen = myPop(strPopupUrl, intShowTool);
		if (!window.opera && (wopen==null || typeof(wopen)=="undefined"))
		{
			x= document.getElementById('popupbutton');
			x.onchange();
		}
   	}
}


function checkUTFString (strValue)
{
	var blnUTF;
	var intStringLength;

	if(strValue == '')
	{
			return (false);
	}
	intStringLength = strValue.length;

	for(intCur = 0; intCur < intStringLength; intCur++)
	{
		blnUTF = true;
		chrValue = strValue.charAt (intCur);
		var intAscii;
		for (intAscii = 0; intAscii < 128; ++ intAscii)
		{
			var strAscii = intAscii.toString (16);
			if (strAscii.length == 1)
				strAscii = "0" + strAscii;

			strAscii = "%" + strAscii;
			strAscii = unescape (strAscii);
			if (strAscii == chrValue)
			{
				blnUTF=false;
				break;
			}
		}
		if(blnUTF == true)
		{
			break;
		}
	}
	return blnUTF;
}

function checkValidURLChars (strValue)
{
	var blnReturn;
	var intStringLength;

	if(strValue == '')
	{
		return (false);
	}
	if( strValue.match(/[#&]/) )
	{
		return ( true );
	}
	intStringLength = strValue.length;

	for(intCur = 0; intCur < intStringLength; intCur++)
	{
		blnReturn = true;
		chrValue = strValue.charAt (intCur);
		var intAscii;
		for (intAscii = 0; intAscii < 128; ++ intAscii)
		{
			var strAscii = intAscii.toString (16);
			if (strAscii.length == 1)
				strAscii = "0" + strAscii;

			strAscii = "%" + strAscii;
			strAscii = unescape (strAscii);
			if (strAscii == chrValue)
			{
				blnReturn=false;
				break;
			}
		}
		if(blnReturn == true)
		{
			break;
		}
	}
	return blnReturn;
}

function getEscapedString (strValue)
{
	var blnUTF;
	var intStringLength;
	var strReturnValue;
	strReturnValue = '';

	if(strValue == '')
	{
			return (strValue);
	}

	intStringLength = strValue.length;

	for(intCur = 0; intCur < intStringLength; intCur++)
	{
		blnUTF = true;
		chrValue = strValue.charAt (intCur);
		var intAscii;
		for (intAscii = 0; intAscii < 128; ++ intAscii)
		{
			var strAscii = intAscii.toString (16);
			if (strAscii.length == 1)
				strAscii = "0" + strAscii;

			strAscii = "%" + strAscii;
			strAscii = unescape (strAscii);

			if (strAscii == chrValue)
			{
				blnUTF=false;
				break;
			}
		}
		if(blnUTF == true)
		{
			strReturnValue = strReturnValue+chrValue;
		}
		else
		{
			if(chrValue == " ")
			{
				chrValue = "_";
			}
			strReturnValue = strReturnValue+escape(chrValue);
		}
	}

	return strReturnValue;
}

if (!isIE4) document.captureEvents(Event.MOUSEMOVE)
var mX=0,mY=0,br_data=false;
document.onmousemove = mPos;
function mPos(e) {
	if (isIE4){
		mX = event.clientX + document.body.scrollLeft;
		mY = event.clientY + document.body.scrollTop;
	}
	else{
		mX = e.pageX;
		mY = e.pageY;
	}
	return true;
}

function relplaceAllALinks(tag_regex)
{
	try
	{
		links = window.document.getElementsByTagName('A');
		links_len = links.length;

		for(i = 0; i < links_len; i++)
		{
			if( links[i].href.match(tag_regex ))
			{
				tempData = links[i].innerHTML;
				modifyKeywordClickURL(links[i], 'olod' );				
				links[i].innerHTML = tempData;
			}
		}
	}
	catch(e)
	{}
}

function modifyKeywordClickURL(anchor_tag, call_type)
{
	anchor_tag.href = anchor_tag.href  + generateBrowLogURL(call_type);
	if (typeof prctu != "undefined" && prctu.length>0)
	{
		anchor_tag.href = prctu + getEscapedString( anchor_tag.href );
	}
	return true;
}

function generateBrowLogURL(call_type)
{
	var append_data='';
	try
	{
		if( typeof br_data == 'undefined' || !br_data )
		{
			br_data = new brdata();
		}
		if( call_type == 'kwclk' )
		{
			append_data = escape(br_data.getMousePositionData());
		}
		else if( call_type == 'adclk' || call_type == 'srcqry' )
		{
			append_data = '&bd=' + escape(br_data.getSearchBoxRelatedData());
		}
		else
		{
			append_data = '&bd=' + escape(br_data.getURLBrowserData());
		}
	}
	catch(e){}
	return append_data;
}

var brdata = function()
{
	this.fd = '#',
	this.cookieSupport = -1,
	this.isinframe = -1,
	this.browserdata='',
	this.getLocalTimeZone = function(){
		return	(new Date()).getTimezoneOffset()/60*(-1);
	},
	this.getScreenHeight = function(){
		return screen.height;
	},
	this.getScreenWidth = function(){
		return screen.width;
	},
	this.calledInExternalFrame = function(){
		return 'n';
	},
	this.isCookieSupported = function(){
		if(this.cookieSupport == -1)
		{
			var ce = navigator.cookieEnabled || false;
			if (typeof navigator.cookieEnabled == 'undefined' && !ce)
			{
				document.cookie="skck";
				ce=(document.cookie.indexOf("skck")!=-1)? true : false;
			}
		}
		return this.cookieSupport;
	},
	this.getURLBrowserData = function(){
		if(this.browserdata == '')
		{
			this.browserdata = this.getLocalTimeZone().toString() +  this.fd + this.getScreenHeight() + this.fd + this.getScreenWidth() + this.fd +  (( this.isCookieSupported() )?1:0).toString() + this.fd + (this.calledInExternalFrame()).toString();
		}
		return this.browserdata;
	}
	this.getMousePositionData = function(){
		return this.fd + mX + this.fd + mY;
	}
	this.getSearchBoxRelatedData = function(){
		return this.getURLBrowserData()+this.getMousePositionData();
	}
};

function confirmToOptOut()
{
  optOut=confirm('You will not be able to see any ads or websearches.');
  if(optOut)
  {
    var date = new Date();
	date.setTime(date.getTime()+(365*24*60*60*1000));
	var expires = "; expires="+date.toGMTString();
    document.cookie = "ootk=1"+expires+"; path=/";    
  	window.location.reload();
  }
}