function modificaDiv(id) {
	var elemento;
	if(document.getElementById)
		elemento = document.getElementById(id);
	else
		elemento = document.all[id];
	return elemento;
};

function setXMLHttpRequest() {
	var XHR = null,	browserUtente = navigator.userAgent.toUpperCase();
	if(typeof(XMLHttpRequest) === "function" || typeof(XMLHttpRequest) === "object")
		XHR = new XMLHttpRequest();
	else if(window.ActiveXObject && browserUtente.indexOf("MSIE 4") < 0) {
		if(browserUtente.indexOf("MSIE 5") < 0)
			XHR = new ActiveXObject("Msxml2.XMLHTTP");
		else
			XHR = new ActiveXObject("Microsoft.XMLHTTP");
	}
	return XHR;
};
		
var readyState = {
	INATTIVO:	0,
	INIZIALIZZATO:	1,
	RICHIESTA:	2,
	RISPOSTA:	3,
	COMPLETATO:	4
};
		
var statusText = new Array();
statusText[100] = "Continue";
statusText[101] = "Switching Protocols";
statusText[200] = "OK";
statusText[201] = "Created";
statusText[202] = "Accepted";
statusText[203] = "Non-Authoritative Information";
statusText[204] = "No Content";
statusText[205] = "Reset Content";
statusText[206] = "Partial Content";
statusText[300] = "Multiple Choices";
statusText[301] = "Moved Permanently";
statusText[302] = "Found";
statusText[303] = "See Other";
statusText[304] = "Not Modified";
statusText[305] = "Use Proxy";
statusText[306] = "(unused, but reserved)";
statusText[307] = "Temporary Redirect";
statusText[400] = "Bad Request";
statusText[401] = "Unauthorized";
statusText[402] = "Payment Required";
statusText[403] = "Forbidden";
statusText[404] = "Not Found";
statusText[405] = "Method Not Allowed";
statusText[406] = "Not Acceptable";
statusText[407] = "Proxy Authentication Required";
statusText[408] = "Request Timeout";
statusText[409] = "Conflict";
statusText[410] = "Gone";
statusText[411] = "Length Required";
statusText[412] = "Precondition Failed";
statusText[413] = "Request Entity Too Large";
statusText[414] = "Request-URI Too Long";
statusText[415] = "Unsupported Media Type";
statusText[416] = "Requested Range Not Satisfiable";
statusText[417] = "Expectation Failed";
statusText[500] = "Internal Server Error";
statusText[501] = "Not Implemented";
statusText[502] = "Bad Gateway";
statusText[503] = "Service Unavailable";
statusText[504] = "Gateway Timeout";
statusText[505] = "HTTP Version Not Supported";
statusText[509] = "Bandwidth Limit Exceeded";

/* Ritorna una query del tipo value=name&value=name per ogni elemento a partire dal nome di un form. */
function getQuery(formname) {
	var form = document.forms[formname];
	var elemArray = form.elements;
	var qstr = '';
	var option, element, elemType, elemName;
	
	function GetElemValue(name, value) {
		qstr += (qstr.length > 0 ? "&" : "") + escape(name).replace(/\+/g, "%2B") + "=" + escape(value ? value : "").replace(/\+/g, "%2B");
	}
	
	for(var i=0; i<elemArray.length; i++) {
		element = elemArray[i];
		elemType = element.type.toUpperCase();
	 	elemName = element.name;

		if(elemName) {
			if(elemType == "TEXT" || elemType == "TEXTAREA" || elemType == "PASSWORD" || elemType == "BUTTON" || elemType == "RESET" || elemType == "SUBMIT" || elemType == "FILE" || elemType == "IMAGE" || elemType == "HIDDEN")
				GetElemValue(elemName, element.value);
			else if(elemType == "CHECKBOX" && element.checked)
				GetElemValue(elemName, element.value ? element.value : "On");
			else if(elemType == "RADIO" && element.checked)
				GetElemValue(elemName, element.value);
			else if(elemType.indexOf("SELECT") != -1)
				for(var j=0; j<element.options.length; j++) {
					option = element.options[j];
					if(option.selected)
						GetElemValue(elemName, option.value ? option.value : option.text);
				}
		}
	}
	return qstr;
}

