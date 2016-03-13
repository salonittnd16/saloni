// This is a manifest file that'll be compiled into application.js.
//
// Any JavaScript file within this directory can be referenced here using a relative path.
//
// You're free to add application-wide JavaScript to this file, but it's generally better 
// to create separate JavaScript files as needed.
//
//= require jquery
//= require_tree .
//= require_self

if (typeof jQuery !== 'undefined') {
    (function ($) {
        $('#spinner').ajaxStart(function () {
            $(this).fadeIn();
        }).ajaxStop(function () {
            $(this).fadeOut();
        });
    })(jQuery);


}
function success(data, id) {
    $("#alert").html(data.message);

    var messageAlert = $(".messageAlert");
    for (item in data) {
        if (item === "message") {
            messageAlert.text(data[item]);
            messageAlert.css({'display': 'block'})
            messageAlert.addClass("alert-success");
            $("#" + id).remove();
        }
        else {
            messageAlert.text(data[item]);
            messageAlert.css({'display': 'block'})
            messageAlert.addClass("alert-danger");
        }
    }
}

function subscribe(id) {
    event.preventDefault();
    $.ajax({
        url: '/subscription/save',
        data: {id: id},
        method: 'post',
        success: function (data) {
            success(data, id)
        }
        ,
        error: function (data) {
            $("#alert").html(data.error);
        }
    })
};

function unsubscribe(id) {
    event.preventDefault();
    $.ajax({
        url: '/subscription/delete',
        data: {id: id},
        method: 'post',
        success: function (data) {
            success(data, id)
        }
        ,
        error: function (data) {
            $("#alert").html(data.error);
        }
    })
};

function topicDelete(id) {
    alert("hello")
    event.preventDefault();
    $.ajax({
        url: '/topic/delete',
        data: {topicId: id},
        method: 'post',
        success: function (data) {
            success(data, id)
        }
        ,
        error: function (data) {
            $("#alert").html(data.error);
        }
    })
};


function commonSuccess(data) {
    var messageAlert = $(".messageAlert");
    for (item in data) {
        if (item === "message") {
            messageAlert.text(data[item]);
            messageAlert.css({'display': 'block'})
            messageAlert.addClass("alert-success");
        }
        else {
            messageAlert.text(data[item]);
            messageAlert.css({'display': 'block'})
            messageAlert.addClass("alert-danger");
        }
    }
}


$(document).ready(function () {
    $(".seriousness").change(function () {
        $.ajax({
            url: "/subscription/update",
            data: {id: $(this).attr('topicId'), seriousness: $(this).val()},
            success: commonSuccess
        });
    });
    $(".visibility").change(function () {
        $.ajax({
            url: "/topic/save",
            data: {topicName: $(this).attr('topicName'), visibility: $(this).val()},
            success: commonSuccess
        });
    });

    $("#saveTopic").click(function () {
        alert($('#visibility').val())
        $.ajax({
            url: "/topic/save",
            data: {topicName: $('#topicName').val(), visibility: $('#visibility').val()},
            success: location.reload()
        });
    });

    $(".edit").bind('click', function () {
        var topicId = $(this).attr("topicId")
        var parent = $(this).attr("parent")
        event.preventDefault()
        var editRow = $("#" + parent + "Edit_" + topicId)
        editRow.show()
        event.preventDefault()

    });

    $("#clearSearchPostBox").click(function () {
        $("#searchPostBox").val("")
    })

    $("#findSearchPostBox").click(function () {
        topicId = $(this).attr('topicId')

        $.ajax({
            url: "/resource/search",
            data: {q: $('#searchPostBox').val(), topicId: topicId},
            method: 'post',
            success: function (result) {
                $("#topicPosts").html(result)
            }
        });
    })


    $('#registerForm').validate({
        rules: {
            'firstName': {
                required: true
            },
            'lastName': {
                required: true
            },
            'password': {
                required: true,
                minlength: 5
            },
            'confirmPassword': {
                required: true,
                //confirm: true
            },
            'userName': {
                required: true,
                remote: {
                    url: "/login/validateUserName",
                    type: "post"
                }
            }
            ,
            'email': {
                required: true,
                email: true,
                remote: {
                    url: "/login/validateEmail",
                    type: "post"
                }

            }
        },
        messages: {
            'firstName': {
                required: "firstname required"
            }
        },
        submitHandler: function (form) {
            $(form).submit();
        }
    });

    jQuery.validator.addMethod("confirm", function (value, element) {
        var check = false;
        var password = $('#registerForm input[id=pwd]').val();

        if (password === value) {
            check = true;
        }
        return check;
    }, "Confirm password doesn't match your password");


});
