function sendPost(formname, div, url, send) {
	var form = document.forms[formname];
	var elemArray = form.elements;
	var input = '';
	var element, elemType, elemName;
	
	for(var i=0; i<elemArray.length; i++) {
		element = elemArray[i];
		elemType = element.type.toUpperCase();
		if(elemType == "TEXT" || elemType == "TEXTAREA" || elemType == "PASSWORD" || elemType == "FILE" || elemType == "HIDDEN") {
		 	elemName = element.name;
		 	qstr = $("#"+elemName).val();
		 	if(qstr == "") {
		 		$("#"+elemName).focus();
				$.jGrowl("<img src=\"alert.png\" width=\"25\" height=\"25\">Errore: Il "+elemName+" non è stato inserito.");
				return false;
			}
		}
	}
	
	var dataString = getQuery(formname);
	$("#"+send).attr("disabled", "true");
	$.ajax({
		type: "POST",
		url: url,
		data: dataString,
		beforeSend: function() {
			$.jGrowl("<img src=\"good.png\" width=\"25\" height=\"25\">Attendi, sto effettuando la richiesta a "+url+"...");
		},
		error: function(e, xhr, settings, exception) {
			$.jGrowl("<img src=\"alert.png\" width=\"25\" height=\"25\">Errore "+e.status+" "+settings);
		},
		success: function(response) {
			$('#'+div).html("")
			.hide()
			.slideToggle('fast', function() {
				$('#'+div).append(response)
				$.jGrowl("<img src=\"good.png\" width=\"25\" height=\"25\">Fatto.");
			});
		}

	});

	return false;
}

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
			if(elemType == "TEXT" || elemType == "TEXTAREA" || elemType == "PASSWORD" || elemType == "FILE" || elemType == "HIDDEN")
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
