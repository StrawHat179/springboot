<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>$Title$</title>
</head>
<body>
<!--这是html的注释-->
<#--这是freemarker的注释-->
<div>名字：${name}</div>
<div>性别：${sex}</div>
<div>字符串长度：${name?length}</div>

<h1>遍历演示</h1>
<#list userList as item>
    <div>${item}</div>
</#list>
</body>
</html>