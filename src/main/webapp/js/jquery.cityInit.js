function init() {
	alert("init");
	// 省市区街道联动
      //扩展显示行政区划第四级(街道)信息：
    var $town = $('#town');
    //
    var townFormat = function(info){
    //将
    $town.hide().empty();
    if(info['code']%1e4&&info['code']<7e6){	//是否为“区”且不是港澳台地区
    	$.ajax({
    		url: '${pageContext.request.contextPath}/resources/streets/'+info['code']+'.json',
    		dataType:'json',
    		required:false,
    	    nodata:'disabled',
    		success:function(town){
    			/*if(null!=town){
	    			$town.show();
	    			for(i in town){
	    					$town.append('<option value="'+i+'">'+town[i]+'</option>');
	    			}
    			}*/
    			alert("town情况：");
    			for(i=0; i<4; i++){
    				$town.append('<option value="2">town</option>');
    			}
    		}
    	});
    }
    };
    
    
    
    
    var province1 = $("#province1").val();
    var city1 = $("#city1").val();
    var area1 = $("#area1").val();
    $('#jqcities').citys({
        province:province1,
        city:city1,
        area:area1,
        onChange:function(info){
        	townFormat(info);
        }
    },function(api){
        var info = api.getInfo();
        townFormat(info);
    });
    setTimeout(function(){
        var town1 = $("#town1").val();
        var elemTown = document.getElementById("town");
        var selIndex = 0;
        for(var i=0; i<elemTown.children.length; i++){
        	if (elemTown.children[i].text==town1) {
        		selIndex = i;break;
			}
        }
        elemTown.selectedIndex = selIndex;
    },1000);
	// 省市区街道联动
	$('.right_wp').css('background-color','#f3f3f3');
	$('.right_wp_box').css({'width':'1065px','border':'0'});
	$('.right_wp').css({'min-height':'900px','width':'1065px'});
	$('.title').css('width','1045px');
	if ($("#success").val() == 'true') {
		$("input:radio[name=addressType]").click(function() {
			var type = $(this).val();
			if (type == "1") {
				$("#revAddress").focus();	// 切换时，重新验证
				$("#revOtherAddress").attr("disabled", false);
				$("#revAddress").attr("disabled", true);
			} else {
				$("#revOtherAddress").focus();	// 切换时，重新验证
				$("#revAddress").attr("disabled", false);
				$("#revOtherAddress").attr("disabled", true);
			}
		});
	}
	
	isEdit = $('#isEdit').val();
	$.each($("input[name=nums]"), function() {
		if (lastGiftIds != "") {
			lastGiftIds += ",";
			lastNums += ",";
		}
		lastGiftIds += $(this).parent().find("input:hidden[name=ids]").val();
		lastNums += $(this).val();
	});
	
	$.each($("input[name=numsNotLive]"), function() {
		if (lastIdsNotlive != "") {
			lastIdsNotlive += ",";
			lastNumsNotlive += ",";
		}
		lastIdsNotlive += $(this).parent().find("input:hidden[name=idsNotLive]").val();
		lastNumsNotlive += $(this).val();
	});
	
	$.each($("input[name=numsLive]"), function() {
		if (lastIdslive != "") {
			lastIdslive += ",";
			lastNumslive += ",";
		}
		lastIdslive += $(this).parent().find("input:hidden[name=idsLive]").val();
		lastNumslive += $(this).val();
	});
	
	if($("#commentUserString").val()){
		$("#revComment").val($("#commentUserString").val());
	}
	
	alert("init完成，恭喜");
	
}