$(function(){
	$("#count").text(result.count);
	let array = result.array;
	let $array = $("#array");
	for(let i=0;i<array.length;i++){
		let $row = $("<div class='row'></div>");
		$array.append($row);
		for(let j=0;j<array[i].length;j++){
			let $cell = $("<div class='cell color" + array[i][j] + "'></div>");
			$row.append($cell);
		}
	}
});