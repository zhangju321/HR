$.fn.serializeObject=function(){
	var o={};//对象
	var a=this.serializeArray();
	$.each(a,function(){
		//undefined作为条件:false
		if(o[this.name]){
			if(!o[this.name].push){
				o[this.name]=[o[this.name]];
			}
			o[this.name].push(this.value||'');
		}else{
			o[this.name]=this.value||'';
		}
	})
	return o;
}
//获取表单数据
//$('form').serializeObject();