$(function() {

	$('#addDoc').click(function() {
		var documentTitle = $('#documentTitle').val();
		var documentNo = $('#documentNo').val();
		var documentUser = $('#documentUser').val();
		var doucmentContent = $('#doucmentContent').val();
		var documentRemark = $('#documentRemark').val();
		var documentType = $("#documentType  option:selected").val();
		var documentDept = $("#documentDept  option:selected").val();
		var documentSpeed = $('input[type=radio][name=documentSpeed]:checked').val();
		var documentConfidential = $('input[type=radio][name=documentConfidential]:checked').val();
		var documentProcess = $("#documentProcess  option:selected").val();
		var data = {
			"documentTitle": documentTitle,
			"documentNo": documentNo,
			"documentUser": documentUser,
			"documentType": documentType,
			"documentDept": documentDept,
			"documentSpeed": documentSpeed,
			"documentConfidential": documentConfidential,
			"doucmentContent": doucmentContent,
			"documentRemark": documentRemark,
			"documentProcess": documentProcess,
		}

		$.ajax({
			type: "post",
			url: "http://localhost:8080/gwspxt/addDocument",
			dataType: "json",
			contentType: 'application/json;charset=UTF-8',
			data: JSON.stringify(data),
			success: function(data) {
				if(data) {
					var documentId = data.documentId;
					$.ajax({
						type: "post",
						url: "http://localhost:8080/gwspxt/updateDocumentState",
						dataType: "json",
						data: JSON.stringify(data),
						contentType: 'application/json;charset=UTF-8',
						success: function(data) {
							$.ajax({
								type: "post",
								url: "http://localhost:8080/gwspxt/messageNextOne",
								dataType: "json",
								data: {
									documentId: documentId,
								},
								success: function(data) {
									window.location.href = "http://localhost:8080/gwspxt/reviewDocument";
								}
							});

						}
					});
				} else {

				}
			}
		});

	});

})