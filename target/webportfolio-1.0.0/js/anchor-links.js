// Source: http://stackoverflow.com/questions/30734552/change-url-while-scrolling
// stackoverflow.com/questions/123999/how-to-tell-if-a-dom-element-is-visible-in-the-current-viewport
function isElementInViewport (el) {
    //special bonus for those using jQuery
    if (typeof jQuery === "function" && el instanceof jQuery) {
        el = el[0];
    }
    var rect = el.getBoundingClientRect();
    return (
        rect.top >= 0 &&
        rect.top <= (window.innerHeight || document.documentElement.clientHeight)
    )
}
// click-to-scroll behavior
$("a.anchor").click(function (e) {
    e.preventDefault();
    var section = this.href;
    var sectionClean = section.substring(section.indexOf("#"));
    $("html, body").animate({
        scrollTop: $(sectionClean).offset().top
    }, 1000, function () {
        window.location.hash = sectionClean;
    });
});

/*TODO: factor in when top of subpage is out of view, and rest of subpage remains in view

        factor in when the top of the sub-page div element is out of view, but ANY part of another section is visible (this can exclude the top if the sub-page
        extends the full length of the window view height), would fix issue on scrolling up and through subpage that extends full window length

    */
//edit function to check if neither bottom or top of div.sub-page is visible, if top of div is not visible. if false on each condition, then ref gl var assigned with the div id (would return last div to have top of the element pass through the window view).
var currentSubPageId = "";

// listen for the scroll event
$(document).on("scroll", function() {
    console.log("onscroll event fired...");
    // check if the anchor elements are visible
    var rectTopInView = false;
    $("div.sub-page").each(function (idx, el) {
        if ( ($(window).scrollTop() != 0) && isElementInViewport(el) ) {
            rectTopInView = true;
            // update the URL hash
            if (window.history.pushState) {
                currentSubPageId = $(el).attr("id");
                var urlHash = "#" + currentSubPageId;
                window.history.pushState(null, null, urlHash);
            }

        }
    });
    console.log("top of div.sub-page element in view: " + rectTopInView);
    if ($(window).scrollTop() == 0) {
        window.location.hash = "";
        window.history.pushState(null, null, "");
    }
});

$(function() {
      $('.back-to-top-fixed').hide();
      $(window).scroll(function() {
            var scroll = $(window).scrollTop();
            if (scroll == 0) {
                  $('.back-to-top-fixed').hide();
                } else {
                  $('.back-to-top-fixed').show();
                }
          });
});
