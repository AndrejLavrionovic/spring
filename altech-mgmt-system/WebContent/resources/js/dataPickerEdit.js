

var monthsNames = ["Jnuary", "February", "March", "April", "May", "June", "July",
"August", "September", "October", "November", "December" ];
var telPrefix = ["085", "086", "087", "089"];
var d = new Date();var year = d.getFullYear();
var globalMonthValue=null;var globalYearValue=null;var globalDayValue=null;
function monthOptons(m){
    var sel = document.getElementById("pickMonth");
    var month = document.getElementById("month").value;
    for(i = 0, y = 0; i <= m.length; i++){
        var opt = document.createElement("option");
        if(i===0){opt.text="";opt.value=-1;}else{if (month != "" && month == y){opt.selected = true;}opt.text = m[y];opt.value = y++;}
        sel.appendChild(opt);
    }
}
function dayOptions(m, y){
    var sel = document.getElementById("pickDay");
    var day = document.getElementById("day").value;
    
    var d = 31;
    if(m==null){d=31;}
    else if(y==null)
    {
        if(m==3 || m==5 || m==8 || m==10){d=30;}
        else if(m==1){d=28;}
        else{d==31;}
    }
    else
    {
        if(((y%4)==0)&&(m==1)){d=29;}
        else if(((y%4)!=0)&&(m==1)){d=28;}
        else if(m==3 || m==5 || m==8 || m==10){d=30;}
        else{d=31;}
    }
    while(sel.firstChild){sel.removeChild(sel.firstChild);}
    for(i = 0; i <=d; i++){
        var opt = document.createElement("option");
        if(i===0){opt.text="";opt.value=-1;}else{opt.text = i;opt.value=i;}
        if(i==globalDayValue){opt.selected = true;}
        if(day != null && day < d && i == day){opt.selected = true}
        sel.appendChild(opt);
    }
}
function yearOptions(start, end){
    var sel = document.getElementById("pickYear");
    var y = document.getElementById("year").value;
    var range = end - start;
    for(i = 0; i <= range; i++){
        var opt = document.createElement("option");
        if(y != null && y == start){opt.selected = true;}
        if(i===0){opt.text="";opt.value=-1;}else{opt.text = start;opt.value = start++;}
        sel.appendChild(opt);
    }
}
function telPrefixOptions(telpr){
	var sel = document.getElementById("selTelPrefix");
	var telPref = document.getElementById("telPref").value;
	for (i=0,y=0;i<=telpr.length;i++){
		var opt = document.createElement("option");
		if(telPref != null && telPref == telpr[y]){opt.selected = true;}
		if(i===0){opt.text="";opt.value=-1;}else{opt.text=telpr[y];opt.value=telpr[y++];}
		sel.appendChild(opt);
	}
}

{
    monthOptons(monthsNames);dayOptions(null, null);yearOptions((year-80),(year-16));telPrefixOptions(telPrefix);
    var selectMonthChange = document.getElementById("pickMonth");
    selectMonthChange.addEventListener("change", function(){
        globalMonthValue = this.options[this.selectedIndex].value;
        if(globalMonthValue == -1) {globalMonthValue=null;}
        dayOptions(globalMonthValue, globalYearValue);
    });
    var selectYearChange = document.getElementById("pickYear");
    selectYearChange.addEventListener("change", function(){
        globalYearValue = this.options[this.selectedIndex].value;
        if(globalYearValue == -1) {globalYearValue=null;}
        dayOptions(globalMonthValue, globalYearValue);
    });
    var selectDayChange = document.getElementById("pickDay");
    selectDayChange.addEventListener("change", function(){
        globalDayValue = this.options[this.selectedIndex].value;
        if(globalDayValue == -1) {globalDayValue=null;}
    });
}
