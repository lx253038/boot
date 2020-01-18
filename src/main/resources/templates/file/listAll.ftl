<#assign path="${springMacroRequestContext.contextPath}">
<!DOCTYPE html>
<html>
<head>
    <title>文件列表</title>
    <link rel="stylesheet" type="text/css" href="${path}/static/layer/css/layui.css">
    <script type="text/javascript" src="${path}/static/js/subModal.js"></script>
    <style>
        body {
            margin: 10px;
        }

    </style>
</head>

<body>
<table class="layui-hide" id="demo" lay-filter="test"></table>


<script type="text/javascript">


    layui.use(['table', 'util'], function () {
        let table = layui.table
            , util = layui.util; //表格
        //向世界问个好
        tableInit(table, {
            title: '文件列表',
            url: 'listFileJson',
            search: {   //定义查询条件参数

            },
            toolbar: '#barDemo',
            cols: [ //表头
                {type: 'checkbox', fixed: 'left', field: 'id', width: 40}
                , {field: 'name', align: 'center', style: 'text-align:left', title: '名称', width: 300, sort: true}
                , {field: 'url', align: 'center', title: '地址', width: 600, sort: true}
                , {field: 'size', align: 'center', title: '大小', width: 160, sort: true}
                , {field: 'type', align: 'center', title: '类型', width: 200, sort: true}
                , {
                    field: 'uploadTime', align: 'center', title: '上传日期', width: 200, sort: true,
                    templet: function (d) {
                        return util.toDateString(d.uploadTime, 'yyyy-MM-dd HH:mm:ss');
                    }
                }
                , {
                    align: 'center', title: '操作', width: 200, sort: false,
                    templet: function (d) {
                        return "<button class='layui-btn layui-btn-danger layui-btn-sm' onclick='deleteFile(\"" + d.id + "\")'>删除</button>" +
                            "<button class='layui-btn  layui-btn-sm' onclick='window.open(\"" + d.url + "\")'>预览</button>" +
                            "<button class='layui-btn  layui-btn-sm' onclick='downLoadFile(\"" + d.url + "\",\"" + d.name + "\")'>下载</button>";
                    }
                }

            ]
        })
    });

    function deleteFile(id) {
        $.post("delById/" + id, function (res) {
            console.log(res)
            if (res.code == 0) {
                layer.msg(res.msg)
                layui.table.reload("idTest")
            }

        });
    }

    function downLoadFile(url, name) {
        window.location.href = "${path}/fileService/downloadFile?fileUrl=" + url + "&fileName=" +encodeURI(name) ;
    }
</script>
</body>
</html>