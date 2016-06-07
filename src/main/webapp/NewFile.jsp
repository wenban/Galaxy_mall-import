<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>DOM动态删除TABLE多行</title>
<script type="text/javascript">
function $(objId){
return document.getElementById(objId);
}
function del_tbl(tblN,ckN){
var ck = document.getElementsByName(ckN);
    var tab = $(tblN);
var rowIndex;
for(var i=0;i<ck.length;i++){
        if(ck[i].checked){
rowIndex = ck[i].parentNode.parentNode.sectionRowIndex;
         tab.deleteRow(rowIndex);
i = -1;
}
}
}</script>
</head>
<body>
<form id="form1" name="form1" method="post" action="">
<table width="253" border="1" align="center" id="list">
<tr>
<td><input type="checkbox" name="cb_k" id="cb_k" /></td>
<td>2</td>
<td>3</td>
</tr>
<tr id="tr1">
<td width="28" height="41"><input type="checkbox" name="del" id="del" /></td>
<td width="124"><div align="center">第一行 </div></td>
<td width="79"><div align="center">1</div></td>
</tr>
<tr id="tr2">
<td height="36"><input type="checkbox" name="del" id="del" /></td>
<td><div align="center">第二行 </div></td>
<td><div align="center">2</div></td>
</tr>
<tr id="tr3">
<td height="40"><input type="checkbox" name="del" id="del" /></td>
<td><div align="center">第三行 </div></td>
<td><div align="center">3</div></td>
</tr>
<tr id="tr4">
<td height="37"><input type="checkbox" name="del" id="del" /></td>
<td><div align="center">第四行 </div></td>
<td><div align="center">4</div></td>
</tr>
<tr id="tr5">
<td height="50"><input type="checkbox" name="del" id="del" /></td>
<td><div align="center">第五行 </div></td>
<td><div align="center">5</div></td>
</tr>
<tr>
<td colspan="3">
<div align="center">
<input type="button" name="btn_del" id="btn_del" value="删 除" onclick="del_tbl('list','del')"/>
</div></td>
</tr>
</table>
</form>
</body>
</html> 