/* Usage: <a href="page.php?id=123" onclick="return inviaGet(this, 'divName');">Click me</a> */
function inviaGet(link, id) {
	var ajax = setXMLHttpRequest(),
	elemento = modificaDiv(id),
	nomeFile = link.href,
	usaLink = true;
	
	// Richiesta fantasma
	var dataChiamata = new Date(),
	inizioChiamata = dataChiamata.getTime(),
	massimaAttesa = 5,
	verificaTempoTrascorso;
	
	if(ajax) {
		usaLink = false;
		if(!link.cliked) {
			link.cliked = true;
			ajax.open("get", nomeFile, true);
			ajax.setRequestHeader("connection", "close");
			ajax.onreadystatechange = function() {
				if(ajax.readyState === readyState.COMPLETATO) {
					if(statusText[ajax.status] === "OK")
						elemento.innerHTML = ajax.responseText;
					else {
						elemento.innerHTML = "Impossibile effettuare l'operazione richiesta.<br />";
						elemento.innerHTML += "Errore riscontrato: " + statusText[ajax.status];
					}
				}
				else if(massimaAttesa < 1000) {
					massimaAttesa = massimaAttesa * 1000;
					verificaTempoTrascorso = function() {
						dataChiamata = new Date();
						if((dataChiamata.getTime() - inizioChiamata) > massimaAttesa) {
							ajax.onreadystatechange = function(){return;};
							ajax.abort();
							ajax = document.createElement("p");
							ajax.innerHTML = "Spiacente, richiesta fallita.<br />La prego di ritentare tra qualche istante.";
							elemento.appendChild(ajax);
							link.cliked = false;
						}
						else
							setTimeout(verificaTempoTrascorso, 100);
					}
					verificaTempoTrascorso();
				}
			}
		}
		ajax.send();
		elemento.innerHTML="<img src='loading.gif'><br />";
	}
	return usaLink;
};

/* Usage: <form action="post" action="page.php" name="example" onsubmit="inviaPost('page.php', 'divName', this.name, 'submitName');"> */
function inviaPost(nomeFile, id, formname, button) {
	var ajax = setXMLHttpRequest(),
	elemento = modificaDiv(id),
	usaLink = true;
	
	// Richiesta fantasma
	var dataChiamata = new Date(),
	inizioChiamata = dataChiamata.getTime(),
	massimaAttesa = 5,
	verificaTempoTrascorso;
	
	if(ajax) {
		usaLink = false;
		if(!button.cliked) {
			button.cliked = true;
			ajax.open("post", nomeFile, true);
			ajax.setRequestHeader("content-type", "application/x-www-form-urlencoded");
			ajax.setRequestHeader("connection", "close");
			ajax.onreadystatechange = function() {
				if(ajax.readyState === readyState.COMPLETATO) {
					if(statusText[ajax.status] === "OK")
						elemento.innerHTML = ajax.responseText;
					else {
						elemento.innerHTML = "Impossibile effettuare l'operazione richiesta.<br />";
						elemento.innerHTML += "Errore riscontrato: " + statusText[ajax.status];
					}
				}
				else if(massimaAttesa < 1000) {
					massimaAttesa = massimaAttesa * 1000;
					verificaTempoTrascorso = function() {
						dataChiamata = new Date();
						if((dataChiamata.getTime() - inizioChiamata) > massimaAttesa) {
							ajax.onreadystatechange = function(){return;};
							ajax.abort();
							ajax = document.createElement("p");
							ajax.innerHTML = "Spiacente, richiesta fallita.<br />La prego di ritentare tra qualche istante.";
							elemento.appendChild(ajax);
							button.cliked = false;
						}
						else
							setTimeout(verificaTempoTrascorso, 100);
					}
					verificaTempoTrascorso();
				}
			}
		}
		ajax.send(getQuery(formname));
		elemento.innerHTML="<img src='loading.gif'><br />";
	}
	return usaLink;
};	

/* Usage: <p onclick="loading('caricamento', 'divName');" */
function loading(testo, div) {
	var puntini = 0;
	testoIntrattenimento = modificaDiv(div),
	animaTesto = function() {
		var testoAggiunto = "";
	 	for(var a = 0; a < puntini; a++)
			testoAggiunto += ".";
		testoIntrattenimento.nodeValue = testo + testoAggiunto;
	      
		if(puntini < 3)
			puntini++;
		else
			puntini = 0;
		setTimeout(animaTesto, 200);
	};
	if(testoIntrattenimento.firstChild) {
		animaTesto = function(){};
		testoIntrattenimento.removeChild(testoIntrattenimento.firstChild);
	}
	else {
		testoIntrattenimento = document.createTextNode(testo);
		modificaDiv(div).appendChild(testoIntrattenimento);
		animaTesto();
	};
};
