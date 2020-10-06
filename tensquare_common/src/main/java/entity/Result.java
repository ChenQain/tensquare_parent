package entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 公共结果集
 *
 * @author Eden.
 * @date 2020/9/22 23:10
 */
@Data
@NoArgsConstructor
public class Result {

    private Boolean flag;
    private Integer code;
    private String message;
    private Object data;

    public Result(Boolean flag, Integer code, String message) {
        this.flag = flag;
        this.code = code;
        this.message = message;
    }

    public Result(Boolean flag, Integer code, String message, Object data) {
        this.flag = flag;
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
