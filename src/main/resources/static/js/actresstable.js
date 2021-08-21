$(document).ready(function(){
    $("#actress-list").dataTable({
        language: {
            url: "https://cdn.datatables.net/plug-ins/3cfcc339e89/i18n/Japanese.json"
        },
        stateSave: true
    });

    $(".btn-nice").on("click", function(event) {
        console.log("投票開始!!")
        var niceData = JSON.stringify({
            actressId: $(this).closest("tr").find(".actressId").val(),
            userId: $(this).closest("tr").find(".userId").val()
        });
        console.log("要求=",niceData)
        $.ajax({
            type: "POST",
            url: "api/system/nice",
            data: niceData,
            contentType: "application/json",
            dataType: "json"
        })
        .done(function(data) {
            console.log("投票完了!!")
            console.log(data)
            var e = $("#" + data.actressId)
            console.log(e)
            $("#" + data.actressId).text(data.niceCnt)
        })
        .fail(function(err) {
            console.error("投票失敗")
        });
    });
});