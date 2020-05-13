
	function FormataData(campo, teclapres)
	{
		var tecla = teclapres.keyCode;
		var vr = new String(campo.value);
		vr = vr.replace(".", "");
		vr = vr.replace("/", "");
		vr = vr.replace("-", "");
		tam = vr.length + 1;
		if (tecla != 14)
		{
			if (tam == 3)
				campo.value = vr.substr(0, 2) + '/';
			if (tam == 5)
				campo.value = vr.substr(0, 2) + '/' + vr.substr(2, 4) + '/';
			
		}
	}
	
	function contWord(idLabel,idTextArea,numWords){   
	  objLb=document.getElementById(idLabel);
	  objTx=document.getElementById(idTextArea);    
	  str = objTx.value;
	  objLb.innerHTML = numWords - str.length;  
	  
	  if(objLb.innerHTML < 0){
	    MsgMaximo(numWords);
	    objLb.innerHTML = 0;
	    objTx.value = str.substr(0,numWords);
	  }
	}