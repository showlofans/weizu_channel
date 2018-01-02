/**更新展示通道维护状态*/
function changeUseState(url, showRateState, id){
	var msg = "确认要维护该通道吗?";
	if(status == '0'){
		msg = '确认要恢复该通道吗?';
	}
	
	layer.confirm(msg,function(index){
		$.ajax({
			type: 'POST',
			url: url,
			data: {id:id,showRateState:showRateState},
			//dataType: 'json',
			success: function(data){
				if(data=="success")
				{
					layer.msg('修改状态成功!',{icon:1,time:1000});
					location.reload();
				}else{
					layer.msg('修改状态失败!',{icon:2,time:1000});
				}
			},
			error:function(data) {
				console.log(data.msg);
			}
		});		
	});
}

/*展示通道-删除*/
function produce_del(url,id){
	layer.confirm('确认要删除吗？',function(index){
		$.ajax({
			type: 'POST',
			url: url,
			data: {id:id},
			//dataType: 'json',
			success: function(data){
				if(data=="success")
				{
					layer.msg('删除通道成功!',{icon:1,time:1000});
					location.reload();
				}else{
					layer.msg('删除通道失败!',{icon:1,time:1000});
				}
			},
			error:function(data) {
				console.log(data.msg);
			}
		});		
	});
}

/*提交表单**/
function submitForm(){
	//$("input[name='pageNo']").val('');
	$('form').submit();
}
/**重置-加入初始参数*/
/* function resetNow(){
	var locationHref = location.href;
	var showModel = $('#showModel').val();
	locationHref += '?showMoel=';
	locationHref += showModel;
	alert(locationHref);
	window.location.replace(locationHref);
} */

/*展示通道添加-添加*/
function showRate_add(obj,title,url,id){
	//alert(id);
	if(id != '0'){//编辑展示通道
		url = url + '?id=' + id; 
	}
	$(obj).attr('data-href',url);
	Hui_admin_tab(obj);
}