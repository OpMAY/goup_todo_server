package com.restcontroller.goup;

import com.response.DefaultRes;
import com.response.Message;
import com.service.todo.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/todo")
public class TodoRestController {
    private final TodoService todoService;

    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    public ResponseEntity getTasks(@RequestParam("userToken") String userToken) {
        Message message = new Message();
        message.put("tasks", todoService.getTask(userToken, null));
        message.put("status", true);
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);
    }
}
