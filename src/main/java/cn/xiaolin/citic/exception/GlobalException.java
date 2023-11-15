package cn.xiaolin.citic.exception;

/**
 * @author xingxiaolin xlxing@bupt.edu.cn
 * @Description
 * @create 2023/11/15
 */
public class GlobalException extends RuntimeException {
    public GlobalException(String msg) {
        super(msg);
    }
}
