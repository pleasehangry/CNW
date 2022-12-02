<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<!-- Main content -->
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<div class="content-header">
		<div class="container-fluid">
			<div class="row mb-2">
				<div class="col-sm-6">
					<h1 class="m-0 text-dark"></h1>
				</div>
			</div>
			<!-- /.row -->
		</div>
		<!-- /.container-fluid -->
	</div>
	<!-- /.content-header -->
	<section class="content">

		<div class="container-fluid">
			<div class="row">
				<div class="col-md-3"></div>
				<div class="col-md-6">
					<!-- general form elements -->
					<div class="card card-primary">
						<div class="card-header" style = "background-color:#00a181; border-color:#00a181;">
							<h3 class="card-title">Thêm Đọc Giả</h3>
						</div>
						<div class="row justify-content-center"
							style="margin-top: 15px; margin-bottom: -15px;">
							<div style="color: red;">${errorString}</div>
						</div>
						<!-- /.card-header -->
						<!-- form start -->
						<form role="form" method="post"
							action="${pageContext.request.contextPath}/AddUser">

							<div class="card-body">
								<div class="form-group">
									<label>Nhập tên sách</label> <input type="text"
										class="form-control" id="name" name="username"
										placeholder="Username...">
								</div>
								<div class="form-group">
									<label>Nhập Mật Khẩu</label> <input type="password"
										class="form-control" id="count" name="password">
								</div>
							</div>
							<div class="card-footer">
								<button type="submit" class="btn btn-primary " style = "background-color:#00a181; border-color:#00a181;">Lưu</button>
								<input type="button" value="Trở lại" class="btn btn-primary"
									onclick="location.href='${pageContext.request.contextPath}/ManageUser'" style = "background-color:#00a181; border-color:#00a181;">
							</div>
						</form>
					</div>
				</div>
				<!-- /.row -->
			</div>
			<!-- /.container-fluid -->
	</section>
	<!-- /.content -->
	<%@ include file="footer.jsp"%>
	<!-- jQuery -->
	<script src="./Resources/plugins/jquery/jquery.min.js"></script>

	<script
		src="./Resources/plugins/bs-custom-file-input/bs-custom-file-input.min.js"></script>
	<!-- AdminLTE App -->
	<script src="./Resources/js/adminlte.min.js"></script>
	<!-- AdminLTE for demo purposes -->
	<script src="./Resources/js/demo.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			bsCustomFileInput.init();
		});
	</script>
	<!-- /.card -->