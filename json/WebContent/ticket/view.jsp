<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="/json/client/js/AjaxUtil.js"></script>
<body>

	<table border="1">
		<tr>
			<th>번호</th>
			<td data-col="tmnum"></td>
		</tr>
		<tr>
			<th>영화명</th>
			<td><input type="text" name="tmname" data-col="tmname"></td>
		</tr>
		<tr>
			<th>개봉일</th>
			<td><input type="text" name="tmstartdat" data-col="tmstartdat"></td>
		</tr>
		<tr>
			<th>종영일</th>
			<td><input type="text" name="tmenddat" data-col="tmenddat"></td>
		</tr>
		<tr>
			<th>등록일자</th>
			<td><input type="text" name="tmcredat" data-col="tmcredat"></td>
		</tr>
		<tr>
			<th>관객수</th>
			<td><input type="text" name="tmcnt" data-col="tmcnt"></td>
		</tr>
	</table>
		<button onclick="updateTicket()">수정</button><button onclick="deleteTicket()">삭제</button>
<script>
var tmnum = <%=request.getParameter("tmnum")%>;

	function updateTicket(){
		
		var tmname = document.querySelector('input[name=tmname]').value;
		var tmstartdat = document.querySelector('input[name=tmstartdat]').value;
		var tmenddat = document.querySelector('input[name=tmenddat]').value;
		var tmcredat = document.querySelector('input[name=tmcredat]').value;
		var tmcnt = document.querySelector('input[name=tmcnt]').value;
		var params = {tmnum:tmnum, tmname:tmname, tmstartdat:tmstartdat, tmenddat:tmenddat, tmcredat:tmcredat, tmcnt:tmcnt};
	var conf = {url:'/json/api/ticket/insert', method:'PUT', params:params, cb:callback};
	var au = new AjaxUtil(conf);
	au.send();
	function callback(res){
		res=JSON.parse(res);
		if(res.rCnt==1){
			alert('수정완료');
			location.href='/json/ticket/list.html';
			return;
		}
		alert('수정 실패');
	}
}


	function deleteTicket(){
		var params = {tmnum:tmnum};
		var conf = {url:'/json/api/ticket/insert', method:'DELETE', params:params, cb:callback};
		var au = new AjaxUtil(conf);
		au.send();
		function callback(res){
			res=JSON.parse(res);
			if(res.rCnt==1){
				alert('삭제완료');
				location.href='/json/ticket/list.html';
				return;
			}
			alert('삭제 실패');
		}
	}
	
	window.onload = function(){
		var conf = {url:'/json/api/ticket/view', params:{tmnum:tmnum}, cb:callback};
		var au = new AjaxUtil(conf);
		au.send();
		
		
		function callback(res){
			res = JSON.parse(res);
			var tds = document.querySelectorAll('input[data-col]');
			var td = document.querySelector('td[data-col]')
			var attr = td.getAttribute('data-col');
			td.innerHTML = res[attr];
			for(var td of tds){
				td.value = res[td.getAttribute('data-col')];
			}
		
		}
	}
</script>	
</body>