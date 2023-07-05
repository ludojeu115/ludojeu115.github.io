/* Made by Ludovic Lonlas */

const get_img_viewer_top_element = function (imgviewer) {
    let children = imgviewer
        .children()
        .not(
            ".imgviewer-blur-layer, .imgviewer-button-left, .imgviewer-button-right, .imgviewer-button-center"
        );
    return children[children.length - 1];
};

const update_imgviewer_size = function (imgviewer) {

    let top = get_img_viewer_top_element(imgviewer);
    let ir = top.width / top.height;

    if(imgviewer.hasClass("imgviewer-fullscreen")){
        let or = $(window).width() / $(window).height();
        if(ir > or) {
            let w = $(window).width() * 0.75;
            let h = w / ir;
            imgviewer.width(w);
            imgviewer.height(h);
        }
        else{
            let h = $(window).height() * 0.75;
            let w = h * ir;
            imgviewer.width(w);
            imgviewer.height(h);
        }
    }

    else {

        imgviewer.width(imgviewer.height() * ir);
    }
};
const hover_left = function () {
    $(this).parent().children(".imgviewer-blur-layer").toggleClass("blur-left");
};
const hover_center = function () {
    $(this).parent().children(".imgviewer-blur-layer").toggleClass("blurred");
};
const hover_right = function () {
    $(this)
        .parent()
        .children(".imgviewer-blur-layer")
        .toggleClass("blur-right");
};

const click_back = function (e) {
    if (e.isPropagationStopped()) return;
    $("body").toggleClass("disable-scroll");
    $(this).remove();
};

const click_left = function (e) {
    e.stopPropagation();
    let imgviewer = $(this).parent();
    let images = imgviewer
        .children()
        .not(
            ".imgviewer-blur-layer, .imgviewer-button-left, .imgviewer-button-right, .imgviewer-button-center"
        ); //only select the original content

    let nb_images = images.length;

    if (nb_images < 2) return;

    /*--------------------------------------------------------*/

    imgviewer.find(images[nb_images - 1]).fadeOut(100);
    setTimeout(function () {
        //add the element as the end of the stack
        let last_element = imgviewer.find(images[nb_images - 1]).detach();
        imgviewer.find(images[0]).before(last_element);
        update_imgviewer_size(imgviewer);
        imgviewer.find(images[nb_images - 2]).fadeIn(300);
    }, 100);

    /*--------------------------------------------------------*/

    if(imgviewer.hasClass("imgviewer-fullscreen")){
        imgviewer.parent().children("p").text(imgviewer.find(images[nb_images - 2]).attr("alt"));
    }

};

const click_right = function (e) {
    e.stopPropagation();
    let imgviewer = $(this).parent();
    let images = imgviewer
        .children()
        .not(
            ".imgviewer-blur-layer, .imgviewer-button-left, .imgviewer-button-right, .imgviewer-button-center"
        ); //only select the original content

    let nb_images = images.length;

    // first create of var of last element
    // remove it from DOM
    //add it before the first element

    if (nb_images < 2) return;

    /*--------------------------------------------------------*/

    imgviewer.find(images[nb_images - 1]).fadeOut(100);

    let first_element = imgviewer.find(images[0]).detach();

    imgviewer.find(images[nb_images - 1]).after(first_element);

    setTimeout(function () {
        update_imgviewer_size(imgviewer);
        first_element.fadeIn(300);
    }, 100);

    /*--------------------------------------------------------*/

    if(imgviewer.hasClass("imgviewer-fullscreen")){
        imgviewer.parent().children("p").text(first_element.attr("alt"));
    }
};

const click_center = function (e) {
    e.stopPropagation();
    let background = $("<div></div>")
        .addClass("imgviewer-fullscreen-background")
        .click(click_back);


    let imgviewer = $(this).parent().clone(true);
    imgviewer.children(".imgviewer-button-center").off(); //disable event from imgviewer-center
    imgviewer
        .children(".imgviewer-blur-layer")
        .removeClass("blurred blur-right blur-left"); //remove existing blur to avoid issues

    let name = $("<p></p>").text(get_img_viewer_top_element(imgviewer).alt).addClass("imgviewer-fullscreen-name on-surface-text title-large");



    background.append(imgviewer).append(name);
    imgviewer.removeClass("imgviewer");
    imgviewer.addClass("imgviewer-fullscreen");

    $("body").append(background)
        .toggleClass("disable-scroll");

    update_imgviewer_size(imgviewer);
};

$( window ).on( "load", function()  {

    $(".imgviewer").each(function () {
        //inside each function

        $(this).children().last().after($(this).children().first())

        // only show element on top
        $(this).children().not(get_img_viewer_top_element($(this))).hide();



        //the div that will blur the imgviewer
        let blur_layer = $("<div></div>").addClass("imgviewer-blur-layer");
        $(this).append(blur_layer);

        //add the buttons
        $(this).append(
            $("<div></div>")
                .addClass("imgviewer-button-left")
                .hover(hover_left)
                .click(click_left)
        );
        $(this).append(
            $("<div></div>")
                .addClass("imgviewer-button-center")
                .hover(hover_center)
                .click(click_center)
        );
        $(this).append(
            $("<div></div>")
                .addClass("imgviewer-button-right")
                .hover(hover_right)
                .click(click_right)
        );
        update_imgviewer_size($(this));

    });

    //end of onStart function
});

//to make sure the ratio is preserved when resizing
$(window).resize(function () {
    $(".imgviewer-fullscreen, .imgviewer").each(function () {
        update_imgviewer_size($(this));
    });

});
