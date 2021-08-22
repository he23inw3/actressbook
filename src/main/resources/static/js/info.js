$(document).ready(function(){
    var category = $(".news-category")
    category.each(function(index, element) {
        switch($(element).text()) {
            case "SALE":
                $(element).addClass("category-sale")
                break;
            case "RELEASE":
                $(element).addClass("category-release")
                break;
            case "APOLOGY":
                $(element).addClass("category-release")
                break;
            default:
                $(element).addClass("category-undefined")
                break;
        }
    });
});