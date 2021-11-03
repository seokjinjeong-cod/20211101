<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Custom styles for this page -->
<link href="vendor/datatables/dataTables.bootstrap4.min.css"
	rel="stylesheet">
<script type="text/javascript">
	$(document).ready(function() {
		var tb = $("<tbody />");
		$.ajax({
			url : "ajaxMemberList.do",
			dataType : "json",
			success : function(data) {
				console.log(data)
				if(data.length > 0){
					for(var i in data){
						var id = data[i].id;
						var name = data[i].name;
						var address = data[i].address;
						var tel = data[i].tel;
						var author = data[i].author;
						
						var tr = $("<tr />").append(
								$("<td />").text(id),
								$("<td />").text(name),
								$("<td />").text(address),
								$("<td />").text(tel),
								$("<td />").text(author)
						);
						tb.append(tr);
					}
					$("#example").append(tb);
				}
			}
		})
	});
</script>

</head>
<body>
<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">Member List</h1>

	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">회원 정보</h6>
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table id="example" class="display">
					<thead>
						<tr>
							<th>ID</th>
							<th>Password</th>
							<th>Address</th>
							<th>Telephone</th>
							<th>Author</th>
						</tr>
					</thead>
				</table>
			</div>
		</div>
	</div>

</div>
<!-- Page level plugins -->
<script src="vendor/datatables/jquery.dataTables.min.js"></script>
<script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

<!-- Page level custom scripts -->
<script src="js/demo/datatables-demo.js"></script>
</body>
</html>