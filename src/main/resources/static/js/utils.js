// Ajax Method
let AjaxUtil = {
    ajax : function($url, $type, $data, $success, $error, $async) {
        let $json = ($data) ? JSON.stringify($data) : "";
        let $asyncOpt = ($async) ? true : false;
        console.log($data);
        $.ajax({
            headers : {
                'Accept' : 'application/json',
                'Content-Type' : 'application/json'
            },
            url : $url,
            type : $type,
            async : $asyncOpt,
            dataType : 'json',
            data : $json,
            contentType : 'application/json;charset=UTF-8',
            mimeType : 'application/json',
            success : function(response, textStatus) {
                if(textStatus == "success") {
                    $success(response);
                } else {
                    $error(response);
                }
            },
            error : function(response) {
                if(response.status == "200") {
                    $success(response);
                } else {
                    $error(response);
                }
            }
        });
    },

}
