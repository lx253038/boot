
let pathName = document.location.pathname;
let index = pathName.substr(1).indexOf("/");
let contextPath = pathName.substr(0,index+1);
document.write("<script src='"+contextPath+"/static/layer/layui.js' charset='utf-8'></script>");
document.write("<script src='"+contextPath+"/static/js/jquery-3.0.0.min.js' charset='utf-8'></script>");


setTimeout(function () {
	layui.use(['layer','form']);
}, 100)

//表格初始化
function tableInit(table, params) {
	if (params != null && typeof (params) != "undefined") {

	} else {
		params = {};
	}
	let cols = null;
	if (params.colspan == undefined ? false : params.colspan) {
		cols = params.cols == undefined ? '' : params.cols   //列合并
	} else {
		cols = params.cols == undefined ? '' : [params.cols]
	}

	table.render({
		id: params.id == undefined ? 'idTest' : params.id   //table实例Id
		, elem: params.elem == undefined ? '#demo' : params.elem  //绑定元素（必须或者默认id为demo）*******************
		, width: params.width == undefined ? '' : params.width
		, autoSort: params.serverSort == undefined ? false : !params.serverSort  //禁用前端自动排序
		, even: params.even == undefined ? true : params.even  //开启隔行背景
		, height: params.height == undefined ? '' : params.height
		, url: params.url == undefined ? '' : params.url   //请求数据url必须   *****************************
		, title: params.title == undefined ? 'XXX表单' : params.title   //标题最好提供数值
		, totalRow: params.totalRow == undefined ? false : params.totalRow //开启合计行
		, request: {
			pageName: 'pageNum' //页码的参数名称，默认：page
			, limitName: 'pageSize' //每页数据量的参数名，默认：limit
		}
		, method: 'post'
		, where: params.search == undefined ? {} : params.search   //查询条件
		, page: params.page == undefined ? true : params.page //开启分页
		, toolbar: params.toolbar == undefined ? 'default' : params.toolbar   //开启头部工具栏  '#toolbarDemo' //指向自定义工具栏模板选择器
		// true 仅开启工具栏，不显示左侧模板   false 不显示    'default' //让工具栏左侧显示默认的内置模板  '<div>xxx</div>' //直接传入工具栏模板字符
		, cols: cols        //表格要显示的数据  *****************************
		, done: params.done == undefined ? function () { } : params.done  //数据渲染完的回调。你可以借此做一些其它的操作
	});

	//是否监听排序事件
	if (params.serverSort == undefined ? true : params.serverSort) {
		table.on('sort(' + (params.filter == undefined ? 'test' : params.filter) + ')', function (obj) { //注：sort是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
			// console.log(obj.type); //当前排序类型：desc（降序）、asc（升序）、null（空对象，默认排序）
			/*			let type = obj.type
                        let msg;
                        if (type == null) {
                            msg = '服务端排序。恢复默认顺序 default'
                        } else {
                            msg = '服务端排序。order by ' + this.context.innerText + ' ' + type
                        }*/
			let sortIcon = layer.load(2, {
				shade: [0.1,'#fff'] //0.1透明度的白色背景
			});
			//尽管我们的 table 自带排序功能，但并没有请求服务端。
			//有些时候，你可能需要根据当前排序的字段，重新向服务端发送请求，从而实现服务端排序，如：
			table.reload(params.id == undefined ? 'idTest' : params.id, {
				initSort: obj //记录初始排序，如果不设的话，将无法标记表头的排序状态。
				, where: { //请求参数（注意：这里面的参数可任意定义，并非下面固定的格式）
					'sortName': obj.field //排序字段
					, 'sortType': obj.type //排序方式
				},
				page:{curr:1} , //默认回到第一页
				done:function () {
					layer.close(sortIcon);
				}
			});

		});
	}



}

