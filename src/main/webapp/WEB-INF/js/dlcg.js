$(document).ready(
    (function(){
        $('requestByJson').click(function(){
            var formData = new Object;
            formData.keyword = $('#keyword').val();
            formData.writername = $('#writername').val();
            formData.blogname = $('#blogname').val();
            formData.blog = $('#blog').val();
            var JsonData = JSON.stringify(formData);
            console.log(JsonData);
            $.ajax({
                type : 'POST',
                url : '/controller/BlogContentController/blog',
                dataType : 'text',
                data : JsonData,
                success : function(data) {
                    alert(data);
                }
            });
        });
    })
)