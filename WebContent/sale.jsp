<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%String ctxPath=request.getContextPath(); %>
	<meta charset="utf-8">
    <title>index</title>
    <style>
    	body{
    		margin: 0;
    		padding: 0;
    		text-align: center;
    	}
    	header{
    		height: 30px;
    		line-height: 50px;
    		font: 30px 黑体;
    		padding: 10px 0;
    		background: #ff552e;
    		color: #fff;
    		letter-spacing: 10px;
    		margin-bottom: 10px;
    		user-select: none;
    	}
    	form{
    		margin: auto;
    		/* 整个表格往左动 数越大越往左 */
    		margin-right: 300px;
    		text-align: center;
    	}
    	.form-content table{
    		margin: auto;
    		font-size: 14px;
    	}
    	.form-content tr {
    		height: 50px;
    		line-height: 50px;
    	}
    	.form-content tr td:first-child{
    		text-align: right;
    		color: grey;
    		vertical-align: top;
    	}
    	.form-content tr td:nth-child(2){
    		width: 20px;
    	}
    	.form-content tr td:last-child{
    		text-align: left;
    		color: grey;
    	}
    	.hoverToPointer:hover{
    		cursor: pointer;
    	}
    	.inputFileIcon{
    		width: 96px;
    		height: 90px;
    		background-image: url(images/icons_edit.png);
    	}
    	.inputFileWithoutIcon{
    		width: 96px;
    		height: 90px;
    	}
    	#drivingBook{
    		background-position: -106px 0;
    		margin: auto;
    	}
    	#engineImg{
    		background-position: -106px 0;
    		margin: auto;
    	}
    	#carImg{
    		background-position: -106px 0;
    		margin: auto;
    	}
    	input[type=file]{
    		display: none;
    	}
    	input[type=number],input[type=date],input[type=text]{
    		border: 1px solid #e0e0e0;
    		height:20px;
    		padding: 7px;
    		margin-right: 5px;
    		width: 185px;
    	}
    	textarea{
    		border: 1px solid #e0e0e0;
    		height:50px;
    		padding: 7px;
    		margin-right: 5px;
    		width: 300px;
    	}
    	textarea::-webkit-input-placeholder{
            color:#aaa;
        }
    	input[type=submit]{
    		margin: 50px;
    		background: #ff552e;
    		border: none;
    		border-radius: 5px;
    		color: #fff;
    		height: 40px;
    		width: 100px;
    		font-size: 20px;
    	}
    	.required{
    		margin-right: 5px;
    		color: red;	
    	}
    </style>
</head>
<body>
<header>我要卖车</header>
请输入信息
<form action="<%=ctxPath%>/PictureServlet" method="post" enctype="multipart/form-data">

	<div class="form-content">
		<table>
			<tr>
				<td><span class="required">*</span> 行驶证</td>
				<td></td>
				<td><input type="file" name="drivingBookImg" required /><div id="drivingBookDiv"><div id="drivingBook" class="hoverToPointer inputFileIcon"></div></div></td>
			</tr>
			<tr>
				<td><span class="required">*</span> 发动机证</td>
				<td></td>
				<td><input type="file" name="engineImg" required/><div id="engineImgDiv"><div id="engineImg" class="hoverToPointer inputFileIcon"></div></div></td>
			</tr>
			<tr>
				<td><span class="required">*</span>汽车照片</td>
				<td></td>
				<td><input type="file" name="carImg" required/><div id="carImgDiv"><div id="carImg" class="hoverToPointer inputFileIcon"></div></div></td>
			</tr>
			<tr>
				<td><span class="required">*</span>汽车品牌</td>
				<td></td>
				<td><input type="text" name="carBrand" required/></td>
			</tr>
			<tr>
				<td><span class="required">*</span> 购买时间</td>
				<td></td>
				<td><input type="date" name="buyTime" required/></td>
			</tr>
			<tr>
				<td><span class="required">*</span> 车型</td>
				<td></td>
				<td><input type="text" name="vehicleType" list="carList" required/></td>
			</tr>
			<tr>
				<td><span class="required">*</span> 里程</td>
				<td></td>
				<td><input type="number" name="mileage" pattern="\d{0,}" required/>万公里</td>
			</tr>
			<tr>
				<td><span class="required">*</span> 价格</td>
				<td></td>
				<td><input type="number" step="0.1" name="price" required/> 万元</td>
			</tr>
			<tr>
				<td><span class="required">*</span> 车况描述</td>
				<td></td>
				<td><textarea name="condition" required placeholder="我的车外观有无剐蹭喷漆、发动机、变速箱有无故障、电子系统是否正常"></textarea></td>
			</tr>
		</table>
		<datalist id="carList">
			<option>越野车</option>
			<option>跑车</option>
			<option>轿车</option>
		</datalist>
	</div>
	<input type="submit" value="发布">
</form>

<%if ((String)session.getAttribute("loginName") == null) {
	request.getRequestDispatcher("login.jsp").forward(request, response);
}%>
Login Name:<% String name = (String)session.getAttribute("loginName") ;
        out.print(name);
%>

</body>
<script>
let drivingBookImgInput = document.getElementsByName("drivingBookImg")[0];
let drivingBookImgIcon = document.getElementById('drivingBook');
drivingBookImgIcon.onclick = function(){
	drivingBookImgInput.click();
}
drivingBookImgInput.onchange = function() {
	drivingBookImgIcon.className = 'hoverToPointer inputFileWithoutIcon';
	let reader = new FileReader();
	reader.readAsDataURL(this.files[0]);
	reader.onload=function(e) {
		drivingBookImgIcon.innerHTML = '<img src="'+e.target.result+'" width="96" height="90px"/>'
	}
}
let engineImgInput = document.getElementsByName("engineImg")[0];
let engineImgIcon = document.getElementById('engineImg');
engineImgIcon.onclick = function(){
	engineImgInput.click();
}
engineImgInput.onchange = function() {
	engineImgIcon.className = 'hoverToPointer inputFileWithoutIcon';
	let reader = new FileReader();
	reader.readAsDataURL(this.files[0]);
	reader.onload=function(e) {
		engineImgIcon.innerHTML = '<img src="'+e.target.result+'" width="96" height="90px"/>'
	}
}

let carImgInput = document.getElementsByName("carImg")[0];
let carImgIcon = document.getElementById('carImg');
carImgIcon.onclick = function(){
	carImgInput.click();
}
carImgInput.onchange = function() {
	carImgIcon.className = 'hoverToPointer inputFileWithoutIcon';
	let reader = new FileReader();
	reader.readAsDataURL(this.files[0]);
	reader.onload=function(e) {
		carImgIcon.innerHTML = '<img src="'+e.target.result+'" width="96" height="90px"/>'
	}
}
</script>
</html>

