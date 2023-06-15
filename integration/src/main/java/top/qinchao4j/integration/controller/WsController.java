package top.qinchao4j.integration.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.qinchao4j.integration.config.WebSocketServer;

import java.io.IOException;

/**
 * Description
 *
 * @author djdgt
 * @since 2023/3/28 10:56
 */
@RestController
@RequestMapping("ws")
@AllArgsConstructor
public class WsController {

    // 推送数据接口
    @GetMapping("send/{message}")
    public String pushToWeb(@PathVariable String message, String toUserId) throws IOException {
        WebSocketServer.sendInfo(message, toUserId);
        return message;
    }
}
