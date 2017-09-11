<html>
<body>
	<h2>入力画面</h2>
	<form:form action="${submitUrl}" modelAttribute="echoForm">
		<div>テキストを入力してください：</div>
		<div>
			<form:input path="text" />
			<form:errors path="text" />
		</div>
		<br/>
		<div>
			<form:select path="selectTest" items="${echoForm.selectTestList}" itemLabel="name" itemValue="id" delimiter=" "/>
			<form:errors path="selectTest" />
		</div>
		<br/>
		<div>
			<form:button>送信</form:button>
		</div>
	</form:form>
</body>
</html>