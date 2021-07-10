$(document).ready(function() {
	$(".unimplemented-btn").on("click", function() {
        $("#notYetDialog").dialog({
            title: "お知らせ",
        	autoClose: false,
        	modal: false,
        	buttons: {
        		"OK": function() {
        			$(this).dialog("close");
        	    }
            }
	    });
	});
});
