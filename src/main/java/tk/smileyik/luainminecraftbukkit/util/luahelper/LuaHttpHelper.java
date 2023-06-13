package tk.smileyik.luainminecraftbukkit.util.luahelper;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

public class LuaHttpHelper {

    /**
     * 向一个URL链接发送一个HTTP请求.
     * @param urlString URL链接文本.
     * @param preOperation 开始请求后的前置操作.
     * @param body 请求体.
     * @param callback 请求完成后调用.
     * @param errorCallback 错误时调用.
     */
    public static void action(String urlString, byte[] body, PreOperation preOperation,
                              Callback callback, ErrorCallback errorCallback) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            preOperation.action(con);
            if (body != null && body.length != 0) {
                con.setDoOutput(true);
                try (BufferedOutputStream bos = new BufferedOutputStream(con.getOutputStream())) {
                    bos.write(body);
                    bos.flush();
                }
            }
            int code = con.getResponseCode();
            callback.callback(code, con);
            con.disconnect();
        } catch (Exception e) {
            errorCallback.callback(e);
        }
    }

    public static interface PreOperation {
        public void action(HttpURLConnection connection) throws ProtocolException;
    }

    public static interface Callback {
        public void callback(int code, HttpURLConnection connection) throws IOException;
    }

    public static interface ErrorCallback {
        public void callback(Exception exception);
    }
}
