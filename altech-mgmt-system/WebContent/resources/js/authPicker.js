/**
 * 
 */
var auths=["user", "man", "head", "hr", "Employee", "Office Manager", "Head Manager", "HR Admin"];
function authOptions(a){
	var sel = document.getElementById("selAuthority");
	var auth = document.getElementById("auth").value;
	for(i=0,y=0;i<=a.length/2;i++){
        var opt = document.createElement("option");
        if(auth != null && auth == a[y]){opt.selected = true;}
        if(i===0){opt.text="";opt.value="";}else{opt.text = a[y+4];opt.value = a[y++];}
        sel.appendChild(opt);
    }}{authOptions(auths);}