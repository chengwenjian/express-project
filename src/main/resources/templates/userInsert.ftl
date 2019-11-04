<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>员工添加</title>
    <!--引入css文件-->
    <link rel="stylesheet" href="${basePath!}/static/layui/css/layui.css" media="all" />
    <!--引入js-->

    <script type="text/javascript" src="${basePath!}/static/layui/layui.js"></script>
    <script type="text/javascript" src="${basePath!}/static/js/cache.js"></script>
    <script type="text/javascript" src="${basePath!}/static/js/jquery-2.1.3.min.js"></script>
</head>
<body>
<div>
<#list list as list>
    <form class="layui-form" action="" method="post">
          <div class="layui-form-item">
                    <label class="layui-form-label">所属网点：</label>
                    <div class="layui-input-block">

                           <input type="text" value="${list.braname}" name="braname" id="braname" required  lay-verify="required"  autocomplete="off" class="layui-input" style="width: 200px;">

                    </div>
                    <label class="layui-form-label">员工姓名：</label>
                    <div class="layui-input-block">
                            <input type="text" name="truename" id="truename" required  lay-verify="required"  autocomplete="off" class="layui-input" style="width: 200px;">
                    </div>

                    <label class="layui-form-label">用户账号：</label>
                    <div class="layui-input-block">
                        <input type="text" name="username" id="username" required  lay-verify="required"  autocomplete="off" class="layui-input" style="width: 200px;">
                    </div>

                    <label class="layui-form-label">用户密码：</label>
                    <div class="layui-input-block">
                        <input type="text" name="password" id="password" required  lay-verify="required"  autocomplete="off" class="layui-input" style="width: 200px;">
                    </div>

                    <label class="layui-form-label">手机：</label>
                    <div class="layui-input-block">
                            <input type="text" name="staphone" id="staphone" required  lay-verify="required"  autocomplete="off" class="layui-input" style="width: 200px;">
                       </div>
                    <label class="layui-form-label">地址：</label>
                    <div class="layui-input-block">
                            <input type="text" name="staaddress" id="staaddress" required  lay-verify="required"  autocomplete="off" class="layui-input" style="width: 300px;">
                        </div>
                    <label class="layui-form-label">身份证号：</label>
                    <div class="layui-input-block">
                            <input type="text" name="staidcard" id="staidcard" required  lay-verify="required"  autocomplete="off" class="layui-input" style="width: 300px;">
                        </div>

                </div>
            <#--<div class="layui-upload">-->
                <#--<button class="layui-btn" id="test1" type="button">上传身份证正面图片</button>-->
                <#--<div class="layui-upload-list">-->
                    <#--<img class="layui-upload-img" id="demo1">-->
                    <#--<p id="demoText"></p>-->
                <#--</div>-->
           <#--</div>-->
            <#--<div class="layui-upload">-->
                    <#--<button class="layui-btn" id="test2" type="button">上传身份证反面图片</button>-->
                    <#--<div class="layui-upload-list">-->
                        <#--<img class="layui-upload-img" id="demo2">-->
                        <#--<p id="demoText2"></p>-->
                    <#--</div>-->
                <#--</div>-->
            <div class="layui-form-item">
                    <div class="layui-input-block">
                           <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
                            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                        </div>
               </div>
        </form>
</#list>
    </div>
</body>
<script type="text/javascript">
    layui.use(['laydate', 'laypage', 'layer', 'table','form'], function(){
        var laydate = layui.laydate //日期
            ,laypage = layui.laypage //分页
            ,layer = layui.layer //弹层
            ,table = layui.table //表格
            ,form = layui.form
            ,select=layui.select;


        form.on('submit(formDemo)', function(data){

            $.ajax({
                url:'/userEdit/toInsert',
                method:'post',
                data:{
                    braname:$("#braname").val(),
                    truename:$("#truename").val(),
                    staphone:$("#staphone").val(),
                    staaddress:$("#staaddress").val(),
                    staidcard:$("#staidcard").val(),
                    username:$("#username").val(),
                    password:$("#password").val()
                },
                dataType:'JSON',
                success:function(data){
                    if(data=="1"){
                        var index = parent.layer.getFrameIndex(window.name);
                        parent.layer.close(index);
                        alert('添加成功！');
                    }
                    else{
                        alert('添加失败！');
                        var index = parent.layer.getFrameIndex(window.name);
                        parent.layer.close(index);
                    }
                },
            }) ;
            // var index = parent.layer.getFrameIndex(window.name);
            // parent.layer.close(index);
        })


    });
</script>
</html>