//选择框
function showPopWin(url, width, height, title, args) {
	if (args != null && typeof (args) != "undefined") {

	} else {
		args = {};
	}
	let btnVal = null;
	if ((args.btn == undefined ? false : args.btn) || url.indexOf(".jsp") != -1) {//按钮
		btnVal = ['确定', '清空', '取消'];
	}
	let _layer;//默认最顶层窗口
	if (args.selfWin == undefined ? false : args.selfWin) {//当前页弹窗或者所有
		_layer = layer;
	}else{
		_layer= window.top.layer
	}

	if (width == null || width == '') {
		width = "700px"
	} else if (typeof (width) == 'number') {
		width = width + 300 + "px" //由于之前设置的值偏小，现高度、宽度增加100
	}
	if (height == null || height == '') {
		height = "600px"
	} else if (typeof (height) == 'number') {
		height = height + 300 + "px"
	}
	let _windowxIndex = _layer.open({
		type: 2,
		anim: 0,
		title: title,
		area: [width, height],
		content: url,
		maxmin: true,
		shadeClose: args.shadeClose == undefined ? false : args.shadeClose,
		resize: false,
		shade: args.shade == undefined ? 0.5 : args.shade,
		scrollbar: false,
		skin: args.skin == undefined ? 'layui-layer-lan' : args.skin,
		btn: btnVal,
		end: function () {
			if (typeof(args.reload) != undefined && args.reload){
				setTimeout(function () {//自定义时间延时刷新
						reloadTable(typeof (args.tableId) == undefined ? 'idTest' : args.tableId)
					}, args.time == undefined ? 0 : args.time
				)
			}

			if (typeof (args.reloadFrm) != undefined && args.reloadFrm) {
				window.reloadFrm();
			}
			if (typeof (args.reloadWin) != undefined && args.reloadWin) {
				window.location.reload();
			}
			if (typeof (args.closeWin) != undefined && args.closeWin) {
				window.parent.hidePopWin();
			}
		}
		, success: function (layero, index) {
			if (args.succFun == undefined ? false : args.succFun) {//成功后是否回调
				let iframeWin = window.top[layero.find('iframe')[0]['name']]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
				iframeWin.initDataByWin(window)  //将当前的window对象传递到子页面中
			}
		}
		, yes: function (index, layero) {//确定
			let iframeWin = window.top[layero.find('iframe')[0]['name']]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
			if (iframeWin.setParentVal(window)) {
				window.top.layer.close(index)
			} else {
				return false
			}
		}
		, btn2: function (index, layero) {//清空
			let iframeWin = window.top[layero.find('iframe')[0]['name']];
			iframeWin.clearParentVal(window)
		}
		, btn3: function (index, layero) {//取消

		}
	});

	return  _windowxIndex;
}

//关闭所有弹框
function hidePopWin() {
	window.top.layer.close(window.top.layer.getFrameIndex(window.name))
}

//table数据重新加载
function reloadTable(_id) {
	if (typeof(_id) == "undefined" || typeof(_id) == undefined || _id == null ||_id == ''){
		_id = 'idTest'
	}
	try {
		layui.table.reload(_id, {
			page: {curr: 1}//默认回到第一页
		});
	} catch (e) {
		window.location.reload();
	}

}


function reloadTableBySearch(id, tableId) {//查询条件刷新Table  id：form表单Id  tableId:表格初始化Id
	let elements = document.getElementById(id).elements;
	let selectDatasJson = "{";
	for (let i = 0; i < elements.length; ++i) {
		if ((elements[i].tagName == 'input' || elements[i].tagName == 'INPUT' || elements[i].tagName == 'select' || elements[i].tagName == 'SELECT') && elements[i].getAttribute('name') != null) {
			selectDatasJson += "'" + elements[i].getAttribute('name') + "':'" + elements[i].value + "',";
		}
	}
	selectDatasJson = selectDatasJson.substring(0, selectDatasJson.lastIndexOf(',')) + '}';

	if (typeof (tableId) == "undefined" || typeof (tableId) == undefined || tableId == null || tableId == '') {
		tableId = 'idTest'
	}
	try {
		layui.table.reload(tableId, {
			page: {curr: 1},//默认回到第一页
			where: eval('(' + selectDatasJson + ')')
		});
	} catch (e) {
		window.location.reload();
	}
}

function resetTable(id, tableId) {//查询条件刷新Table  id：form表单Id  tableId:表格初始化Id
	$("#" + id)[0].reset();
	$("input[type='hidden']").val("")//清空表单信息
	reloadTableBySearch(id, tableId);
}

/*
    上传附件
*/
function Upload(guid, domId) {
	showPopWin('/ais/commons/file/welcome.action?guid=' + guid + '&deletePermission=true&domId=' + domId, "90%", "90%", "上传附件", {succFun: true});
	//parent.setAutoHeight();
}

/**
 * 初始化查询条件框样式
 */
function initOption(tableId) {
	if (tableId != null) {
		let table = $("#" + tableId);
		if (table != null && table != 'undefined') {
			let trs = $("#" + tableId).find("tr");
			if (trs != null && trs.length > 0) {
				for(let i = 1; i < trs.length - 1; ++i) {
					trs[i].setAttribute('name', '_optionRow');
					trs[i].style.display = 'none';
				}
			}
		}
		//
	} else {
		let _options = document.getElementsByName("_optionRow");
		if (_options != null && _options.length > 0) {
			for(let i = 0; i < _options.length; ++i) {
				_options[i].style.display = 'none';
			}
		}
	}
}

/**
 * 查询条件展开收缩
 */
function openOption(thisdoc) {
	if (thisdoc != null) {
		let _options = document.getElementsByName("_optionRow");
		// let _openOption = document.getElementById("_openOption");

		if (_options != null && _options.length > 0) {
			if (thisdoc.innerText == "展开") {
				for(let i = 0; i < _options.length; ++i) {
					_options[i].style.display = '';
				}
				thisdoc.innerText = "收起";
			} else {
				for(let i = 0; i < _options.length; ++i) {
					_options[i].style.display = 'none';
				}
				thisdoc.innerText = "展开";
			}
		}
	}
}

/**
 * 金额格式化
 * @param amount
 * @returns {*|string}
 */
function formatAmount(amount) {

	return amount.toFixed(2).replace(/(\d)(?=(\d{3})+\.)/g, '$1,');
}