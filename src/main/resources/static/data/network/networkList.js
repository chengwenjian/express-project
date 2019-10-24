var active = {
    setTop: function(){
        var that = this;
        layer.open({
            type: 1
            ,offset: type //具体配置参考：http://www.layui.com/doc/modules/layer.html#offset
            ,id: 'layerDemo'+type //防止重复弹出
            ,content: '<div style="padding: 20px 100px;">'+ text +'</div>'
            ,btn: '关闭全部'
            ,btnAlign: 'c' //按钮居中
            ,shade: 0 //不显示遮罩
            ,yes: function(){
                layer.closeAll();
            }
        });
    }}