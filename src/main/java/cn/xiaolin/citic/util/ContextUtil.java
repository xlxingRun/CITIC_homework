package cn.xiaolin.citic.util;

import org.apache.commons.lang3.NotImplementedException;

import java.util.Optional;

/**
 * @author xingxiaolin xlxing@bupt.edu.cn
 * @Description
 * @create 2023/7/30
 */
public class ContextUtil {
    private ContextUtil() {
        throw new NotImplementedException();
    }
    private static final ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<>();

    public static void setUsername(String username) {
        THREAD_LOCAL.set(username);
    }

    public static String getUsername() {
        return Optional.ofNullable(THREAD_LOCAL.get()).orElse("xiaolin");
    }
}
