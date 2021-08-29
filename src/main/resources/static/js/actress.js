$(document).ready(function(){
    $("#actress-list").dataTable({
        language: {
            url: "https://cdn.datatables.net/plug-ins/3cfcc339e89/i18n/Japanese.json"
        },
        stateSave: true
    });

    $(".btn-nice").on("click", function(event) {
        console.log("投票開始!!")
        $.ajax({
            type: "POST",
            url: "api/system/nice",
            data: JSON.stringify({
                actressId: $(this).closest("tr").find(".actress-id").val(),
                userId: $(this).closest("tr").find(".user-id").val()
            }),
            contentType: "application/json",
            dataType: "json"
        })
        .done(function(data) {
            console.log("投票完了!!")
            $("#" + data.actressId).text(data.niceCnt)
        })
        .fail(function(err) {
            console.error("投票失敗", err)
        });
    });
});