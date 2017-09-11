<html>
<body>
	<h2>出力画面</h2>
	<div>入力したテキストは・・・</div>
	<div>
		<span><c:out value="${echoForm.text}" /></span>
	</div>
	<br/>
	<div>選択されたIDは</div>
	<div>
		<span><c:out value="${echoForm.selectTest}" /></span>
	</div>
	<br/>
	<div>チェックボックスは</div>
	<div>
		<span><c:out value="${echoForm.checkTest}" /></span>
	</div>
	<br/>
	<div>複数選択チェックボックスは</div>
	<div>
		<c:forEach items="${echoForm.checkBoxesTest}" var="id">
   			<c:out value="${id}" />
  		</c:forEach>
	</div>
	<div>です。</div>
	<br>
	<div>
		<a href="<c:url value='/' />">トップ画面へ戻る</a>
	</div>
</body>
</html>