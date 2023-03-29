package enum_;

import lombok.Data;

public enum HttpStatus {
    状态2xx(200, "成功"),
    状态3xx(300, "重定向成功"),
    状态4xx(400, "客户端错误"),
    状态5xx(500, "服务端错误");

    private String str;
    private Integer status;

    HttpStatus() {
    }

    HttpStatus(Integer status,String str) {
        this.str = str;
        this.status = status;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}

@Data
class http {
    private Integer id;
    private String type;
    private Integer statusCode;
    private Enum<HttpStatus> status;

    public static void main(String[] args) {
        /*Integer status = HttpStatus.状态2xx.getStatus();
        System.out.println("status = " + status);
        HttpStatus.状态3xx.setStr("~~~~~~~~~~");
        System.out.println(HttpStatus.状态3xx.getStr());*/
        http http = new http();
        http.setType(HttpStatus.状态2xx.getStr());
        http.setStatusCode(HttpStatus.状态2xx.getStatus());
        http.setStatus(HttpStatus.状态3xx);
        System.out.println("http = " + http);

        System.out.println(HttpStatus.状态3xx);
        String str = String.valueOf(HttpStatus.状态3xx);
        System.out.println(str.equals("状态3xx"));
    }
}
