$.get(location.origin + "/tech-news", function(data) {
  for(var i = 0; i < data.length; i++){
    var techNew = data[i];
    if(techNew.newsSource == 'TECH_CRUNCH'){
        var html = "<div class='col-md-9 md-margin-bottom-50'>"
                        + "<div class='row margin-bottom-50'>"
                            + "<div class='col-sm-3 sm-margin-bottom-20'>"
                                + "<img class='img-responsive' src='assets/tech-news-logos/tech-crunch.jpg' alt=''>"
                            + "</div>"
                  + "<div class='col-sm-8'>"
                        + "<div class='blog-grid'>"
                        + "<h3><a href='" + techNew.redirectUrl + "'>" + techNew.title + "</a></h3>"
                        + "<p>" + techNew.body + "</p>"
                        + "<a class='r-more' href='" + techNew.redirectUrl + "' target='_blank'>Read More</a>"
                    + "</div>"
                + "</div>"
            + "</div>"
        + "</div>";

        $( "#news_body" ).append(html);
    }else if(techNew.newsSource == 'MASHABLE'){
        var html = "<div class='col-md-9 md-margin-bottom-50'>"
                        + "<div class='row margin-bottom-50'>"
                            + "<div class='col-sm-3 sm-margin-bottom-20'>"
                                + "<img class='img-responsive' src='assets/tech-news-logos/mashable.png' alt=''>"
                            + "</div>"
                  + "<div class='col-sm-8'>"
                        + "<div class='blog-grid'>"
                        + "<h3><a href='" + techNew.redirectUrl + "'>" + techNew.title + "</a></h3>"
                        + "<p></p>"
                        + "<a class='r-more' href='" + techNew.redirectUrl + "' target='_blank'>Read More</a>"
                    + "</div>"
                + "</div>"
            + "</div>"
        + "</div>";

        $( "#news_body" ).append(html);
    }
  }
});

var subscribe = function(){
    var email = $( "#subscriptionEmail" ).val();
    $.get(location.origin + "/subscribe/" + email, function(data) {
        alert("subscribed");
    });
};